package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4967a;
    final ResolveAccountRequest f4968b;

    static {
        CREATOR = new C0394m();
    }

    SignInRequest(int i, ResolveAccountRequest resolveAccountRequest) {
        this.f4967a = i;
        this.f4968b = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public ResolveAccountRequest m8949a() {
        return this.f4968b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0394m.m8999a(this, parcel, i);
    }
}
