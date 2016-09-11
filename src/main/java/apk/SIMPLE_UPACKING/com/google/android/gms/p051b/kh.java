package com.google.android.gms.p051b;

import android.os.SystemClock;

/* renamed from: com.google.android.gms.b.kh */
public final class kh implements kf {
    private static kh f3865a;

    public static synchronized kf m6922c() {
        kf kfVar;
        synchronized (kh.class) {
            if (f3865a == null) {
                f3865a = new kh();
            }
            kfVar = f3865a;
        }
        return kfVar;
    }

    public long m6923a() {
        return System.currentTimeMillis();
    }

    public long m6924b() {
        return SystemClock.elapsedRealtime();
    }
}
