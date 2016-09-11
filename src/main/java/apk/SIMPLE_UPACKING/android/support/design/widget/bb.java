package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: Snackbar */
class bb implements AnimationListener {
    final /* synthetic */ Snackbar f355a;

    bb(Snackbar snackbar) {
        this.f355a = snackbar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f355a.m432e();
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
