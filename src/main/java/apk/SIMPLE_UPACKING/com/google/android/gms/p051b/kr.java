package com.google.android.gms.p051b;

import com.google.android.gms.common.internal.bf;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.b.kr */
public class kr implements ThreadFactory {
    private final String f3876a;
    private final int f3877b;
    private final AtomicInteger f3878c;
    private final ThreadFactory f3879d;

    public kr(String str) {
        this(str, 0);
    }

    public kr(String str, int i) {
        this.f3878c = new AtomicInteger();
        this.f3879d = Executors.defaultThreadFactory();
        this.f3876a = (String) bf.m7874a((Object) str, (Object) "Name must not be null");
        this.f3877b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f3879d.newThread(new ks(runnable, this.f3877b));
        newThread.setName(this.f3876a + "[" + this.f3878c.getAndIncrement() + "]");
        return newThread;
    }
}
