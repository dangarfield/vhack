package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int f4343a;
    final int f4344b;
    int f4345c;
    String f4346d;
    IBinder f4347e;
    Scope[] f4348f;
    Bundle f4349g;
    Account f4350h;

    static {
        CREATOR = new C0305x();
    }

    public GetServiceRequest(int i) {
        this.f4343a = 2;
        this.f4345c = C0268j.f4322b;
        this.f4344b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.f4343a = i;
        this.f4344b = i2;
        this.f4345c = i3;
        this.f4346d = str;
        if (i < 2) {
            this.f4350h = m7685a(iBinder);
        } else {
            this.f4347e = iBinder;
            this.f4350h = account;
        }
        this.f4348f = scopeArr;
        this.f4349g = bundle;
    }

    private Account m7685a(IBinder iBinder) {
        return iBinder != null ? C0278a.m7704a(aq.m7703a(iBinder)) : null;
    }

    public GetServiceRequest m7686a(Account account) {
        this.f4350h = account;
        return this;
    }

    public GetServiceRequest m7687a(Bundle bundle) {
        this.f4349g = bundle;
        return this;
    }

    public GetServiceRequest m7688a(ap apVar) {
        if (apVar != null) {
            this.f4347e = apVar.asBinder();
        }
        return this;
    }

    public GetServiceRequest m7689a(String str) {
        this.f4346d = str;
        return this;
    }

    public GetServiceRequest m7690a(Collection collection) {
        this.f4348f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0305x.m7985a(this, parcel, i);
    }
}
