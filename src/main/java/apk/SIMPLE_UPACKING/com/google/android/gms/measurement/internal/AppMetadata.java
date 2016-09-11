package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AppMetadata implements SafeParcelable {
    public static final ah CREATOR;
    public final int f4617a;
    public final String f4618b;
    public final String f4619c;
    public final String f4620d;
    public final String f4621e;
    public final long f4622f;
    public final long f4623g;
    public final String f4624h;
    public final boolean f4625i;
    public final boolean f4626j;

    static {
        CREATOR = new ah();
    }

    AppMetadata(int i, String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2) {
        this.f4617a = i;
        this.f4618b = str;
        this.f4619c = str2;
        this.f4620d = str3;
        this.f4621e = str4;
        this.f4622f = j;
        this.f4623g = j2;
        this.f4624h = str5;
        if (i >= 3) {
            this.f4625i = z;
        } else {
            this.f4625i = true;
        }
        this.f4626j = z2;
    }

    AppMetadata(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2) {
        bf.m7875a(str);
        this.f4617a = 4;
        this.f4618b = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        this.f4619c = str2;
        this.f4620d = str3;
        this.f4621e = str4;
        this.f4622f = j;
        this.f4623g = j2;
        this.f4624h = str5;
        this.f4625i = z;
        this.f4626j = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ah.m8309a(this, parcel, i);
    }
}
