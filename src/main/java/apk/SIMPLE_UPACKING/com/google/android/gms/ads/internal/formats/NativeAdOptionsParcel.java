package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p051b.fi;

@fi
public class NativeAdOptionsParcel implements SafeParcelable {
    public static final C0055a CREATOR;
    public final int f2964a;
    public final boolean f2965b;
    public final int f2966c;
    public final boolean f2967d;

    static {
        CREATOR = new C0055a();
    }

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2) {
        this.f2964a = i;
        this.f2965b = z;
        this.f2966c = i2;
        this.f2967d = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0055a.m5433a(this, parcel, i);
    }
}
