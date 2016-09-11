package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p047a.C0002a;

class ad implements ab {
    private IBinder f2935a;

    ad(IBinder iBinder) {
        this.f2935a = iBinder;
    }

    public IBinder m5358a(C0002a c0002a, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            obtain.writeInt(i);
            this.f2935a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            return readStrongBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f2935a;
    }
}
