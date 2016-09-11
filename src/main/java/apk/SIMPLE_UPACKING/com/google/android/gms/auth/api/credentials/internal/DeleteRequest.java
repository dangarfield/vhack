package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class DeleteRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3177a;
    private final Credential f3178b;

    static {
        CREATOR = new C0124c();
    }

    DeleteRequest(int i, Credential credential) {
        this.f3177a = i;
        this.f3178b = credential;
    }

    public Credential m5714a() {
        return this.f3178b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0124c.m5775a(this, parcel, i);
    }
}
