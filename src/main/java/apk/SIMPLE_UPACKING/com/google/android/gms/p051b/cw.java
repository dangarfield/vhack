package com.google.android.gms.p051b;

/* renamed from: com.google.android.gms.b.cw */
class cw implements Runnable {
    final /* synthetic */ cu f3537a;
    private final hy f3538b;
    private final jk f3539c;
    private final Runnable f3540d;

    public cw(cu cuVar, hy hyVar, jk jkVar, Runnable runnable) {
        this.f3537a = cuVar;
        this.f3538b = hyVar;
        this.f3539c = jkVar;
        this.f3540d = runnable;
    }

    public void run() {
        if (this.f3538b.m6200g()) {
            this.f3538b.m6196c("canceled-at-delivery");
            return;
        }
        if (this.f3539c.m6886a()) {
            this.f3538b.m6191a(this.f3539c.f3852a);
        } else {
            this.f3538b.m6193b(this.f3539c.f3854c);
        }
        if (this.f3539c.f3855d) {
            this.f3538b.m6194b("intermediate-response");
        } else {
            this.f3538b.m6196c("done");
        }
        if (this.f3540d != null) {
            this.f3540d.run();
        }
    }
}
