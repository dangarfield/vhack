package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountResponse implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4355a;
    IBinder f4356b;
    private ConnectionResult f4357c;
    private boolean f4358d;
    private boolean f4359e;

    static {
        CREATOR = new bh();
    }

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f4355a = i;
        this.f4356b = iBinder;
        this.f4357c = connectionResult;
        this.f4358d = z;
        this.f4359e = z2;
    }

    public ap m7694a() {
        return aq.m7703a(this.f4356b);
    }

    public ConnectionResult m7695b() {
        return this.f4357c;
    }

    public boolean m7696c() {
        return this.f4358d;
    }

    public boolean m7697d() {
        return this.f4359e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f4357c.equals(resolveAccountResponse.f4357c) && m7694a().equals(resolveAccountResponse.m7694a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        bh.m7887a(this, parcel, i);
    }
}
