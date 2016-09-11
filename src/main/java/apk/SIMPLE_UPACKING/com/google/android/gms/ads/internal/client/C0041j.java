package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.ads.internal.client.j */
public class C0041j implements Creator {
    static void m5402a(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, adSizeParcel.f2909a);
        C0300c.m7957a(parcel, 2, adSizeParcel.f2910b, false);
        C0300c.m7949a(parcel, 3, adSizeParcel.f2911c);
        C0300c.m7949a(parcel, 4, adSizeParcel.f2912d);
        C0300c.m7959a(parcel, 5, adSizeParcel.f2913e);
        C0300c.m7949a(parcel, 6, adSizeParcel.f2914f);
        C0300c.m7949a(parcel, 7, adSizeParcel.f2915g);
        C0300c.m7961a(parcel, 8, adSizeParcel.f2916h, i, false);
        C0300c.m7959a(parcel, 9, adSizeParcel.f2917i);
        C0300c.m7959a(parcel, 10, adSizeParcel.f2918j);
        C0300c.m7959a(parcel, 11, adSizeParcel.f2919k);
        C0300c.m7947a(parcel, a);
    }

    public AdSizeParcel m5403a(Parcel parcel) {
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z = false;
        int b = C0298a.m7928b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i5 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i4 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    i3 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    z4 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    adSizeParcelArr = (AdSizeParcel[]) C0298a.m7930b(parcel, a, AdSizeParcel.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    z3 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    z2 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdSizeParcel(i5, str, i4, i3, z4, i2, i, adSizeParcelArr, z3, z2, z);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public AdSizeParcel[] m5404a(int i) {
        return new AdSizeParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5403a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5404a(i);
    }
}
