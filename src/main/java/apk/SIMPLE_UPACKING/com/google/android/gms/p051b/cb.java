package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.overlay.C0060c;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;

/* renamed from: com.google.android.gms.b.cb */
final class cb implements ce {
    cb() {
    }

    public void m6219a(hb hbVar, Map map) {
        C0060c h = hbVar.m6649h();
        if (h != null) {
            h.m5476a();
            return;
        }
        h = hbVar.m6650i();
        if (h != null) {
            h.m5476a();
        } else {
            C0099b.m5643d("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
