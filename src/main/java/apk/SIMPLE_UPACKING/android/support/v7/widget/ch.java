package android.support.v7.widget;

import android.support.v4.p002h.bu;
import android.support.v4.p002h.di;
import android.view.View;

/* compiled from: DefaultItemAnimator */
class ch extends ck {
    final /* synthetic */ ci f2047a;
    final /* synthetic */ di f2048b;
    final /* synthetic */ View f2049c;
    final /* synthetic */ bz f2050d;

    ch(bz bzVar, ci ciVar, di diVar, View view) {
        this.f2050d = bzVar;
        this.f2047a = ciVar;
        this.f2048b = diVar;
        this.f2049c = view;
        super();
    }

    public void m4235a(View view) {
        this.f2050d.m4173b(this.f2047a.f2052b, false);
    }

    public void m4236b(View view) {
        this.f2048b.m2286a(null);
        bu.m1939c(this.f2049c, 1.0f);
        bu.m1923a(this.f2049c, 0.0f);
        bu.m1935b(this.f2049c, 0.0f);
        this.f2050d.m4167a(this.f2047a.f2052b, false);
        this.f2050d.f2025l.remove(this.f2047a.f2052b);
        this.f2050d.m4208j();
    }
}
