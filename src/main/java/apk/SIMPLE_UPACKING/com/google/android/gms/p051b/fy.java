package com.google.android.gms.p051b;

import android.content.Context;

/* renamed from: com.google.android.gms.b.fy */
class fy implements Runnable {
    final /* synthetic */ Context f3684a;
    final /* synthetic */ fx f3685b;

    fy(fx fxVar, Context context) {
        this.f3685b = fxVar;
        this.f3684a = context;
    }

    public void run() {
        synchronized (this.f3685b.f3680b) {
            this.f3685b.f3682d = this.f3685b.m6524a(this.f3684a);
            this.f3685b.f3680b.notifyAll();
        }
    }
}
