package com.google.android.gms.auth.api.credentials.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* renamed from: com.google.android.gms.auth.api.credentials.internal.j */
class C0131j implements C0129h {
    private IBinder f3211a;

    C0131j(IBinder iBinder) {
        this.f3211a = iBinder;
    }

    public void m5794a(C0126e c0126e) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            obtain.writeStrongBinder(c0126e != null ? c0126e.asBinder() : null);
            this.f3211a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5795a(C0126e c0126e, CredentialRequest credentialRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            obtain.writeStrongBinder(c0126e != null ? c0126e.asBinder() : null);
            if (credentialRequest != null) {
                obtain.writeInt(1);
                credentialRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3211a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5796a(C0126e c0126e, DeleteRequest deleteRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            obtain.writeStrongBinder(c0126e != null ? c0126e.asBinder() : null);
            if (deleteRequest != null) {
                obtain.writeInt(1);
                deleteRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3211a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5797a(C0126e c0126e, GeneratePasswordRequest generatePasswordRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            obtain.writeStrongBinder(c0126e != null ? c0126e.asBinder() : null);
            if (generatePasswordRequest != null) {
                obtain.writeInt(1);
                generatePasswordRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3211a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5798a(C0126e c0126e, SaveRequest saveRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            obtain.writeStrongBinder(c0126e != null ? c0126e.asBinder() : null);
            if (saveRequest != null) {
                obtain.writeInt(1);
                saveRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3211a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3211a;
    }
}
