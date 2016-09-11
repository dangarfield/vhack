package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

class bb implements az {
    private IBinder f4417a;

    bb(IBinder iBinder) {
        this.f4417a = iBinder;
    }

    public void m7868a(ResolveAccountResponse resolveAccountResponse) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            if (resolveAccountResponse != null) {
                obtain.writeInt(1);
                resolveAccountResponse.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4417a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f4417a;
    }
}
