package com.google.android.gms.p051b;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.b.dl */
class dl implements dj {
    private IBinder f3544a;

    dl(IBinder iBinder) {
        this.f3544a = iBinder;
    }

    public int m6328a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            this.f3544a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3544a;
    }
}
