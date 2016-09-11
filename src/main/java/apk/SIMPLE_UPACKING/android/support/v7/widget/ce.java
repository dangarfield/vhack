package android.support.v7.widget;

import android.support.v4.p002h.bu;
import android.support.v4.p002h.di;
import android.view.View;

/* compiled from: DefaultItemAnimator */
class ce extends ck {
    final /* synthetic */ ey f2036a;
    final /* synthetic */ di f2037b;
    final /* synthetic */ bz f2038c;

    ce(bz bzVar, ey eyVar, di diVar) {
        this.f2038c = bzVar;
        this.f2036a = eyVar;
        this.f2037b = diVar;
        super();
    }

    public void m4227a(View view) {
        this.f2038c.m4185m(this.f2036a);
    }

    public void m4229c(View view) {
        bu.m1939c(view, 1.0f);
    }

    public void m4228b(View view) {
        this.f2037b.m2286a(null);
        this.f2038c.m4182j(this.f2036a);
        this.f2038c.f2022i.remove(this.f2036a);
        this.f2038c.m4208j();
    }
}
