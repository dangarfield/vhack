package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: ValueAnimatorCompatImplEclairMr1 */
class bz extends bw {
    private static final Handler f385a;
    private long f386b;
    private boolean f387c;
    private final int[] f388d;
    private final float[] f389e;
    private int f390f;
    private Interpolator f391g;
    private bx f392h;
    private by f393i;
    private float f394j;
    private final Runnable f395k;

    bz() {
        this.f388d = new int[2];
        this.f389e = new float[2];
        this.f390f = 200;
        this.f395k = new ca(this);
    }

    static {
        f385a = new Handler(Looper.getMainLooper());
    }

    public void m639a() {
        if (!this.f387c) {
            if (this.f391g == null) {
                this.f391g = new AccelerateDecelerateInterpolator();
            }
            this.f386b = SystemClock.uptimeMillis();
            this.f387c = true;
            if (this.f392h != null) {
                this.f392h.m634a();
            }
            f385a.postDelayed(this.f395k, 10);
        }
    }

    public boolean m645b() {
        return this.f387c;
    }

    public void m644a(Interpolator interpolator) {
        this.f391g = interpolator;
    }

    public void m643a(by byVar) {
        this.f393i = byVar;
    }

    public void m642a(int i, int i2) {
        this.f388d[0] = i;
        this.f388d[1] = i2;
    }

    public int m646c() {
        return AnimationUtils.m457a(this.f388d[0], this.f388d[1], m649f());
    }

    public void m640a(float f, float f2) {
        this.f389e[0] = f;
        this.f389e[1] = f2;
    }

    public float m647d() {
        return AnimationUtils.m456a(this.f389e[0], this.f389e[1], m649f());
    }

    public void m641a(int i) {
        this.f390f = i;
    }

    public void m648e() {
        this.f387c = false;
        f385a.removeCallbacks(this.f395k);
        if (this.f392h != null) {
            this.f392h.m636c();
        }
    }

    public float m649f() {
        return this.f394j;
    }

    private void m638g() {
        if (this.f387c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f386b)) / ((float) this.f390f);
            if (this.f391g != null) {
                uptimeMillis = this.f391g.getInterpolation(uptimeMillis);
            }
            this.f394j = uptimeMillis;
            if (this.f393i != null) {
                this.f393i.m620a();
            }
            if (SystemClock.uptimeMillis() >= this.f386b + ((long) this.f390f)) {
                this.f387c = false;
                if (this.f392h != null) {
                    this.f392h.m635b();
                }
            }
        }
        if (this.f387c) {
            f385a.postDelayed(this.f395k, 10);
        }
    }
}
