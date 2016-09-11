package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.support.v7.p018b.R;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;

/* renamed from: com.google.android.gms.auth.api.signin.internal.r */
class C0178r implements C0176p {
    private IBinder f3345a;

    C0178r(IBinder iBinder) {
        this.f3345a = iBinder;
    }

    public void m6034a(C0159m c0159m, GoogleSignInOptions googleSignInOptions) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            obtain.writeStrongBinder(c0159m != null ? c0159m.asBinder() : null);
            if (googleSignInOptions != null) {
                obtain.writeInt(1);
                googleSignInOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3345a.transact(R.AppCompatTheme_buttonStyleSmall, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m6035a(C0159m c0159m, SignInConfiguration signInConfiguration) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            obtain.writeStrongBinder(c0159m != null ? c0159m.asBinder() : null);
            if (signInConfiguration != null) {
                obtain.writeInt(1);
                signInConfiguration.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3345a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m6036a(C0159m c0159m, SignInConfiguration signInConfiguration, SignInAccount signInAccount, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            obtain.writeStrongBinder(c0159m != null ? c0159m.asBinder() : null);
            if (signInConfiguration != null) {
                obtain.writeInt(1);
                signInConfiguration.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (signInAccount != null) {
                obtain.writeInt(1);
                signInAccount.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            this.f3345a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3345a;
    }

    public void m6037b(C0159m c0159m, GoogleSignInOptions googleSignInOptions) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            obtain.writeStrongBinder(c0159m != null ? c0159m.asBinder() : null);
            if (googleSignInOptions != null) {
                obtain.writeInt(1);
                googleSignInOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3345a.transact(R.AppCompatTheme_checkboxStyle, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m6038b(C0159m c0159m, SignInConfiguration signInConfiguration) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            obtain.writeStrongBinder(c0159m != null ? c0159m.asBinder() : null);
            if (signInConfiguration != null) {
                obtain.writeInt(1);
                signInConfiguration.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3345a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m6039c(C0159m c0159m, GoogleSignInOptions googleSignInOptions) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            obtain.writeStrongBinder(c0159m != null ? c0159m.asBinder() : null);
            if (googleSignInOptions != null) {
                obtain.writeInt(1);
                googleSignInOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3345a.transact(R.AppCompatTheme_checkedTextViewStyle, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
