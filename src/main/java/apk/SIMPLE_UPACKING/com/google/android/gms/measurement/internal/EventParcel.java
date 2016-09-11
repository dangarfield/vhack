package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class EventParcel implements SafeParcelable {
    public static final au CREATOR;
    public final int f4629a;
    public final String f4630b;
    public final EventParams f4631c;
    public final String f4632d;
    public final long f4633e;

    static {
        CREATOR = new au();
    }

    EventParcel(int i, String str, EventParams eventParams, String str2, long j) {
        this.f4629a = i;
        this.f4630b = str;
        this.f4631c = eventParams;
        this.f4632d = str2;
        this.f4633e = j;
    }

    public EventParcel(String str, EventParams eventParams, String str2, long j) {
        this.f4629a = 1;
        this.f4630b = str;
        this.f4631c = eventParams;
        this.f4632d = str2;
        this.f4633e = j;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "origin=" + this.f4632d + ",name=" + this.f4630b + ",params=" + this.f4631c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        au.m8477a(this, parcel, i);
    }
}
