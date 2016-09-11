package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;

/* renamed from: com.google.android.gms.b.bu */
final class bu implements ce {
    bu() {
    }

    public void m6174a(hb hbVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            C0099b.m5643d("URL missing from httpTrack GMSG.");
        } else {
            new gt(hbVar.getContext(), hbVar.m6655n().f3092b, str).m5505b();
        }
    }
}
