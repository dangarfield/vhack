package android.support.v4.p002h;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: ViewCompatLollipop */
/* renamed from: android.support.v4.h.cr */
final class cr implements OnApplyWindowInsetsListener {
    final /* synthetic */ bm f936a;

    cr(bm bmVar) {
        this.f936a = bmVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((ed) this.f936a.m701a(view, new ed(windowInsets))).m2363f();
    }
}
