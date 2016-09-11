package android.support.v7.widget;

/* compiled from: RecyclerView */
class dv implements go {
    final /* synthetic */ RecyclerView f2133a;

    dv(RecyclerView recyclerView) {
        this.f2133a = recyclerView;
    }

    public void m4343a(ey eyVar, ef efVar, ef efVar2) {
        this.f2133a.f142a.m4437d(eyVar);
        this.f2133a.m134b(eyVar, efVar, efVar2);
    }

    public void m4344b(ey eyVar, ef efVar, ef efVar2) {
        this.f2133a.m121a(eyVar, efVar, efVar2);
    }

    public void m4345c(ey eyVar, ef efVar, ef efVar2) {
        eyVar.m4519a(false);
        if (this.f2133a.f126H) {
            if (this.f2133a.f147f.m4151a(eyVar, eyVar, efVar, efVar2)) {
                this.f2133a.m102C();
            }
        } else if (this.f2133a.f147f.m4157c(eyVar, efVar, efVar2)) {
            this.f2133a.m102C();
        }
    }

    public void m4342a(ey eyVar) {
        this.f2133a.f146e.m3527a(eyVar.f2195a, this.f2133a.f142a);
    }
}
