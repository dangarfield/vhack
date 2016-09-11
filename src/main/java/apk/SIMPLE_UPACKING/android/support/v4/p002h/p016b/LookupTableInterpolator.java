package android.support.v4.p002h.p016b;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.h.b.d */
abstract class LookupTableInterpolator implements Interpolator {
    private final float[] f914a;
    private final float f915b;

    public LookupTableInterpolator(float[] fArr) {
        this.f914a = fArr;
        this.f915b = 1.0f / ((float) (this.f914a.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f914a.length - 1)) * f), this.f914a.length - 2);
        float f2 = (f - (((float) min) * this.f915b)) / this.f915b;
        return ((this.f914a[min + 1] - this.f914a[min]) * f2) + this.f914a[min];
    }
}
