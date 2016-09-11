package android.support.v7.widget;

import android.view.View;
import java.util.List;

/* compiled from: LinearLayoutManager */
class cw {
    boolean f2091a;
    int f2092b;
    int f2093c;
    int f2094d;
    int f2095e;
    int f2096f;
    int f2097g;
    int f2098h;
    boolean f2099i;
    int f2100j;
    List f2101k;
    boolean f2102l;

    cw() {
        this.f2091a = true;
        this.f2098h = 0;
        this.f2099i = false;
        this.f2101k = null;
    }

    boolean m4271a(ev evVar) {
        return this.f2094d >= 0 && this.f2094d < evVar.m4487e();
    }

    View m4268a(ep epVar) {
        if (this.f2101k != null) {
            return m4267b();
        }
        View c = epVar.m4430c(this.f2094d);
        this.f2094d += this.f2095e;
        return c;
    }

    private View m4267b() {
        int size = this.f2101k.size();
        for (int i = 0; i < size; i++) {
            View view = ((ey) this.f2101k.get(i)).f2195a;
            ek ekVar = (ek) view.getLayoutParams();
            if (!ekVar.m4249c() && this.f2094d == ekVar.m4251e()) {
                m4270a(view);
                return view;
            }
        }
        return null;
    }

    public void m4269a() {
        m4270a(null);
    }

    public void m4270a(View view) {
        View b = m4272b(view);
        if (b == null) {
            this.f2094d = -1;
        } else {
            this.f2094d = ((ek) b.getLayoutParams()).m4251e();
        }
    }

    public View m4272b(View view) {
        int size = this.f2101k.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        while (i2 < size) {
            int i3;
            View view3;
            View view4 = ((ey) this.f2101k.get(i2)).f2195a;
            ek ekVar = (ek) view4.getLayoutParams();
            if (view4 != view) {
                if (ekVar.m4249c()) {
                    i3 = i;
                    view3 = view2;
                } else {
                    i3 = (ekVar.m4251e() - this.f2094d) * this.f2095e;
                    if (i3 < 0) {
                        i3 = i;
                        view3 = view2;
                    } else if (i3 < i) {
                        if (i3 == 0) {
                            return view4;
                        }
                        view3 = view4;
                    }
                }
                i2++;
                view2 = view3;
                i = i3;
            }
            i3 = i;
            view3 = view2;
            i2++;
            view2 = view3;
            i = i3;
        }
        return view2;
    }
}
