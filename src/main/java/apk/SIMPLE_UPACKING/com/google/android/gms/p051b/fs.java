package com.google.android.gms.p051b;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.b.fs */
final class fs implements Callable {
    final /* synthetic */ Runnable f3671a;

    fs(Runnable runnable) {
        this.f3671a = runnable;
    }

    public Void m6510a() {
        this.f3671a.run();
        return null;
    }

    public /* synthetic */ Object call() {
        return m6510a();
    }
}
