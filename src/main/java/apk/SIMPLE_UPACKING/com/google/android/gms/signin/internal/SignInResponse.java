package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInResponse implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4969a;
    private final ConnectionResult f4970b;
    private final ResolveAccountResponse f4971c;

    static {
        CREATOR = new C0395n();
    }

    public SignInResponse(int i) {
        this(new ConnectionResult(i, null), null);
    }

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f4969a = i;
        this.f4970b = connectionResult;
        this.f4971c = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public ConnectionResult m8950a() {
        return this.f4970b;
    }

    public ResolveAccountResponse m8951b() {
        return this.f4971c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0395n.m9002a(this, parcel, i);
    }
}
