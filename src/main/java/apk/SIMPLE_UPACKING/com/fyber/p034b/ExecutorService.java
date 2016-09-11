package com.fyber.p034b;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.fyber.b.c */
final class ExecutorService implements ThreadFactory {
    ExecutorService() {
    }

    public final Thread newThread(Runnable runnable) {
        return new ExecutorService(runnable);
    }
}
