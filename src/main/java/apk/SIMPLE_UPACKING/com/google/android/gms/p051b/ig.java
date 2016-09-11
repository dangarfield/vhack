package com.google.android.gms.p051b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.b.ig */
class ig implements ie {
    private IBinder f3815a;

    ig(IBinder iBinder) {
        this.f3815a = iBinder;
    }

    public void m6803a(Status status) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3815a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3815a;
    }
}
