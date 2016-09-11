package android.support.v4.p002h;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

/* compiled from: ViewPropertyAnimatorCompat */
/* renamed from: android.support.v4.h.dk */
class dk implements ds {
    WeakHashMap f944a;

    dk() {
        this.f944a = null;
    }

    public void m2311a(di diVar, View view, long j) {
    }

    public void m2310a(di diVar, View view, float f) {
        m2308e(diVar, view);
    }

    public void m2316b(di diVar, View view, float f) {
        m2308e(diVar, view);
    }

    public void m2319c(di diVar, View view, float f) {
        m2308e(diVar, view);
    }

    public long m2309a(di diVar, View view) {
        return 0;
    }

    public void m2314a(di diVar, View view, Interpolator interpolator) {
    }

    public void m2317b(di diVar, View view, long j) {
    }

    public void m2315b(di diVar, View view) {
        m2308e(diVar, view);
    }

    public void m2318c(di diVar, View view) {
        m2306a(view);
        m2307d(diVar, view);
    }

    public void m2312a(di diVar, View view, dz dzVar) {
        view.setTag(2113929216, dzVar);
    }

    public void m2313a(di diVar, View view, eb ebVar) {
    }

    private void m2307d(di diVar, View view) {
        dz dzVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof dz) {
            dzVar = (dz) tag;
        } else {
            dzVar = null;
        }
        Runnable a = diVar.f941c;
        Runnable b = diVar.f942d;
        diVar.f941c = null;
        diVar.f942d = null;
        if (a != null) {
            a.run();
        }
        if (dzVar != null) {
            dzVar.m543a(view);
            dzVar.m544b(view);
        }
        if (b != null) {
            b.run();
        }
        if (this.f944a != null) {
            this.f944a.remove(view);
        }
    }

    private void m2306a(View view) {
        if (this.f944a != null) {
            Runnable runnable = (Runnable) this.f944a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
    }

    private void m2308e(di diVar, View view) {
        Runnable runnable;
        if (this.f944a != null) {
            runnable = (Runnable) this.f944a.get(view);
        } else {
            runnable = null;
        }
        if (runnable == null) {
            runnable = new dl(this, diVar, view, null);
            if (this.f944a == null) {
                this.f944a = new WeakHashMap();
            }
            this.f944a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }
}
