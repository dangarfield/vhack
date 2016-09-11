package android.support.v4.p002h;

import android.view.View;
import android.view.animation.Interpolator;

/* compiled from: ViewPropertyAnimatorCompatICS */
/* renamed from: android.support.v4.h.dt */
class dt {
    public static void m2337a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m2336a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m2341b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m2344c(View view, float f) {
        view.animate().translationY(f);
    }

    public static long m2335a(View view) {
        return view.animate().getDuration();
    }

    public static void m2339a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m2342b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void m2340b(View view) {
        view.animate().cancel();
    }

    public static void m2343c(View view) {
        view.animate().start();
    }

    public static void m2338a(View view, dz dzVar) {
        if (dzVar != null) {
            view.animate().setListener(new du(dzVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
