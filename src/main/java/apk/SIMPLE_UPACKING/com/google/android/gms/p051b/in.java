package com.google.android.gms.p051b;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.b.in */
public abstract class in extends Binder implements im {
    public static im m6812a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof im)) ? new io(iBinder) : (im) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                parcel.enforceInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
                Intent a = m6811a(parcel.readInt() != 0 ? (GetConsentIntentRequest) GetConsentIntentRequest.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.consent.internal.IConsentService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
