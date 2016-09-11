package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.v4.p002h.bu;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewOffsetHelper */
class ck {
    private final View f407a;
    private int f408b;
    private int f409c;
    private int f410d;
    private int f411e;

    public ck(View view) {
        this.f407a = view;
    }

    public void m670a() {
        this.f408b = this.f407a.getTop();
        this.f409c = this.f407a.getLeft();
        m669c();
    }

    private void m669c() {
        bu.m1947e(this.f407a, this.f410d - (this.f407a.getTop() - this.f408b));
        bu.m1949f(this.f407a, this.f411e - (this.f407a.getLeft() - this.f409c));
        if (VERSION.SDK_INT < 23) {
            m668a(this.f407a);
            ViewParent parent = this.f407a.getParent();
            if (parent instanceof View) {
                m668a((View) parent);
            }
        }
    }

    private static void m668a(View view) {
        float n = bu.m1957n(view);
        bu.m1935b(view, 1.0f + n);
        bu.m1935b(view, n);
    }

    public boolean m671a(int i) {
        if (this.f410d == i) {
            return false;
        }
        this.f410d = i;
        m669c();
        return true;
    }

    public boolean m673b(int i) {
        if (this.f411e == i) {
            return false;
        }
        this.f411e = i;
        m669c();
        return true;
    }

    public int m672b() {
        return this.f410d;
    }
}
