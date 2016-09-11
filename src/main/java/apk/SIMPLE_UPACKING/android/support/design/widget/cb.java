package android.support.design.widget;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

/* compiled from: ValueAnimatorCompatImplHoneycombMr1 */
class cb extends bw {
    final ValueAnimator f400a;

    cb() {
        this.f400a = new ValueAnimator();
    }

    public void m651a() {
        this.f400a.start();
    }

    public boolean m657b() {
        return this.f400a.isRunning();
    }

    public void m656a(Interpolator interpolator) {
        this.f400a.setInterpolator(interpolator);
    }

    public void m655a(by byVar) {
        this.f400a.addUpdateListener(new cc(this, byVar));
    }

    public void m654a(int i, int i2) {
        this.f400a.setIntValues(new int[]{i, i2});
    }

    public int m658c() {
        return ((Integer) this.f400a.getAnimatedValue()).intValue();
    }

    public void m652a(float f, float f2) {
        this.f400a.setFloatValues(new float[]{f, f2});
    }

    public float m659d() {
        return ((Float) this.f400a.getAnimatedValue()).floatValue();
    }

    public void m653a(int i) {
        this.f400a.setDuration((long) i);
    }

    public void m660e() {
        this.f400a.cancel();
    }
}
