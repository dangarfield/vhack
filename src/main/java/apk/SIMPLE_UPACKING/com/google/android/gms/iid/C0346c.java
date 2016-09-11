package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.iid.c */
final class C0346c implements Creator {
    C0346c() {
    }

    public MessengerCompat m8140a(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
    }

    public MessengerCompat[] m8141a(int i) {
        return new MessengerCompat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8140a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8141a(i);
    }
}
