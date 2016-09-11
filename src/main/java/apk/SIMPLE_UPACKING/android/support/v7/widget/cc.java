package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DefaultItemAnimator */
class cc implements Runnable {
    final /* synthetic */ ArrayList f2031a;
    final /* synthetic */ bz f2032b;

    cc(bz bzVar, ArrayList arrayList) {
        this.f2032b = bzVar;
        this.f2031a = arrayList;
    }

    public void run() {
        Iterator it = this.f2031a.iterator();
        while (it.hasNext()) {
            this.f2032b.m4210u((ey) it.next());
        }
        this.f2031a.clear();
        this.f2032b.f2019f.remove(this.f2031a);
    }
}
