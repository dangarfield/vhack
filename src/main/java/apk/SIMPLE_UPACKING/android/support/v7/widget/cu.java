package android.support.v7.widget;

import android.view.View;

/* compiled from: LinearLayoutManager */
class cu {
    int f2083a;
    int f2084b;
    boolean f2085c;
    final /* synthetic */ LinearLayoutManager f2086d;

    cu(LinearLayoutManager linearLayoutManager) {
        this.f2086d = linearLayoutManager;
    }

    void m4262a() {
        this.f2083a = -1;
        this.f2084b = Integer.MIN_VALUE;
        this.f2085c = false;
    }

    void m4264b() {
        this.f2084b = this.f2085c ? this.f2086d.f1692j.m4307d() : this.f2086d.f1692j.m4305c();
    }

    public String toString() {
        return "AnchorInfo{mPosition=" + this.f2083a + ", mCoordinate=" + this.f2084b + ", mLayoutFromEnd=" + this.f2085c + '}';
    }

    private boolean m4261a(View view, ev evVar) {
        ek ekVar = (ek) view.getLayoutParams();
        return !ekVar.m4249c() && ekVar.m4251e() >= 0 && ekVar.m4251e() < evVar.m4487e();
    }

    public void m4263a(View view) {
        int b = this.f2086d.f1692j.m4303b();
        if (b >= 0) {
            m4265b(view);
            return;
        }
        this.f2083a = this.f2086d.m3566d(view);
        int c;
        if (this.f2085c) {
            b = (this.f2086d.f1692j.m4307d() - b) - this.f2086d.f1692j.m4304b(view);
            this.f2084b = this.f2086d.f1692j.m4307d() - b;
            if (b > 0) {
                c = this.f2084b - this.f2086d.f1692j.m4306c(view);
                int c2 = this.f2086d.f1692j.m4305c();
                c -= c2 + Math.min(this.f2086d.f1692j.m4300a(view) - c2, 0);
                if (c < 0) {
                    this.f2084b = Math.min(b, -c) + this.f2084b;
                    return;
                }
                return;
            }
            return;
        }
        c = this.f2086d.f1692j.m4300a(view);
        c2 = c - this.f2086d.f1692j.m4305c();
        this.f2084b = c;
        if (c2 > 0) {
            b = (this.f2086d.f1692j.m4307d() - Math.min(0, (this.f2086d.f1692j.m4307d() - b) - this.f2086d.f1692j.m4304b(view))) - (c + this.f2086d.f1692j.m4306c(view));
            if (b < 0) {
                this.f2084b -= Math.min(c2, -b);
            }
        }
    }

    public void m4265b(View view) {
        if (this.f2085c) {
            this.f2084b = this.f2086d.f1692j.m4304b(view) + this.f2086d.f1692j.m4303b();
        } else {
            this.f2084b = this.f2086d.f1692j.m4300a(view);
        }
        this.f2083a = this.f2086d.m3566d(view);
    }
}
