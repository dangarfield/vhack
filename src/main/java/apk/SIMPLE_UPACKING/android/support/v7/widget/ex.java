package android.support.v7.widget;

import android.support.v4.p002h.bu;
import android.support.v4.p005e.TraceCompat;
import android.support.v4.widget.as;
import android.view.animation.Interpolator;

/* compiled from: RecyclerView */
class ex implements Runnable {
    final /* synthetic */ RecyclerView f2187a;
    private int f2188b;
    private int f2189c;
    private as f2190d;
    private Interpolator f2191e;
    private boolean f2192f;
    private boolean f2193g;

    public ex(RecyclerView recyclerView) {
        this.f2187a = recyclerView;
        this.f2191e = RecyclerView.ao;
        this.f2192f = false;
        this.f2193g = false;
        this.f2190d = as.m2533a(recyclerView.getContext(), RecyclerView.ao);
    }

    public void run() {
        if (this.f2187a.f146e == null) {
            m4498b();
            return;
        }
        m4491c();
        this.f2187a.m167t();
        as asVar = this.f2190d;
        et etVar = this.f2187a.f146e.f1683r;
        if (asVar.m2545g()) {
            int e;
            int i;
            int f;
            int i2;
            Object obj;
            Object obj2;
            int b = asVar.m2540b();
            int c = asVar.m2541c();
            int i3 = b - this.f2188b;
            int i4 = c - this.f2189c;
            int i5 = 0;
            int i6 = 0;
            this.f2188b = b;
            this.f2189c = c;
            int i7 = 0;
            int i8 = 0;
            if (this.f2187a.f156q != null) {
                this.f2187a.m187b();
                this.f2187a.m173z();
                TraceCompat.m1435a("RV Scroll");
                if (i3 != 0) {
                    i5 = this.f2187a.f146e.m3498a(i3, this.f2187a.f142a, this.f2187a.f148g);
                    i7 = i3 - i5;
                }
                if (i4 != 0) {
                    i6 = this.f2187a.f146e.m3541b(i4, this.f2187a.f142a, this.f2187a.f148g);
                    i8 = i4 - i6;
                }
                TraceCompat.m1434a();
                this.f2187a.m108I();
                this.f2187a.m100A();
                this.f2187a.m183a(false);
                if (!(etVar == null || etVar.m4457b() || !etVar.m4458c())) {
                    e = this.f2187a.f148g.m4487e();
                    if (e == 0) {
                        etVar.m4452a();
                        i = i7;
                        i7 = i6;
                        i6 = i;
                    } else if (etVar.m4459d() >= e) {
                        etVar.m4453a(e - 1);
                        etVar.m4449a(i3 - i7, i4 - i8);
                        i = i7;
                        i7 = i6;
                        i6 = i;
                    } else {
                        etVar.m4449a(i3 - i7, i4 - i8);
                    }
                    if (!this.f2187a.f158s.isEmpty()) {
                        this.f2187a.invalidate();
                    }
                    if (bu.m1921a(this.f2187a) != 2) {
                        this.f2187a.m152i(i3, i4);
                    }
                    if (!(i6 == 0 && i8 == 0)) {
                        f = (int) asVar.m2544f();
                        if (i6 == b) {
                            e = i6 >= 0 ? -f : i6 <= 0 ? f : 0;
                            i2 = e;
                        } else {
                            i2 = 0;
                        }
                        if (i8 != c) {
                            f = 0;
                        } else if (i8 < 0) {
                            f = -f;
                        } else if (i8 <= 0) {
                            f = 0;
                        }
                        if (bu.m1921a(this.f2187a) != 2) {
                            this.f2187a.m192c(i2, f);
                        }
                        if ((i2 != 0 || i6 == b || asVar.m2542d() == 0) && (f != 0 || i8 == c || asVar.m2543e() == 0)) {
                            asVar.m2546h();
                        }
                    }
                    if (!(i5 == 0 && i7 == 0)) {
                        this.f2187a.m207h(i5, i7);
                    }
                    if (!this.f2187a.awakenScrollBars()) {
                        this.f2187a.invalidate();
                    }
                    obj = (i4 == 0 && this.f2187a.f146e.m3575e() && i7 == i4) ? 1 : null;
                    obj2 = (i3 == 0 && this.f2187a.f146e.m3571d() && i5 == i3) ? 1 : null;
                    obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                    if (!asVar.m2538a() || obj2 == null) {
                        this.f2187a.setScrollState(0);
                    } else {
                        m4493a();
                    }
                }
            }
            i = i7;
            i7 = i6;
            i6 = i;
            if (this.f2187a.f158s.isEmpty()) {
                this.f2187a.invalidate();
            }
            if (bu.m1921a(this.f2187a) != 2) {
                this.f2187a.m152i(i3, i4);
            }
            f = (int) asVar.m2544f();
            if (i6 == b) {
                i2 = 0;
            } else {
                if (i6 >= 0) {
                    if (i6 <= 0) {
                    }
                }
                i2 = e;
            }
            if (i8 != c) {
                f = 0;
            } else if (i8 < 0) {
                f = -f;
            } else if (i8 <= 0) {
                f = 0;
            }
            if (bu.m1921a(this.f2187a) != 2) {
                this.f2187a.m192c(i2, f);
            }
            asVar.m2546h();
            this.f2187a.m207h(i5, i7);
            if (this.f2187a.awakenScrollBars()) {
                this.f2187a.invalidate();
            }
            if (i4 == 0) {
            }
            if (i3 == 0) {
            }
            if (i3 == 0) {
            }
            if (asVar.m2538a()) {
            }
            this.f2187a.setScrollState(0);
        }
        if (etVar != null) {
            if (etVar.m4457b()) {
                etVar.m4449a(0, 0);
            }
            if (!this.f2193g) {
                etVar.m4452a();
            }
        }
        m4492d();
    }

