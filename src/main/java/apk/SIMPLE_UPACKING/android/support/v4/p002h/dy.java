package android.support.v4.p002h;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatKK */
/* renamed from: android.support.v4.h.dy */
final class dy implements AnimatorUpdateListener {
    final /* synthetic */ eb f955a;
    final /* synthetic */ View f956b;

    dy(eb ebVar, View view) {
        this.f955a = ebVar;
        this.f956b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f955a.m2350a(this.f956b);
    }
}
