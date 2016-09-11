package android.support.v7.widget;

import android.view.View;

/* compiled from: SimpleItemAnimator */
public abstract class fn extends ec {
    boolean f2014a;

    public abstract boolean m4168a(ey eyVar);

    public abstract boolean m4169a(ey eyVar, int i, int i2, int i3, int i4);

    public abstract boolean m4171a(ey eyVar, ey eyVar2, int i, int i2, int i3, int i4);

    public abstract boolean m4174b(ey eyVar);

    public fn() {
        this.f2014a = true;
    }

    public boolean m4179g(ey eyVar) {
        return !this.f2014a || eyVar.m4534n();
    }

    public boolean m4170a(ey eyVar, ef efVar, ef efVar2) {
        int i = efVar.f2140a;
        int i2 = efVar.f2141b;
        View view = eyVar.f2195a;
        int left = efVar2 == null ? view.getLeft() : efVar2.f2140a;
        int top = efVar2 == null ? view.getTop() : efVar2.f2141b;
        if (eyVar.m4537q() || (i == left && i2 == top)) {
            return m4168a(eyVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return m4169a(eyVar, i, i2, left, top);
    }

    public boolean m4175b(ey eyVar, ef efVar, ef efVar2) {
        if (efVar == null || (efVar.f2140a == efVar2.f2140a && efVar.f2141b == efVar2.f2141b)) {
            return m4174b(eyVar);
        }
        return m4169a(eyVar, efVar.f2140a, efVar.f2141b, efVar2.f2140a, efVar2.f2141b);
    }

    public boolean m4177c(ey eyVar, ef efVar, ef efVar2) {
        if (efVar.f2140a == efVar2.f2140a && efVar.f2141b == efVar2.f2141b) {
            m4181i(eyVar);
            return false;
        }
        return m4169a(eyVar, efVar.f2140a, efVar.f2141b, efVar2.f2140a, efVar2.f2141b);
    }

    public boolean m4172a(ey eyVar, ey eyVar2, ef efVar, ef efVar2) {
        int i;
        int i2;
        int i3 = efVar.f2140a;
        int i4 = efVar.f2141b;
        if (eyVar2.m4523c()) {
            i = efVar.f2140a;
            i2 = efVar.f2141b;
        } else {
            i = efVar2.f2140a;
            i2 = efVar2.f2141b;
        }
        return m4171a(eyVar, eyVar2, i3, i4, i, i2);
    }

    public final void m4180h(ey eyVar) {
        m4187o(eyVar);
        m4160e(eyVar);
    }

    public final void m4181i(ey eyVar) {
        m4191s(eyVar);
        m4160e(eyVar);
    }

    public final void m4182j(ey eyVar) {
        m4189q(eyVar);
        m4160e(eyVar);
    }

    public final void m4167a(ey eyVar, boolean z) {
        m4178d(eyVar, z);
        m4160e(eyVar);
    }

    public final void m4183k(ey eyVar) {
        m4186n(eyVar);
    }

    public final void m4184l(ey eyVar) {
        m4190r(eyVar);
    }

    public final void m4185m(ey eyVar) {
        m4188p(eyVar);
    }

    public final void m4173b(ey eyVar, boolean z) {
        m4176c(eyVar, z);
    }

    public void m4186n(ey eyVar) {
    }

    public void m4187o(ey eyVar) {
    }

    public void m4188p(ey eyVar) {
    }

    public void m4189q(ey eyVar) {
    }

    public void m4190r(ey eyVar) {
    }

    public void m4191s(ey eyVar) {
    }

    public void m4176c(ey eyVar, boolean z) {
    }

    public void m4178d(ey eyVar, boolean z) {
    }
}
