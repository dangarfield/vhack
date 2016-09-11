package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.bf;

abstract class ao {
    private static volatile Handler f4672b;
    private final bx f4673a;
    private final Runnable f4674c;
    private volatile long f4675d;
    private boolean f4676e;

    ao(bx bxVar) {
        bf.m7873a((Object) bxVar);
        this.f4673a = bxVar;
        this.f4676e = true;
        this.f4674c = new ap(this);
    }

    private Handler m8442d() {
        if (f4672b != null) {
            return f4672b;
        }
        Handler handler;
        synchronized (ao.class) {
            if (f4672b == null) {
                f4672b = new Handler(this.f4673a.m8778q().getMainLooper());
            }
            handler = f4672b;
        }
        return handler;
    }

    public abstract void m8443a();

    public void m8444a(long j) {
        m8446c();
        if (j >= 0) {
            this.f4675d = this.f4673a.m8779r().m6913a();
            if (!m8442d().postDelayed(this.f4674c, j)) {
                this.f4673a.m8767f().m8582b().m8608a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public boolean m8445b() {
        return this.f4675d != 0;
    }

    public void m8446c() {
        this.f4675d = 0;
        m8442d().removeCallbacks(this.f4674c);
    }
}
