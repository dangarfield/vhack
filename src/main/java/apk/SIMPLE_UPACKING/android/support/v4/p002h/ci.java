package android.support.v4.p002h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

/* compiled from: ViewCompatBase */
/* renamed from: android.support.v4.h.ci */
class ci {
    private static Field f932a;
    private static boolean f933b;
    private static Field f934c;
    private static boolean f935d;

    static ColorStateList m2161a(View view) {
        return view instanceof bo ? ((bo) view).getSupportBackgroundTintList() : null;
    }

    static void m2163a(View view, ColorStateList colorStateList) {
        if (view instanceof bo) {
            ((bo) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static Mode m2165b(View view) {
        return view instanceof bo ? ((bo) view).getSupportBackgroundTintMode() : null;
    }

    static void m2164a(View view, Mode mode) {
        if (view instanceof bo) {
            ((bo) view).setSupportBackgroundTintMode(mode);
        }
    }

    static boolean m2167c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m2168d(View view) {
        if (!f933b) {
            try {
                f932a = View.class.getDeclaredField("mMinWidth");
                f932a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f933b = true;
        }
        if (f932a != null) {
            try {
                return ((Integer) f932a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int m2169e(View view) {
        if (!f935d) {
            try {
                f934c = View.class.getDeclaredField("mMinHeight");
                f934c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f935d = true;
        }
        if (f934c != null) {
            try {
                return ((Integer) f934c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m2170f(View view) {
        return view.getWindowToken() != null;
    }

    static void m2162a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    static void m2166b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }
}
