package com.google.android.gms.p051b;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.b.ft */
final class ft implements Callable {
    final /* synthetic */ Runnable f3672a;

    ft(Runnable runnable) {
        this.f3672a = runnable;
    }

    public Void m6511a() {
        this.f3672a.run();
        return null;
    }

    public /* synthetic */ Object call() {
        return m6511a();
    }
}
