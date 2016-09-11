package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DefaultItemAnimator */
class ca implements Runnable {
    final /* synthetic */ ArrayList f2027a;
    final /* synthetic */ bz f2028b;

    ca(bz bzVar, ArrayList arrayList) {
        this.f2028b = bzVar;
        this.f2027a = arrayList;
    }

    public void run() {
        Iterator it = this.f2027a.iterator();
        while (it.hasNext()) {
            cj cjVar = (cj) it.next();
            this.f2028b.m4201b(cjVar.f2057a, cjVar.f2058b, cjVar.f2059c, cjVar.f2060d, cjVar.f2061e);
        }
        this.f2027a.clear();
        this.f2028b.f2020g.remove(this.f2027a);
    }
}
