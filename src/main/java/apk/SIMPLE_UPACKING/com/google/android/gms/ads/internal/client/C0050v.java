package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.p047a.C0002a;
import com.google.android.gms.p047a.C0003b;
import com.google.android.gms.p051b.da;

/* renamed from: com.google.android.gms.ads.internal.client.v */
public abstract class C0050v extends Binder implements C0049u {
    public static C0049u m5426a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0049u)) ? new C0051w(iBinder) : (C0049u) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        AdSizeParcel adSizeParcel = null;
        C0002a a;
        IBinder a2;
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                a = C0003b.m5322a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    adSizeParcel = AdSizeParcel.CREATOR.m5403a(parcel);
                }
                a2 = m5424a(a, adSizeParcel, parcel.readString(), da.m6266a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a2);
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                a = C0003b.m5322a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    adSizeParcel = AdSizeParcel.CREATOR.m5403a(parcel);
                }
                a2 = m5425a(a, adSizeParcel, parcel.readString(), da.m6266a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a2);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
