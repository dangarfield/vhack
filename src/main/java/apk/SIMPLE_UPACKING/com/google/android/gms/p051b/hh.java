package com.google.android.gms.p051b;

import java.util.Map;

/* renamed from: com.google.android.gms.b.hh */
class hh implements ce {
    final /* synthetic */ hc f3761a;

    private hh(hc hcVar) {
        this.f3761a = hcVar;
    }

    public void m6699a(hb hbVar, Map map) {
        if (map.keySet().contains("start")) {
            this.f3761a.m6673g();
        } else if (map.keySet().contains("stop")) {
            this.f3761a.m6674h();
        } else if (map.keySet().contains("cancel")) {
            this.f3761a.m6675i();
        }
    }
}
