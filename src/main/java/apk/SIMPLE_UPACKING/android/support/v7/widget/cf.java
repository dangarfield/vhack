package android.support.v7.widget;

import android.support.v4.p002h.bu;
import android.support.v4.p002h.di;
import android.view.View;

/* compiled from: DefaultItemAnimator */
class cf extends ck {
    final /* synthetic */ ey f2039a;
    final /* synthetic */ int f2040b;
    final /* synthetic */ int f2041c;
    final /* synthetic */ di f2042d;
    final /* synthetic */ bz f2043e;

    cf(bz bzVar, ey eyVar, int i, int i2, di diVar) {
        this.f2043e = bzVar;
        this.f2039a = eyVar;
        this.f2040b = i;
        this.f2041c = i2;
        this.f2042d = diVar;
        super();
    }

    public void m4230a(View view) {
        this.f2043e.m4184l(this.f2039a);
    }

    public void m4232c(View view) {
        if (this.f2040b != 0) {
            bu.m1923a(view, 0.0f);
        }
        if (this.f2041c != 0) {
            bu.m1935b(view, 0.0f);
        }
    }

    public void m4231b(View view) {
        this.f2042d.m2286a(null);
        this.f2043e.m4181i(this.f2039a);
        this.f2043e.f2023j.remove(this.f2039a);
        this.f2043e.m4208j();
    }
}
