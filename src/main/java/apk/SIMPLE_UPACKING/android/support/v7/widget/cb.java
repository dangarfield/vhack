package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DefaultItemAnimator */
class cb implements Runnable {
    final /* synthetic */ ArrayList f2029a;
    final /* synthetic */ bz f2030b;

    cb(bz bzVar, ArrayList arrayList) {
        this.f2030b = bzVar;
        this.f2029a = arrayList;
    }

    public void run() {
        Iterator it = this.f2029a.iterator();
        while (it.hasNext()) {
            this.f2030b.m4196a((ci) it.next());
        }
        this.f2029a.clear();
        this.f2030b.f2021h.remove(this.f2029a);
    }
}
