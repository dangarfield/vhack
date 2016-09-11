package android.support.v7.widget;

import android.support.v4.p002h.ea;
import android.view.View;

/* compiled from: ToolbarWidgetWrapper */
class gl extends ea {
    final /* synthetic */ int f2329a;
    final /* synthetic */ gj f2330b;
    private boolean f2331c;

    gl(gj gjVar, int i) {
        this.f2330b = gjVar;
        this.f2329a = i;
        this.f2331c = false;
    }

    public void m4724a(View view) {
        this.f2330b.f2309a.setVisibility(0);
    }

    public void m4725b(View view) {
        if (!this.f2331c) {
            this.f2330b.f2309a.setVisibility(this.f2329a);
        }
    }

    public void m4726c(View view) {
        this.f2331c = true;
    }
}
