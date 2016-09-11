package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.p009c.p010a.DrawableWrapper;
import com.google.android.gms.C0001R;

/* compiled from: DrawableUtils */
class cl {
    public static final Rect f2062a;
    private static Class f2063b;

    static {
        f2062a = new Rect();
        if (VERSION.SDK_INT >= 18) {
            try {
                f2063b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    static void m4238a(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m4240c(drawable);
        }
    }

    static boolean m4239b(Drawable drawable) {
        if (drawable instanceof LayerDrawable) {
            boolean z;
            if (VERSION.SDK_INT >= 16) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (drawable instanceof InsetDrawable) {
            if (VERSION.SDK_INT < 14) {
                return false;
            }
            return true;
        } else if (drawable instanceof StateListDrawable) {
            if (VERSION.SDK_INT < 8) {
                return false;
            }
            return true;
        } else if (drawable instanceof GradientDrawable) {
            if (VERSION.SDK_INT < 14) {
                return false;
            }
            return true;
        } else if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainerState)) {
                return true;
            }
            for (Drawable b : ((DrawableContainerState) constantState).getChildren()) {
                if (!m4239b(b)) {
                    return false;
                }
            }
            return true;
        } else if (drawable instanceof DrawableWrapper) {
            return m4239b(((DrawableWrapper) drawable).m1321a());
        } else {
            if (drawable instanceof android.support.v7.p003c.p004a.DrawableWrapper) {
                return m4239b(((android.support.v7.p003c.p004a.DrawableWrapper) drawable).m522b());
            }
            return true;
        }
    }

    private static void m4240c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(fw.f2285e);
        } else {
            drawable.setState(fw.f2288h);
        }
        drawable.setState(state);
    }

    static Mode m4237a(int i, Mode mode) {
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return Mode.SRC_OVER;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return Mode.SRC_IN;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                return Mode.SRC_ATOP;
            case C0001R.styleable.MapAttrs_zOrderOnTop /*14*/:
                return Mode.MULTIPLY;
            case C0001R.styleable.MapAttrs_uiMapToolbar /*15*/:
                return Mode.SCREEN;
            case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                if (VERSION.SDK_INT >= 11) {
                    return Mode.valueOf("ADD");
                }
                return mode;
            default:
                return mode;
        }
    }
}
