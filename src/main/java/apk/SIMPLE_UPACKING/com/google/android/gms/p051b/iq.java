package com.google.android.gms.p051b;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.b.iq */
public class iq {
    private AtomicInteger f3819a;
    private final Map f3820b;
    private final Set f3821c;
    private final PriorityBlockingQueue f3822d;
    private final PriorityBlockingQueue f3823e;
    private final C0208k f3824f;
    private final di f3825g;
    private final kl f3826h;
    private ep[] f3827i;
    private aw f3828j;
    private List f3829k;

    public iq(C0208k c0208k, di diVar) {
        this(c0208k, diVar, 4);
    }

    public iq(C0208k c0208k, di diVar, int i) {
        this(c0208k, diVar, i, new cu(new Handler(Looper.getMainLooper())));
    }

    public iq(C0208k c0208k, di diVar, int i, kl klVar) {
        this.f3819a = new AtomicInteger();
        this.f3820b = new HashMap();
        this.f3821c = new HashSet();
        this.f3822d = new PriorityBlockingQueue();
        this.f3823e = new PriorityBlockingQueue();
        this.f3829k = new ArrayList();
        this.f3824f = c0208k;
        this.f3825g = diVar;
        this.f3827i = new ep[i];
        this.f3826h = klVar;
    }

    public hy m6820a(hy hyVar) {
        hyVar.m6185a(this);
        synchronized (this.f3821c) {
            this.f3821c.add(hyVar);
        }
        hyVar.m6184a(m6824c());
        hyVar.m6194b("add-to-queue");
        if (hyVar.m6209p()) {
            synchronized (this.f3820b) {
                String e = hyVar.m6198e();
                if (this.f3820b.containsKey(e)) {
                    Queue queue = (Queue) this.f3820b.get(e);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(hyVar);
                    this.f3820b.put(e, queue);
                    if (me.f4033b) {
                        me.m7096a("Request for cacheKey=%s is in flight, putting on hold.", e);
                    }
                } else {
                    this.f3820b.put(e, null);
                    this.f3822d.add(hyVar);
                }
            }
        } else {
            this.f3823e.add(hyVar);
        }
        return hyVar;
    }

    public void m6821a() {
        m6822b();
        this.f3828j = new aw(this.f3822d, this.f3823e, this.f3824f, this.f3826h);
        this.f3828j.start();
        for (int i = 0; i < this.f3827i.length; i++) {
            ep epVar = new ep(this.f3823e, this.f3825g, this.f3824f, this.f3826h);
            this.f3827i[i] = epVar;
            epVar.start();
        }
    }

    public void m6822b() {
        if (this.f3828j != null) {
            this.f3828j.m6122a();
        }
        for (int i = 0; i < this.f3827i.length; i++) {
            if (this.f3827i[i] != null) {
                this.f3827i[i].m6460a();
            }
        }
    }

    void m6823b(hy hyVar) {
        synchronized (this.f3821c) {
            this.f3821c.remove(hyVar);
        }
        synchronized (this.f3829k) {
            for (ir a : this.f3829k) {
                a.m6825a(hyVar);
            }
        }
        if (hyVar.m6209p()) {
            synchronized (this.f3820b) {
                Queue queue = (Queue) this.f3820b.remove(hyVar.m6198e());
                if (queue != null) {
                    if (me.f4033b) {
                        me.m7096a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f3822d.addAll(queue);
                }
            }
        }
    }

    public int m6824c() {
        return this.f3819a.incrementAndGet();
    }
}
