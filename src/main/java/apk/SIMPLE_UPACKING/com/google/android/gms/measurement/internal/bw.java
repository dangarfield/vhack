package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;
import java.util.concurrent.BlockingQueue;

final class bw extends Thread {
    final /* synthetic */ bt f4843a;
    private final Object f4844b;
    private final BlockingQueue f4845c;

    public bw(bt btVar, String str, BlockingQueue blockingQueue) {
        this.f4843a = btVar;
        bf.m7873a((Object) str);
        this.f4844b = new Object();
        this.f4845c = blockingQueue;
        setName(str);
    }

    private void m8729a(InterruptedException interruptedException) {
        this.f4843a.m8726s().m8583c().m8608a(getName() + " was interrupted", interruptedException);
    }

    public void m8730a() {
        synchronized (this.f4844b) {
            this.f4844b.notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
        r0 = 0;
        r1 = r0;
    L_0x0002:
        if (r1 != 0) goto L_0x0015;
    L_0x0004:
        r0 = r4.f4843a;	 Catch:{ InterruptedException -> 0x0010 }
        r0 = r0.f4837h;	 Catch:{ InterruptedException -> 0x0010 }
        r0.acquire();	 Catch:{ InterruptedException -> 0x0010 }
        r0 = 1;
        r1 = r0;
        goto L_0x0002;
    L_0x0010:
        r0 = move-exception;
        r4.m8729a(r0);
        goto L_0x0002;
    L_0x0015:
        r0 = r4.f4845c;	 Catch:{ all -> 0x0023 }
        r0 = r0.poll();	 Catch:{ all -> 0x0023 }
        r0 = (java.util.concurrent.FutureTask) r0;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x004d;
    L_0x001f:
        r0.run();	 Catch:{ all -> 0x0023 }
        goto L_0x0015;
    L_0x0023:
        r0 = move-exception;
        r1 = r4.f4843a;
        r1 = r1.f4836g;
        monitor-enter(r1);
        r2 = r4.f4843a;	 Catch:{ all -> 0x00e1 }
        r2 = r2.f4837h;	 Catch:{ all -> 0x00e1 }
        r2.release();	 Catch:{ all -> 0x00e1 }
        r2 = r4.f4843a;	 Catch:{ all -> 0x00e1 }
        r2 = r2.f4836g;	 Catch:{ all -> 0x00e1 }
        r2.notifyAll();	 Catch:{ all -> 0x00e1 }
        r2 = r4.f4843a;	 Catch:{ all -> 0x00e1 }
        r2 = r2.f4830a;	 Catch:{ all -> 0x00e1 }
        if (r4 != r2) goto L_0x00d1;
    L_0x0045:
        r2 = r4.f4843a;	 Catch:{ all -> 0x00e1 }
        r3 = 0;
        r2.f4830a = r3;	 Catch:{ all -> 0x00e1 }
    L_0x004b:
        monitor-exit(r1);	 Catch:{ all -> 0x00e1 }
        throw r0;
    L_0x004d:
        r1 = r4.f4844b;	 Catch:{ all -> 0x0023 }
        monitor-enter(r1);	 Catch:{ all -> 0x0023 }
        r0 = r4.f4845c;	 Catch:{ all -> 0x00a6 }
        r0 = r0.peek();	 Catch:{ all -> 0x00a6 }
        if (r0 != 0) goto L_0x0067;
    L_0x0058:
        r0 = r4.f4843a;	 Catch:{ all -> 0x00a6 }
        r0 = r0.f4838i;	 Catch:{ all -> 0x00a6 }
        if (r0 != 0) goto L_0x0067;
    L_0x0060:
        r0 = r4.f4844b;	 Catch:{ InterruptedException -> 0x00a1 }
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.wait(r2);	 Catch:{ InterruptedException -> 0x00a1 }
    L_0x0067:
        monitor-exit(r1);	 Catch:{ all -> 0x00a6 }
        r0 = r4.f4843a;	 Catch:{ all -> 0x0023 }
        r1 = r0.f4836g;	 Catch:{ all -> 0x0023 }
        monitor-enter(r1);	 Catch:{ all -> 0x0023 }
        r0 = r4.f4845c;	 Catch:{ all -> 0x00ce }
        r0 = r0.peek();	 Catch:{ all -> 0x00ce }
        if (r0 != 0) goto L_0x00cb;
    L_0x0077:
        monitor-exit(r1);	 Catch:{ all -> 0x00ce }
        r0 = r4.f4843a;
        r1 = r0.f4836g;
        monitor-enter(r1);
        r0 = r4.f4843a;	 Catch:{ all -> 0x00b8 }
        r0 = r0.f4837h;	 Catch:{ all -> 0x00b8 }
        r0.release();	 Catch:{ all -> 0x00b8 }
        r0 = r4.f4843a;	 Catch:{ all -> 0x00b8 }
        r0 = r0.f4836g;	 Catch:{ all -> 0x00b8 }
        r0.notifyAll();	 Catch:{ all -> 0x00b8 }
        r0 = r4.f4843a;	 Catch:{ all -> 0x00b8 }
        r0 = r0.f4830a;	 Catch:{ all -> 0x00b8 }
        if (r4 != r0) goto L_0x00a9;
    L_0x0099:
        r0 = r4.f4843a;	 Catch:{ all -> 0x00b8 }
        r2 = 0;
        r0.f4830a = r2;	 Catch:{ all -> 0x00b8 }
    L_0x009f:
        monitor-exit(r1);	 Catch:{ all -> 0x00b8 }
        return;
    L_0x00a1:
        r0 = move-exception;
        r4.m8729a(r0);	 Catch:{ all -> 0x00a6 }
        goto L_0x0067;
    L_0x00a6:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00a6 }
        throw r0;	 Catch:{ all -> 0x0023 }
    L_0x00a9:
        r0 = r4.f4843a;	 Catch:{ all -> 0x00b8 }
        r0 = r0.f4831b;	 Catch:{ all -> 0x00b8 }
        if (r4 != r0) goto L_0x00bb;
    L_0x00b1:
        r0 = r4.f4843a;	 Catch:{ all -> 0x00b8 }
        r2 = 0;
        r0.f4831b = r2;	 Catch:{ all -> 0x00b8 }
        goto L_0x009f;
    L_0x00b8:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00b8 }
        throw r0;
    L_0x00bb:
        r0 = r4.f4843a;	 Catch:{ all -> 0x00b8 }
        r0 = r0.m8726s();	 Catch:{ all -> 0x00b8 }
        r0 = r0.m8582b();	 Catch:{ all -> 0x00b8 }
        r2 = "Current scheduler thread is neither worker nor network";
        r0.m8607a(r2);	 Catch:{ all -> 0x00b8 }
        goto L_0x009f;
    L_0x00cb:
        monitor-exit(r1);	 Catch:{ all -> 0x00ce }
        goto L_0x0015;
    L_0x00ce:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00ce }
        throw r0;	 Catch:{ all -> 0x0023 }
    L_0x00d1:
        r2 = r4.f4843a;	 Catch:{ all -> 0x00e1 }
        r2 = r2.f4831b;	 Catch:{ all -> 0x00e1 }
        if (r4 != r2) goto L_0x00e4;
    L_0x00d9:
        r2 = r4.f4843a;	 Catch:{ all -> 0x00e1 }
        r3 = 0;
        r2.f4831b = r3;	 Catch:{ all -> 0x00e1 }
        goto L_0x004b;
    L_0x00e1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00e1 }
        throw r0;
    L_0x00e4:
        r2 = r4.f4843a;	 Catch:{ all -> 0x00e1 }
        r2 = r2.m8726s();	 Catch:{ all -> 0x00e1 }
        r2 = r2.m8582b();	 Catch:{ all -> 0x00e1 }
        r3 = "Current scheduler thread is neither worker nor network";
        r2.m8607a(r3);	 Catch:{ all -> 0x00e1 }
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.bw.run():void");
    }
}
