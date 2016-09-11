package android.support.v4.p002h;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* compiled from: ViewConfigurationCompat */
/* renamed from: android.support.v4.h.ct */
public final class ct {
    static final cy f937a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f937a = new cx();
        } else if (VERSION.SDK_INT >= 11) {
            f937a = new cw();
        } else if (VERSION.SDK_INT >= 8) {
            f937a = new cv();
        } else {
            f937a = new cu();
        }
    }

    public static int m2231a(ViewConfiguration viewConfiguration) {
        return f937a.m2233a(viewConfiguration);
    }

    public static boolean m2232b(ViewConfiguration viewConfiguration) {
        return f937a.m2234b(viewConfiguration);
    }
}
