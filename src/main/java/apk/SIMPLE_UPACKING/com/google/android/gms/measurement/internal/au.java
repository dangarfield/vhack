package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public class au implements Creator {
    static void m8477a(EventParcel eventParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, eventParcel.f4629a);
        C0300c.m7957a(parcel, 2, eventParcel.f4630b, false);
        C0300c.m7953a(parcel, 3, eventParcel.f4631c, i, false);
        C0300c.m7957a(parcel, 4, eventParcel.f4632d, false);
        C0300c.m7950a(parcel, 5, eventParcel.f4633e);
        C0300c.m7947a(parcel, a);
    }

    public EventParcel m8478a(Parcel parcel) {
        String str = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    eventParams = (EventParams) C0298a.m7925a(parcel, a, EventParams.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    j = C0298a.m7935f(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParcel(i, str2, eventParams, str, j);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public EventParcel[] m8479a(int i) {
        return new EventParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8478a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8479a(i);
    }
}
