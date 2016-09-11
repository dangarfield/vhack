package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: Snackbar */
class av implements AnimationListener {
    final /* synthetic */ int f348a;
    final /* synthetic */ Snackbar f349b;

    av(Snackbar snackbar, int i) {
        this.f349b = snackbar;
        this.f348a = i;
    }

    public void onAnimationEnd(Animation animation) {
        this.f349b.m431d(this.f348a);
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
