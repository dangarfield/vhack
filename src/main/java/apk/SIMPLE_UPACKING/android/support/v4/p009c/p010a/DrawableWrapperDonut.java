package android.support.v4.p009c.p010a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.t */
class DrawableWrapperDonut extends DrawableWrapperDonut {
    DrawableWrapperDonut(DrawableWrapperDonut drawableWrapperDonut, Resources resources) {
        super(drawableWrapperDonut, resources);
    }

    public Drawable newDrawable(Resources resources) {
        return new DrawableWrapperDonut(this, resources);
    }
}
