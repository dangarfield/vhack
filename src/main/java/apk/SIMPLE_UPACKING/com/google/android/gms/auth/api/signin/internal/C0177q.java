package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.signin.internal.q */
public abstract class C0177q extends Binder implements C0176p {
    public static C0176p m6033a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0176p)) ? new C0178r(iBinder) : (C0176p) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m6028a(C0160n.m5957a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m6031b(C0160n.m5957a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m6029a(C0160n.m5957a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (SignInAccount) SignInAccount.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_buttonStyleSmall /*101*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m6027a(C0160n.m5957a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_checkboxStyle /*102*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m6030b(C0160n.m5957a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_checkedTextViewStyle /*103*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                m6032c(C0160n.m5957a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
