package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserAttributeParcel implements SafeParcelable {
    public static final ae CREATOR;
    public final int f4634a;
    public final String f4635b;
    public final long f4636c;
    public final Long f4637d;
    public final Float f4638e;
    public final String f4639f;
    public final String f4640g;

    static {
        CREATOR = new ae();
    }

    UserAttributeParcel(int i, String str, long j, Long l, Float f, String str2, String str3) {
        this.f4634a = i;
        this.f4635b = str;
        this.f4636c = j;
        this.f4637d = l;
        this.f4638e = f;
        this.f4639f = str2;
        this.f4640g = str3;
    }

    UserAttributeParcel(af afVar) {
        this(afVar.f4660b, afVar.f4661c, afVar.f4662d, afVar.f4659a);
    }

    UserAttributeParcel(String str, long j, Object obj, String str2) {
        bf.m7875a(str);
        this.f4634a = 1;
        this.f4635b = str;
        this.f4636c = j;
        this.f4640g = str2;
        if (obj == null) {
            this.f4637d = null;
            this.f4638e = null;
            this.f4639f = null;
        } else if (obj instanceof Long) {
            this.f4637d = (Long) obj;
            this.f4638e = null;
            this.f4639f = null;
        } else if (obj instanceof Float) {
            this.f4637d = null;
            this.f4638e = (Float) obj;
            this.f4639f = null;
        } else if (obj instanceof String) {
            this.f4637d = null;
            this.f4638e = null;
            this.f4639f = (String) obj;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public Object m8198a() {
        return this.f4637d != null ? this.f4637d : this.f4638e != null ? this.f4638e : this.f4639f != null ? this.f4639f : null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ae.m8250a(this, parcel, i);
    }
}
