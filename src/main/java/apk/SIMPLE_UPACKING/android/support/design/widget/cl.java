package android.support.design.widget;

import android.os.Build.VERSION;

/* compiled from: ViewUtils */
class cl {
    static final bv f412a;
    private static final cn f413b;

    static {
        f412a = new cm();
        if (VERSION.SDK_INT >= 21) {
            f413b = new cp();
        } else {
            f413b = new co();
        }
    }

    static bs m674a() {
        return f412a.m623a();
    }
}
