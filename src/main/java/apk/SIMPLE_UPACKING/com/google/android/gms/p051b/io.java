package com.google.android.gms.p051b;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;

/* renamed from: com.google.android.gms.b.io */
class io implements im {
    private IBinder f3817a;

    io(IBinder iBinder) {
        this.f3817a = iBinder;
    }

    public Intent m6813a(GetConsentIntentRequest getConsentIntentRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.consent.internal.IConsentService");
            if (getConsentIntentRequest != null) {
                obtain.writeInt(1);
                getConsentIntentRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3817a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return intent;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3817a;
    }
}
