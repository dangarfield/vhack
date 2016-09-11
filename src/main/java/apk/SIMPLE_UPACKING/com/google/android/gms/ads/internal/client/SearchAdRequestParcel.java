package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p051b.fi;

@fi
public final class SearchAdRequestParcel implements SafeParcelable {
    public static final C0032e CREATOR;
    public final int f2920a;
    public final int f2921b;
    public final int f2922c;
    public final int f2923d;
    public final int f2924e;
    public final int f2925f;
    public final int f2926g;
    public final int f2927h;
    public final int f2928i;
    public final String f2929j;
    public final int f2930k;
    public final String f2931l;
    public final int f2932m;
    public final int f2933n;
    public final String f2934o;

    static {
        CREATOR = new C0032e();
    }

    SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.f2920a = i;
        this.f2921b = i2;
        this.f2922c = i3;
        this.f2923d = i4;
        this.f2924e = i5;
        this.f2925f = i6;
        this.f2926g = i7;
        this.f2927h = i8;
        this.f2928i = i9;
        this.f2929j = str;
        this.f2930k = i10;
        this.f2931l = str2;
        this.f2932m = i11;
        this.f2933n = i12;
        this.f2934o = str3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0032e.m5382a(this, parcel, i);
    }
}
