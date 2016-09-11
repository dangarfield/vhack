package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyGrpcRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3215a;
    public final String f3216b;
    public final int f3217c;
    public final long f3218d;
    public final byte[] f3219e;
    public final String f3220f;

    static {
        CREATOR = new C0145b();
    }

    ProxyGrpcRequest(int i, String str, int i2, long j, byte[] bArr, String str2) {
        this.f3215a = i;
        this.f3216b = str;
        this.f3217c = i2;
        this.f3218d = j;
        this.f3219e = bArr;
        this.f3220f = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0145b.m5817a(this, parcel, i);
    }
}
