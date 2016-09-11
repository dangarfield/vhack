package android.support.v7.widget;

import android.view.View;

/* compiled from: LayoutState */
class cr {
    boolean f2072a;
    int f2073b;
    int f2074c;
    int f2075d;
    int f2076e;
    int f2077f;
    int f2078g;
    boolean f2079h;
    boolean f2080i;

    cr() {
        this.f2072a = true;
        this.f2077f = 0;
        this.f2078g = 0;
    }

    boolean m4259a(ev evVar) {
        return this.f2074c >= 0 && this.f2074c < evVar.m4487e();
    }

    View m4258a(ep epVar) {
        View c = epVar.m4430c(this.f2074c);
        this.f2074c += this.f2075d;
        return c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2073b + ", mCurrentPosition=" + this.f2074c + ", mItemDirection=" + this.f2075d + ", mLayoutDirection=" + this.f2076e + ", mStartLine=" + this.f2077f + ", mEndLine=" + this.f2078g + '}';
    }
}
