package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData implements SafeParcelable {
    public static final C0192b CREATOR;
    final int f3365a;
    FACLConfig f3366b;
    String f3367c;
    boolean f3368d;
    String f3369e;

    static {
        CREATOR = new C0192b();
    }

    FACLData(int i, FACLConfig fACLConfig, String str, boolean z, String str2) {
        this.f3365a = i;
        this.f3366b = fACLConfig;
        this.f3367c = str;
        this.f3368d = z;
        this.f3369e = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0192b.m6059a(this, parcel, i);
    }
}
