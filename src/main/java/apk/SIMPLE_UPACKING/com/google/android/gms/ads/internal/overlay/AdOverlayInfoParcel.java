package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.C0027a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p047a.C0003b;
import com.google.android.gms.p047a.C0005d;
import com.google.android.gms.p051b.bq;
import com.google.android.gms.p051b.cf;
import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.hb;

@fi
public final class AdOverlayInfoParcel implements SafeParcelable {
    public static final C0068k CREATOR;
    public final int f2999a;
    public final AdLauncherIntentInfoParcel f3000b;
    public final C0027a f3001c;
    public final C0069l f3002d;
    public final hb f3003e;
    public final bq f3004f;
    public final String f3005g;
    public final boolean f3006h;
    public final String f3007i;
    public final C0077t f3008j;
    public final int f3009k;
    public final int f3010l;
    public final String f3011m;
    public final VersionInfoParcel f3012n;
    public final cf f3013o;
    public final String f3014p;
    public final InterstitialAdParameterParcel f3015q;

    static {
        CREATOR = new C0068k();
    }

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.f2999a = i;
        this.f3000b = adLauncherIntentInfoParcel;
        this.f3001c = (C0027a) C0005d.m5324a(C0003b.m5322a(iBinder));
        this.f3002d = (C0069l) C0005d.m5324a(C0003b.m5322a(iBinder2));
        this.f3003e = (hb) C0005d.m5324a(C0003b.m5322a(iBinder3));
        this.f3004f = (bq) C0005d.m5324a(C0003b.m5322a(iBinder4));
        this.f3005g = str;
        this.f3006h = z;
        this.f3007i = str2;
        this.f3008j = (C0077t) C0005d.m5324a(C0003b.m5322a(iBinder5));
        this.f3009k = i2;
        this.f3010l = i3;
        this.f3011m = str3;
        this.f3012n = versionInfoParcel;
        this.f3013o = (cf) C0005d.m5324a(C0003b.m5322a(iBinder6));
        this.f3014p = str4;
        this.f3015q = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(C0027a c0027a, C0069l c0069l, C0077t c0077t, hb hbVar, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        this.f2999a = 4;
        this.f3000b = null;
        this.f3001c = c0027a;
        this.f3002d = c0069l;
        this.f3003e = hbVar;
        this.f3004f = null;
        this.f3005g = null;
        this.f3006h = z;
        this.f3007i = null;
        this.f3008j = c0077t;
        this.f3009k = i;
        this.f3010l = 2;
        this.f3011m = null;
        this.f3012n = versionInfoParcel;
        this.f3013o = null;
        this.f3014p = null;
        this.f3015q = null;
    }

    public AdOverlayInfoParcel(C0027a c0027a, C0069l c0069l, bq bqVar, C0077t c0077t, hb hbVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, cf cfVar) {
        this.f2999a = 4;
        this.f3000b = null;
        this.f3001c = c0027a;
        this.f3002d = c0069l;
        this.f3003e = hbVar;
        this.f3004f = bqVar;
        this.f3005g = null;
        this.f3006h = z;
        this.f3007i = null;
        this.f3008j = c0077t;
        this.f3009k = i;
        this.f3010l = 3;
        this.f3011m = str;
        this.f3012n = versionInfoParcel;
        this.f3013o = cfVar;
        this.f3014p = null;
        this.f3015q = null;
    }

    public AdOverlayInfoParcel(C0027a c0027a, C0069l c0069l, bq bqVar, C0077t c0077t, hb hbVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, cf cfVar) {
        this.f2999a = 4;
        this.f3000b = null;
        this.f3001c = c0027a;
        this.f3002d = c0069l;
        this.f3003e = hbVar;
        this.f3004f = bqVar;
        this.f3005g = str2;
        this.f3006h = z;
        this.f3007i = str;
        this.f3008j = c0077t;
        this.f3009k = i;
        this.f3010l = 3;
        this.f3011m = null;
        this.f3012n = versionInfoParcel;
        this.f3013o = cfVar;
        this.f3014p = null;
        this.f3015q = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, C0027a c0027a, C0069l c0069l, C0077t c0077t, VersionInfoParcel versionInfoParcel) {
        this.f2999a = 4;
        this.f3000b = adLauncherIntentInfoParcel;
        this.f3001c = c0027a;
        this.f3002d = c0069l;
        this.f3003e = null;
        this.f3004f = null;
        this.f3005g = null;
        this.f3006h = false;
        this.f3007i = null;
        this.f3008j = c0077t;
        this.f3009k = -1;
        this.f3010l = 4;
        this.f3011m = null;
        this.f3012n = versionInfoParcel;
        this.f3013o = null;
        this.f3014p = null;
        this.f3015q = null;
    }

    public static AdOverlayInfoParcel m5449a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void m5450a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    IBinder m5451a() {
        return C0005d.m5323a(this.f3001c).asBinder();
    }

    IBinder m5452b() {
        return C0005d.m5323a(this.f3002d).asBinder();
    }

    IBinder m5453c() {
        return C0005d.m5323a(this.f3003e).asBinder();
    }

    IBinder m5454d() {
        return C0005d.m5323a(this.f3004f).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    IBinder m5455e() {
        return C0005d.m5323a(this.f3013o).asBinder();
    }

    IBinder m5456f() {
        return C0005d.m5323a(this.f3008j).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0068k.m5508a(this, parcel, i);
    }
}
