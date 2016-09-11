package android.support.v4.p002h;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewParentCompat */
/* renamed from: android.support.v4.h.db */
public final class db {
    static final dd f938a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f938a = new df();
        } else if (i >= 19) {
            f938a = new de();
        } else if (i >= 14) {
            f938a = new dc();
        } else {
            f938a = new dg();
        }
    }

    public static boolean m2247a(ViewParent viewParent, View view, View view2, int i) {
        return f938a.m2254a(viewParent, view, view2, i);
    }

    public static void m2248b(ViewParent viewParent, View view, View view2, int i) {
        f938a.m2255b(viewParent, view, view2, i);
    }

    public static void m2242a(ViewParent viewParent, View view) {
        f938a.m2249a(viewParent, view);
    }

    public static void m2243a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f938a.m2250a(viewParent, view, i, i2, i3, i4);
    }

    public static void m2244a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f938a.m2251a(viewParent, view, i, i2, iArr);
    }

    public static boolean m2246a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f938a.m2253a(viewParent, view, f, f2, z);
    }

    public static boolean m2245a(ViewParent viewParent, View view, float f, float f2) {
        return f938a.m2252a(viewParent, view, f, f2);
    }
}
