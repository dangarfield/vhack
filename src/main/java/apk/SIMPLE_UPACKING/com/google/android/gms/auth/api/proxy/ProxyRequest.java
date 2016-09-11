package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyRequest implements SafeParcelable {
    public static final Creator CREATOR;
    public static final int f3221a;
    public static final int f3222b;
    public static final int f3223c;
    public static final int f3224d;
    public static final int f3225e;
    public static final int f3226f;
    public static final int f3227g;
    public static final int f3228h;
    public static final int f3229i;
    final int f3230j;
    public final String f3231k;
    public final int f3232l;
    public final long f3233m;
    public final byte[] f3234n;
    Bundle f3235o;

    static {
        CREATOR = new C0146c();
        f3221a = 0;
        f3222b = 1;
        f3223c = 2;
        f3224d = 3;
        f3225e = 4;
        f3226f = 5;
        f3227g = 6;
        f3228h = 7;
        f3229i = 7;
    }

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.f3230j = i;
        this.f3231k = str;
        this.f3232l = i2;
        this.f3233m = j;
        this.f3234n = bArr;
        this.f3235o = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.f3231k + ", method: " + this.f3232l + " ]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0146c.m5820a(this, parcel, i);
    }
}
