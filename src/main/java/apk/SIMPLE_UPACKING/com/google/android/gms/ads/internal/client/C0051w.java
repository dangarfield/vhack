package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p047a.C0002a;
import com.google.android.gms.p051b.cz;

/* renamed from: com.google.android.gms.ads.internal.client.w */
class C0051w implements C0049u {
    private IBinder f2963a;

    C0051w(IBinder iBinder) {
        this.f2963a = iBinder;
    }

    public IBinder m5427a(C0002a c0002a, AdSizeParcel adSizeParcel, String str, cz czVar, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            if (adSizeParcel != null) {
                obtain.writeInt(1);
                adSizeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (czVar != null) {
                iBinder = czVar.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f2963a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            iBinder = obtain2.readStrongBinder();
            return iBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder m5428a(C0002a c0002a, AdSizeParcel adSizeParcel, String str, cz czVar, int i, int i2) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            if (adSizeParcel != null) {
                obtain.writeInt(1);
                adSizeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (czVar != null) {
                iBinder = czVar.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f2963a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            iBinder = obtain2.readStrongBinder();
            return iBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f2963a;
    }
}
