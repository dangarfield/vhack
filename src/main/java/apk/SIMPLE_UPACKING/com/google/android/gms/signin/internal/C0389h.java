package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.aq;
import com.google.android.gms.common.internal.ba;

/* renamed from: com.google.android.gms.signin.internal.h */
public abstract class C0389h extends Binder implements C0388g {
    public static C0388g m8973a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0388g)) ? new C0390i(iBinder) : (C0388g) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = false;
        SignInRequest signInRequest = null;
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                AuthAccountRequest authAccountRequest;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    authAccountRequest = (AuthAccountRequest) AuthAccountRequest.CREATOR.createFromParcel(parcel);
                }
                m8965a(authAccountRequest, C0251e.m7531a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                CheckServerAuthResult checkServerAuthResult;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    checkServerAuthResult = (CheckServerAuthResult) CheckServerAuthResult.CREATOR.createFromParcel(parcel);
                }
                m8968a(checkServerAuthResult);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                m8972a(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                ResolveAccountRequest resolveAccountRequest;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    resolveAccountRequest = (ResolveAccountRequest) ResolveAccountRequest.CREATOR.createFromParcel(parcel);
                }
                m8966a(resolveAccountRequest, ba.m7867a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                m8963a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                Account account;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    account = (Account) Account.CREATOR.createFromParcel(parcel);
                }
                m8964a(readInt, account, C0251e.m7531a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                ap a = aq.m7703a(parcel.readStrongBinder());
                int readInt2 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                m8967a(a, readInt2, z);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                RecordConsentRequest recordConsentRequest;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    recordConsentRequest = (RecordConsentRequest) RecordConsentRequest.CREATOR.createFromParcel(parcel);
                }
                m8969a(recordConsentRequest, C0251e.m7531a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                m8971a(C0251e.m7531a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    signInRequest = (SignInRequest) SignInRequest.CREATOR.createFromParcel(parcel);
                }
                m8970a(signInRequest, C0251e.m7531a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
