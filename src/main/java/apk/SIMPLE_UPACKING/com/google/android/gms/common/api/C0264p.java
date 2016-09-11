package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.ax;

/* renamed from: com.google.android.gms.common.api.p */
class C0264p implements Runnable {
    final /* synthetic */ C0257n f4319a;
    final /* synthetic */ C0263o f4320b;

    C0264p(C0263o c0263o, C0257n c0257n) {
        this.f4320b = c0263o;
        this.f4319a = c0257n;
    }

    public void run() {
        if (!this.f4320b.f4311k.isFinishing() && !this.f4320b.f4311k.m1226f().m817e()) {
            this.f4320b.m7620a(ax.m7314b(this.f4320b.f4311k), this.f4319a);
        }
    }
}
