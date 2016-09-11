package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.kf;

class ac {
    private final kf f4651a;
    private long f4652b;

    public ac(kf kfVar) {
        bf.m7873a((Object) kfVar);
        this.f4651a = kfVar;
    }

    public void m8202a() {
        this.f4652b = this.f4651a.m6914b();
    }

    public boolean m8203a(long j) {
        return this.f4652b == 0 || this.f4651a.m6914b() - this.f4652b >= j;
    }

    public void m8204b() {
        this.f4652b = 0;
    }
}
