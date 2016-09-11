package com.google.android.gms.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C0001R;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.signin.internal.e */
public abstract class C0251e extends Binder implements C0250d {
    public C0251e() {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public static C0250d m7531a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0250d)) ? new C0387f(iBinder) : (C0250d) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                m7526a(parcel.readInt() != 0 ? (ConnectionResult) ConnectionResult.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (AuthAccountResult) AuthAccountResult.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                m7527a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                m7530b(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                m7528a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (GoogleSignInAccount) GoogleSignInAccount.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                m7529a(parcel.readInt() != 0 ? (SignInResponse) SignInResponse.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.signin.internal.ISignInCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
