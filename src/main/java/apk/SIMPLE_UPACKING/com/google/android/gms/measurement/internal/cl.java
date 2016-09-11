package com.google.android.gms.measurement.internal;

abstract class cl extends ck {
    private boolean f4654a;
    private boolean f4655b;
    private boolean f4656c;

    cl(bx bxVar) {
        super(bxVar);
        this.n.m8757a(this);
    }

    boolean m8223E() {
        return this.f4654a && !this.f4655b;
    }

    boolean m8224F() {
        return this.f4656c;
    }

    protected void m8225G() {
        if (!m8223E()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m8226H() {
        if (this.f4654a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        m8227a();
        this.n.m8750D();
        this.f4654a = true;
    }

    protected abstract void m8227a();
}
