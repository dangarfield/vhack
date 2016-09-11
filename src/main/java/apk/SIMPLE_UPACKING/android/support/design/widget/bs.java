package android.support.design.widget;

import android.view.animation.Interpolator;

/* compiled from: ValueAnimatorCompat */
class bs {
    private final bw f382a;

    bs(bw bwVar) {
        this.f382a = bwVar;
    }

    public void m610a() {
        this.f382a.m624a();
    }

    public boolean m616b() {
        return this.f382a.m630b();
    }

    public void m615a(Interpolator interpolator) {
        this.f382a.m629a(interpolator);
    }

    public void m614a(bu buVar) {
        if (buVar != null) {
            this.f382a.m628a(new bt(this, buVar));
        } else {
            this.f382a.m628a(null);
        }
    }

    public void m613a(int i, int i2) {
        this.f382a.m627a(i, i2);
    }

    public int m617c() {
        return this.f382a.m631c();
    }

    public void m611a(float f, float f2) {
        this.f382a.m625a(f, f2);
    }

    public float m618d() {
        return this.f382a.m632d();
    }

    public void m612a(int i) {
        this.f382a.m626a(i);
    }

    public void m619e() {
        this.f382a.m633e();
    }
}
