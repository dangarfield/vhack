package com.google.android.gms.p051b;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

@fi
/* renamed from: com.google.android.gms.b.ao */
public class ao {
    BlockingQueue f3451a;
    Map f3452b;

    public ar m6109a(String str) {
        ar arVar = (ar) this.f3452b.get(str);
        return arVar != null ? arVar : ar.f3453a;
    }

    public boolean m6110a(az azVar) {
        return this.f3451a.offer(azVar);
    }
}
