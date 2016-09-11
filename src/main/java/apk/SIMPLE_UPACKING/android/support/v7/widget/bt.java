package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChildHelper */
class bt {
    final bv f2003a;
    final bu f2004b;
    final List f2005c;

    bt(bv bvVar) {
        this.f2003a = bvVar;
        this.f2004b = new bu();
        this.f2005c = new ArrayList();
    }

    private void m4077g(View view) {
        this.f2005c.add(view);
        this.f2003a.m4113c(view);
    }

    private boolean m4078h(View view) {
        if (!this.f2005c.remove(view)) {
            return false;
        }
        this.f2003a.m4114d(view);
        return true;
    }

    void m4085a(View view, boolean z) {
        m4084a(view, -1, z);
    }

    void m4084a(View view, int i, boolean z) {
        int a;
        if (i < 0) {
            a = this.f2003a.m4104a();
        } else {
            a = m4076e(i);
        }
        this.f2004b.m4099a(a, z);
        if (z) {
            m4077g(view);
        }
        this.f2003a.m4107a(view, a);
    }

    private int m4076e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f2003a.m4104a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f2004b.m4103e(i2));
            if (e == 0) {
                while (this.f2004b.m4101c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    void m4082a(View view) {
        int a = this.f2003a.m4105a(view);
        if (a >= 0) {
            if (this.f2004b.m4102d(a)) {
                m4078h(view);
            }
            this.f2003a.m4106a(a);
        }
    }

    void m4081a(int i) {
        int e = m4076e(i);
        View b = this.f2003a.m4110b(e);
        if (b != null) {
            if (this.f2004b.m4102d(e)) {
                m4078h(b);
            }
            this.f2003a.m4106a(e);
        }
    }

    View m4088b(int i) {
        return this.f2003a.m4110b(m4076e(i));
    }

    void m4080a() {
        this.f2004b.m4097a();
        for (int size = this.f2005c.size() - 1; size >= 0; size--) {
            this.f2003a.m4114d((View) this.f2005c.get(size));
            this.f2005c.remove(size);
        }
        this.f2003a.m4111b();
    }

    View m4079a(int i, int i2) {
        int size = this.f2005c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f2005c.get(i3);
            ey b = this.f2003a.m4109b(view);
            if (b.m4524d() == i && !b.m4534n() && !b.m4537q() && (i2 == -1 || b.m4528h() == i2)) {
                return view;
            }
        }
        return null;
    }

    void m4083a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a;
        if (i < 0) {
            a = this.f2003a.m4104a();
        } else {
            a = m4076e(i);
        }
        this.f2004b.m4099a(a, z);
        if (z) {
            m4077g(view);
        }
        this.f2003a.m4108a(view, a, layoutParams);
    }

    int m4086b() {
        return this.f2003a.m4104a() - this.f2005c.size();
    }

    int m4089c() {
        return this.f2003a.m4104a();
    }

    View m4090c(int i) {
        return this.f2003a.m4110b(i);
    }

    void m4092d(int i) {
        int e = m4076e(i);
        this.f2004b.m4102d(e);
        this.f2003a.m4112c(e);
    }

    int m4087b(View view) {
        int a = this.f2003a.m4105a(view);
        if (a == -1 || this.f2004b.m4101c(a)) {
            return -1;
        }
        return a - this.f2004b.m4103e(a);
    }

    boolean m4091c(View view) {
        return this.f2005c.contains(view);
    }

    void m4093d(View view) {
        int a = this.f2003a.m4105a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f2004b.m4098a(a);
        m4077g(view);
    }

    void m4094e(View view) {
        int a = this.f2003a.m4105a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f2004b.m4101c(a)) {
            this.f2004b.m4100b(a);
            m4078h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f2004b.toString() + ", hidden list:" + this.f2005c.size();
    }

    boolean m4095f(View view) {
        int a = this.f2003a.m4105a(view);
        if (a == -1) {
            return m4078h(view) ? true : true;
        } else {
            if (!this.f2004b.m4101c(a)) {
                return false;
            }
            this.f2004b.m4102d(a);
            if (m4078h(view)) {
                this.f2003a.m4106a(a);
            } else {
                this.f2003a.m4106a(a);
            }
            return true;
        }
    }
}
