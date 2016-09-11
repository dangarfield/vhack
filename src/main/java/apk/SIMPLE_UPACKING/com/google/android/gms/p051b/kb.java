package com.google.android.gms.p051b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.b.kb */
public abstract class kb extends Binder implements ka {
    public static ka m6908a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ka)) ? new kc(iBinder) : (ka) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
                m6907a(jy.m6888a(parcel.readStrongBinder()));
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
