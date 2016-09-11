package android.support.v7.widget;

import android.support.v4.p002h.bu;
import android.support.v4.p002h.di;
import android.view.View;

/* compiled from: DefaultItemAnimator */
class cg extends ck {
    final /* synthetic */ ci f2044a;
    final /* synthetic */ di f2045b;
    final /* synthetic */ bz f2046c;

    cg(bz bzVar, ci ciVar, di diVar) {
        this.f2046c = bzVar;
        this.f2044a = ciVar;
        this.f2045b = diVar;
        super();
    }

    public void m4233a(View view) {
        this.f2046c.m4173b(this.f2044a.f2051a, true);
    }

    public void m4234b(View view) {
        this.f2045b.m2286a(null);
        bu.m1939c(view, 1.0f);
        bu.m1923a(view, 0.0f);
        bu.m1935b(view, 0.0f);
        this.f2046c.m4167a(this.f2044a.f2051a, true);
        this.f2046c.f2025l.remove(this.f2044a.f2051a);
        this.f2046c.m4208j();
    }
}
