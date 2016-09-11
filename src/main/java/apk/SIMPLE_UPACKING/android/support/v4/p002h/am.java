package android.support.v4.p002h;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MarginLayoutParamsCompat */
/* renamed from: android.support.v4.h.am */
public final class am {
    static final an f911a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f911a = new ap();
        } else {
            f911a = new ao();
        }
    }

    public static int m1780a(MarginLayoutParams marginLayoutParams) {
        return f911a.m1782a(marginLayoutParams);
    }

    public static int m1781b(MarginLayoutParams marginLayoutParams) {
        return f911a.m1783b(marginLayoutParams);
    }
}
