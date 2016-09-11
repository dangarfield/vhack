package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.List;

public abstract class ay extends Binder implements ax {
    public ay() {
        attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public static ax m8497a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ax)) ? new az(iBinder) : (ax) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        AppMetadata appMetadata = null;
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                EventParcel a = parcel.readInt() != 0 ? EventParcel.CREATOR.m8478a(parcel) : null;
                if (parcel.readInt() != 0) {
                    appMetadata = AppMetadata.CREATOR.m8310a(parcel);
                }
                m8493a(a, appMetadata);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                UserAttributeParcel a2 = parcel.readInt() != 0 ? UserAttributeParcel.CREATOR.m8251a(parcel) : null;
                if (parcel.readInt() != 0) {
                    appMetadata = AppMetadata.CREATOR.m8310a(parcel);
                }
                m8495a(a2, appMetadata);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                if (parcel.readInt() != 0) {
                    appMetadata = AppMetadata.CREATOR.m8310a(parcel);
                }
                m8492a(appMetadata);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                EventParcel a3;
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                if (parcel.readInt() != 0) {
                    a3 = EventParcel.CREATOR.m8478a(parcel);
                }
                m8494a(a3, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                if (parcel.readInt() != 0) {
                    appMetadata = AppMetadata.CREATOR.m8310a(parcel);
                }
                m8496b(appMetadata);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                if (parcel.readInt() != 0) {
                    appMetadata = AppMetadata.CREATOR.m8310a(parcel);
                }
                List a4 = m8491a(appMetadata, parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeTypedList(a4);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
