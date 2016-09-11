package com.google.android.gms.gcm;

import android.content.Intent;

/* renamed from: com.google.android.gms.gcm.b */
class C0337b implements Runnable {
    final /* synthetic */ Intent f4545a;
    final /* synthetic */ C0336a f4546b;

    C0337b(C0336a c0336a, Intent intent) {
        this.f4546b = c0336a;
        this.f4545a = intent;
    }

    public void run() {
        this.f4546b.m8077c(this.f4545a);
    }
}
