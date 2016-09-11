package com.google.android.gms.p051b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

/* renamed from: com.google.android.gms.b.ix */
class ix implements iv {
    private IBinder f3831a;

    ix(IBinder iBinder) {
        this.f3831a = iBinder;
    }

    public void m6832a(is isVar, ProxyGrpcRequest proxyGrpcRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
            obtain.writeStrongBinder(isVar != null ? isVar.asBinder() : null);
            if (proxyGrpcRequest != null) {
                obtain.writeInt(1);
                proxyGrpcRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3831a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m6833a(is isVar, ProxyRequest proxyRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
            obtain.writeStrongBinder(isVar != null ? isVar.asBinder() : null);
            if (proxyRequest != null) {
                obtain.writeInt(1);
                proxyRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3831a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3831a;
    }
}
