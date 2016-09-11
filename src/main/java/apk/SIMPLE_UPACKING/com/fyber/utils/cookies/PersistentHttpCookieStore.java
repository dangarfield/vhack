package com.fyber.utils.cookies;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.fyber.utils.cookies.b */
public final class PersistentHttpCookieStore implements CookieStore {
    private final ConcurrentHashMap f2800a;
    private final SharedPreferences f2801b;

    public PersistentHttpCookieStore(Context context) {
        int i = 0;
        this.f2801b = context.getSharedPreferences("FyberCookiePrefsFile", 0);
        this.f2800a = new ConcurrentHashMap();
        String string = this.f2801b.getString("names", null);
        if (string != null) {
            String[] split = TextUtils.split(string, ",");
            int length = split.length;
            while (i < length) {
                String str = split[i];
                String string2 = this.f2801b.getString("cookie_" + str, null);
                if (StringUtils.m5260b(string2)) {
                    this.f2800a.put(URI.create(str), m5256a(string2));
                }
                i++;
            }
        }
    }

    public final void add(URI uri, HttpCookie httpCookie) {
        URI a = PersistentHttpCookieStore.m5255a(uri);
        List list = (List) this.f2800a.get(a);
        if (list == null) {
            list = new ArrayList();
            this.f2800a.put(a, list);
        } else {
            list.remove(httpCookie);
        }
        list.add(httpCookie);
        this.f2801b.edit().putString("names", TextUtils.join(",", this.f2800a.keySet())).putString("cookie_" + a, PersistentHttpCookieStore.m5253a(list)).commit();
    }

    private List m5256a(String str) {
        List linkedList = new LinkedList();
        for (String b : TextUtils.split(str, ",")) {
            linkedList.add(m5257b(b));
        }
        return linkedList;
    }

    private static String m5253a(List list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (HttpCookie parcelableHttpCookie : list) {
            Parcelable parcelableHttpCookie2 = new ParcelableHttpCookie(parcelableHttpCookie);
            Parcel obtain = Parcel.obtain();
            parcelableHttpCookie2.writeToParcel(obtain, 0);
            stringBuilder.append(PersistentHttpCookieStore.m5254a(obtain.marshall())).append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public final List get(URI uri) {
        List arrayList = new ArrayList();
        if (((List) this.f2800a.get(uri)) != null) {
            for (HttpCookie httpCookie : (List) this.f2800a.get(uri)) {
                if (httpCookie != null) {
                    if (httpCookie.hasExpired()) {
                        ((List) this.f2800a.get(uri)).remove(httpCookie);
                    } else {
                        arrayList.add(httpCookie);
                    }
                }
            }
        }
        for (Entry entry : this.f2800a.entrySet()) {
            if (!uri.equals(entry.getKey())) {
                for (HttpCookie httpCookie2 : (List) entry.getValue()) {
                    if (httpCookie2 != null && HttpCookie.domainMatches(httpCookie2.getDomain(), uri.getHost())) {
                        if (httpCookie2.hasExpired()) {
                            ((List) entry.getValue()).remove(httpCookie2);
                        } else if (!arrayList.contains(httpCookie2)) {
                            arrayList.add(httpCookie2);
                        }
                    }
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final List getCookies() {
        List arrayList = new ArrayList();
        for (List<HttpCookie> list : this.f2800a.values()) {
            for (HttpCookie httpCookie : list) {
                if (httpCookie.hasExpired()) {
                    list.remove(httpCookie);
                } else if (!arrayList.contains(httpCookie)) {
                    arrayList.add(httpCookie);
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final List getURIs() {
        List arrayList = new ArrayList(this.f2800a.keySet());
        arrayList.remove(null);
        return Collections.unmodifiableList(arrayList);
    }

    public final boolean remove(URI uri, HttpCookie httpCookie) {
        URI a = PersistentHttpCookieStore.m5255a(uri);
        List list = (List) this.f2800a.get(a);
        if (list == null) {
            return false;
        }
        boolean remove = list.remove(httpCookie);
        if (remove) {
            Editor edit = this.f2801b.edit();
            if (list.isEmpty()) {
                edit.remove("cookie_" + a);
            } else {
                edit.putString("cookie_" + a, PersistentHttpCookieStore.m5253a(list));
            }
            edit.commit();
        }
        return remove;
    }

    public final boolean removeAll() {
        Editor edit = this.f2801b.edit();
        for (URI uri : this.f2800a.keySet()) {
            edit.remove("cookie_" + uri);
        }
        edit.remove("names");
        edit.commit();
        boolean z = !this.f2800a.isEmpty();
        this.f2800a.clear();
        return z;
    }

    private HttpCookie m5257b(String str) {
        Exception e;
        int length = str.length();
        byte[] bArr = new byte[((length / 2) + 1)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        Creator creator = ParcelableHttpCookie.CREATOR;
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        HttpCookie a = ((ParcelableHttpCookie) creator.createFromParcel(obtain)).m5252a();
        if (a == null) {
            try {
                return ((SerializableHttpCookie) new PersistentHttpCookieStore(this, new ByteArrayInputStream(bArr)).readObject()).m5258a();
            } catch (IOException e2) {
                e = e2;
                FyberLogger.m5223b("PersistentHttpCookieStore", "Exception in decodeCookie - " + e.getMessage());
                return a;
            } catch (ClassNotFoundException e3) {
                e = e3;
                FyberLogger.m5223b("PersistentHttpCookieStore", "Exception in decodeCookie - " + e.getMessage());
                return a;
            }
        }
        return a;
    }

    private static String m5254a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(i));
        }
        return stringBuilder.toString().toUpperCase(Locale.US);
    }

    private static URI m5255a(URI uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URI(uri.getScheme(), uri.getHost(), null, null);
        } catch (URISyntaxException e) {
            return uri;
        }
    }
}
