package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: FragmentManager */
final class an implements Creator {
    an() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m890a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m891a(i);
    }

    public FragmentManagerState m890a(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    public FragmentManagerState[] m891a(int i) {
        return new FragmentManagerState[i];
    }
}
