package android.support.v7.widget;

import android.support.v4.p002h.bu;
import android.support.v4.p002h.di;
import android.view.View;

/* compiled from: DefaultItemAnimator */
class cd extends ck {
    final /* synthetic */ ey f2033a;
    final /* synthetic */ di f2034b;
    final /* synthetic */ bz f2035c;

    cd(bz bzVar, ey eyVar, di diVar) {
        this.f2035c = bzVar;
        this.f2033a = eyVar;
        this.f2034b = diVar;
        super();
    }

    public void m4225a(View view) {
        this.f2035c.m4183k(this.f2033a);
    }

    public void m4226b(View view) {
        this.f2034b.m2286a(null);
        bu.m1939c(view, 1.0f);
        this.f2035c.m4180h(this.f2033a);
        this.f2035c.f2024k.remove(this.f2033a);
        this.f2035c.m4208j();
    }
}
