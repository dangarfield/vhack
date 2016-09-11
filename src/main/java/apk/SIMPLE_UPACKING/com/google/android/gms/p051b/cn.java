package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.C0056g;

@fi
/* renamed from: com.google.android.gms.b.cn */
public class cn extends fn {
    final hb f3527a;
    final cq f3528b;
    private final String f3529c;

    cn(hb hbVar, cq cqVar, String str) {
        this.f3527a = hbVar;
        this.f3528b = cqVar;
        this.f3529c = str;
        C0056g.m5447k().m6245a(this);
    }

    public void m6243a() {
        try {
            this.f3528b.m6251a(this.f3529c);
        } finally {
            fx.f3679a.post(new co(this));
        }
    }
}
