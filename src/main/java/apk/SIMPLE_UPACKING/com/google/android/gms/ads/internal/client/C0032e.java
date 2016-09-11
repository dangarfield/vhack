package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.ads.internal.client.e */
public class C0032e implements Creator {
    static void m5382a(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, searchAdRequestParcel.f2920a);
        C0300c.m7949a(parcel, 2, searchAdRequestParcel.f2921b);
        C0300c.m7949a(parcel, 3, searchAdRequestParcel.f2922c);
        C0300c.m7949a(parcel, 4, searchAdRequestParcel.f2923d);
        C0300c.m7949a(parcel, 5, searchAdRequestParcel.f2924e);
        C0300c.m7949a(parcel, 6, searchAdRequestParcel.f2925f);
        C0300c.m7949a(parcel, 7, searchAdRequestParcel.f2926g);
        C0300c.m7949a(parcel, 8, searchAdRequestParcel.f2927h);
        C0300c.m7949a(parcel, 9, searchAdRequestParcel.f2928i);
        C0300c.m7957a(parcel, 10, searchAdRequestParcel.f2929j, false);
        C0300c.m7949a(parcel, 11, searchAdRequestParcel.f2930k);
        C0300c.m7957a(parcel, 12, searchAdRequestParcel.f2931l, false);
        C0300c.m7949a(parcel, 13, searchAdRequestParcel.f2932m);
        C0300c.m7949a(parcel, 14, searchAdRequestParcel.f2933n);
        C0300c.m7957a(parcel, 15, searchAdRequestParcel.f2934o, false);
        C0300c.m7947a(parcel, a);
    }

    public SearchAdRequestParcel m5383a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i3 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    i4 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    i5 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    i6 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i7 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    i8 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    i9 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                    i10 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_useViewLifecycle /*13*/:
                    i11 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_zOrderOnTop /*14*/:
                    i12 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiMapToolbar /*15*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public SearchAdRequestParcel[] m5384a(int i) {
        return new SearchAdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5383a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5384a(i);
    }
}
