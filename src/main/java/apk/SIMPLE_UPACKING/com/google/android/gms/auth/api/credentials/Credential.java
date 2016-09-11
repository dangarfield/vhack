package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class Credential implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3138a;
    private final String f3139b;
    private final String f3140c;
    private final Uri f3141d;
    private final List f3142e;
    private final String f3143f;
    private final String f3144g;
    private final String f3145h;
    private final String f3146i;

    static {
        CREATOR = new C0116f();
    }

    Credential(int i, String str, String str2, Uri uri, List list, String str3, String str4, String str5, String str6) {
        this.f3138a = i;
        String trim = ((String) bf.m7874a((Object) str, (Object) "credential identifier cannot be null")).trim();
        bf.m7876a(trim, (Object) "credential identifier cannot be empty");
        this.f3139b = trim;
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.f3140c = str2;
        this.f3141d = uri;
        this.f3142e = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f3143f = str3;
        if (str3 == null || !str3.isEmpty()) {
            if (!TextUtils.isEmpty(str4)) {
                trim = Uri.parse(str4).getScheme();
                boolean z = "http".equalsIgnoreCase(trim) || "https".equalsIgnoreCase(trim);
                bf.m7881b(z);
            }
            this.f3144g = str4;
            this.f3145h = str5;
            this.f3146i = str6;
            if (!TextUtils.isEmpty(this.f3143f) && !TextUtils.isEmpty(this.f3144g)) {
                throw new IllegalStateException("password and accountType cannot both be set");
            }
            return;
        }
        throw new IllegalArgumentException("password cannot be empty");
    }

    public String m5668a() {
        return this.f3139b;
    }

    public String m5669b() {
        return this.f3140c;
    }

    public Uri m5670c() {
        return this.f3141d;
    }

    public List m5671d() {
        return this.f3142e;
    }

    public int describeContents() {
        return 0;
    }

    public String m5672e() {
        return this.f3143f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f3139b, credential.f3139b) && TextUtils.equals(this.f3140c, credential.f3140c) && bc.m7871a(this.f3141d, credential.f3141d) && TextUtils.equals(this.f3143f, credential.f3143f) && TextUtils.equals(this.f3144g, credential.f3144g) && TextUtils.equals(this.f3145h, credential.f3145h);
    }

    public String m5673f() {
        return this.f3145h;
    }

    public String m5674g() {
        return this.f3144g;
    }

    public String m5675h() {
        return this.f3146i;
    }

    public int hashCode() {
        return bc.m7869a(this.f3139b, this.f3140c, this.f3141d, this.f3143f, this.f3144g, this.f3145h);
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0116f.m5702a(this, parcel, i);
    }
}
