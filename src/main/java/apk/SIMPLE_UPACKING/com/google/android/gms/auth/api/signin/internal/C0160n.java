package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.signin.internal.n */
public abstract class C0160n extends Binder implements C0159m {
    public C0160n() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    public static C0159m m5957a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0159m)) ? new C0175o(iBinder) : (C0159m) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                m5953a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (SignInAccount) SignInAccount.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                m5952a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                m5954a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_buttonStyleSmall /*101*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                m5951a(parcel.readInt() != 0 ? (GoogleSignInAccount) GoogleSignInAccount.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_checkboxStyle /*102*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                m5955b(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case R.AppCompatTheme_checkedTextViewStyle /*103*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                m5956c(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
