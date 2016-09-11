package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.ads.internal.overlay.b */
public class C0058b implements Creator {
    static void m5459a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, adLauncherIntentInfoParcel.f2990a);
        C0300c.m7957a(parcel, 2, adLauncherIntentInfoParcel.f2991b, false);
        C0300c.m7957a(parcel, 3, adLauncherIntentInfoParcel.f2992c, false);
        C0300c.m7957a(parcel, 4, adLauncherIntentInfoParcel.f2993d, false);
        C0300c.m7957a(parcel, 5, adLauncherIntentInfoParcel.f2994e, false);
        C0300c.m7957a(parcel, 6, adLauncherIntentInfoParcel.f2995f, false);
        C0300c.m7957a(parcel, 7, adLauncherIntentInfoParcel.f2996g, false);
        C0300c.m7957a(parcel, 8, adLauncherIntentInfoParcel.f2997h, false);
        C0300c.m7953a(parcel, 9, adLauncherIntentInfoParcel.f2998i, i, false);
        C0300c.m7947a(parcel, a);
    }

    public AdLauncherIntentInfoParcel m5460a(Parcel parcel) {
        Intent intent = null;
        int b = C0298a.m7928b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str7 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str6 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str5 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str4 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    intent = (Intent) C0298a.m7925a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdLauncherIntentInfoParcel(i, str7, str6, str5, str4, str3, str2, str, intent);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public AdLauncherIntentInfoParcel[] m5461a(int i) {
        return new AdLauncherIntentInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5460a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5461a(i);
    }
}
