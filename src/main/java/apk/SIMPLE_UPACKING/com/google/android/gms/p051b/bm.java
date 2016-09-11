package com.google.android.gms.p051b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p047a.C0002a;

/* renamed from: com.google.android.gms.b.bm */
class bm implements bk {
    private IBinder f3479a;

    bm(IBinder iBinder) {
        this.f3479a = iBinder;
    }

    public IBinder m6155a(C0002a c0002a, C0002a c0002a2, C0002a c0002a3, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            obtain.writeStrongBinder(c0002a2 != null ? c0002a2.asBinder() : null);
            if (c0002a3 != null) {
                iBinder = c0002a3.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f3479a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            iBinder = obtain2.readStrongBinder();
            return iBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3479a;
    }
}
