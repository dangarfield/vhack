package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.ads.internal.reward.mediation.client.d */
public class C0097d implements Creator {
    static void m5625a(RewardItemParcel rewardItemParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, rewardItemParcel.f3087a);
        C0300c.m7957a(parcel, 2, rewardItemParcel.f3088b, false);
        C0300c.m7949a(parcel, 3, rewardItemParcel.f3089c);
        C0300c.m7947a(parcel, a);
    }

    public RewardItemParcel m5626a(Parcel parcel) {
        int i = 0;
        int b = C0298a.m7928b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new RewardItemParcel(i2, str, i);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public RewardItemParcel[] m5627a(int i) {
        return new RewardItemParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5626a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5627a(i);
    }
}
