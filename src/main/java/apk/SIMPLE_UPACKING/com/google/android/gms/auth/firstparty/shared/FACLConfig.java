package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLConfig implements SafeParcelable {
    public static final C0191a CREATOR;
    final int f3358a;
    boolean f3359b;
    String f3360c;
    boolean f3361d;
    boolean f3362e;
    boolean f3363f;
    boolean f3364g;

    static {
        CREATOR = new C0191a();
    }

    FACLConfig(int i, boolean z, String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f3358a = i;
        this.f3359b = z;
        this.f3360c = str;
        this.f3361d = z2;
        this.f3362e = z3;
        this.f3363f = z4;
        this.f3364g = z5;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FACLConfig)) {
            return false;
        }
        FACLConfig fACLConfig = (FACLConfig) obj;
        return this.f3359b == fACLConfig.f3359b && TextUtils.equals(this.f3360c, fACLConfig.f3360c) && this.f3361d == fACLConfig.f3361d && this.f3362e == fACLConfig.f3362e && this.f3363f == fACLConfig.f3363f && this.f3364g == fACLConfig.f3364g;
    }

    public int hashCode() {
        return bc.m7869a(Boolean.valueOf(this.f3359b), this.f3360c, Boolean.valueOf(this.f3361d), Boolean.valueOf(this.f3362e), Boolean.valueOf(this.f3363f), Boolean.valueOf(this.f3364g));
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0191a.m6056a(this, parcel, i);
    }
}
