package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class ValidateAccountRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4360a;
    final IBinder f4361b;
    private final int f4362c;
    private final Scope[] f4363d;
    private final Bundle f4364e;
    private final String f4365f;

    static {
        CREATOR = new C0281c();
    }

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f4360a = i;
        this.f4362c = i2;
        this.f4361b = iBinder;
        this.f4363d = scopeArr;
        this.f4364e = bundle;
        this.f4365f = str;
    }

    public int m7698a() {
        return this.f4362c;
    }

    public Scope[] m7699b() {
        return this.f4363d;
    }

    public String m7700c() {
        return this.f4365f;
    }

    public Bundle m7701d() {
        return this.f4364e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0281c.m7890a(this, parcel, i);
    }
}
