package android.support.design.widget;

import android.support.v4.p002h.bm;
import android.support.v4.p002h.bu;
import android.view.View;

/* renamed from: android.support.design.widget.w */
class CoordinatorLayoutInsetsHelperLollipop implements CoordinatorLayoutInsetsHelper {
    CoordinatorLayoutInsetsHelperLollipop() {
    }

    public void m729a(View view, bm bmVar) {
        if (bu.m1963t(view)) {
            bu.m1930a(view, bmVar);
            view.setSystemUiVisibility(1280);
        }
    }
}
