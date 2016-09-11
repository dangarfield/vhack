package android.support.v4.p002h;

import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewParentCompat */
/* renamed from: android.support.v4.h.dg */
class dg implements dd {
    dg() {
    }

    public boolean m2261a(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof bk) {
            return ((bk) viewParent).onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    public void m2262b(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof bk) {
            ((bk) viewParent).onNestedScrollAccepted(view, view2, i);
        }
    }

    public void m2256a(ViewParent viewParent, View view) {
        if (viewParent instanceof bk) {
            ((bk) viewParent).onStopNestedScroll(view);
        }
    }

    public void m2257a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        if (viewParent instanceof bk) {
            ((bk) viewParent).onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public void m2258a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        if (viewParent instanceof bk) {
            ((bk) viewParent).onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public boolean m2260a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        if (viewParent instanceof bk) {
            return ((bk) viewParent).onNestedFling(view, f, f2, z);
        }
        return false;
    }

    public boolean m2259a(ViewParent viewParent, View view, float f, float f2) {
        if (viewParent instanceof bk) {
            return ((bk) viewParent).onNestedPreFling(view, f, f2);
        }
        return false;
    }
}
