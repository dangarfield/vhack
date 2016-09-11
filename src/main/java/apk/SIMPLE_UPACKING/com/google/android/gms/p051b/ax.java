package com.google.android.gms.p051b;

/* renamed from: com.google.android.gms.b.ax */
class ax implements Runnable {
    final /* synthetic */ hy f3465a;
    final /* synthetic */ aw f3466b;

    ax(aw awVar, hy hyVar) {
        this.f3466b = awVar;
        this.f3465a = hyVar;
    }

    public void run() {
        try {
            this.f3466b.f3461c.put(this.f3465a);
        } catch (InterruptedException e) {
        }
    }
}
