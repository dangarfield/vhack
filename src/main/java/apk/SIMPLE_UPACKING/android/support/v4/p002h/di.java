package android.support.v4.p002h;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
/* renamed from: android.support.v4.h.di */
public final class di {
    static final ds f939a;
    private WeakReference f940b;
    private Runnable f941c;
    private Runnable f942d;
    private int f943e;

    di(View view) {
        this.f941c = null;
        this.f942d = null;
        this.f943e = -1;
        this.f940b = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f939a = new dr();
        } else if (i >= 19) {
            f939a = new dq();
        } else if (i >= 18) {
            f939a = new ViewPropertyAnimatorCompat();
        } else if (i >= 16) {
            f939a = new dp();
        } else if (i >= 14) {
            f939a = new dm();
        } else {
            f939a = new dk();
        }
    }

    public di m2285a(long j) {
        View view = (View) this.f940b.get();
        if (view != null) {
            f939a.m2296a(this, view, j);
        }
        return this;
    }

    public di m2284a(float f) {
        View view = (View) this.f940b.get();
        if (view != null) {
            f939a.m2295a(this, view, f);
        }
        return this;
    }

    public di m2289b(float f) {
        View view = (View) this.f940b.get();
        if (view != null) {
            f939a.m2301b(this, view, f);
        }
        return this;
    }

    public di m2292c(float f) {
        View view = (View) this.f940b.get();
        if (view != null) {
            f939a.m2304c(this, view, f);
        }
        return this;
    }

    public long m2283a() {
        View view = (View) this.f940b.get();
        if (view != null) {
            return f939a.m2294a(this, view);
        }
        return 0;
    }

    public di m2288a(Interpolator interpolator) {
        View view = (View) this.f940b.get();
        if (view != null) {
            f939a.m2299a(this, view, interpolator);
        }
        return this;
    }

    public di m2290b(long j) {
        View view = (View) this.f940b.get();
        if (view != null) {
            f939a.m2302b(this, view, j);
        }
        return this;
    }

    public void m2291b() {
        View view = (View) this.f940b.get();
        if (view != null) {
            f939a.m2300b(this, view);
        }
    }

    public void m2293c() {
        View view = (View) this.f940b.get();
        if (view != null) {
            f939a.m2303c(this, view);
        }
    }

    public di m2286a(dz dzVar) {
        View view = (View) this.f940b.get();
        if (view != null) {
            f939a.m2297a(this, view, dzVar);
        }
        return this;
    }

    public di m2287a(eb ebVar) {
        View view = (View) this.f940b.get();
        if (view != null) {
            f939a.m2298a(this, view, ebVar);
        }
        return this;
    }
}
