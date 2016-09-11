package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0098a;
import java.util.ArrayList;
import java.util.List;

@fi
/* renamed from: com.google.android.gms.b.gz */
class gz {
    private final Object f3726a;
    private final List f3727b;
    private final List f3728c;
    private boolean f3729d;

    public gz() {
        this.f3726a = new Object();
        this.f3727b = new ArrayList();
        this.f3728c = new ArrayList();
        this.f3729d = false;
    }

    private void m6618b(Runnable runnable) {
        fr.m6507a(runnable);
    }

    private void m6619c(Runnable runnable) {
        C0098a.f3096a.post(runnable);
    }

    public void m6620a() {
        synchronized (this.f3726a) {
            if (this.f3729d) {
                return;
            }
            for (Runnable b : this.f3727b) {
                m6618b(b);
            }
            for (Runnable b2 : this.f3728c) {
                m6619c(b2);
            }
            this.f3727b.clear();
            this.f3728c.clear();
            this.f3729d = true;
        }
    }

    public void m6621a(Runnable runnable) {
        synchronized (this.f3726a) {
            if (this.f3729d) {
                m6619c(runnable);
            } else {
                this.f3728c.add(runnable);
            }
        }
    }
}
