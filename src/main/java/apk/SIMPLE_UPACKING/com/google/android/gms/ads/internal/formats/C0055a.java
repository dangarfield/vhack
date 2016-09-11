package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.ads.internal.formats.a */
public class C0055a implements Creator {
    static void m5433a(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, nativeAdOptionsParcel.f2964a);
        C0300c.m7959a(parcel, 2, nativeAdOptionsParcel.f2965b);
        C0300c.m7949a(parcel, 3, nativeAdOptionsParcel.f2966c);
        C0300c.m7959a(parcel, 4, nativeAdOptionsParcel.f2967d);
        C0300c.m7947a(parcel, a);
    }

    public NativeAdOptionsParcel m5434a(Parcel parcel) {
        boolean z = false;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    z2 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new NativeAdOptionsParcel(i2, z2, i, z);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public NativeAdOptionsParcel[] m5435a(int i) {
        return new NativeAdOptionsParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5434a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5435a(i);
    }
}
