package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public class at implements Creator {
    static void m8474a(EventParams eventParams, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, eventParams.f4627a);
        C0300c.m7951a(parcel, 2, eventParams.m8197b(), false);
        C0300c.m7947a(parcel, a);
    }

    public EventParams m8475a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    bundle = C0298a.m7941l(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParams(i, bundle);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public EventParams[] m8476a(int i) {
        return new EventParams[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8475a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8476a(i);
    }
}
