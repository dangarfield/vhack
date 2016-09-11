package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: ScrollerCompat */
class au implements at {
    au() {
    }

    public Object m2561a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    public boolean m2566a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public int m2568b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public int m2569c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public float m2570d(Object obj) {
        return 0.0f;
    }

    public boolean m2571e(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public void m2562a(Object obj, int i, int i2, int i3, int i4) {
        ((Scroller) obj).startScroll(i, i2, i3, i4);
    }

    public void m2563a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public void m2564a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m2565a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m2572f(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public int m2573g(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public int m2574h(Object obj) {
        return ((Scroller) obj).getFinalY();
    }

    public boolean m2567a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return false;
    }
}
