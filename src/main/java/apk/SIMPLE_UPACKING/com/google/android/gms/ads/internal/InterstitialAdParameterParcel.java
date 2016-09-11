package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p051b.fi;

@fi
public final class InterstitialAdParameterParcel implements SafeParcelable {
    public static final C0053e CREATOR;
    public final int f2879a;
    public final boolean f2880b;
    public final boolean f2881c;
    public final String f2882d;
    public final boolean f2883e;
    public final float f2884f;

    static {
        CREATOR = new C0053e();
    }

    InterstitialAdParameterParcel(int i, boolean z, boolean z2, String str, boolean z3, float f) {
        this.f2879a = i;
        this.f2880b = z;
        this.f2881c = z2;
        this.f2882d = str;
        this.f2883e = z3;
        this.f2884f = f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0053e.m5430a(this, parcel, i);
    }
}
