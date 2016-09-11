package com.google.android.gms.p051b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C0026c;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.cj */
public final class cj implements ce {
    private final cf f3517a;
    private final C0026c f3518b;
    private final dv f3519c;

    public cj(cf cfVar, C0026c c0026c, dv dvVar) {
        this.f3517a = cfVar;
        this.f3518b = c0026c;
        this.f3519c = dvVar;
    }

    private void m6228a(boolean z) {
        if (this.f3519c != null) {
            this.f3519c.m6399a(z);
        }
    }

    private static boolean m6229a(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int m6230b(Map map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return C0056g.m5441e().m6569b();
            }
            if ("l".equalsIgnoreCase(str)) {
                return C0056g.m5441e().m6556a();
            }
            if ("c".equalsIgnoreCase(str)) {
                return C0056g.m5441e().m6572c();
            }
        }
        return -1;
    }

    private static void m6231b(hb hbVar, Map map) {
        String str = (String) map.get("u");
        if (TextUtils.isEmpty(str)) {
            C0099b.m5643d("Destination url cannot be empty.");
        } else {
            new ck(hbVar, str).m5505b();
        }
    }

    private static void m6232c(hb hbVar, Map map) {
        Context context = hbVar.getContext();
        if (TextUtils.isEmpty((String) map.get("u"))) {
            C0099b.m5643d("Destination url cannot be empty.");
            return;
        }
        try {
            hbVar.m6652k().m6680a(new AdLauncherIntentInfoParcel(new cl(hbVar).m6236a(context, map)));
        } catch (ActivityNotFoundException e) {
            C0099b.m5643d(e.getMessage());
        }
    }

    public void m6233a(hb hbVar, Map map) {
        String str = (String) map.get("a");
        if (str == null) {
            C0099b.m5643d("Action missing from an open GMSG.");
        } else if (this.f3518b == null || this.f3518b.m5348a()) {
            hc k = hbVar.m6652k();
            if ("expand".equalsIgnoreCase(str)) {
                if (hbVar.m6656o()) {
                    C0099b.m5643d("Cannot expand WebView that is already expanded.");
                    return;
                }
                m6228a(false);
                k.m6686a(cj.m6229a(map), cj.m6230b(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                m6228a(false);
                if (str != null) {
                    k.m6687a(cj.m6229a(map), cj.m6230b(map), str);
                } else {
                    k.m6688a(cj.m6229a(map), cj.m6230b(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.f3517a == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.f3517a.m6223a(str, new ArrayList());
                } else {
                    this.f3517a.m6223a(str, new ArrayList(Arrays.asList(str2.split(" "))));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("play_store"))) {
                cj.m6231b(hbVar, map);
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                m6228a(true);
                cj.m6232c(hbVar, map);
            } else {
                m6228a(true);
                str = (String) map.get("u");
                k.m6680a(new AdLauncherIntentInfoParcel((String) map.get("i"), !TextUtils.isEmpty(str) ? C0056g.m5439c().m6527a(hbVar, str) : str, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.f3518b.m5347a((String) map.get("u"));
        }
    }
}
