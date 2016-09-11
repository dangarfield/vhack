package com.google.android.gms.p051b;

import java.util.concurrent.Future;

@fi
/* renamed from: com.google.android.gms.b.fn */
public abstract class fn {
    private final Runnable f3040a;
    private volatile Thread f3041b;
    private boolean f3042c;

    public fn() {
        this.f3040a = new fo(this);
        this.f3042c = false;
    }

    public abstract void m5504a();

    public final Future m5505b() {
        return this.f3042c ? fr.m6506a(1, this.f3040a) : fr.m6507a(this.f3040a);
    }
}
