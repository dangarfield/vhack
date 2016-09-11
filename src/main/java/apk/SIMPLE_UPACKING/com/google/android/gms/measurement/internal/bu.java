package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class bu extends FutureTask {
    final /* synthetic */ bt f4839a;
    private final String f4840b;

    bu(bt btVar, Runnable runnable, String str) {
        this.f4839a = btVar;
        super(runnable, null);
        bf.m7873a((Object) str);
        this.f4840b = str;
    }

    bu(bt btVar, Callable callable, String str) {
        this.f4839a = btVar;
        super(callable);
        bf.m7873a((Object) str);
        this.f4840b = str;
    }

    protected void setException(Throwable th) {
        this.f4839a.m8726s().m8582b().m8608a(this.f4840b, th);
        super.setException(th);
    }
}
