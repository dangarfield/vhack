package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;

/* renamed from: com.google.android.gms.iid.g */
class C0350g implements C0348e {
    private IBinder f4582a;

    C0350g(IBinder iBinder) {
        this.f4582a = iBinder;
    }

    public void m8145a(Message message) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            if (message != null) {
                obtain.writeInt(1);
                message.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4582a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f4582a;
    }
}
