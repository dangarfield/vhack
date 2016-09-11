package android.support.v4.p002h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: ViewCompatLollipop */
/* renamed from: android.support.v4.h.cq */
class cq {
    public static void m2217a(View view) {
        view.requestApplyInsets();
    }

    public static void m2218a(View view, float f) {
        view.setElevation(f);
    }

    public static float m2222b(View view) {
        return view.getElevation();
    }

    public static float m2223c(View view) {
        return view.getTranslationZ();
    }

    public static void m2221a(View view, bm bmVar) {
        if (bmVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new cr(bmVar));
        }
    }

    static ColorStateList m2224d(View view) {
        return view.getBackgroundTintList();
    }

    static void m2219a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    static Mode m2225e(View view) {
        return view.getBackgroundTintMode();
    }

    static void m2220a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static ec m2216a(View view, ec ecVar) {
        if (!(ecVar instanceof ed)) {
            return ecVar;
        }
        WindowInsets f = ((ed) ecVar).m2363f();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f);
        if (onApplyWindowInsets != f) {
            return new ed(onApplyWindowInsets);
        }
        return ecVar;
    }

    public static void m2226f(View view) {
        view.stopNestedScroll();
    }

    public static float m2227g(View view) {
        return view.getZ();
    }
}
