package android.support.v4.p002h;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompat */
/* renamed from: android.support.v4.h.dn */
class dn implements dz {
    di f949a;
    boolean f950b;

    dn(di diVar) {
        this.f949a = diVar;
    }

    public void m2330a(View view) {
        dz dzVar;
        this.f950b = false;
        if (this.f949a.f943e >= 0) {
            bu.m1926a(view, 2, null);
        }
        if (this.f949a.f941c != null) {
            Runnable a = this.f949a.f941c;
            this.f949a.f941c = null;
            a.run();
        }
        Object tag = view.getTag(2113929216);
        if (tag instanceof dz) {
            dzVar = (dz) tag;
        } else {
            dzVar = null;
        }
        if (dzVar != null) {
            dzVar.m543a(view);
        }
    }

    public void m2331b(View view) {
        if (this.f949a.f943e >= 0) {
            bu.m1926a(view, this.f949a.f943e, null);
            this.f949a.f943e = -1;
        }
        if (VERSION.SDK_INT >= 16 || !this.f950b) {
            dz dzVar;
            if (this.f949a.f942d != null) {
                Runnable b = this.f949a.f942d;
                this.f949a.f942d = null;
                b.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof dz) {
                dzVar = (dz) tag;
            } else {
                dzVar = null;
            }
            if (dzVar != null) {
                dzVar.m544b(view);
            }
            this.f950b = true;
        }
    }

    public void m2332c(View view) {
        dz dzVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof dz) {
            dzVar = (dz) tag;
        } else {
            dzVar = null;
        }
        if (dzVar != null) {
            dzVar.m545c(view);
        }
    }
}
