package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.q */
class C0375q implements Runnable {
    final /* synthetic */ ax f4939a;
    final /* synthetic */ C0374p f4940b;

    C0375q(C0374p c0374p, ax axVar) {
        this.f4940b = c0374p;
        this.f4939a = axVar;
    }

    public void run() {
        synchronized (this.f4940b) {
            this.f4940b.f4937b = false;
            if (!this.f4940b.f4936a.m8880b()) {
                this.f4940b.f4936a.m8897s().m8606z().m8607a("Connected to service");
                this.f4940b.f4936a.m8867a(this.f4939a);
            }
        }
    }
}
