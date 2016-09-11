package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p051b.fi;

@fi
public final class AdLauncherIntentInfoParcel implements SafeParcelable {
    public static final C0058b CREATOR;
    public final int f2990a;
    public final String f2991b;
    public final String f2992c;
    public final String f2993d;
    public final String f2994e;
    public final String f2995f;
    public final String f2996g;
    public final String f2997h;
    public final Intent f2998i;

    static {
        CREATOR = new C0058b();
    }

    public AdLauncherIntentInfoParcel(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent) {
        this.f2990a = i;
        this.f2991b = str;
        this.f2992c = str2;
        this.f2993d = str3;
        this.f2994e = str4;
        this.f2995f = str5;
        this.f2996g = str6;
        this.f2997h = str7;
        this.f2998i = intent;
    }

    public AdLauncherIntentInfoParcel(Intent intent) {
        this(2, null, null, null, null, null, null, null, intent);
    }

    public AdLauncherIntentInfoParcel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(2, str, str2, str3, str4, str5, str6, str7, null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0058b.m5459a(this, parcel, i);
    }
}
