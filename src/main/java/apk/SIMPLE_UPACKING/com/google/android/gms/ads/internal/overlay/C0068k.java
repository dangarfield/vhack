package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.C0298a;
import com.google.android.gms.common.internal.safeparcel.C0299b;
import com.google.android.gms.common.internal.safeparcel.C0300c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.ads.internal.overlay.k */
public class C0068k implements Creator {
    static void m5508a(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int a = C0300c.m7946a(parcel);
        C0300c.m7949a(parcel, 1, adOverlayInfoParcel.f2999a);
        C0300c.m7953a(parcel, 2, adOverlayInfoParcel.f3000b, i, false);
        C0300c.m7952a(parcel, 3, adOverlayInfoParcel.m5451a(), false);
        C0300c.m7952a(parcel, 4, adOverlayInfoParcel.m5452b(), false);
        C0300c.m7952a(parcel, 5, adOverlayInfoParcel.m5453c(), false);
        C0300c.m7952a(parcel, 6, adOverlayInfoParcel.m5454d(), false);
        C0300c.m7957a(parcel, 7, adOverlayInfoParcel.f3005g, false);
        C0300c.m7959a(parcel, 8, adOverlayInfoParcel.f3006h);
        C0300c.m7957a(parcel, 9, adOverlayInfoParcel.f3007i, false);
        C0300c.m7952a(parcel, 10, adOverlayInfoParcel.m5456f(), false);
        C0300c.m7949a(parcel, 11, adOverlayInfoParcel.f3009k);
        C0300c.m7949a(parcel, 12, adOverlayInfoParcel.f3010l);
        C0300c.m7957a(parcel, 13, adOverlayInfoParcel.f3011m, false);
        C0300c.m7953a(parcel, 14, adOverlayInfoParcel.f3012n, i, false);
        C0300c.m7952a(parcel, 15, adOverlayInfoParcel.m5455e(), false);
        C0300c.m7953a(parcel, 17, adOverlayInfoParcel.f3015q, i, false);
        C0300c.m7957a(parcel, 16, adOverlayInfoParcel.f3014p, false);
        C0300c.m7947a(parcel, a);
    }

    public AdOverlayInfoParcel m5509a(Parcel parcel) {
        int b = C0298a.m7928b(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < b) {
            int a = C0298a.m7923a(parcel);
            switch (C0298a.m7922a(a)) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    i = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) C0298a.m7925a(parcel, a, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    iBinder = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    iBinder2 = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    iBinder3 = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    iBinder4 = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    z = C0298a.m7932c(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str2 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    iBinder5 = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                    i2 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i3 = C0298a.m7933d(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_useViewLifecycle /*13*/:
                    str3 = C0298a.m7939j(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_zOrderOnTop /*14*/:
                    versionInfoParcel = (VersionInfoParcel) C0298a.m7925a(parcel, a, VersionInfoParcel.CREATOR);
                    break;
                case C0001R.styleable.MapAttrs_uiMapToolbar /*15*/:
                    iBinder6 = C0298a.m7940k(parcel, a);
                    break;
                case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                    str4 = C0298a.m7939j(parcel, a);
                    break;
                case R.Toolbar_maxButtonHeight /*17*/:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) C0298a.m7925a(parcel, a, InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    C0298a.m7929b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        }
        throw new C0299b("Overread allowed size end=" + b, parcel);
    }

    public AdOverlayInfoParcel[] m5510a(int i) {
        return new AdOverlayInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5509a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5510a(i);
    }
}
