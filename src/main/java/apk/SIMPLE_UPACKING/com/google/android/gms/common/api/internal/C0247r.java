package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0121h;
import com.google.android.gms.common.api.C0244s;
import java.util.Map;

/* renamed from: com.google.android.gms.common.api.internal.r */
class C0247r extends C0246x {
    final /* synthetic */ C0242o f4262a;
    private final Map f4263c;

    public C0247r(C0242o c0242o, Map map) {
        this.f4262a = c0242o;
        super(null);
        this.f4263c = map;
    }

    public void m7523a() {
        int a = this.f4262a.f4239d.m7638a(this.f4262a.f4238c);
        if (a != 0) {
            this.f4262a.f4236a.m7378a(new C0248s(this, this.f4262a, new ConnectionResult(a, null)));
            return;
        }
        if (this.f4262a.f4248m) {
            this.f4262a.f4246k.m7067k();
        }
        for (C0121h c0121h : this.f4263c.keySet()) {
            c0121h.m5717a((C0244s) this.f4263c.get(c0121h));
        }
    }
}
