package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.C0172j;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONObject;

public class EmailSignInOptions implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3242a;
    private final Uri f3243b;
    private String f3244c;
    private Uri f3245d;

    static {
        CREATOR = new C0152e();
    }

    EmailSignInOptions(int i, Uri uri, String str, Uri uri2) {
        bf.m7874a((Object) uri, (Object) "Server widget url cannot be null in order to use email/password sign in.");
        bf.m7876a(uri.toString(), (Object) "Server widget url cannot be null in order to use email/password sign in.");
        bf.m7882b(Patterns.WEB_URL.matcher(uri.toString()).matches(), "Invalid server widget url");
        this.f3242a = i;
        this.f3243b = uri;
        this.f3244c = str;
        this.f3245d = uri2;
    }

    private JSONObject m5826e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverWidgetUrl", this.f3243b.toString());
            if (!TextUtils.isEmpty(this.f3244c)) {
                jSONObject.put("modeQueryName", this.f3244c);
            }
            if (this.f3245d != null) {
                jSONObject.put("tosUrl", this.f3245d.toString());
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public Uri m5827a() {
        return this.f3243b;
    }

    public Uri m5828b() {
        return this.f3245d;
    }

    public String m5829c() {
        return this.f3244c;
    }

    public String m5830d() {
        return m5826e().toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            EmailSignInOptions emailSignInOptions = (EmailSignInOptions) obj;
            if (!this.f3243b.equals(emailSignInOptions.m5827a())) {
                return false;
            }
            if (this.f3245d == null) {
                if (emailSignInOptions.m5828b() != null) {
                    return false;
                }
            } else if (!this.f3245d.equals(emailSignInOptions.m5828b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f3244c)) {
                if (!TextUtils.isEmpty(emailSignInOptions.m5829c())) {
                    return false;
                }
            } else if (!this.f3244c.equals(emailSignInOptions.m5829c())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new C0172j().m6018a(this.f3243b).m6018a(this.f3245d).m6018a(this.f3244c).m6017a();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0152e.m5883a(this, parcel, i);
    }
}
