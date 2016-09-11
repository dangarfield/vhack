package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4351a;
    private final Account f4352b;
    private final int f4353c;
    private final GoogleSignInAccount f4354d;

    static {
        CREATOR = new bg();
    }

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f4351a = i;
        this.f4352b = account;
        this.f4353c = i2;
        this.f4354d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account m7691a() {
        return this.f4352b;
    }

    public int m7692b() {
        return this.f4353c;
    }

    public GoogleSignInAccount m7693c() {
        return this.f4354d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bg.m7884a(this, parcel, i);
    }
}
