package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

class az implements ax {
    private IBinder f4722a;

    az(IBinder iBinder) {
        this.f4722a = iBinder;
    }

    public List m8498a(AppMetadata appMetadata, boolean z) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            this.f4722a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            List createTypedArrayList = obtain2.createTypedArrayList(UserAttributeParcel.CREATOR);
            return createTypedArrayList;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m8499a(AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4722a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m8500a(EventParcel eventParcel, AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4722a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m8501a(EventParcel eventParcel, String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f4722a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m8502a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (userAttributeParcel != null) {
                obtain.writeInt(1);
                userAttributeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4722a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f4722a;
    }

    public void m8503b(AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4722a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
