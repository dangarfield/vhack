package android.support.v7.widget;

import android.support.v4.p014g.Pools;

/* compiled from: ViewInfoStore */
class gn {
    static Pools f2334d;
    int f2335a;
    ef f2336b;
    ef f2337c;

    static {
        f2334d = new Pools(20);
    }

    private gn() {
    }

    static gn m4744a() {
        gn gnVar = (gn) f2334d.m1523a();
        return gnVar == null ? new gn() : gnVar;
    }

    static void m4745a(gn gnVar) {
        gnVar.f2335a = 0;
        gnVar.f2336b = null;
        gnVar.f2337c = null;
        f2334d.m1524a(gnVar);
    }

    static void m4746b() {
        do {
        } while (f2334d.m1523a() != null);
    }
}
