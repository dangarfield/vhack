package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.ln;
import com.google.android.gms.p051b.lq;
import java.util.ArrayList;
import java.util.List;

class cb implements am {
    lq f4876a;
    List f4877b;
    List f4878c;
    long f4879d;
    final /* synthetic */ bx f4880e;

    private cb(bx bxVar) {
        this.f4880e = bxVar;
    }

    private long m8809a(ln lnVar) {
        return ((lnVar.f3939c.longValue() / 1000) / 60) / 60;
    }

    public void m8810a(lq lqVar) {
        bf.m7873a((Object) lqVar);
        this.f4876a = lqVar;
    }

    boolean m8811a() {
        return this.f4878c == null || this.f4878c.isEmpty();
    }

    public boolean m8812a(long j, ln lnVar) {
        bf.m7873a((Object) lnVar);
        if (this.f4878c == null) {
            this.f4878c = new ArrayList();
        }
        if (this.f4877b == null) {
            this.f4877b = new ArrayList();
        }
        if (this.f4878c.size() > 0 && m8809a((ln) this.f4878c.get(0)) != m8809a(lnVar)) {
            return false;
        }
        long e = this.f4879d + ((long) lnVar.m6966e());
        if (e >= ((long) this.f4880e.m8765d().m8338T())) {
            return false;
        }
        this.f4879d = e;
        this.f4878c.add(lnVar);
        this.f4877b.add(Long.valueOf(j));
        return this.f4878c.size() < this.f4880e.m8765d().m8339U();
    }
}
