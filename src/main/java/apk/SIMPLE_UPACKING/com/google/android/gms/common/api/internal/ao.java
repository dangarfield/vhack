package com.google.android.gms.common.api.internal;

import com.google.android.gms.p051b.kr;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ao {
    private static final ExecutorService f4190a;

    static {
        f4190a = Executors.newFixedThreadPool(2, new kr("GAC_Executor"));
    }

    public static ExecutorService m7393a() {
        return f4190a;
    }
}
