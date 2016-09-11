package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.ads.internal.e */
public class C0053e implements Creator {
    static void m5430a(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, interstitialAdParameterParcel.f2879a);
        C0300c.m7959a(parcel, 2, interstitialAdParameterParcel.f2880b);
        C0300c.m7959a(parcel, 3, interstitialAdParameterParcel.f2881c);
        C0300c.m7957a(parcel, 4, interstitialAdParameterParcel.f2882d, false);
        C0300c.m7959a(parcel, 5, interstitialAdParameterParcel.f2883e);
        C0300c.m7948a(parcel, 6, interstitialAdParameterParcel.f2884f);
        C0300c.m7947a(parcel, a);
    }

    public InterstitialAdParameterParcel m5431a(Parcel parcel) {
        boolean z = false;
        int b = C0298a.m7928b(parcel);
        String str = null;
        float f = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    z3 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    z2 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    f = C0298a.m7937h(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new InterstitialAdParameterParcel(i, z3, z2, str, z, f);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public InterstitialAdParameterParcel[] m5432a(int i) {
        return new InterstitialAdParameterParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5431a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5432a(i);
    }
}
