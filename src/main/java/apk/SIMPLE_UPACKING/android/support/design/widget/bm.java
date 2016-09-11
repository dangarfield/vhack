package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: StateListAnimator */
class bm implements AnimationListener {
    final /* synthetic */ bl f373a;

    bm(bl blVar) {
        this.f373a = blVar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f373a.f370c == animation) {
            this.f373a.f370c = null;
        }
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
