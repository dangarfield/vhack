package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.k */
class C0238k implements Runnable {
    final /* synthetic */ C0235h f4231a;

    C0238k(C0235h c0235h) {
        this.f4231a = c0235h;
    }

    public void run() {
        this.f4231a.f4227m.lock();
        try {
            this.f4231a.m7447j();
        } finally {
            this.f4231a.f4227m.unlock();
        }
    }
}
