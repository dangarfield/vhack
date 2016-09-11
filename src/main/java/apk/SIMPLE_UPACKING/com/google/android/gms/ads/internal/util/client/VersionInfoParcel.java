package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p051b.fi;

@fi
public final class VersionInfoParcel implements SafeParcelable {
    public static final C0100c CREATOR;
    public final int f3091a;
    public String f3092b;
    public int f3093c;
    public int f3094d;
    public boolean f3095e;

    static {
        CREATOR = new C0100c();
    }

    VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        this.f3091a = i;
        this.f3092b = str;
        this.f3093c = i2;
        this.f3094d = i3;
        this.f3095e = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0100c.m5644a(this, parcel, i);
    }
}
