package com.google.android.gms.p051b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p047a.C0002a;

/* renamed from: com.google.android.gms.b.fa */
class fa implements ey {
    private IBinder f3624a;

    fa(IBinder iBinder) {
        this.f3624a = iBinder;
    }

    public IBinder m6483a(C0002a c0002a) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            this.f3624a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            return readStrongBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3624a;
    }
}
