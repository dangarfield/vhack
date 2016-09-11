package android.support.v7.widget;

import android.support.v4.p005e.TraceCompat;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: RecyclerView */
public abstract class dy {
    private final dz f2136a;
    private boolean f2137b;

    public abstract int m4366a();

    public abstract ey m4368a(ViewGroup viewGroup, int i);

    public abstract void m4372a(ey eyVar, int i);

    public void m4373a(ey eyVar, int i, List list) {
        m4372a(eyVar, i);
    }

    public final ey m4375b(ViewGroup viewGroup, int i) {
        TraceCompat.m1435a("RV CreateView");
        ey a = m4368a(viewGroup, i);
        a.f2199e = i;
        TraceCompat.m1434a();
        return a;
    }

    public final void m4378b(ey eyVar, int i) {
        eyVar.f2196b = i;
        if (m4379b()) {
            eyVar.f2198d = m4374b(i);
        }
        eyVar.m4514a(1, 519);
        TraceCompat.m1435a("RV OnBindView");
        m4373a(eyVar, i, eyVar.m4541u());
        eyVar.m4540t();
        TraceCompat.m1434a();
    }

    public int m4367a(int i) {
        return 0;
    }

    public long m4374b(int i) {
        return -1;
    }

    public final boolean m4379b() {
        return this.f2137b;
    }

    public void m4371a(ey eyVar) {
    }

    public boolean m4380b(ey eyVar) {
        return false;
    }

    public void m4381c(ey eyVar) {
    }

    public void m4382d(ey eyVar) {
    }

    public void m4370a(ea eaVar) {
        this.f2136a.registerObserver(eaVar);
    }

    public void m4377b(ea eaVar) {
        this.f2136a.unregisterObserver(eaVar);
    }

    public void m4369a(RecyclerView recyclerView) {
    }

    public void m4376b(RecyclerView recyclerView) {
    }
}
