package com.google.android.gms.p051b;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.b.mf */
class mf {
    public static final boolean f4034a;
    private final List f4035b;
    private boolean f4036c;

    static {
        f4034a = me.f4033b;
    }

    mf() {
        this.f4035b = new ArrayList();
        this.f4036c = false;
    }

    private long m7101a() {
        if (this.f4035b.size() == 0) {
            return 0;
        }
        return ((mg) this.f4035b.get(this.f4035b.size() - 1)).f4039c - ((mg) this.f4035b.get(0)).f4039c;
    }

    public synchronized void m7102a(String str) {
        this.f4036c = true;
        if (m7101a() > 0) {
            long j = ((mg) this.f4035b.get(0)).f4039c;
            me.m7098b("(%-4d ms) %s", Long.valueOf(r2), str);
            long j2 = j;
            for (mg mgVar : this.f4035b) {
                me.m7098b("(+%-4d) [%2d] %s", Long.valueOf(mgVar.f4039c - j2), Long.valueOf(mgVar.f4038b), mgVar.f4037a);
                j2 = mgVar.f4039c;
            }
        }
    }

    public synchronized void m7103a(String str, long j) {
        if (this.f4036c) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.f4035b.add(new mg(str, j, SystemClock.elapsedRealtime()));
    }

    protected void finalize() {
        if (!this.f4036c) {
            m7102a("Request on the loose");
            me.m7099c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}
