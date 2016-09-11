package com.google.android.gms.p051b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p047a.C0002a;

/* renamed from: com.google.android.gms.b.kx */
class kx implements kv {
    private IBinder f3882a;

    kx(IBinder iBinder) {
        this.f3882a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3882a;
    }

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        boolean z2 = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeInt(z ? 1 : 0);
            obtain.writeInt(i);
            this.f3882a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z2 = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z2;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int getIntFlagValue(String str, int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f3882a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public long getLongFlagValue(String str, long j, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeLong(j);
            obtain.writeInt(i);
            this.f3882a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            long readLong = obtain2.readLong();
            return readLong;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String getStringFlagValue(String str, String str2, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeInt(i);
            this.f3882a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void init(C0002a c0002a) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            this.f3882a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
