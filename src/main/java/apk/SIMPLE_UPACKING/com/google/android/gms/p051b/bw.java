package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;

/* renamed from: com.google.android.gms.b.bw */
final class bw implements ce {
    bw() {
    }

    public void m6176a(hb hbVar, Map map) {
        String str = (String) map.get("ty");
        String str2 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt((String) map.get("tx"));
            int parseInt2 = Integer.parseInt(str);
            int parseInt3 = Integer.parseInt(str2);
            C0202f m = hbVar.m6654m();
            if (m != null) {
                m.m6478a().m6412a(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException e) {
            C0099b.m5643d("Could not parse touch parameters from gmsg.");
        }
    }
}
