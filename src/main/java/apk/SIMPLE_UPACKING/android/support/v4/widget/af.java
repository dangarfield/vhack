package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: NestedScrollView */
final class af implements Creator {
    af() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2495a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2496a(i);
    }

    public SavedState m2495a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m2496a(int i) {
        return new SavedState[i];
    }
}
