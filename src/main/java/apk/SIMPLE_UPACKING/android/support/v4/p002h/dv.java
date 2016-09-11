package android.support.v4.p002h;

import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatJB */
/* renamed from: android.support.v4.h.dv */
class dv {
    public static void m2345a(View view, dz dzVar) {
        if (dzVar != null) {
            view.animate().setListener(new dw(dzVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
