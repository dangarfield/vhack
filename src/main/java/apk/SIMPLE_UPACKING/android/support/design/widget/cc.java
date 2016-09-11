package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ValueAnimatorCompatImplHoneycombMr1 */
class cc implements AnimatorUpdateListener {
    final /* synthetic */ by f401a;
    final /* synthetic */ cb f402b;

    cc(cb cbVar, by byVar) {
        this.f402b = cbVar;
        this.f401a = byVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f401a.m620a();
    }
}
