package android.support.v4.p002h;

import android.view.WindowInsets;

/* compiled from: WindowInsetsCompatApi21 */
/* renamed from: android.support.v4.h.ed */
class ed extends ec {
    private final WindowInsets f957a;

    ed(WindowInsets windowInsets) {
        this.f957a = windowInsets;
    }

    public int m2357a() {
        return this.f957a.getSystemWindowInsetLeft();
    }

    public int m2359b() {
        return this.f957a.getSystemWindowInsetTop();
    }

    public int m2360c() {
        return this.f957a.getSystemWindowInsetRight();
    }

    public int m2361d() {
        return this.f957a.getSystemWindowInsetBottom();
    }

    public boolean m2362e() {
        return this.f957a.isConsumed();
    }

    public ec m2358a(int i, int i2, int i3, int i4) {
        return new ed(this.f957a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    WindowInsets m2363f() {
        return this.f957a;
    }
}
