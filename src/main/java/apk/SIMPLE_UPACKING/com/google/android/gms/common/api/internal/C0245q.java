package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0225a;
import com.google.android.gms.common.api.C0244s;
import com.google.android.gms.common.internal.bf;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.api.internal.q */
class C0245q implements C0244s {
    private final WeakReference f4258a;
    private final C0225a f4259b;
    private final int f4260c;

    public C0245q(C0242o c0242o, C0225a c0225a, int i) {
        this.f4258a = new WeakReference(c0242o);
        this.f4259b = c0225a;
        this.f4260c = i;
    }

    public void m7521a(ConnectionResult connectionResult) {
        boolean z = false;
        C0242o c0242o = (C0242o) this.f4258a.get();
        if (c0242o != null) {
            if (Looper.myLooper() == c0242o.f4236a.f4179g.m7595c()) {
                z = true;
            }
            bf.m7878a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            c0242o.f4237b.lock();
            try {
                if (c0242o.m7492b(0)) {
                    if (!connectionResult.m7280b()) {
                        c0242o.m7491b(connectionResult, this.f4259b, this.f4260c);
                    }
                    if (c0242o.m7499d()) {
                        c0242o.m7500e();
                    }
                    c0242o.f4237b.unlock();
                }
            } finally {
                c0242o.f4237b.unlock();
            }
        }
    }
}
