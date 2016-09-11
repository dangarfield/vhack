package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.p007b.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.C0257n;
import com.google.android.gms.common.api.internal.av;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.auth.api.signin.internal.d */
public class C0162d extends AsyncTaskLoader implements av {
    private Semaphore f3320o;
    private Set f3321p;

    public C0162d(Context context, Set set) {
        super(context);
        this.f3320o = new Semaphore(0);
        this.f3321p = set;
    }

    public /* synthetic */ Object m5965d() {
        return m5967s();
    }

    protected void m5966j() {
        this.f3320o.drainPermits();
        m1254l();
    }

    public Void m5967s() {
        int i = 0;
        for (C0257n a : this.f3321p) {
            i = a.m7557a((av) this) ? i + 1 : i;
        }
        try {
            this.f3320o.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public void m5968t() {
        this.f3320o.release();
    }
}
