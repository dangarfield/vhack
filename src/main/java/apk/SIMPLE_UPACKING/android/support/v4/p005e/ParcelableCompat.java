package android.support.v4.p005e;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.e.e */
class ParcelableCompat implements Creator {
    final ParcelableCompatCreatorCallbacks f828a;

    public ParcelableCompat(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        this.f828a = parcelableCompatCreatorCallbacks;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.f828a.m677b(parcel, null);
    }

    public Object[] newArray(int i) {
        return this.f828a.m678b(i);
    }
}
