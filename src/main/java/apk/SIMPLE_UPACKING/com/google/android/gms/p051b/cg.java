package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.cg */
public class cg implements ce {
    private final ch f3513a;

    public cg(ch chVar) {
        this.f3513a = chVar;
    }

    public void m6224a(hb hbVar, Map map) {
        float parseFloat;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                parseFloat = Float.parseFloat((String) map.get("blurRadius"));
                this.f3513a.m6225a(equals);
                this.f3513a.m6226a(equals2, parseFloat);
            }
        } catch (Throwable e) {
            C0099b.m5640b("Fail to parse float", e);
        }
        parseFloat = 0.0f;
        this.f3513a.m6225a(equals);
        this.f3513a.m6226a(equals2, parseFloat);
    }
}
