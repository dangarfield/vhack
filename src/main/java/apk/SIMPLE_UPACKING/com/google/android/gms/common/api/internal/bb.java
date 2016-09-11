package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C0224w;
import com.google.android.gms.common.api.C0257n;

class bb implements Runnable {
    final /* synthetic */ C0224w f4209a;
    final /* synthetic */ ba f4210b;

    bb(ba baVar, C0224w c0224w) {
        this.f4210b = baVar;
        this.f4209a = c0224w;
    }

    public void run() {
        C0257n c0257n;
        try {
            this.f4210b.f4208h.sendMessage(this.f4210b.f4208h.obtainMessage(0, this.f4210b.f4201a.m7635a(this.f4209a)));
            this.f4210b.m7414b(this.f4209a);
            c0257n = (C0257n) this.f4210b.f4207g.get();
            if (c0257n != null) {
                c0257n.m7559b(this.f4210b);
            }
        } catch (RuntimeException e) {
            this.f4210b.f4208h.sendMessage(this.f4210b.f4208h.obtainMessage(1, e));
            this.f4210b.m7414b(this.f4209a);
            c0257n = (C0257n) this.f4210b.f4207g.get();
            if (c0257n != null) {
                c0257n.m7559b(this.f4210b);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            this.f4210b.m7414b(this.f4209a);
            c0257n = (C0257n) this.f4210b.f4207g.get();
            if (c0257n != null) {
                c0257n.m7559b(this.f4210b);
            }
        }
    }
}
