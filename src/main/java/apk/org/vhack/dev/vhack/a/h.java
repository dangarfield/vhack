package org.vhack.dev.vhack.a;

import java.util.List;

/* compiled from: IabHelper */
class h implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ f b;

    h(f fVar, List list) {
        this.b = fVar;
        this.a = list;
    }

    public void run() {
        this.b.d.a(this.b.a, this.a);
    }
}
