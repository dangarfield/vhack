package android.support.v4.p009c.p010a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.z */
class DrawableWrapperKitKat extends DrawableWrapperDonut {
    DrawableWrapperKitKat(DrawableWrapperDonut drawableWrapperDonut, Resources resources) {
        super(drawableWrapperDonut, resources);
    }

    public Drawable newDrawable(Resources resources) {
        return new DrawableWrapperKitKat(this, resources);
    }
}
