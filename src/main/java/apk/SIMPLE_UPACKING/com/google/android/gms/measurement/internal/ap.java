package com.google.android.gms.measurement.internal;

import android.os.Looper;

class ap implements Runnable {
    final /* synthetic */ ao f4677a;

    ap(ao aoVar) {
        this.f4677a = aoVar;
    }

    public void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f4677a.f4673a.m8769h().m8709a((Runnable) this);
            return;
        }
        boolean b = this.f4677a.m8445b();
        this.f4677a.f4675d = 0;
        if (b && this.f4677a.f4676e) {
            this.f4677a.m8443a();
        }
    }
}
