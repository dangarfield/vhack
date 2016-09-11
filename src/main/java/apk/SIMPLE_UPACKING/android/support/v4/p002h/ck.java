package android.support.v4.p002h;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewCompatHC */
/* renamed from: android.support.v4.h.ck */
class ck {
    static long m2175a() {
        return ValueAnimator.getFrameDelay();
    }

    public static float m2172a(View view) {
        return view.getAlpha();
    }

    public static void m2178a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int m2180b(View view) {
        return view.getLayerType();
    }

    public static int m2174a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int m2184c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int m2186d(View view) {
        return view.getMeasuredState();
    }

    public static float m2187e(View view) {
        return view.getTranslationX();
    }

    public static float m2188f(View view) {
        return view.getTranslationY();
    }

    public static void m2176a(View view, float f) {
        view.setTranslationX(f);
    }

    public static void m2181b(View view, float f) {
        view.setTranslationY(f);
    }

    public static void m2185c(View view, float f) {
        view.setAlpha(f);
    }

    public static void m2189g(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void m2179a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static void m2183b(View view, boolean z) {
        view.setActivated(z);
    }

    public static int m2173a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    static void m2177a(View view, int i) {
        view.offsetTopAndBottom(i);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            ck.m2190h((View) parent);
        }
    }

    static void m2182b(View view, int i) {
        view.offsetLeftAndRight(i);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            ck.m2190h((View) parent);
        }
    }

    private static void m2190h(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
