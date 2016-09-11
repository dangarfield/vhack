package android.support.v4.p009c.p010a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.x */
class DrawableWrapperHoneycomb extends DrawableWrapperDonut {
    DrawableWrapperHoneycomb(DrawableWrapperDonut drawableWrapperDonut, Resources resources) {
        super(drawableWrapperDonut, resources);
    }

    public Drawable newDrawable(Resources resources) {
        return new DrawableWrapperHoneycomb(this, resources);
    }
}
