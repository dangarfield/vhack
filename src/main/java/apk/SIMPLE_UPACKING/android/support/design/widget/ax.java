package android.support.design.widget;

import android.view.View;

/* compiled from: Snackbar */
class ax implements bf {
    final /* synthetic */ Snackbar f351a;

    ax(Snackbar snackbar) {
        this.f351a = snackbar;
    }

    public void m539a(View view) {
    }

    public void m540b(View view) {
        if (this.f351a.m435a()) {
            Snackbar.f267a.post(new ay(this));
        }
    }
}