    private void m4491c() {
        this.f2193g = false;
        this.f2192f = true;
    }

    private void m4492d() {
        this.f2192f = false;
        if (this.f2193g) {
            m4493a();
        }
    }

    void m4493a() {
        if (this.f2192f) {
            this.f2193g = true;
            return;
        }
        this.f2187a.removeCallbacks(this);
        bu.m1931a(this.f2187a, (Runnable) this);
    }

    public void m4494a(int i, int i2) {
        this.f2187a.setScrollState(2);
        this.f2189c = 0;
        this.f2188b = 0;
        this.f2190d.m2536a(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        m4493a();
    }

    public void m4499b(int i, int i2) {
        m4496a(i, i2, 0, 0);
    }

    public void m4496a(int i, int i2, int i3, int i4) {
        m4495a(i, i2, m4490b(i, i2, i3, i4));
    }

    private float m4489a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private int m4490b(int i, int i2, int i3, int i4) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.f2187a.getWidth() : this.f2187a.getHeight();
        int i5 = width / 2;
        float a = (m4489a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
        } else {
            if (obj != null) {
                round = abs;
            } else {
                round = abs2;
            }
            round = (int) (((((float) round) / ((float) width)) + 1.0f) * 300.0f);
        }
        return Math.min(round, 2000);
    }

    public void m4495a(int i, int i2, int i3) {
        m4497a(i, i2, i3, RecyclerView.ao);
    }

    public void m4497a(int i, int i2, int i3, Interpolator interpolator) {
        if (this.f2191e != interpolator) {
            this.f2191e = interpolator;
            this.f2190d = as.m2533a(this.f2187a.getContext(), interpolator);
        }
        this.f2187a.setScrollState(2);
        this.f2189c = 0;
        this.f2188b = 0;
        this.f2190d.m2535a(0, 0, i, i2, i3);
        m4493a();
    }

    public void m4498b() {
        this.f2187a.removeCallbacks(this);
        this.f2190d.m2546h();
    }
}
