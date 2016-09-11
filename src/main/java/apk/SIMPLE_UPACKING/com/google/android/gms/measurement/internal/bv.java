package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;
import java.lang.Thread.UncaughtExceptionHandler;

final class bv implements UncaughtExceptionHandler {
    final /* synthetic */ bt f4841a;
    private final String f4842b;

    public bv(bt btVar, String str) {
        this.f4841a = btVar;
        bf.m7873a((Object) str);
        this.f4842b = str;
    }

    public synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f4841a.m8726s().m8582b().m8608a(this.f4842b, th);
    }
}
