package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken implements SafeParcelable {
    public static final Creator CREATOR;
    final int f3156a;
    private final String f3157b;
    private final String f3158c;

    static {
        CREATOR = new C0119i();
    }

    IdToken(int i, String str, String str2) {
        this.f3156a = i;
        this.f3157b = str;
        this.f3158c = str2;
    }

    public String m5683a() {
        return this.f3157b;
    }

    public String m5684b() {
        return this.f3158c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0119i.m5711a(this, parcel, i);
    }
}
