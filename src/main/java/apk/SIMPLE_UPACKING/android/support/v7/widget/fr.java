package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: StaggeredGridLayoutManager */
final class fr implements Creator {
    fr() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4588a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4589a(i);
    }

    public FullSpanItem m4588a(Parcel parcel) {
        return new FullSpanItem(parcel);
    }

    public FullSpanItem[] m4589a(int i) {
        return new FullSpanItem[i];
    }
}
