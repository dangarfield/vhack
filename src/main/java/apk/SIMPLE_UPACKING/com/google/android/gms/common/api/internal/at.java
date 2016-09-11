package com.google.android.gms.common.api.internal;

import com.google.android.gms.p051b.kr;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class at {
    private static final ExecutorService f4192a;

    static {
        f4192a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new kr("GAC_Transform"));
    }

    public static ExecutorService m7398a() {
        return f4192a;
    }
}
