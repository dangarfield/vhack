package com.google.android.gms.p051b;

import java.util.HashMap;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.ay */
public class ay {
    private final Map f3467a;
    private final az f3468b;

    public ay(az azVar) {
        this.f3468b = azVar;
        this.f3467a = new HashMap();
    }

    public az m6123a() {
        return this.f3468b;
    }

    public void m6124a(String str, av avVar) {
        this.f3467a.put(str, avVar);
    }

    public void m6125a(String str, String str2, long j) {
        aq.m6113a(this.f3468b, (av) this.f3467a.get(str2), j, str);
        this.f3467a.put(str, aq.m6112a(this.f3468b, j));
    }
}
