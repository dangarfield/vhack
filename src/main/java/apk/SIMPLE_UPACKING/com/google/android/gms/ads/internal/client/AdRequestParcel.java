package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p051b.fi;
import java.util.List;

@fi
public final class AdRequestParcel implements SafeParcelable {
    public static final C0040i CREATOR;
    public final int f2891a;
    public final long f2892b;
    public final Bundle f2893c;
    public final int f2894d;
    public final List f2895e;
    public final boolean f2896f;
    public final int f2897g;
    public final boolean f2898h;
    public final String f2899i;
    public final SearchAdRequestParcel f2900j;
    public final Location f2901k;
    public final String f2902l;
    public final Bundle f2903m;
    public final Bundle f2904n;
    public final List f2905o;
    public final String f2906p;
    public final String f2907q;
    public final boolean f2908r;

    static {
        CREATOR = new C0040i();
    }

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List list2, String str3, String str4, boolean z3) {
        this.f2891a = i;
        this.f2892b = j;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f2893c = bundle;
        this.f2894d = i2;
        this.f2895e = list;
        this.f2896f = z;
        this.f2897g = i3;
        this.f2898h = z2;
        this.f2899i = str;
        this.f2900j = searchAdRequestParcel;
        this.f2901k = location;
        this.f2902l = str2;
        this.f2903m = bundle2;
        this.f2904n = bundle3;
        this.f2905o = list2;
        this.f2906p = str3;
        this.f2907q = str4;
        this.f2908r = z3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.f2891a == adRequestParcel.f2891a && this.f2892b == adRequestParcel.f2892b && bc.m7871a(this.f2893c, adRequestParcel.f2893c) && this.f2894d == adRequestParcel.f2894d && bc.m7871a(this.f2895e, adRequestParcel.f2895e) && this.f2896f == adRequestParcel.f2896f && this.f2897g == adRequestParcel.f2897g && this.f2898h == adRequestParcel.f2898h && bc.m7871a(this.f2899i, adRequestParcel.f2899i) && bc.m7871a(this.f2900j, adRequestParcel.f2900j) && bc.m7871a(this.f2901k, adRequestParcel.f2901k) && bc.m7871a(this.f2902l, adRequestParcel.f2902l) && bc.m7871a(this.f2903m, adRequestParcel.f2903m) && bc.m7871a(this.f2904n, adRequestParcel.f2904n) && bc.m7871a(this.f2905o, adRequestParcel.f2905o) && bc.m7871a(this.f2906p, adRequestParcel.f2906p) && bc.m7871a(this.f2907q, adRequestParcel.f2907q) && this.f2908r == adRequestParcel.f2908r;
    }

    public int hashCode() {
        return bc.m7869a(Integer.valueOf(this.f2891a), Long.valueOf(this.f2892b), this.f2893c, Integer.valueOf(this.f2894d), this.f2895e, Boolean.valueOf(this.f2896f), Integer.valueOf(this.f2897g), Boolean.valueOf(this.f2898h), this.f2899i, this.f2900j, this.f2901k, this.f2902l, this.f2903m, this.f2904n, this.f2905o, this.f2906p, this.f2907q, Boolean.valueOf(this.f2908r));
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0040i.m5399a(this, parcel, i);
    }
}
