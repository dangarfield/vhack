package android.support.v4.widget;

import android.view.animation.AnimationUtils;

/* renamed from: android.support.v4.widget.c */
class AutoScrollHelper {
    private int f1056a;
    private int f1057b;
    private float f1058c;
    private float f1059d;
    private long f1060e;
    private long f1061f;
    private int f1062g;
    private int f1063h;
    private long f1064i;
    private float f1065j;
    private int f1066k;

    public AutoScrollHelper() {
        this.f1060e = Long.MIN_VALUE;
        this.f1064i = -1;
        this.f1061f = 0;
        this.f1062g = 0;
        this.f1063h = 0;
    }

    public void m2650a(int i) {
        this.f1056a = i;
    }

    public void m2652b(int i) {
        this.f1057b = i;
    }

    public void m2648a() {
        this.f1060e = AnimationUtils.currentAnimationTimeMillis();
        this.f1064i = -1;
        this.f1061f = this.f1060e;
        this.f1065j = 0.5f;
        this.f1062g = 0;
        this.f1063h = 0;
    }

    public void m2651b() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f1066k = AutoScrollHelper.m2462b((int) (currentAnimationTimeMillis - this.f1060e), 0, this.f1057b);
        this.f1065j = m2647a(currentAnimationTimeMillis);
        this.f1064i = currentAnimationTimeMillis;
    }

    public boolean m2653c() {
        return this.f1064i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1064i + ((long) this.f1066k);
    }

    private float m2647a(long j) {
        if (j < this.f1060e) {
            return 0.0f;
        }
        if (this.f1064i < 0 || j < this.f1064i) {
            return AutoScrollHelper.m2461b(((float) (j - this.f1060e)) / ((float) this.f1056a), 0.0f, 1.0f) * 0.5f;
        }
        long j2 = j - this.f1064i;
        return (AutoScrollHelper.m2461b(((float) j2) / ((float) this.f1066k), 0.0f, 1.0f) * this.f1065j) + (1.0f - this.f1065j);
    }

    private float m2646a(float f) {
        return ((-4.0f * f) * f) + (4.0f * f);
    }

    public void m2654d() {
        if (this.f1061f == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float a = m2646a(m2647a(currentAnimationTimeMillis));
        long j = currentAnimationTimeMillis - this.f1061f;
        this.f1061f = currentAnimationTimeMillis;
        this.f1062g = (int) ((((float) j) * a) * this.f1058c);
        this.f1063h = (int) ((((float) j) * a) * this.f1059d);
    }

    public void m2649a(float f, float f2) {
        this.f1058c = f;
        this.f1059d = f2;
    }

    public int m2655e() {
        return (int) (this.f1058c / Math.abs(this.f1058c));
    }

    public int m2656f() {
        return (int) (this.f1059d / Math.abs(this.f1059d));
    }

    public int m2657g() {
        return this.f1062g;
    }

    public int m2658h() {
        return this.f1063h;
    }
}
