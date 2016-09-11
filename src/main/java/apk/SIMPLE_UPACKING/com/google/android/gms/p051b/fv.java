package com.google.android.gms.p051b;

import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.b.fv */
final class fv implements Runnable {
    final /* synthetic */ gx f3675a;
    final /* synthetic */ Future f3676b;

    fv(gx gxVar, Future future) {
        this.f3675a = gxVar;
        this.f3676b = future;
    }

    public void run() {
        if (this.f3675a.isCancelled()) {
            this.f3676b.cancel(true);
        }
    }
}
