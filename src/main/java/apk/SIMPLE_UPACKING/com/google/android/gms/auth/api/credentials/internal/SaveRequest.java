package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SaveRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3181a;
    private final Credential f3182b;

    static {
        CREATOR = new C0132k();
    }

    SaveRequest(int i, Credential credential) {
        this.f3181a = i;
        this.f3182b = credential;
    }

    public Credential m5716a() {
        return this.f3182b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0132k.m5799a(this, parcel, i);
    }
}
