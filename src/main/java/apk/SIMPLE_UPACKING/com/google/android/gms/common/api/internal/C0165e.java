package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.C0164t;
import com.google.android.gms.common.api.C0198v;
import com.google.android.gms.common.api.C0224w;
import com.google.android.gms.common.api.C0231x;
import com.google.android.gms.common.api.C0257n;
import com.google.android.gms.common.api.C0265u;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.as;
import com.google.android.gms.common.internal.bf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.common.api.internal.e */
public abstract class C0165e extends C0164t {
    private final Object f3322a;
    private final WeakReference f3323b;
    protected final C0233f f3324c;
    private final CountDownLatch f3325d;
    private final ArrayList f3326e;
    private C0231x f3327f;
    private volatile C0224w f3328g;
    private volatile boolean f3329h;
    private boolean f3330i;
    private boolean f3331j;
    private boolean f3332k;
    private as f3333l;
    private Integer f3334m;
    private volatile ba f3335n;

    protected C0165e(C0257n c0257n) {
        this.f3322a = new Object();
        this.f3325d = new CountDownLatch(1);
        this.f3326e = new ArrayList();
        this.f3324c = new C0233f(c0257n != null ? c0257n.m7561c() : Looper.getMainLooper());
        this.f3323b = new WeakReference(c0257n);
    }

    public static void m5972b(C0224w c0224w) {
        if (c0224w instanceof C0198v) {
            try {
                ((C0198v) c0224w).m6249a();
            } catch (Throwable e) {
                Log.w("BasePendingResult", "Unable to release " + c0224w, e);
            }
        }
    }

    private void m5973c(C0224w c0224w) {
        this.f3328g = c0224w;
        this.f3333l = null;
        this.f3325d.countDown();
        Status a = this.f3328g.m7286a();
        if (this.f3327f != null) {
            this.f3324c.m7422a();
            if (!this.f3330i) {
                this.f3324c.m7423a(this.f3327f, m5974i());
            }
        }
        Iterator it = this.f3326e.iterator();
        while (it.hasNext()) {
            ((C0265u) it.next()).m7631a(a);
        }
        this.f3326e.clear();
    }

    private C0224w m5974i() {
        C0224w c0224w;
        boolean z = true;
        synchronized (this.f3322a) {
            if (this.f3329h) {
                z = false;
            }
            bf.m7878a(z, (Object) "Result has already been consumed.");
            bf.m7878a(m5981e(), (Object) "Result is not ready.");
            c0224w = this.f3328g;
            this.f3328g = null;
            this.f3327f = null;
            this.f3329h = true;
        }
        m5979d();
        return c0224w;
    }

    public Integer m5975a() {
        return this.f3334m;
    }

    public final void m5976a(C0224w c0224w) {
        boolean z = true;
        synchronized (this.f3322a) {
            if (this.f3331j || this.f3330i) {
                C0165e.m5972b(c0224w);
                return;
            }
            bf.m7878a(!m5981e(), (Object) "Results have already been set");
            if (this.f3329h) {
                z = false;
            }
            bf.m7878a(z, (Object) "Result has already been consumed");
            m5973c(c0224w);
        }
    }

    public final void m5977a(C0231x c0231x) {
        boolean z = true;
        bf.m7878a(!this.f3329h, (Object) "Result has already been consumed.");
        synchronized (this.f3322a) {
            if (this.f3335n != null) {
                z = false;
            }
            bf.m7878a(z, (Object) "Cannot set callbacks if then() has been called.");
            if (m5984h()) {
            } else if (!this.f3332k || (((C0257n) this.f3323b.get()) != null && (c0231x instanceof ba))) {
                if (m5981e()) {
                    this.f3324c.m7423a(c0231x, m5974i());
                } else {
                    this.f3327f = c0231x;
                }
            } else {
                m5982f();
            }
        }
    }

    protected abstract C0224w m5978b(Status status);

    protected void m5979d() {
    }

    public final void m5980d(Status status) {
        synchronized (this.f3322a) {
            if (!m5981e()) {
                m5976a(m5978b(status));
                this.f3331j = true;
            }
        }
    }

    public final boolean m5981e() {
        return this.f3325d.getCount() == 0;
    }

    public void m5982f() {
        synchronized (this.f3322a) {
            if (this.f3330i || this.f3329h) {
                return;
            }
            if (this.f3333l != null) {
                try {
                    this.f3333l.m7768a();
                } catch (RemoteException e) {
                }
            }
            C0165e.m5972b(this.f3328g);
            this.f3327f = null;
            this.f3330i = true;
            m5973c(m5978b(Status.f4135e));
        }
    }

    public void m5983g() {
        synchronized (this.f3322a) {
            if (((C0257n) this.f3323b.get()) == null) {
                m5982f();
                return;
            }
            if (this.f3327f == null || (this.f3327f instanceof ba)) {
                this.f3332k = true;
            } else {
                m5982f();
            }
        }
    }

    public boolean m5984h() {
        boolean z;
        synchronized (this.f3322a) {
            z = this.f3330i;
        }
        return z;
    }
}
