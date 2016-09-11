package android.support.design.widget;

import android.support.v4.p002h.bu;
import android.support.v4.widget.bm;
import android.view.View;

/* renamed from: android.support.design.widget.h */
class BottomSheetBehavior extends bm {
    final /* synthetic */ BottomSheetBehavior f416a;

    BottomSheetBehavior(BottomSheetBehavior bottomSheetBehavior) {
        this.f416a = bottomSheetBehavior;
    }

    public boolean m691a(View view, int i) {
        if (this.f416a.f206f == 1 || this.f416a.f218r) {
            return false;
        }
        if (this.f416a.f206f == 3 && this.f416a.f216p == i) {
            View view2 = (View) this.f416a.f213m.get();
            if (view2 != null && bu.m1938b(view2, -1)) {
                return false;
            }
        }
        boolean z = this.f416a.f212l != null && this.f416a.f212l.get() == view;
        return z;
    }

    public void m690a(View view, int i, int i2, int i3, int i4) {
        this.f416a.m337c(i2);
    }

    public void m688a(int i) {
        if (i == 1) {
            this.f416a.m333b(1);
        }
    }

    public void m689a(View view, float f, float f2) {
        int f3;
        int i = 3;
        if (f2 < 0.0f) {
            f3 = this.f416a.f203c;
        } else if (this.f416a.f205e && this.f416a.m331a(view, f2)) {
            f3 = this.f416a.f211k;
            i = 5;
        } else if (f2 == 0.0f) {
            int top = view.getTop();
            if (Math.abs(top - this.f416a.f203c) < Math.abs(top - this.f416a.f204d)) {
                f3 = this.f416a.f203c;
            } else {
                f3 = this.f416a.f204d;
                i = 4;
            }
        } else {
            f3 = this.f416a.f204d;
            i = 4;
        }
        if (this.f416a.f207g.m2635a(view.getLeft(), f3)) {
            this.f416a.m333b(2);
            bu.m1931a(view, new BottomSheetBehavior(this.f416a, view, i));
            return;
        }
        this.f416a.m333b(i);
    }

    public int m687a(View view, int i, int i2) {
        return ar.m520a(i, this.f416a.f203c, this.f416a.f205e ? this.f416a.f211k : this.f416a.f204d);
    }

    public int m692b(View view, int i, int i2) {
        return view.getLeft();
    }

    public int m686a(View view) {
        if (this.f416a.f205e) {
            return this.f416a.f211k - this.f416a.f203c;
        }
        return this.f416a.f204d - this.f416a.f203c;
    }
}
