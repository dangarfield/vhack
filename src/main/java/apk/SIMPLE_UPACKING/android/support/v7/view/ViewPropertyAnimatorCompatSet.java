package android.support.v7.view;

import android.support.v4.p002h.ea;
import android.view.View;

/* renamed from: android.support.v7.view.m */
class ViewPropertyAnimatorCompatSet extends ea {
    final /* synthetic */ ViewPropertyAnimatorCompatSet f1415a;
    private boolean f1416b;
    private int f1417c;

    ViewPropertyAnimatorCompatSet(ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet) {
        this.f1415a = viewPropertyAnimatorCompatSet;
        this.f1416b = false;
        this.f1417c = 0;
    }

    public void m3168a(View view) {
        if (!this.f1416b) {
            this.f1416b = true;
            if (this.f1415a.f1412d != null) {
                this.f1415a.f1412d.m543a(null);
            }
        }
    }

    void m3167a() {
        this.f1417c = 0;
        this.f1416b = false;
        this.f1415a.m3159c();
    }

    public void m3169b(View view) {
        int i = this.f1417c + 1;
        this.f1417c = i;
        if (i == this.f1415a.f1409a.size()) {
            if (this.f1415a.f1412d != null) {
                this.f1415a.f1412d.m544b(null);
            }
            m3167a();
        }
    }
}
