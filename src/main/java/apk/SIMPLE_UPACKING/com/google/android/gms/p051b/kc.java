package com.google.android.gms.p051b;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.b.kc */
class kc implements ka {
    private IBinder f3863a;

    kc(IBinder iBinder) {
        this.f3863a = iBinder;
    }

    public void m6909a(jx jxVar) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
            if (jxVar != null) {
                iBinder = jxVar.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f3863a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3863a;
    }
}
