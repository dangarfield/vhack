package android.support.v7.widget;

import android.view.animation.Interpolator;

/* compiled from: RecyclerView */
final class du implements Interpolator {
    du() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
