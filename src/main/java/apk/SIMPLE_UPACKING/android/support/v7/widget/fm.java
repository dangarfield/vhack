package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: SearchView */
final class fm implements Creator {
    fm() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4581a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4582a(i);
    }

    public SavedState m4581a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m4582a(int i) {
        return new SavedState[i];
    }
}
