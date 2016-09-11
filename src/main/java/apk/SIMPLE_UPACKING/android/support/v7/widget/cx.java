package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutManager.SavedState;

/* compiled from: LinearLayoutManager */
final class cx implements Creator {
    cx() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4273a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4274a(i);
    }

    public SavedState m4273a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m4274a(int i) {
        return new SavedState[i];
    }
}
