package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.ads.internal.util.client.c */
public class C0100c implements Creator {
    static void m5644a(VersionInfoParcel versionInfoParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, versionInfoParcel.f3091a);
        C0300c.m7957a(parcel, 2, versionInfoParcel.f3092b, false);
        C0300c.m7949a(parcel, 3, versionInfoParcel.f3093c);
        C0300c.m7949a(parcel, 4, versionInfoParcel.f3094d);
        C0300c.m7959a(parcel, 5, versionInfoParcel.f3095e);
        C0300c.m7947a(parcel, a);
    }

    public VersionInfoParcel m5645a(Parcel parcel) {
        boolean z = false;
        int b = C0298a.m7928b(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i3 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new VersionInfoParcel(i3, str, i2, i, z);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public VersionInfoParcel[] m5646a(int i) {
        return new VersionInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5645a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5646a(i);
    }
}
