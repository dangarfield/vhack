package com.google.android.gms.p051b;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p047a.C0002a;
import com.google.android.gms.p047a.C0003b;

/* renamed from: com.google.android.gms.b.bj */
class bj implements bh {
    private IBinder f3478a;

    bj(IBinder iBinder) {
        this.f3478a = iBinder;
    }

    public C0002a m6150a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.f3478a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            C0002a a = C0003b.m5322a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3478a;
    }

    public Uri m6151b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.f3478a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            Uri uri = obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return uri;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public double m6152c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.f3478a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            double readDouble = obtain2.readDouble();
            return readDouble;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
