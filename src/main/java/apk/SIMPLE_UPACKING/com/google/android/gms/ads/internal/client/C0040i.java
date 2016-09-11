package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.List;

/* renamed from: com.google.android.gms.ads.internal.client.i */
public class C0040i implements Creator {
    static void m5399a(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, adRequestParcel.f2891a);
        C0300c.m7950a(parcel, 2, adRequestParcel.f2892b);
        C0300c.m7951a(parcel, 3, adRequestParcel.f2893c, false);
        C0300c.m7949a(parcel, 4, adRequestParcel.f2894d);
        C0300c.m7966b(parcel, 5, adRequestParcel.f2895e, false);
        C0300c.m7959a(parcel, 6, adRequestParcel.f2896f);
        C0300c.m7949a(parcel, 7, adRequestParcel.f2897g);
        C0300c.m7959a(parcel, 8, adRequestParcel.f2898h);
        C0300c.m7957a(parcel, 9, adRequestParcel.f2899i, false);
        C0300c.m7953a(parcel, 10, adRequestParcel.f2900j, i, false);
        C0300c.m7953a(parcel, 11, adRequestParcel.f2901k, i, false);
        C0300c.m7957a(parcel, 12, adRequestParcel.f2902l, false);
        C0300c.m7951a(parcel, 13, adRequestParcel.f2903m, false);
        C0300c.m7951a(parcel, 14, adRequestParcel.f2904n, false);
        C0300c.m7966b(parcel, 15, adRequestParcel.f2905o, false);
        C0300c.m7957a(parcel, 17, adRequestParcel.f2907q, false);
        C0300c.m7957a(parcel, 16, adRequestParcel.f2906p, false);
        C0300c.m7959a(parcel, 18, adRequestParcel.f2908r);
        C0300c.m7947a(parcel, a);
    }

    public AdRequestParcel m5400a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    j = C0298a.m7935f(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    bundle = C0298a.m7941l(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    list = C0298a.m7945p(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i3 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    z2 = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    searchAdRequestParcel = (SearchAdRequestParcel) C0298a.m7925a(parcel, a, SearchAdRequestParcel.CREATOR);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                    location = (Location) C0298a.m7925a(parcel, a, Location.CREATOR);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_useViewLifecycle /*13*/:
                    bundle2 = C0298a.m7941l(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_zOrderOnTop /*14*/:
                    bundle3 = C0298a.m7941l(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiMapToolbar /*15*/:
                    list2 = C0298a.m7945p(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case R.Toolbar_maxButtonHeight /*17*/:
                    str4 = C0298a.m7939j(parcel, a);
                    break;
                case R.Toolbar_collapseIcon /*18*/:
                    z3 = C0298a.m7932c(parcel, a);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public AdRequestParcel[] m5401a(int i) {
        return new AdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5400a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5401a(i);
    }
}
