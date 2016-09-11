package com.fyber.utils.cookies;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.fyber.utils.cookies.a */
final class ParcelableHttpCookie implements Creator {
    ParcelableHttpCookie() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ParcelableHttpCookie[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ParcelableHttpCookie(parcel);
    }
}
