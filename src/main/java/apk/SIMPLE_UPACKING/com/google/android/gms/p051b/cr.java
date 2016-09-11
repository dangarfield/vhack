package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.common.internal.C0282d;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.cr */
public class cr implements ce {
    public void m6253a(hb hbVar, Map map) {
        cp k = C0056g.m5447k();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                C0099b.m5643d("Precache video action is missing the src parameter.");
                return;
            }
            int parseInt;
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            String str2 = map.containsKey("mimetype") ? (String) map.get("mimetype") : "";
            if (k.m6248b(hbVar)) {
                C0099b.m5643d("Precache task already running.");
                return;
            }
            C0282d.m7893a(hbVar.m6648g());
            new cn(hbVar, hbVar.m6648g().f2885a.m6254a(hbVar, parseInt, str2), str).m5505b();
        } else if (!k.m6246a(hbVar)) {
            C0099b.m5643d("Precache abort but no preload task running.");
        }
    }
}
