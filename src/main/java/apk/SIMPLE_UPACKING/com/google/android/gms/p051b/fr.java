package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@fi
/* renamed from: com.google.android.gms.b.fr */
public final class fr {
    private static final ExecutorService f3669a;
    private static final ExecutorService f3670b;

    static {
        f3669a = Executors.newFixedThreadPool(10, fr.m6509a("Default"));
        f3670b = Executors.newFixedThreadPool(5, fr.m6509a("Loader"));
    }

    public static gy m6506a(int i, Runnable runnable) {
        return i == 1 ? fr.m6508a(f3670b, new fs(runnable)) : fr.m6508a(f3669a, new ft(runnable));
    }

    public static gy m6507a(Runnable runnable) {
        return fr.m6506a(0, runnable);
    }

    public static gy m6508a(ExecutorService executorService, Callable callable) {
        Object gxVar = new gx();
        try {
            gxVar.m6605a(new fv(gxVar, executorService.submit(new fu(gxVar, callable))));
        } catch (Throwable e) {
            C0099b.m5642c("Thread execution is rejected.", e);
            gxVar.cancel(true);
        }
        return gxVar;
    }

    private static ThreadFactory m6509a(String str) {
        return new fw(str);
    }
}
