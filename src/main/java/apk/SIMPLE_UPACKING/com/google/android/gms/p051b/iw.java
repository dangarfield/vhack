package com.google.android.gms.p051b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C0001R;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.b.iw */
public abstract class iw extends Binder implements iv {
    public static iv m6831a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof iv)) ? new ix(iBinder) : (iv) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        ProxyGrpcRequest proxyGrpcRequest = null;
        is a;
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                ProxyRequest proxyRequest;
                parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                a = it.m6827a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    proxyRequest = (ProxyRequest) ProxyRequest.CREATOR.createFromParcel(parcel);
                }
                m6830a(a, proxyRequest);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                a = it.m6827a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    proxyGrpcRequest = (ProxyGrpcRequest) ProxyGrpcRequest.CREATOR.createFromParcel(parcel);
                }
                m6829a(a, proxyGrpcRequest);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.internal.IAuthService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
