package org.vhack.dev.vhack;

import android.widget.ScrollView;

/* compiled from: MainActivity */
class dw implements Runnable {
    final /* synthetic */ ScrollView a;
    final /* synthetic */ dv b;

    dw(dv dvVar, ScrollView scrollView) {
        this.b = dvVar;
        this.a = scrollView;
    }

    public void run() {
        this.a.fullScroll(130);
    }
}
