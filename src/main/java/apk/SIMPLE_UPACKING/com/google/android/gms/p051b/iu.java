package com.google.android.gms.p051b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* renamed from: com.google.android.gms.b.iu */
class iu implements is {
    private IBinder f3830a;

    iu(IBinder iBinder) {
        this.f3830a = iBinder;
    }

    public void m6828a(ProxyResponse proxyResponse) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthCallbacks");
            if (proxyResponse != null) {
                obtain.writeInt(1);
                proxyResponse.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3830a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3830a;
    }
}
