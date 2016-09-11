package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.C0016c;
import com.google.android.gms.ads.C0021h;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p051b.fi;

@fi
public class AdSizeParcel implements SafeParcelable {
    public static final C0041j CREATOR;
    public final int f2909a;
    public final String f2910b;
    public final int f2911c;
    public final int f2912d;
    public final boolean f2913e;
    public final int f2914f;
    public final int f2915g;
    public final AdSizeParcel[] f2916h;
    public final boolean f2917i;
    public final boolean f2918j;
    public boolean f2919k;

    static {
        CREATOR = new C0041j();
    }

    public AdSizeParcel() {
        this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    AdSizeParcel(int i, String str, int i2, int i3, boolean z, int i4, int i5, AdSizeParcel[] adSizeParcelArr, boolean z2, boolean z3, boolean z4) {
        this.f2909a = i;
        this.f2910b = str;
        this.f2911c = i2;
        this.f2912d = i3;
        this.f2913e = z;
        this.f2914f = i4;
        this.f2915g = i5;
        this.f2916h = adSizeParcelArr;
        this.f2917i = z2;
        this.f2918j = z3;
        this.f2919k = z4;
    }

    public AdSizeParcel(Context context, C0016c c0016c) {
        this(context, new C0016c[]{c0016c});
    }

    public AdSizeParcel(Context context, C0016c[] c0016cArr) {
        int i;
        int i2;
        C0016c c0016c = c0016cArr[0];
        this.f2909a = 5;
        this.f2913e = false;
        this.f2918j = c0016c.m5339c();
        if (this.f2918j) {
            this.f2914f = C0016c.f2866a.m5337b();
            this.f2911c = C0016c.f2866a.m5335a();
        } else {
            this.f2914f = c0016c.m5337b();
            this.f2911c = c0016c.m5335a();
        }
        boolean z = this.f2914f == -1;
        boolean z2 = this.f2911c == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (C0046n.m5409a().m5631a(context) && C0046n.m5409a().m5634b(context)) {
                this.f2915g = m5349a(displayMetrics) - C0046n.m5409a().m5635c(context);
            } else {
                this.f2915g = m5349a(displayMetrics);
            }
            double d = (double) (((float) this.f2915g) / displayMetrics.density);
            i = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i++;
            }
            i2 = i;
        } else {
            i = this.f2914f;
            this.f2915g = C0046n.m5409a().m5629a(displayMetrics, this.f2914f);
            i2 = i;
        }
        i = z2 ? m5351c(displayMetrics) : this.f2911c;
        this.f2912d = C0046n.m5409a().m5629a(displayMetrics, i);
        if (z || z2) {
            this.f2910b = i2 + "x" + i + "_as";
        } else if (this.f2918j) {
            this.f2910b = "320x50_mb";
        } else {
            this.f2910b = c0016c.toString();
        }
        if (c0016cArr.length > 1) {
            this.f2916h = new AdSizeParcel[c0016cArr.length];
            for (int i3 = 0; i3 < c0016cArr.length; i3++) {
                this.f2916h[i3] = new AdSizeParcel(context, c0016cArr[i3]);
            }
        } else {
            this.f2916h = null;
        }
        this.f2917i = false;
        this.f2919k = false;
    }

    public static int m5349a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int m5350b(DisplayMetrics displayMetrics) {
        return (int) (((float) m5351c(displayMetrics)) * displayMetrics.density);
    }

    private static int m5351c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public C0016c m5352a() {
        return C0021h.m5341a(this.f2914f, this.f2911c, this.f2910b);
    }

    public void m5353a(boolean z) {
        this.f2919k = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0041j.m5402a(this, parcel, i);
    }
}
