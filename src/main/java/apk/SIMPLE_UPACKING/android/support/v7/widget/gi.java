package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.Toolbar.SavedState;

/* compiled from: Toolbar */
final class gi implements Creator {
    gi() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4674a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4675a(i);
    }

    public SavedState m4674a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m4675a(int i) {
        return new SavedState[i];
    }
}
