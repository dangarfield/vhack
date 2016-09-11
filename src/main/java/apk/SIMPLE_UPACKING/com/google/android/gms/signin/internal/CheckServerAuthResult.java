package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckServerAuthResult implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4960a;
    final boolean f4961b;
    final List f4962c;

    static {
        CREATOR = new C0386c();
    }

    CheckServerAuthResult(int i, boolean z, List list) {
        this.f4960a = i;
        this.f4961b = z;
        this.f4962c = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0386c.m8955a(this, parcel, i);
    }
}
