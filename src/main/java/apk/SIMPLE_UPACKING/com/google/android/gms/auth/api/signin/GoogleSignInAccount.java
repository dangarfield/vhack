package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p051b.kf;
import com.google.android.gms.p051b.kh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Creator CREATOR;
    public static kf f3246a;
    private static Comparator f3247l;
    final int f3248b;
    List f3249c;
    private String f3250d;
    private String f3251e;
    private String f3252f;
    private String f3253g;
    private Uri f3254h;
    private String f3255i;
    private long f3256j;
    private String f3257k;

    static {
        CREATOR = new C0153f();
        f3246a = kh.m6922c();
        f3247l = new C0148a();
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List list) {
        this.f3248b = i;
        this.f3250d = str;
        this.f3251e = str2;
        this.f3252f = str3;
        this.f3253g = str4;
        this.f3254h = uri;
        this.f3255i = str5;
        this.f3256j = j;
        this.f3257k = str6;
        this.f3249c = list;
    }

    public static GoogleSignInAccount m5831a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return m5832a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).m5835b(jSONObject.optString("serverAuthCode", null));
    }

    public static GoogleSignInAccount m5832a(String str, String str2, String str3, String str4, Uri uri, Long l, String str5, Set set) {
        if (l == null) {
            l = Long.valueOf(f3246a.m6913a() / 1000);
        }
        return new GoogleSignInAccount(2, str, str2, str3, str4, uri, null, l.longValue(), bf.m7875a(str5), new ArrayList((Collection) bf.m7873a((Object) set)));
    }

    private JSONObject m5833k() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m5834a() != null) {
                jSONObject.put("id", m5834a());
            }
            if (m5836b() != null) {
                jSONObject.put("tokenId", m5836b());
            }
            if (m5837c() != null) {
                jSONObject.put("email", m5837c());
            }
            if (m5838d() != null) {
                jSONObject.put("displayName", m5838d());
            }
            if (m5839e() != null) {
                jSONObject.put("photoUrl", m5839e().toString());
            }
            if (m5840f() != null) {
                jSONObject.put("serverAuthCode", m5840f());
            }
            jSONObject.put("expirationTime", this.f3256j);
            jSONObject.put("obfuscatedIdentifier", m5842h());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f3249c, f3247l);
            for (Scope a : this.f3249c) {
                jSONArray.put(a.m7285a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String m5834a() {
        return this.f3250d;
    }

    public GoogleSignInAccount m5835b(String str) {
        this.f3255i = str;
        return this;
    }

    public String m5836b() {
        return this.f3251e;
    }

    public String m5837c() {
        return this.f3252f;
    }

    public String m5838d() {
        return this.f3253g;
    }

    public int describeContents() {
        return 0;
    }

    public Uri m5839e() {
        return this.f3254h;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).m5843i().equals(m5843i());
    }

    public String m5840f() {
        return this.f3255i;
    }

    public long m5841g() {
        return this.f3256j;
    }

    public String m5842h() {
        return this.f3257k;
    }

    public String m5843i() {
        return m5833k().toString();
    }

    public String m5844j() {
        JSONObject k = m5833k();
        k.remove("serverAuthCode");
        return k.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0153f.m5886a(this, parcel, i);
    }
}
