package android.support.v4.p002h;

import android.view.View;

/* compiled from: ViewCompatJB */
/* renamed from: android.support.v4.h.cn */
class cn {
    public static boolean m2199a(View view) {
        return view.hasTransientState();
    }

    public static void m2200b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m2197a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m2198a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int m2201c(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m2196a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static int m2202d(View view) {
        return view.getMinimumWidth();
    }

    public static int m2203e(View view) {
        return view.getMinimumHeight();
    }

    public static void m2204f(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m2205g(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean m2206h(View view) {
        return view.hasOverlappingRendering();
    }
}
