package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.bp */
public final class bp implements ce {
    private final bq f3484a;

    public bp(bq bqVar) {
        this.f3484a = bqVar;
    }

    public void m6166a(hb hbVar, Map map) {
        String str = (String) map.get("name");
        if (str == null) {
            C0099b.m5643d("App event with no name parameter.");
        } else {
            this.f3484a.m6167a(str, (String) map.get("info"));
        }
    }
}
