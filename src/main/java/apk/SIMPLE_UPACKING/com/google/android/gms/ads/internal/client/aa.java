package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public abstract class aa extends Binder implements C0028z {
    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                long a = m5355a();
                parcel2.writeNoException();
                parcel2.writeLong(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
