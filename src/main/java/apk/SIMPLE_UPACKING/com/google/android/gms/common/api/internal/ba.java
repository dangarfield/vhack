package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.C0164t;
import com.google.android.gms.common.api.C0198v;
import com.google.android.gms.common.api.C0224w;
import com.google.android.gms.common.api.C0231x;
import com.google.android.gms.common.api.C0257n;
import com.google.android.gms.common.api.C0266y;
import com.google.android.gms.common.api.C0267z;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.aa;
import com.google.android.gms.common.internal.bf;
import java.lang.ref.WeakReference;

public class ba extends aa implements C0231x {
    private C0267z f4201a;
    private ba f4202b;
    private C0266y f4203c;
    private C0164t f4204d;
    private final Object f4205e;
    private Status f4206f;
    private final WeakReference f4207g;
    private final bc f4208h;

    private void m7408a(Status status) {
        synchronized (this.f4205e) {
            this.f4206f = status;
            m7413b(this.f4206f);
        }
    }

    private void m7412b() {
        if (this.f4201a != null || this.f4203c != null) {
            C0257n c0257n = (C0257n) this.f4207g.get();
            if (!(this.f4201a == null || c0257n == null)) {
                c0257n.m7554a(this);
            }
            if (this.f4206f != null) {
                m7413b(this.f4206f);
            } else if (this.f4204d != null) {
                this.f4204d.m5971a(this);
            }
        }
    }

    private void m7413b(Status status) {
        synchronized (this.f4205e) {
            if (this.f4201a != null) {
                Status a = this.f4201a.m7634a(status);
                bf.m7874a((Object) a, (Object) "onFailure must not return null");
                this.f4202b.m7408a(a);
            } else if (m7416c()) {
                this.f4203c.m7632a(status);
            }
        }
    }

    private void m7414b(C0224w c0224w) {
        if (c0224w instanceof C0198v) {
            try {
                ((C0198v) c0224w).m6249a();
            } catch (Throwable e) {
                Log.w("TransformedResultImpl", "Unable to release " + c0224w, e);
            }
        }
    }

    private boolean m7416c() {
        return (this.f4203c == null || ((C0257n) this.f4207g.get()) == null) ? false : true;
    }

    void m7419a() {
        synchronized (this.f4205e) {
            this.f4203c = null;
        }
    }

    public void m7420a(C0164t c0164t) {
        synchronized (this.f4205e) {
            this.f4204d = c0164t;
            m7412b();
        }
    }

    public void m7421a(C0224w c0224w) {
        synchronized (this.f4205e) {
            if (!c0224w.m7286a().m7292e()) {
                m7408a(c0224w.m7286a());
                m7414b(c0224w);
            } else if (this.f4201a != null) {
                at.m7398a().submit(new bb(this, c0224w));
            } else if (m7416c()) {
                this.f4203c.m7633b(c0224w);
            }
        }
    }
}
