package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyResponse implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3236a;
    public final int f3237b;
    public final PendingIntent f3238c;
    public final int f3239d;
    final Bundle f3240e;
    public final byte[] f3241f;

    static {
        CREATOR = new C0147d();
    }

    ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.f3236a = i;
        this.f3237b = i2;
        this.f3239d = i3;
        this.f3240e = bundle;
        this.f3241f = bArr;
        this.f3238c = pendingIntent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0147d.m5823a(this, parcel, i);
    }
}
