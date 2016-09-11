package com.google.android.gms.measurement.internal;

class bd implements Runnable {
    final /* synthetic */ String f4762a;
    final /* synthetic */ bc f4763b;

    bd(bc bcVar, String str) {
        this.f4763b = bcVar;
        this.f4762a = str;
    }

    public void run() {
        bn e = this.f4763b.n.m8766e();
        if (!e.m8223E() || e.m8224F()) {
            this.f4763b.m8578a(6, "Persisted config not initialized . Not logging error/warn.");
        } else {
            e.f4795b.m8669a(this.f4762a);
        }
    }
}
