package com.google.android.gms.p051b;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.b.ky */
public class ky {
    public static Object m6959a(Callable callable) {
        Object call;
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(ThreadPolicy.LAX);
            call = callable.call();
        } catch (Throwable th) {
            call = null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        return call;
    }
}
