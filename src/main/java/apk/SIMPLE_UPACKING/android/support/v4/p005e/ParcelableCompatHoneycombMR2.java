package android.support.v4.p005e;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* renamed from: android.support.v4.e.g */
class ParcelableCompatHoneycombMR2 implements ClassLoaderCreator {
    private final ParcelableCompatCreatorCallbacks f829a;

    public ParcelableCompatHoneycombMR2(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        this.f829a = parcelableCompatCreatorCallbacks;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.f829a.m677b(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f829a.m677b(parcel, classLoader);
    }

    public Object[] newArray(int i) {
        return this.f829a.m678b(i);
    }
}
