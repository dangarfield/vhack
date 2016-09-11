package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Scope implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4129a;
    private final String f4130b;

    static {
        CREATOR = new ac();
    }

    Scope(int i, String str) {
        bf.m7876a(str, (Object) "scopeUri must not be null or empty");
        this.f4129a = i;
        this.f4130b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public String m7285a() {
        return this.f4130b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.f4130b.equals(((Scope) obj).f4130b);
    }

    public int hashCode() {
        return this.f4130b.hashCode();
    }

    public String toString() {
        return this.f4130b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ac.m7300a(this, parcel, i);
    }
}
