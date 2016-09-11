package com.google.android.gms.p051b;

import android.os.Process;
import com.google.android.gms.ads.internal.C0056g;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.b.fu */
final class fu implements Runnable {
    final /* synthetic */ gx f3673a;
    final /* synthetic */ Callable f3674b;

    fu(gx gxVar, Callable callable) {
        this.f3673a = gxVar;
        this.f3674b = callable;
    }

    public void run() {
        try {
            Process.setThreadPriority(10);
            this.f3673a.m6606b(this.f3674b.call());
        } catch (Throwable e) {
            C0056g.m5442f().m6500a(e, true);
            this.f3673a.cancel(true);
        }
    }
}
