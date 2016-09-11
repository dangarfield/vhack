package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Fragment */
final class ao implements Creator {
    ao() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m892a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m893a(i);
    }

    public FragmentState m892a(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] m893a(int i) {
        return new FragmentState[i];
    }
}
