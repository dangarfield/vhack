package com.google.android.gms.p051b;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.b.ii */
public abstract class ii extends Binder implements ih {
    public static ih m6805a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ih)) ? new ij(iBinder) : (ih) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
                m6804a(parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), C0206if.m6802a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
