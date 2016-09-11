package com.google.android.gms.p051b;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@fi
/* renamed from: com.google.android.gms.b.gx */
public class gx implements gy {
    private final Object f3706a;
    private Object f3707b;
    private boolean f3708c;
    private boolean f3709d;
    private final gz f3710e;

    public gx() {
        this.f3706a = new Object();
        this.f3707b = null;
        this.f3708c = false;
        this.f3709d = false;
        this.f3710e = new gz();
    }

    public void m6605a(Runnable runnable) {
        this.f3710e.m6621a(runnable);
    }

    public void m6606b(Object obj) {
        synchronized (this.f3706a) {
            if (this.f3709d) {
            } else if (this.f3708c) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            } else {
                this.f3708c = true;
                this.f3707b = obj;
                this.f3706a.notifyAll();
                this.f3710e.m6620a();
            }
        }
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f3706a) {
            if (this.f3708c) {
                return false;
            }
            this.f3709d = true;
            this.f3708c = true;
            this.f3706a.notifyAll();
            this.f3710e.m6620a();
            return true;
        }
    }

    public Object get() {
        Object obj;
        synchronized (this.f3706a) {
            if (!this.f3708c) {
                try {
                    this.f3706a.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.f3709d) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            obj = this.f3707b;
        }
        return obj;
    }

    public Object get(long j, TimeUnit timeUnit) {
        Object obj;
        synchronized (this.f3706a) {
            if (!this.f3708c) {
                try {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis != 0) {
                        this.f3706a.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.f3708c) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.f3709d) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                obj = this.f3707b;
            }
        }
        return obj;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.f3706a) {
            z = this.f3709d;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.f3706a) {
            z = this.f3708c;
        }
        return z;
    }
}
