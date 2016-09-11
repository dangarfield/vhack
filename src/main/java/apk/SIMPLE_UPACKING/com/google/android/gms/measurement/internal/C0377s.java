package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.s */
class C0377s implements Runnable {
    final /* synthetic */ ax f4943a;
    final /* synthetic */ C0374p f4944b;

    C0377s(C0374p c0374p, ax axVar) {
        this.f4944b = c0374p;
        this.f4943a = axVar;
    }

    public void run() {
        synchronized (this.f4944b) {
            this.f4944b.f4937b = false;
            if (!this.f4944b.f4936a.m8880b()) {
                this.f4944b.f4936a.m8897s().m8605y().m8607a("Connected to remote service");
                this.f4944b.f4936a.m8867a(this.f4943a);
            }
        }
    }
}
