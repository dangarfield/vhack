package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.StaggeredGridLayoutManager.SavedState;

/* compiled from: StaggeredGridLayoutManager */
final class fs implements Creator {
    fs() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4590a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4591a(i);
    }

    public SavedState m4590a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m4591a(int i) {
        return new SavedState[i];
    }
}
