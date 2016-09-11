package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: RecyclerView */
class dw implements bv {
    final /* synthetic */ RecyclerView f2134a;

    dw(RecyclerView recyclerView) {
        this.f2134a = recyclerView;
    }

    public int m4346a() {
        return this.f2134a.getChildCount();
    }

    public void m4349a(View view, int i) {
        this.f2134a.addView(view, i);
        this.f2134a.m156j(view);
    }

    public int m4347a(View view) {
        return this.f2134a.indexOfChild(view);
    }

    public void m4348a(int i) {
        View childAt = this.f2134a.getChildAt(i);
        if (childAt != null) {
            this.f2134a.m154i(childAt);
        }
        this.f2134a.removeViewAt(i);
    }

    public View m4352b(int i) {
        return this.f2134a.getChildAt(i);
    }

    public void m4353b() {
        int a = m4346a();
        for (int i = 0; i < a; i++) {
            this.f2134a.m154i(m4352b(i));
        }
        this.f2134a.removeAllViews();
    }

    public ey m4351b(View view) {
        return RecyclerView.m138c(view);
    }

    public void m4350a(View view, int i, LayoutParams layoutParams) {
        ey c = RecyclerView.m138c(view);
        if (c != null) {
            if (c.m4538r() || c.m4523c()) {
                c.m4533m();
            } else {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + c);
            }
        }
        this.f2134a.attachViewToParent(view, i, layoutParams);
    }

    public void m4354c(int i) {
        View b = m4352b(i);
        if (b != null) {
            ey c = RecyclerView.m138c(b);
            if (c != null) {
                if (!c.m4538r() || c.m4523c()) {
                    c.m4522b(256);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + c);
                }
            }
        }
        this.f2134a.detachViewFromParent(i);
    }

    public void m4355c(View view) {
        ey c = RecyclerView.m138c(view);
        if (c != null) {
            c.m4512z();
        }
    }

    public void m4356d(View view) {
        ey c = RecyclerView.m138c(view);
        if (c != null) {
            c.m4500A();
        }
    }
}
