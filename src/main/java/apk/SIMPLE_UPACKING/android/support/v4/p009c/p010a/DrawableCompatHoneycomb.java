package android.support.v4.p009c.p010a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.m */
class DrawableCompatHoneycomb {
    public static void m1403a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable m1404b(Drawable drawable) {
        if (drawable instanceof DrawableWrapperHoneycomb) {
            return drawable;
        }
        return new DrawableWrapperHoneycomb(drawable);
    }
}
