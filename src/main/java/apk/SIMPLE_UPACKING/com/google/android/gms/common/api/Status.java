package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status implements C0224w, SafeParcelable {
    public static final Creator CREATOR;
    public static final Status f4131a;
    public static final Status f4132b;
    public static final Status f4133c;
    public static final Status f4134d;
    public static final Status f4135e;
    private final int f4136f;
    private final int f4137g;
    private final String f4138h;
    private final PendingIntent f4139i;

    static {
        f4131a = new Status(0);
        f4132b = new Status(14);
        f4133c = new Status(8);
        f4134d = new Status(15);
        f4135e = new Status(16);
        CREATOR = new ad();
    }

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f4136f = i;
        this.f4137g = i2;
        this.f4138h = str;
        this.f4139i = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String m7287g() {
        return this.f4138h != null ? this.f4138h : C0262m.m7616a(this.f4137g);
    }

    public Status m7288a() {
        return this;
    }

    PendingIntent m7289b() {
        return this.f4139i;
    }

    public String m7290c() {
        return this.f4138h;
    }

    int m7291d() {
        return this.f4136f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean m7292e() {
        return this.f4137g <= 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f4136f == status.f4136f && this.f4137g == status.f4137g && bc.m7871a(this.f4138h, status.f4138h) && bc.m7871a(this.f4139i, status.f4139i);
    }

    public int m7293f() {
        return this.f4137g;
    }

    public int hashCode() {
        return bc.m7869a(Integer.valueOf(this.f4136f), Integer.valueOf(this.f4137g), this.f4138h, this.f4139i);
    }

    public String toString() {
        return bc.m7870a((Object) this).m7872a("statusCode", m7287g()).m7872a("resolution", this.f4139i).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ad.m7303a(this, parcel, i);
    }
}
