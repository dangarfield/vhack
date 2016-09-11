package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.overlay.C0060c;

/* renamed from: com.google.android.gms.b.hd */
class hd implements Runnable {
    final /* synthetic */ hc f3758a;

    hd(hc hcVar) {
        this.f3758a = hcVar;
    }

    public void run() {
        this.f3758a.f3736a.m6663v();
        C0060c h = this.f3758a.f3736a.m6649h();
        if (h != null) {
            h.m5497m();
        }
        if (this.f3758a.f3743j != null) {
            this.f3758a.f3743j.m6694a();
            this.f3758a.f3743j = null;
        }
    }
}
