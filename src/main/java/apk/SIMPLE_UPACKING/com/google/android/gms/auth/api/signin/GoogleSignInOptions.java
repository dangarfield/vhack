package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.C0172j;
import com.google.android.gms.common.api.C0141f;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInOptions implements C0141f, SafeParcelable {
    public static final Creator CREATOR;
    public static final Scope f3258a;
    public static final Scope f3259b;
    public static final Scope f3260c;
    public static final GoogleSignInOptions f3261d;
    private static Comparator f3262m;
    final int f3263e;
    private final ArrayList f3264f;
    private Account f3265g;
    private boolean f3266h;
    private final boolean f3267i;
    private final boolean f3268j;
    private String f3269k;
    private String f3270l;

    static {
        f3258a = new Scope("profile");
        f3259b = new Scope("email");
        f3260c = new Scope("openid");
        f3261d = new C0151d().m5879a().m5881b().m5882c();
        CREATOR = new C0154g();
        f3262m = new C0150c();
    }

    GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.f3263e = i;
        this.f3264f = arrayList;
        this.f3265g = account;
        this.f3266h = z;
        this.f3267i = z2;
        this.f3268j = z3;
        this.f3269k = str;
        this.f3270l = str2;
    }

    private GoogleSignInOptions(Set set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, new ArrayList(set), account, z, z2, z3, str, str2);
    }

    public static GoogleSignInOptions m5845a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        Object optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null));
    }

    private JSONObject m5853i() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f3264f, f3262m);
            Iterator it = this.f3264f.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).m7285a());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f3265g != null) {
                jSONObject.put("accountName", this.f3265g.name);
            }
            jSONObject.put("idTokenRequested", this.f3266h);
            jSONObject.put("forceCodeForRefreshToken", this.f3268j);
            jSONObject.put("serverAuthRequested", this.f3267i);
            if (!TextUtils.isEmpty(this.f3269k)) {
                jSONObject.put("serverClientId", this.f3269k);
            }
            if (!TextUtils.isEmpty(this.f3270l)) {
                jSONObject.put("hostedDomain", this.f3270l);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList m5854a() {
        return new ArrayList(this.f3264f);
    }

    public Account m5855b() {
        return this.f3265g;
    }

    public boolean m5856c() {
        return this.f3266h;
    }

    public boolean m5857d() {
        return this.f3267i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean m5858e() {
        return this.f3268j;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f3264f.size() != googleSignInOptions.m5854a().size() || !this.f3264f.containsAll(googleSignInOptions.m5854a())) {
                return false;
            }
            if (this.f3265g == null) {
                if (googleSignInOptions.m5855b() != null) {
                    return false;
                }
            } else if (!this.f3265g.equals(googleSignInOptions.m5855b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f3269k)) {
                if (!TextUtils.isEmpty(googleSignInOptions.m5859f())) {
                    return false;
                }
            } else if (!this.f3269k.equals(googleSignInOptions.m5859f())) {
                return false;
            }
            return this.f3268j == googleSignInOptions.m5858e() && this.f3266h == googleSignInOptions.m5856c() && this.f3267i == googleSignInOptions.m5857d();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public String m5859f() {
        return this.f3269k;
    }

    public String m5860g() {
        return this.f3270l;
    }

    public String m5861h() {
        return m5853i().toString();
    }

    public int hashCode() {
        Object arrayList = new ArrayList();
        Iterator it = this.f3264f.iterator();
        while (it.hasNext()) {
            arrayList.add(((Scope) it.next()).m7285a());
        }
        Collections.sort(arrayList);
        return new C0172j().m6018a(arrayList).m6018a(this.f3265g).m6018a(this.f3269k).m6019a(this.f3268j).m6019a(this.f3266h).m6019a(this.f3267i).m6017a();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0154g.m5889a(this, parcel, i);
    }
}
