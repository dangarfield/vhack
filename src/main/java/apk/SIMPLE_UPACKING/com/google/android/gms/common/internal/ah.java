package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah implements Callback {
    final ArrayList f4384a;
    private final ai f4385b;
    private final ArrayList f4386c;
    private final ArrayList f4387d;
    private volatile boolean f4388e;
    private final AtomicInteger f4389f;
    private boolean f4390g;
    private final Handler f4391h;
    private final Object f4392i;

    public ah(Looper looper, ai aiVar) {
        this.f4386c = new ArrayList();
        this.f4384a = new ArrayList();
        this.f4387d = new ArrayList();
        this.f4388e = false;
        this.f4389f = new AtomicInteger(0);
        this.f4390g = false;
        this.f4392i = new Object();
        this.f4385b = aiVar;
        this.f4391h = new Handler(looper, this);
    }

    public void m7729a() {
        this.f4388e = false;
        this.f4389f.incrementAndGet();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7730a(int r6) {
        /*
        r5 = this;
        r0 = 0;
        r1 = 1;
        r2 = android.os.Looper.myLooper();
        r3 = r5.f4391h;
        r3 = r3.getLooper();
        if (r2 != r3) goto L_0x000f;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r2 = "onUnintentionalDisconnection must only be called on the Handler thread";
        com.google.android.gms.common.internal.bf.m7878a(r0, r2);
        r0 = r5.f4391h;
        r0.removeMessages(r1);
        r1 = r5.f4392i;
        monitor-enter(r1);
        r0 = 1;
        r5.f4390g = r0;	 Catch:{ all -> 0x005e }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x005e }
        r2 = r5.f4386c;	 Catch:{ all -> 0x005e }
        r0.<init>(r2);	 Catch:{ all -> 0x005e }
        r2 = r5.f4389f;	 Catch:{ all -> 0x005e }
        r2 = r2.get();	 Catch:{ all -> 0x005e }
        r3 = r0.iterator();	 Catch:{ all -> 0x005e }
    L_0x0030:
        r0 = r3.hasNext();	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x0048;
    L_0x0036:
        r0 = r3.next();	 Catch:{ all -> 0x005e }
        r0 = (com.google.android.gms.common.api.C0229q) r0;	 Catch:{ all -> 0x005e }
        r4 = r5.f4388e;	 Catch:{ all -> 0x005e }
        if (r4 == 0) goto L_0x0048;
    L_0x0040:
        r4 = r5.f4389f;	 Catch:{ all -> 0x005e }
        r4 = r4.get();	 Catch:{ all -> 0x005e }
        if (r4 == r2) goto L_0x0052;
    L_0x0048:
        r0 = r5.f4384a;	 Catch:{ all -> 0x005e }
        r0.clear();	 Catch:{ all -> 0x005e }
        r0 = 0;
        r5.f4390g = r0;	 Catch:{ all -> 0x005e }
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        return;
    L_0x0052:
        r4 = r5.f4386c;	 Catch:{ all -> 0x005e }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x005e }
        if (r4 == 0) goto L_0x0030;
    L_0x005a:
        r0.m7342a(r6);	 Catch:{ all -> 0x005e }
        goto L_0x0030;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.ah.a(int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7731a(android.os.Bundle r6) {
        /*
        r5 = this;
        r2 = 0;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r3 = r5.f4391h;
        r3 = r3.getLooper();
        if (r0 != r3) goto L_0x006e;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r3 = "onConnectionSuccess must only be called on the Handler thread";
        com.google.android.gms.common.internal.bf.m7878a(r0, r3);
        r3 = r5.f4392i;
        monitor-enter(r3);
        r0 = r5.f4390g;	 Catch:{ all -> 0x0080 }
        if (r0 != 0) goto L_0x0070;
    L_0x001b:
        r0 = r1;
    L_0x001c:
        com.google.android.gms.common.internal.bf.m7877a(r0);	 Catch:{ all -> 0x0080 }
        r0 = r5.f4391h;	 Catch:{ all -> 0x0080 }
        r4 = 1;
        r0.removeMessages(r4);	 Catch:{ all -> 0x0080 }
        r0 = 1;
        r5.f4390g = r0;	 Catch:{ all -> 0x0080 }
        r0 = r5.f4384a;	 Catch:{ all -> 0x0080 }
        r0 = r0.size();	 Catch:{ all -> 0x0080 }
        if (r0 != 0) goto L_0x0072;
    L_0x0030:
        com.google.android.gms.common.internal.bf.m7877a(r1);	 Catch:{ all -> 0x0080 }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0080 }
        r1 = r5.f4386c;	 Catch:{ all -> 0x0080 }
        r0.<init>(r1);	 Catch:{ all -> 0x0080 }
        r1 = r5.f4389f;	 Catch:{ all -> 0x0080 }
        r1 = r1.get();	 Catch:{ all -> 0x0080 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0080 }
    L_0x0044:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x0064;
    L_0x004a:
        r0 = r2.next();	 Catch:{ all -> 0x0080 }
        r0 = (com.google.android.gms.common.api.C0229q) r0;	 Catch:{ all -> 0x0080 }
        r4 = r5.f4388e;	 Catch:{ all -> 0x0080 }
        if (r4 == 0) goto L_0x0064;
    L_0x0054:
        r4 = r5.f4385b;	 Catch:{ all -> 0x0080 }
        r4 = r4.m5726h();	 Catch:{ all -> 0x0080 }
        if (r4 == 0) goto L_0x0064;
    L_0x005c:
        r4 = r5.f4389f;	 Catch:{ all -> 0x0080 }
        r4 = r4.get();	 Catch:{ all -> 0x0080 }
        if (r4 == r1) goto L_0x0074;
    L_0x0064:
        r0 = r5.f4384a;	 Catch:{ all -> 0x0080 }
        r0.clear();	 Catch:{ all -> 0x0080 }
        r0 = 0;
        r5.f4390g = r0;	 Catch:{ all -> 0x0080 }
        monitor-exit(r3);	 Catch:{ all -> 0x0080 }
        return;
    L_0x006e:
        r0 = r2;
        goto L_0x000f;
    L_0x0070:
        r0 = r2;
        goto L_0x001c;
    L_0x0072:
        r1 = r2;
        goto L_0x0030;
    L_0x0074:
        r4 = r5.f4384a;	 Catch:{ all -> 0x0080 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0080 }
        if (r4 != 0) goto L_0x0044;
    L_0x007c:
        r0.m7343a(r6);	 Catch:{ all -> 0x0080 }
        goto L_0x0044;
    L_0x0080:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0080 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.ah.a(android.os.Bundle):void");
    }

    public void m7732a(ConnectionResult connectionResult) {
        bf.m7878a(Looper.myLooper() == this.f4391h.getLooper(), (Object) "onConnectionFailure must only be called on the Handler thread");
        this.f4391h.removeMessages(1);
        synchronized (this.f4392i) {
            ArrayList arrayList = new ArrayList(this.f4387d);
            int i = this.f4389f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0230r c0230r = (C0230r) it.next();
                if (!this.f4388e || this.f4389f.get() != i) {
                    return;
                } else if (this.f4387d.contains(c0230r)) {
                    c0230r.m7346a(connectionResult);
                }
            }
        }
    }

    public void m7733a(C0229q c0229q) {
        bf.m7873a((Object) c0229q);
        synchronized (this.f4392i) {
            if (this.f4386c.contains(c0229q)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + c0229q + " is already registered");
            } else {
                this.f4386c.add(c0229q);
            }
        }
        if (this.f4385b.m5726h()) {
            this.f4391h.sendMessage(this.f4391h.obtainMessage(1, c0229q));
        }
    }

    public void m7734a(C0230r c0230r) {
        bf.m7873a((Object) c0230r);
        synchronized (this.f4392i) {
            if (this.f4387d.contains(c0230r)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + c0230r + " is already registered");
            } else {
                this.f4387d.add(c0230r);
            }
        }
    }

    public void m7735b() {
        this.f4388e = true;
    }

    public void m7736b(C0230r c0230r) {
        bf.m7873a((Object) c0230r);
        synchronized (this.f4392i) {
            if (!this.f4387d.remove(c0230r)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + c0230r + " not found");
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            C0229q c0229q = (C0229q) message.obj;
            synchronized (this.f4392i) {
                if (this.f4388e && this.f4385b.m5726h() && this.f4386c.contains(c0229q)) {
                    c0229q.m7343a(this.f4385b.b_());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
