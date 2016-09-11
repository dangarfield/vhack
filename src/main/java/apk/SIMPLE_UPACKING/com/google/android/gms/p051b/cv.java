package com.google.android.gms.p051b;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.b.cv */
class cv implements Executor {
    final /* synthetic */ Handler f3535a;
    final /* synthetic */ cu f3536b;

    cv(cu cuVar, Handler handler) {
        this.f3536b = cuVar;
        this.f3535a = handler;
    }

    public void execute(Runnable runnable) {
        this.f3535a.post(runnable);
    }
}
