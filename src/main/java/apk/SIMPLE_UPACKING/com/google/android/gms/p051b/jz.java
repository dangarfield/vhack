package com.google.android.gms.p051b;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.b.jz */
class jz implements jx {
    private IBinder f3862a;

    jz(IBinder iBinder) {
        this.f3862a = iBinder;
    }

    public void m6903a(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonCallbacks");
            obtain.writeInt(i);
            this.f3862a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3862a;
    }
}
