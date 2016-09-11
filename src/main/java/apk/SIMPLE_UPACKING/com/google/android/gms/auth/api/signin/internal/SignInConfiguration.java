package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONObject;

public final class SignInConfiguration implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3297a;
    private final String f3298b;
    private String f3299c;
    private EmailSignInOptions f3300d;
    private GoogleSignInOptions f3301e;
    private String f3302f;

    static {
        CREATOR = new ab();
    }

    SignInConfiguration(int i, String str, String str2, EmailSignInOptions emailSignInOptions, GoogleSignInOptions googleSignInOptions, String str3) {
        this.f3297a = i;
        this.f3298b = bf.m7875a(str);
        this.f3299c = str2;
        this.f3300d = emailSignInOptions;
        this.f3301e = googleSignInOptions;
        this.f3302f = str3;
    }

    public SignInConfiguration(String str) {
        this(2, str, null, null, null, null);
    }

    private JSONObject m5899g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consumerPackageName", this.f3298b);
            if (!TextUtils.isEmpty(this.f3299c)) {
                jSONObject.put("serverClientId", this.f3299c);
            }
            if (this.f3300d != null) {
                jSONObject.put("emailSignInOptions", this.f3300d.m5830d());
            }
            if (this.f3301e != null) {
                jSONObject.put("googleSignInOptions", this.f3301e.m5861h());
            }
            if (!TextUtils.isEmpty(this.f3302f)) {
                jSONObject.put("apiKey", this.f3302f);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public SignInConfiguration m5900a(GoogleSignInOptions googleSignInOptions) {
        this.f3301e = (GoogleSignInOptions) bf.m7874a((Object) googleSignInOptions, (Object) "GoogleSignInOptions cannot be null.");
        return this;
    }

    public String m5901a() {
        return this.f3298b;
    }

    public String m5902b() {
        return this.f3299c;
    }

    public EmailSignInOptions m5903c() {
        return this.f3300d;
    }

    public GoogleSignInOptions m5904d() {
        return this.f3301e;
    }

    public int describeContents() {
        return 0;
    }

    public String m5905e() {
        return this.f3302f;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.f3298b.equals(signInConfiguration.m5901a())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f3299c)) {
                if (!TextUtils.isEmpty(signInConfiguration.m5902b())) {
                    return false;
                }
            } else if (!this.f3299c.equals(signInConfiguration.m5902b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f3302f)) {
                if (!TextUtils.isEmpty(signInConfiguration.m5905e())) {
                    return false;
                }
            } else if (!this.f3302f.equals(signInConfiguration.m5905e())) {
                return false;
            }
            if (this.f3300d == null) {
                if (signInConfiguration.m5903c() != null) {
                    return false;
                }
            } else if (!this.f3300d.equals(signInConfiguration.m5903c())) {
                return false;
            }
            if (this.f3301e == null) {
                if (signInConfiguration.m5904d() != null) {
                    return false;
                }
            } else if (!this.f3301e.equals(signInConfiguration.m5904d())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public String m5906f() {
        return m5899g().toString();
    }

    public int hashCode() {
        return new C0172j().m6018a(this.f3298b).m6018a(this.f3299c).m6018a(this.f3302f).m6018a(this.f3300d).m6018a(this.f3301e).m6017a();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ab.m5926a(this, parcel, i);
    }
}
