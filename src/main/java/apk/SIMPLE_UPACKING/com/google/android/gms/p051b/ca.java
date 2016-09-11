package com.google.android.gms.p051b;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;

/* renamed from: com.google.android.gms.b.ca */
final class ca implements ce {
    ca() {
    }

    public void m6218a(hb hbVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            C0099b.m5643d("URL missing from click GMSG.");
            return;
        }
        Uri a;
        Uri parse = Uri.parse(str);
        try {
            C0202f m = hbVar.m6654m();
            if (m != null && m.m6481b(parse)) {
                a = m.m6477a(parse, hbVar.getContext());
                new gt(hbVar.getContext(), hbVar.m6655n().f3092b, a.toString()).m5505b();
            }
        } catch (C0203g e) {
            C0099b.m5643d("Unable to append parameter to URL: " + str);
        }
        a = parse;
        new gt(hbVar.getContext(), hbVar.m6655n().f3092b, a.toString()).m5505b();
    }
}
