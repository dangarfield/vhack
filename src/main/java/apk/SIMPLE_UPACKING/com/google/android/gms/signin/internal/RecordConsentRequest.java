package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4963a;
    private final Account f4964b;
    private final Scope[] f4965c;
    private final String f4966d;

    static {
        CREATOR = new C0391j();
    }

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.f4963a = i;
        this.f4964b = account;
        this.f4965c = scopeArr;
        this.f4966d = str;
    }

    public Account m8946a() {
        return this.f4964b;
    }

    public Scope[] m8947b() {
        return this.f4965c;
    }

    public String m8948c() {
        return this.f4966d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0391j.m8984a(this, parcel, i);
    }
}
