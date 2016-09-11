package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.fx;

@fi
/* renamed from: com.google.android.gms.ads.internal.overlay.w */
class C0079w implements Runnable {
    private C0073p f3058a;
    private boolean f3059b;

    C0079w(C0073p c0073p) {
        this.f3059b = false;
        this.f3058a = c0073p;
    }

    public void m5559a() {
        this.f3059b = true;
        fx.f3679a.removeCallbacks(this);
    }

    public void m5560b() {
        fx.f3679a.postDelayed(this, 250);
    }

    public void run() {
        if (!this.f3059b) {
            this.f3058a.m5544h();
            m5560b();
        }
    }
}
