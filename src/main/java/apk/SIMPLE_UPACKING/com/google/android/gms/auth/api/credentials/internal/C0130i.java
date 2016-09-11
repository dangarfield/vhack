package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C0001R;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.credentials.internal.i */
public abstract class C0130i extends Binder implements C0129h {
    public static C0129h m5793a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0129h)) ? new C0131j(iBinder) : (C0129h) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        GeneratePasswordRequest generatePasswordRequest = null;
        C0126e a;
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                CredentialRequest credentialRequest;
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                a = C0127f.m5784a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    credentialRequest = (CredentialRequest) CredentialRequest.CREATOR.createFromParcel(parcel);
                }
                m5789a(a, credentialRequest);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                SaveRequest saveRequest;
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                a = C0127f.m5784a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    saveRequest = (SaveRequest) SaveRequest.CREATOR.createFromParcel(parcel);
                }
                m5792a(a, saveRequest);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                DeleteRequest deleteRequest;
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                a = C0127f.m5784a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    deleteRequest = (DeleteRequest) DeleteRequest.CREATOR.createFromParcel(parcel);
                }
                m5790a(a, deleteRequest);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                m5788a(C0127f.m5784a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                a = C0127f.m5784a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    generatePasswordRequest = (GeneratePasswordRequest) GeneratePasswordRequest.CREATOR.createFromParcel(parcel);
                }
                m5791a(a, generatePasswordRequest);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
