package org.vhack.dev.vhack;

import android.widget.ScrollView;

/* compiled from: MainActivity */
class dw implements Runnable {
    final /* synthetic */ ScrollView f5394a;
    final /* synthetic */ dv f5395b;

    dw(dv dvVar, ScrollView scrollView) {
        this.f5395b = dvVar;
        this.f5394a = scrollView;
    }

    public void run() {
        this.f5394a.fullScroll(130);
    }
}
