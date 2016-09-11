package com.google.android.gms.p051b;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.b.cu */
public class cu implements kl {
    private final Executor f3534a;

    public cu(Handler handler) {
        this.f3534a = new cv(this, handler);
    }

    public void m6258a(hy hyVar, jk jkVar) {
        m6259a(hyVar, jkVar, null);
    }

    public void m6259a(hy hyVar, jk jkVar, Runnable runnable) {
        hyVar.m6213t();
        hyVar.m6194b("post-response");
        this.f3534a.execute(new cw(this, hyVar, jkVar, runnable));
    }

    public void m6260a(hy hyVar, lt ltVar) {
        hyVar.m6194b("post-error");
        this.f3534a.execute(new cw(this, hyVar, jk.m6884a(ltVar), null));
    }
}
