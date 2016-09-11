package com.google.android.gms.p051b;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.b.ij */
class ij implements ih {
    private IBinder f3816a;

    ij(IBinder iBinder) {
        this.f3816a = iBinder;
    }

    public void m6806a(Account account, int i, ie ieVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
            if (account != null) {
                obtain.writeInt(1);
                account.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            obtain.writeStrongBinder(ieVar != null ? ieVar.asBinder() : null);
            this.f3816a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3816a;
    }
}
