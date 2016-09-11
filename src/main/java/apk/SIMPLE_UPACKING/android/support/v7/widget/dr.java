package android.support.v7.widget;

import android.view.View;

/* compiled from: OrientationHelper */
final class dr extends dp {
    dr(ei eiVar) {
        super(null);
    }

    public int m4331d() {
        return this.a.m3607w() - this.a.m3491A();
    }

    public int m4333e() {
        return this.a.m3607w();
    }

    public void m4327a(int i) {
        this.a.m3589j(i);
    }

    public int m4329c() {
        return this.a.m3609y();
    }

    public int m4330c(View view) {
        ek ekVar = (ek) view.getLayoutParams();
        return ekVar.bottomMargin + (this.a.m3582g(view) + ekVar.topMargin);
    }

    public int m4332d(View view) {
        ek ekVar = (ek) view.getLayoutParams();
        return ekVar.rightMargin + (this.a.m3578f(view) + ekVar.leftMargin);
    }

    public int m4328b(View view) {
        ek ekVar = (ek) view.getLayoutParams();
        return ekVar.bottomMargin + this.a.m3591k(view);
    }

    public int m4326a(View view) {
        return this.a.m3586i(view) - ((ek) view.getLayoutParams()).topMargin;
    }

    public int m4334f() {
        return (this.a.m3607w() - this.a.m3609y()) - this.a.m3491A();
    }

    public int m4335g() {
        return this.a.m3491A();
    }

    public int m4336h() {
        return this.a.m3605u();
    }

    public int m4337i() {
        return this.a.m3604t();
    }
}
