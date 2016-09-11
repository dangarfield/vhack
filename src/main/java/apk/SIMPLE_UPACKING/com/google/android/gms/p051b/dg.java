package com.google.android.gms.p051b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.b.dg */
public abstract class dg extends Binder implements df {
    public static df m6317a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof df)) ? new dh(iBinder) : (df) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                m6310a();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                m6313b();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                m6311a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                m6314c();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                m6315d();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                m6316e();
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                m6312a(dk.m6327a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
