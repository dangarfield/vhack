package android.support.v7.widget;

import android.support.v4.p002h.bu;

/* renamed from: android.support.v7.widget.h */
class ActionBarOverlayLayout implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout f2339a;

    ActionBarOverlayLayout(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f2339a = actionBarOverlayLayout;
    }

    public void run() {
        this.f2339a.m3425k();
        this.f2339a.f1640x = bu.m1960q(this.f2339a.f1621e).m2292c((float) (-this.f2339a.f1621e.getHeight())).m2286a(this.f2339a.f1641y);
    }
}
