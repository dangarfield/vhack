package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.C0015b;
import com.google.android.gms.ads.C0018d;
import com.google.android.gms.ads.C0020g;
import com.google.android.gms.ads.p048a.C0011d;
import com.google.android.gms.ads.p048a.C0012e;
import com.google.android.gms.ads.p049b.C0014a;
import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.kn;

@fi
/* renamed from: com.google.android.gms.ads.internal.util.client.a */
public class C0098a {
    public static final Handler f3096a;
    private static final String f3097b;
    private static final String f3098c;
    private static final String f3099d;
    private static final String f3100e;
    private static final String f3101f;
    private static final String f3102g;

    static {
        f3096a = new Handler(Looper.getMainLooper());
        f3097b = C0018d.class.getName();
        f3098c = C0020g.class.getName();
        f3099d = C0011d.class.getName();
        f3100e = C0012e.class.getName();
        f3101f = C0014a.class.getName();
        f3102g = C0015b.class.getName();
    }

    public int m5628a(Context context, int i) {
        return m5629a(context.getResources().getDisplayMetrics(), i);
    }

    public int m5629a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public boolean m5630a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean m5631a(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    public int m5632b(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return m5633b(displayMetrics, i);
    }

    public int m5633b(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    public boolean m5634b(Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (kn.m6936d()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            i = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        } else {
            try {
                i = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        boolean z = displayMetrics.heightPixels == i && displayMetrics.widthPixels == i2;
        return z;
    }

    public int m5635c(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }
}
