package android.support.v7.widget;

import android.view.View;

/* compiled from: OrientationHelper */
final class dq extends dp {
    dq(ei eiVar) {
        super(null);
    }

    public int m4319d() {
        return this.a.m3606v() - this.a.m3610z();
    }

    public int m4321e() {
        return this.a.m3606v();
    }

    public void m4315a(int i) {
        this.a.m3587i(i);
    }

    public int m4317c() {
        return this.a.m3608x();
    }

    public int m4318c(View view) {
        ek ekVar = (ek) view.getLayoutParams();
        return ekVar.rightMargin + (this.a.m3578f(view) + ekVar.leftMargin);
    }

    public int m4320d(View view) {
        ek ekVar = (ek) view.getLayoutParams();
        return ekVar.bottomMargin + (this.a.m3582g(view) + ekVar.topMargin);
    }

    public int m4316b(View view) {
        ek ekVar = (ek) view.getLayoutParams();
        return ekVar.rightMargin + this.a.m3588j(view);
    }

    public int m4314a(View view) {
        return this.a.m3584h(view) - ((ek) view.getLayoutParams()).leftMargin;
    }

    public int m4322f() {
        return (this.a.m3606v() - this.a.m3608x()) - this.a.m3610z();
    }

    public int m4323g() {
        return this.a.m3610z();
    }

    public int m4324h() {
        return this.a.m3604t();
    }

    public int m4325i() {
        return this.a.m3605u();
    }
}
