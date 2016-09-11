package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

/* compiled from: ScrollerCompat */
public final class as {
    Object f1029a;
    at f1030b;

    public static as m2532a(Context context) {
        return m2533a(context, null);
    }

    public static as m2533a(Context context, Interpolator interpolator) {
        return new as(VERSION.SDK_INT, context, interpolator);
    }

    private as(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f1030b = new aw();
        } else if (i >= 9) {
            this.f1030b = new av();
        } else {
            this.f1030b = new au();
        }
        this.f1029a = this.f1030b.m2547a(context, interpolator);
    }

    public boolean m2538a() {
        return this.f1030b.m2552a(this.f1029a);
    }

    public int m2540b() {
        return this.f1030b.m2554b(this.f1029a);
    }

    public int m2541c() {
        return this.f1030b.m2555c(this.f1029a);
    }

    public int m2542d() {
        return this.f1030b.m2559g(this.f1029a);
    }

    public int m2543e() {
        return this.f1030b.m2560h(this.f1029a);
    }

    public float m2544f() {
        return this.f1030b.m2556d(this.f1029a);
    }

    public boolean m2545g() {
        return this.f1030b.m2557e(this.f1029a);
    }

    public void m2534a(int i, int i2, int i3, int i4) {
        this.f1030b.m2548a(this.f1029a, i, i2, i3, i4);
    }

    public void m2535a(int i, int i2, int i3, int i4, int i5) {
        this.f1030b.m2549a(this.f1029a, i, i2, i3, i4, i5);
    }

    public void m2536a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1030b.m2550a(this.f1029a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m2537a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1030b.m2551a(this.f1029a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m2539a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f1030b.m2553a(this.f1029a, i, i2, i3, i4, i5, i6);
    }

    public void m2546h() {
        this.f1030b.m2558f(this.f1029a);
    }
}
