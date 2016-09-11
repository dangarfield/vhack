package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.x */
abstract class C0246x implements Runnable {
    final /* synthetic */ C0242o f4261b;

    private C0246x(C0242o c0242o) {
        this.f4261b = c0242o;
    }

    protected abstract void m7522a();

    public void run() {
        this.f4261b.f4237b.lock();
        try {
            if (!Thread.interrupted()) {
                m7522a();
                this.f4261b.f4237b.unlock();
            }
        } catch (RuntimeException e) {
            this.f4261b.f4236a.m7379a(e);
        } finally {
            this.f4261b.f4237b.unlock();
        }
    }
}
