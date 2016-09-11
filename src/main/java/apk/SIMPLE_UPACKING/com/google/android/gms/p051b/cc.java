package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.C0025b;
import com.google.android.gms.ads.internal.overlay.C0060c;
import com.google.android.gms.ads.internal.overlay.C0075r;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.b.cc */
final class cc implements ce {
    cc() {
    }

    private void m6220a(hb hbVar) {
        C0099b.m5641c("Received support message, responding.");
        boolean z = false;
        C0025b g = hbVar.m6648g();
        if (g != null) {
            C0075r c0075r = g.f2887c;
            if (c0075r != null) {
                z = c0075r.m5551a();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", "checkSupport");
            jSONObject.put("supports", z);
            hbVar.m6261a("appStreaming", jSONObject);
        } catch (Throwable th) {
        }
    }

    public void m6221a(hb hbVar, Map map) {
        if ("checkSupport".equals(map.get("action"))) {
            m6220a(hbVar);
            return;
        }
        C0060c h = hbVar.m6649h();
        if (h != null) {
            h.m5480a(hbVar, map);
        }
    }
}
