package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

public class EventParams implements SafeParcelable, Iterable {
    public static final at CREATOR;
    public final int f4627a;
    private final Bundle f4628b;

    static {
        CREATOR = new at();
    }

    EventParams(int i, Bundle bundle) {
        this.f4627a = i;
        this.f4628b = bundle;
    }

    EventParams(Bundle bundle) {
        bf.m7873a((Object) bundle);
        this.f4628b = bundle;
        this.f4627a = 1;
    }

    public int m8195a() {
        return this.f4628b.size();
    }

    Object m8196a(String str) {
        return this.f4628b.get(str);
    }

    public Bundle m8197b() {
        return new Bundle(this.f4628b);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator iterator() {
        return new C0359a(this);
    }

    public String toString() {
        return this.f4628b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        at.m8474a(this, parcel, i);
    }
}
