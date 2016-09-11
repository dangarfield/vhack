package com.google.android.gms.p051b;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.google.android.gms.b.aw */
public class aw extends Thread {
    private static final boolean f3459a;
    private final BlockingQueue f3460b;
    private final BlockingQueue f3461c;
    private final C0208k f3462d;
    private final kl f3463e;
    private volatile boolean f3464f;

    static {
        f3459a = me.f4033b;
    }

    public aw(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, C0208k c0208k, kl klVar) {
        this.f3464f = false;
        this.f3460b = blockingQueue;
        this.f3461c = blockingQueue2;
        this.f3462d = c0208k;
        this.f3463e = klVar;
    }

    public void m6122a() {
        this.f3464f = true;
        interrupt();
    }

    public void run() {
        if (f3459a) {
            me.m7096a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f3462d.m6905a();
        while (true) {
            try {
                hy hyVar = (hy) this.f3460b.take();
                hyVar.m6194b("cache-queue-take");
                if (hyVar.m6200g()) {
                    hyVar.m6196c("cache-discard-canceled");
                } else {
                    C0209l a = this.f3462d.m6904a(hyVar.m6198e());
                    if (a == null) {
                        hyVar.m6194b("cache-miss");
                        this.f3461c.put(hyVar);
                    } else if (a.m6960a()) {
                        hyVar.m6194b("cache-hit-expired");
                        hyVar.m6187a(a);
                        this.f3461c.put(hyVar);
                    } else {
                        hyVar.m6194b("cache-hit");
                        jk a2 = hyVar.m6188a(new fk(a.f3883a, a.f3889g));
                        hyVar.m6194b("cache-hit-parsed");
                        if (a.m6961b()) {
                            hyVar.m6194b("cache-hit-refresh-needed");
                            hyVar.m6187a(a);
                            a2.f3855d = true;
                            this.f3463e.m6256a(hyVar, a2, new ax(this, hyVar));
                        } else {
                            this.f3463e.m6255a(hyVar, a2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f3464f) {
                    return;
                }
            }
        }
    }
}
