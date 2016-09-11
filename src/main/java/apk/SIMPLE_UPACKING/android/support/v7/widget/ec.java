package android.support.v7.widget;

import java.util.ArrayList;
import java.util.List;

/* compiled from: RecyclerView */
public abstract class ec {
    private ee f2008a;
    private ArrayList f2009b;
    private long f2010c;
    private long f2011d;
    private long f2012e;
    private long f2013f;

    public abstract void m4148a();

    public abstract boolean m4150a(ey eyVar, ef efVar, ef efVar2);

    public abstract boolean m4151a(ey eyVar, ey eyVar2, ef efVar, ef efVar2);

    public abstract boolean m4153b();

    public abstract boolean m4154b(ey eyVar, ef efVar, ef efVar2);

    public abstract void m4155c();

    public abstract void m4156c(ey eyVar);

    public abstract boolean m4157c(ey eyVar, ef efVar, ef efVar2);

    public ec() {
        this.f2008a = null;
        this.f2009b = new ArrayList();
        this.f2010c = 120;
        this.f2011d = 120;
        this.f2012e = 250;
        this.f2013f = 250;
    }

    public long m4158d() {
        return this.f2012e;
    }

    public long m4159e() {
        return this.f2010c;
    }

    public long m4161f() {
        return this.f2011d;
    }

    public long m4163g() {
        return this.f2013f;
    }

    void m4149a(ee eeVar) {
        this.f2008a = eeVar;
    }

    public ef m4147a(ev evVar, ey eyVar, int i, List list) {
        return m4166i().m4386a(eyVar);
    }

    public ef m4146a(ev evVar, ey eyVar) {
        return m4166i().m4386a(eyVar);
    }

    static int m4145d(ey eyVar) {
        int f = eyVar.f2206l & 14;
        if (eyVar.m4534n()) {
            return 4;
        }
        if ((f & 4) != 0) {
            return f;
        }
        int f2 = eyVar.m4526f();
        int e = eyVar.m4525e();
        if (f2 == -1 || e == -1 || f2 == e) {
            return f;
        }
        return f | 2048;
    }

    public final void m4160e(ey eyVar) {
        m4162f(eyVar);
        if (this.f2008a != null) {
            this.f2008a.m4385a(eyVar);
        }
    }

    public void m4162f(ey eyVar) {
    }

    public boolean m4164g(ey eyVar) {
        return true;
    }

    public boolean m4152a(ey eyVar, List list) {
        return m4164g(eyVar);
    }

    public final void m4165h() {
        int size = this.f2009b.size();
        for (int i = 0; i < size; i++) {
            ((ed) this.f2009b.get(i)).m4384a();
        }
        this.f2009b.clear();
    }

    public ef m4166i() {
        return new ef();
    }
}
