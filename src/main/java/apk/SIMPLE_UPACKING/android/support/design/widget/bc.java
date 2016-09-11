package android.support.design.widget;

import android.support.v4.p002h.ea;
import android.view.View;

/* compiled from: Snackbar */
class bc extends ea {
    boolean f356a;
    final /* synthetic */ int f357b;
    final /* synthetic */ Snackbar f358c;

    bc(Snackbar snackbar, int i) {
        this.f358c = snackbar;
        this.f357b = i;
        this.f356a = false;
    }

    public void m551a(View view) {
        if (!this.f358c.f271e.isEnabled()) {
            this.f358c.f269c.m420b(0, 180);
        }
    }

    public void m552b(View view) {
        this.f358c.m431d(this.f357b);
    }
}
