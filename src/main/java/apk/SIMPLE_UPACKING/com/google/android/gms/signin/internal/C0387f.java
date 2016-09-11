package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.signin.internal.f */
class C0387f implements C0250d {
    private IBinder f4972a;

    C0387f(IBinder iBinder) {
        this.f4972a = iBinder;
    }

    public void m8958a(ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (connectionResult != null) {
                obtain.writeInt(1);
                connectionResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (authAccountResult != null) {
                obtain.writeInt(1);
                authAccountResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4972a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m8959a(Status status) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4972a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m8960a(Status status, GoogleSignInAccount googleSignInAccount) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (googleSignInAccount != null) {
                obtain.writeInt(1);
                googleSignInAccount.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4972a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m8961a(SignInResponse signInResponse) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (signInResponse != null) {
                obtain.writeInt(1);
                signInResponse.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4972a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f4972a;
    }

    public void m8962b(Status status) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4972a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
