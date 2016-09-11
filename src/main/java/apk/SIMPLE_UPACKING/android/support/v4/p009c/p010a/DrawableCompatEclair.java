package android.support.v4.p009c.p010a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.l */
class DrawableCompatEclair {
    public static Drawable m1402a(Drawable drawable) {
        if (drawable instanceof DrawableWrapperEclair) {
            return drawable;
        }
        return new DrawableWrapperEclair(drawable);
    }
}
