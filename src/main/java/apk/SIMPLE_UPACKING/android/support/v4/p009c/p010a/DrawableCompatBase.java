package android.support.v4.p009c.p010a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.c.a.k */
class DrawableCompatBase {
    public static void m1398a(Drawable drawable, int i) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable).m1322a(i);
        }
    }

    public static void m1399a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable).m1323a(colorStateList);
        }
    }

    public static void m1401a(Drawable drawable, Mode mode) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable).m1324a(mode);
        }
    }

    public static Drawable m1397a(Drawable drawable) {
        if (drawable instanceof DrawableWrapperDonut) {
            return drawable;
        }
        return new DrawableWrapperDonut(drawable);
    }

    public static void m1400a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }
}
