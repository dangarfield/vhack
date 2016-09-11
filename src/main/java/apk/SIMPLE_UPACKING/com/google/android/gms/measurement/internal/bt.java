package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.kf;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class bt extends cl {
    private bw f4830a;
    private bw f4831b;
    private final BlockingQueue f4832c;
    private final BlockingQueue f4833d;
    private final UncaughtExceptionHandler f4834e;
    private final UncaughtExceptionHandler f4835f;
    private final Object f4836g;
    private final Semaphore f4837h;
    private volatile boolean f4838i;

    bt(bx bxVar) {
        super(bxVar);
        this.f4836g = new Object();
        this.f4837h = new Semaphore(2);
        this.f4832c = new LinkedBlockingQueue();
        this.f4833d = new LinkedBlockingQueue();
        this.f4834e = new bv(this, "Thread death: Uncaught exception on worker thread");
        this.f4835f = new bv(this, "Thread death: Uncaught exception on network thread");
    }

    private void m8700a(FutureTask futureTask) {
        synchronized (this.f4836g) {
            this.f4832c.add(futureTask);
            if (this.f4830a == null) {
                this.f4830a = new bw(this, "Measurement Worker", this.f4832c);
                this.f4830a.setUncaughtExceptionHandler(this.f4834e);
                this.f4830a.start();
            } else {
                this.f4830a.m8730a();
            }
        }
    }

    private void m8702b(FutureTask futureTask) {
        synchronized (this.f4836g) {
            this.f4833d.add(futureTask);
            if (this.f4831b == null) {
                this.f4831b = new bw(this, "Measurement Network", this.f4833d);
                this.f4831b.setUncaughtExceptionHandler(this.f4835f);
                this.f4831b.start();
            } else {
                this.f4831b.m8730a();
            }
        }
    }

    public Future m8707a(Callable callable) {
        m8225G();
        bf.m7873a((Object) callable);
        FutureTask buVar = new bu(this, callable, "Task exception on worker thread");
        if (Thread.currentThread() == this.f4830a) {
            buVar.run();
        } else {
            m8700a(buVar);
        }
        return buVar;
    }

    protected void m8708a() {
    }

    public void m8709a(Runnable runnable) {
        m8225G();
        bf.m7873a((Object) runnable);
        m8700a(new bu(this, runnable, "Task exception on worker thread"));
    }

    public void m8710b(Runnable runnable) {
        m8225G();
        bf.m7873a((Object) runnable);
        m8702b(new bu(this, runnable, "Task exception on network thread"));
    }

    public /* bridge */ /* synthetic */ void m8711d() {
        super.m8205d();
    }

    public void m8712e() {
        if (Thread.currentThread() != this.f4831b) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public void m8713f() {
        if (Thread.currentThread() != this.f4830a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public /* bridge */ /* synthetic */ ai m8714g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8715h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8716i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8717j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8718k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8719l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8720m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8721n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8722o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8723p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8724q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8725r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8726s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8727t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8728u() {
        return super.m8222u();
    }
}
