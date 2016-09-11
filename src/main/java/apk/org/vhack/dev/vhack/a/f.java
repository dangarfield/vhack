package org.vhack.dev.vhack.a;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IabHelper */
class f implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ i b;
    final /* synthetic */ Handler c;
    final /* synthetic */ j d;
    final /* synthetic */ d e;

    f(d dVar, List list, i iVar, Handler handler, j jVar) {
        this.e = dVar;
        this.a = list;
        this.b = iVar;
        this.c = handler;
        this.d = jVar;
    }

    public void run() {
        List arrayList = new ArrayList();
        for (o oVar : this.a) {
            try {
                this.e.a(oVar);
                arrayList.add(new n(0, "Successful consume of sku " + oVar.a()));
            } catch (c e) {
                arrayList.add(e.a());
            }
        }
        this.e.b();
        if (!(this.e.d || this.b == null)) {
            this.c.post(new g(this, arrayList));
        }
        if (!this.e.d && this.d != null) {
            this.c.post(new h(this, arrayList));
        }
    }
}
