package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C0224w;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult implements C0224w, SafeParcelable {
    public static final Creator CREATOR;
    final int f4957a;
    private int f4958b;
    private Intent f4959c;

    static {
        CREATOR = new C0385a();
    }

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.f4957a = i;
        this.f4958b = i2;
        this.f4959c = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public Status m8943a() {
        return this.f4958b == 0 ? Status.f4131a : Status.f4135e;
    }

    public int m8944b() {
        return this.f4958b;
    }

    public Intent m8945c() {
        return this.f4959c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0385a.m8952a(this, parcel, i);
    }
}
