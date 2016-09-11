package android.support.v7.widget;

import android.support.v4.p014g.ArrayMap;
import android.support.v4.p014g.LongSparseArray;

/* compiled from: ViewInfoStore */
class gm {
    final ArrayMap f2332a;
    final LongSparseArray f2333b;

    gm() {
        this.f2332a = new ArrayMap();
        this.f2333b = new LongSparseArray();
    }

    void m4729a() {
        this.f2332a.clear();
        this.f2333b.m1513c();
    }

    void m4731a(ey eyVar, ef efVar) {
        gn gnVar = (gn) this.f2332a.get(eyVar);
        if (gnVar == null) {
            gnVar = gn.m4744a();
            this.f2332a.put(eyVar, gnVar);
        }
        gnVar.f2336b = efVar;
        gnVar.f2335a |= 4;
    }

    boolean m4733a(ey eyVar) {
        gn gnVar = (gn) this.f2332a.get(eyVar);
        return (gnVar == null || (gnVar.f2335a & 1) == 0) ? false : true;
    }

    ef m4734b(ey eyVar) {
        return m4727a(eyVar, 4);
    }

    ef m4737c(ey eyVar) {
        return m4727a(eyVar, 8);
    }

    private ef m4727a(ey eyVar, int i) {
        ef efVar = null;
        int a = this.f2332a.m1457a((Object) eyVar);
        if (a >= 0) {
            gn gnVar = (gn) this.f2332a.m1464c(a);
            if (!(gnVar == null || (gnVar.f2335a & i) == 0)) {
                gnVar.f2335a &= i ^ -1;
                if (i == 4) {
                    efVar = gnVar.f2336b;
                } else if (i == 8) {
                    efVar = gnVar.f2337c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((gnVar.f2335a & 12) == 0) {
                    this.f2332a.m1465d(a);
                    gn.m4745a(gnVar);
                }
            }
        }
        return efVar;
    }

    void m4730a(long j, ey eyVar) {
        this.f2333b.m1511b(j, eyVar);
    }

    void m4736b(ey eyVar, ef efVar) {
        gn gnVar = (gn) this.f2332a.get(eyVar);
        if (gnVar == null) {
            gnVar = gn.m4744a();
            this.f2332a.put(eyVar, gnVar);
        }
        gnVar.f2335a |= 2;
        gnVar.f2336b = efVar;
    }

    boolean m4739d(ey eyVar) {
        gn gnVar = (gn) this.f2332a.get(eyVar);
        return (gnVar == null || (gnVar.f2335a & 4) == 0) ? false : true;
    }

    ey m4728a(long j) {
        return (ey) this.f2333b.m1505a(j);
    }

    void m4738c(ey eyVar, ef efVar) {
        gn gnVar = (gn) this.f2332a.get(eyVar);
        if (gnVar == null) {
            gnVar = gn.m4744a();
            this.f2332a.put(eyVar, gnVar);
        }
        gnVar.f2337c = efVar;
        gnVar.f2335a |= 8;
    }

    void m4740e(ey eyVar) {
        gn gnVar = (gn) this.f2332a.get(eyVar);
        if (gnVar == null) {
            gnVar = gn.m4744a();
            this.f2332a.put(eyVar, gnVar);
        }
        r0.f2335a |= 1;
    }

    void m4741f(ey eyVar) {
        gn gnVar = (gn) this.f2332a.get(eyVar);
        if (gnVar != null) {
            gnVar.f2335a &= -2;
        }
    }

    void m4732a(go goVar) {
        for (int size = this.f2332a.size() - 1; size >= 0; size--) {
            ey eyVar = (ey) this.f2332a.m1463b(size);
            gn gnVar = (gn) this.f2332a.m1465d(size);
            if ((gnVar.f2335a & 3) == 3) {
                goVar.m4338a(eyVar);
            } else if ((gnVar.f2335a & 1) != 0) {
                if (gnVar.f2336b == null) {
                    goVar.m4338a(eyVar);
                } else {
                    goVar.m4339a(eyVar, gnVar.f2336b, gnVar.f2337c);
                }
            } else if ((gnVar.f2335a & 14) == 14) {
                goVar.m4340b(eyVar, gnVar.f2336b, gnVar.f2337c);
            } else if ((gnVar.f2335a & 12) == 12) {
                goVar.m4341c(eyVar, gnVar.f2336b, gnVar.f2337c);
            } else if ((gnVar.f2335a & 4) != 0) {
                goVar.m4339a(eyVar, gnVar.f2336b, null);
            } else if ((gnVar.f2335a & 8) != 0) {
                goVar.m4340b(eyVar, gnVar.f2336b, gnVar.f2337c);
            } else if ((gnVar.f2335a & 2) != 0) {
            }
            gn.m4745a(gnVar);
        }
    }

    void m4742g(ey eyVar) {
        for (int b = this.f2333b.m1508b() - 1; b >= 0; b--) {
            if (eyVar == this.f2333b.m1512c(b)) {
                this.f2333b.m1507a(b);
                break;
            }
        }
        gn gnVar = (gn) this.f2332a.remove(eyVar);
        if (gnVar != null) {
            gn.m4745a(gnVar);
        }
    }

    void m4735b() {
        gn.m4746b();
    }

    public void m4743h(ey eyVar) {
        m4741f(eyVar);
    }
}
