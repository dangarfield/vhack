package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView.SavedState;

/* compiled from: RecyclerView */
final class es implements Creator {
    es() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4447a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4448a(i);
    }

    public SavedState m4447a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m4448a(int i) {
        return new SavedState[i];
    }
}
