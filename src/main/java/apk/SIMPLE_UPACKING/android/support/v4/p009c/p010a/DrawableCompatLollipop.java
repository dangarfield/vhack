package android.support.v4.p009c.p010a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.c.a.p */
class DrawableCompatLollipop {
    public static void m1412a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m1414a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m1413a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void m1415a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m1418a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Drawable m1411a(Drawable drawable) {
        if (drawable instanceof aa) {
            return drawable;
        }
        return new aa(drawable);
    }

    public static void m1416a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean m1419b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m1420c(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void m1417a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }
}
