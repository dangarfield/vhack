package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.auth.api.signin.internal.l */
public abstract class C0174l extends Binder implements C0173k {
    public C0174l() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.IRevocationService");
                m6020a();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.signin.internal.IRevocationService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
