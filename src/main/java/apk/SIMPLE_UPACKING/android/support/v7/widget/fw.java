package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.p009c.ColorUtils;
import android.util.TypedValue;

/* compiled from: ThemeUtils */
class fw {
    static final int[] f2281a;
    static final int[] f2282b;
    static final int[] f2283c;
    static final int[] f2284d;
    static final int[] f2285e;
    static final int[] f2286f;
    static final int[] f2287g;
    static final int[] f2288h;
    private static final ThreadLocal f2289i;
    private static final int[] f2290j;

    static {
        f2289i = new ThreadLocal();
        f2281a = new int[]{-16842910};
        f2282b = new int[]{16842908};
        f2283c = new int[]{16843518};
        f2284d = new int[]{16842919};
        f2285e = new int[]{16842912};
        f2286f = new int[]{16842913};
        f2287g = new int[]{-16842919, -16842908};
        f2288h = new int[0];
        f2290j = new int[1];
    }

    public static int m4634a(Context context, int i) {
        f2290j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f2290j);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList m4637b(Context context, int i) {
        f2290j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f2290j);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int m4638c(Context context, int i) {
        ColorStateList b = m4637b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f2281a, b.getDefaultColor());
        }
        TypedValue a = m4636a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m4635a(context, i, a.getFloat());
    }

    private static TypedValue m4636a() {
        TypedValue typedValue = (TypedValue) f2289i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f2289i.set(typedValue);
        return typedValue;
    }

    static int m4635a(Context context, int i, float f) {
        int a = m4634a(context, i);
        return ColorUtils.m1425b(a, Math.round(((float) Color.alpha(a)) * f));
    }
}
