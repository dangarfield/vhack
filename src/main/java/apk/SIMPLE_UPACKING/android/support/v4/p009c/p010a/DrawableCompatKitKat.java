package android.support.v4.p009c.p010a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.o */
class DrawableCompatKitKat {
    public static void m1407a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m1408a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m1409b(Drawable drawable) {
        if (drawable instanceof DrawableWrapperKitKat) {
            return drawable;
        }
        return new DrawableWrapperKitKat(drawable);
    }

    public static int m1410c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
