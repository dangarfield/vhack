package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.google.android.gms.b.ep */
public class ep extends Thread {
    private final BlockingQueue f3613a;
    private final di f3614b;
    private final C0208k f3615c;
    private final kl f3616d;
    private volatile boolean f3617e;

    public ep(BlockingQueue blockingQueue, di diVar, C0208k c0208k, kl klVar) {
        this.f3617e = false;
        this.f3613a = blockingQueue;
        this.f3614b = diVar;
        this.f3615c = c0208k;
        this.f3616d = klVar;
    }

    @TargetApi(14)
    private void m6458a(hy hyVar) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(hyVar.m6195c());
        }
    }

    private void m6459a(hy hyVar, lt ltVar) {
        this.f3616d.m6257a(hyVar, hyVar.m6189a(ltVar));
    }

    public void m6460a() {
        this.f3617e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                hy hyVar = (hy) this.f3613a.take();
                try {
                    hyVar.m6194b("network-queue-take");
                    if (hyVar.m6200g()) {
                        hyVar.m6196c("network-discard-cancelled");
                    } else {
                        m6458a(hyVar);
                        fk a = this.f3614b.m6325a(hyVar);
                        hyVar.m6194b("network-http-complete");
                        if (a.f3636d && hyVar.m6214u()) {
                            hyVar.m6196c("not-modified");
                        } else {
                            jk a2 = hyVar.m6188a(a);
                            hyVar.m6194b("network-parse-complete");
                            if (hyVar.m6209p() && a2.f3853b != null) {
                                this.f3615c.m6906a(hyVar.m6198e(), a2.f3853b);
                                hyVar.m6194b("network-cache-written");
                            }
                            hyVar.m6213t();
                            this.f3616d.m6255a(hyVar, a2);
                        }
                    }
                } catch (lt e) {
                    e.m6065a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    m6459a(hyVar, e);
                } catch (Throwable e2) {
                    me.m7097a(e2, "Unhandled exception %s", e2.toString());
                    lt ltVar = new lt(e2);
                    ltVar.m6065a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f3616d.m6257a(hyVar, ltVar);
                }
            } catch (InterruptedException e3) {
                if (this.f3617e) {
                    return;
                }
            }
        }
    }
}
