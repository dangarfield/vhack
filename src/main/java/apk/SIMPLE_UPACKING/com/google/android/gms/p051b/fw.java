package com.google.android.gms.p051b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.b.fw */
final class fw implements ThreadFactory {
    final /* synthetic */ String f3677a;
    private final AtomicInteger f3678b;

    fw(String str) {
        this.f3677a = str;
        this.f3678b = new AtomicInteger(1);
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AdWorker(" + this.f3677a + ") #" + this.f3678b.getAndIncrement());
    }
}
