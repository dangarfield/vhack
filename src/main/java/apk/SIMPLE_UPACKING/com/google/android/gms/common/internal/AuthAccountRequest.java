package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4338a;
    final IBinder f4339b;
    final Scope[] f4340c;
    Integer f4341d;
    Integer f4342e;

    static {
        CREATOR = new C0283e();
    }

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.f4338a = i;
        this.f4339b = iBinder;
        this.f4340c = scopeArr;
        this.f4341d = num;
        this.f4342e = num2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0283e.m7894a(this, parcel, i);
    }
}
