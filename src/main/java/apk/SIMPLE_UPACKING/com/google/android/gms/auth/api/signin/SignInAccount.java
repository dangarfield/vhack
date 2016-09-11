package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONObject;

public class SignInAccount implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3271a;
    private String f3272b;
    private String f3273c;
    private String f3274d;
    private String f3275e;
    private Uri f3276f;
    private GoogleSignInAccount f3277g;
    private String f3278h;
    private String f3279i;

    static {
        CREATOR = new C0156i();
    }

    SignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, GoogleSignInAccount googleSignInAccount, String str5, String str6) {
        this.f3271a = i;
        this.f3274d = bf.m7876a(str3, (Object) "Email cannot be empty.");
        this.f3275e = str4;
        this.f3276f = uri;
        this.f3272b = str;
        this.f3273c = str2;
        this.f3277g = googleSignInAccount;
        this.f3278h = bf.m7875a(str5);
        this.f3279i = str6;
    }

    public static SignInAccount m5862a(C0155h c0155h, String str, String str2, String str3, Uri uri, String str4, String str5) {
        String str6 = null;
        if (c0155h != null) {
            str6 = c0155h.m5894a();
        }
        return new SignInAccount(2, str6, str, str2, str3, uri, null, str4, str5);
    }

    public static SignInAccount m5863a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        return m5862a(C0155h.m5892a(jSONObject.optString("providerId", null)), jSONObject.optString("tokenId", null), jSONObject.getString("email"), jSONObject.optString("displayName", null), !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null, jSONObject.getString("localId"), jSONObject.optString("refreshToken")).m5865a(GoogleSignInAccount.m5831a(jSONObject.optString("googleSignInAccount")));
    }

    private JSONObject m5864k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("email", m5867b());
            if (!TextUtils.isEmpty(this.f3275e)) {
                jSONObject.put("displayName", this.f3275e);
            }
            if (this.f3276f != null) {
                jSONObject.put("photoUrl", this.f3276f.toString());
            }
            if (!TextUtils.isEmpty(this.f3272b)) {
                jSONObject.put("providerId", this.f3272b);
            }
            if (!TextUtils.isEmpty(this.f3273c)) {
                jSONObject.put("tokenId", this.f3273c);
            }
            if (this.f3277g != null) {
                jSONObject.put("googleSignInAccount", this.f3277g.m5843i());
            }
            if (!TextUtils.isEmpty(this.f3279i)) {
                jSONObject.put("refreshToken", this.f3279i);
            }
            jSONObject.put("localId", m5872g());
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public SignInAccount m5865a(GoogleSignInAccount googleSignInAccount) {
        this.f3277g = googleSignInAccount;
        return this;
    }

    public String m5866a() {
        return this.f3273c;
    }

    public String m5867b() {
        return this.f3274d;
    }

    public String m5868c() {
        return this.f3275e;
    }

    public Uri m5869d() {
        return this.f3276f;
    }

    public int describeContents() {
        return 0;
    }

    public C0155h m5870e() {
        return C0155h.m5892a(this.f3272b);
    }

    public GoogleSignInAccount m5871f() {
        return this.f3277g;
    }

    public String m5872g() {
        return this.f3278h;
    }

    public String m5873h() {
        return this.f3279i;
    }

    public String m5874i() {
        return m5864k().toString();
    }

    String m5875j() {
        return this.f3272b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0156i.m5895a(this, parcel, i);
    }
}
