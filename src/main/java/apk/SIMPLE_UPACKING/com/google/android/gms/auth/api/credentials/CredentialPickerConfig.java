package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3147a;
    private final boolean f3148b;
    private final boolean f3149c;
    private final boolean f3150d;

    static {
        CREATOR = new C0117g();
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3) {
        this.f3147a = i;
        this.f3148b = z;
        this.f3149c = z2;
        this.f3150d = z3;
    }

    private CredentialPickerConfig(C0112b c0112b) {
        this(1, c0112b.f3169a, c0112b.f3170b, c0112b.f3171c);
    }

    public boolean m5676a() {
        return this.f3148b;
    }

    public boolean m5677b() {
        return this.f3149c;
    }

    public boolean m5678c() {
        return this.f3150d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0117g.m5705a(this, parcel, i);
    }
}
