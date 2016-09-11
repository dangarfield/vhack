package android.support.v4.widget;

import android.view.animation.Interpolator;

/* compiled from: ViewDragHelper */
final class bk implements Interpolator {
    bk() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
