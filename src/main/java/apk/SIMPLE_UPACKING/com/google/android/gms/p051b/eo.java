package com.google.android.gms.p051b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p047a.C0002a;

/* renamed from: com.google.android.gms.b.eo */
class eo implements em {
    private IBinder f3612a;

    eo(IBinder iBinder) {
        this.f3612a = iBinder;
    }

    public IBinder m6457a(C0002a c0002a) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            this.f3612a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            return readStrongBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3612a;
    }
}
