package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C0046n;

/* renamed from: com.google.android.gms.ads.c */
public final class C0016c {
    public static final C0016c f2866a;
    public static final C0016c f2867b;
    public static final C0016c f2868c;
    public static final C0016c f2869d;
    public static final C0016c f2870e;
    public static final C0016c f2871f;
    public static final C0016c f2872g;
    public static final C0016c f2873h;
    private final int f2874i;
    private final int f2875j;
    private final String f2876k;

    static {
        f2866a = new C0016c(320, 50, "320x50_mb");
        f2867b = new C0016c(468, 60, "468x60_as");
        f2868c = new C0016c(320, 100, "320x100_as");
        f2869d = new C0016c(728, 90, "728x90_as");
        f2870e = new C0016c(300, 250, "300x250_as");
        f2871f = new C0016c(160, 600, "160x600_as");
        f2872g = new C0016c(-1, -2, "smart_banner");
        f2873h = new C0016c(-3, -4, "fluid");
    }

    public C0016c(int i, int i2) {
        this(i, i2, (i == -1 ? "FULL" : String.valueOf(i)) + "x" + (i2 == -2 ? "AUTO" : String.valueOf(i2)) + "_as");
    }

    C0016c(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.f2874i = i;
            this.f2875j = i2;
            this.f2876k = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public int m5335a() {
        return this.f2875j;
    }

    public int m5336a(Context context) {
        switch (this.f2875j) {
            case -4:
            case -3:
                return -1;
            case -2:
                return AdSizeParcel.m5350b(context.getResources().getDisplayMetrics());
            default:
                return C0046n.m5409a().m5628a(context, this.f2875j);
        }
    }

    public int m5337b() {
        return this.f2874i;
    }

    public int m5338b(Context context) {
        switch (this.f2874i) {
            case -4:
            case -3:
                return -1;
            case -1:
                return AdSizeParcel.m5349a(context.getResources().getDisplayMetrics());
            default:
                return C0046n.m5409a().m5628a(context, this.f2874i);
        }
    }

    public boolean m5339c() {
        return this.f2874i == -3 && this.f2875j == -4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0016c)) {
            return false;
        }
        C0016c c0016c = (C0016c) obj;
        return this.f2874i == c0016c.f2874i && this.f2875j == c0016c.f2875j && this.f2876k.equals(c0016c.f2876k);
    }

    public int hashCode() {
        return this.f2876k.hashCode();
    }

    public String toString() {
        return this.f2876k;
    }
}
