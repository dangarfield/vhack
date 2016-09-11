package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GeneratePasswordRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3179a;
    private final PasswordSpecification f3180b;

    static {
        CREATOR = new C0125d();
    }

    GeneratePasswordRequest(int i, PasswordSpecification passwordSpecification) {
        this.f3179a = i;
        this.f3180b = passwordSpecification;
    }

    public PasswordSpecification m5715a() {
        return this.f3180b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0125d.m5778a(this, parcel, i);
    }
}
