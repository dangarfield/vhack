package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.dx */
public class dx {
    private final hb f3578a;
    private final boolean f3579b;
    private final String f3580c;

    public dx(hb hbVar, Map map) {
        this.f3578a = hbVar;
        this.f3580c = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.f3579b = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.f3579b = true;
        }
    }

    public void m6405a() {
        if (this.f3578a == null) {
            C0099b.m5643d("AdWebView is null");
            return;
        }
        int b = "portrait".equalsIgnoreCase(this.f3580c) ? C0056g.m5441e().m6569b() : "landscape".equalsIgnoreCase(this.f3580c) ? C0056g.m5441e().m6556a() : this.f3579b ? -1 : C0056g.m5441e().m6572c();
        this.f3578a.m6640b(b);
    }
}
