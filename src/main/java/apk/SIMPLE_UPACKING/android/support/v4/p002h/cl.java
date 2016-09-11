package android.support.v4.p002h;

import android.view.View;
import android.view.View.AccessibilityDelegate;

/* compiled from: ViewCompatICS */
/* renamed from: android.support.v4.h.cl */
class cl {
    public static boolean m2193a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m2194b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void m2191a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static void m2192a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }
}
