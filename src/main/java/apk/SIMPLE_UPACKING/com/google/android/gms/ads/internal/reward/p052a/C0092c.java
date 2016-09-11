package com.google.android.gms.ads.internal.reward.p052a;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p047a.C0002a;
import com.google.android.gms.p051b.cz;

/* renamed from: com.google.android.gms.ads.internal.reward.a.c */
class C0092c implements C0090a {
    private IBinder f3086a;

    C0092c(IBinder iBinder) {
        this.f3086a = iBinder;
    }

    public IBinder m5601a(C0002a c0002a, cz czVar, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            if (czVar != null) {
                iBinder = czVar.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f3086a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            iBinder = obtain2.readStrongBinder();
            return iBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3086a;
    }
}
