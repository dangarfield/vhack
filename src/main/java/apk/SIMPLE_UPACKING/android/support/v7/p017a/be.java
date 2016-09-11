package android.support.v7.p017a;

import android.support.v4.p002h.bu;
import android.support.v4.p002h.ea;
import android.view.View;

/* compiled from: WindowDecorActionBar */
/* renamed from: android.support.v7.a.be */
class be extends ea {
    final /* synthetic */ bd f1234a;

    be(bd bdVar) {
        this.f1234a = bdVar;
    }

    public void m2991b(View view) {
        if (this.f1234a.f1205C && this.f1234a.f1227t != null) {
            bu.m1935b(this.f1234a.f1227t, 0.0f);
            bu.m1935b(this.f1234a.f1224q, 0.0f);
        }
        this.f1234a.f1224q.setVisibility(8);
        this.f1234a.f1224q.setTransitioning(false);
        this.f1234a.f1210H = null;
        this.f1234a.m2982i();
        if (this.f1234a.f1223p != null) {
            bu.m1962s(this.f1234a.f1223p);
        }
    }
}
