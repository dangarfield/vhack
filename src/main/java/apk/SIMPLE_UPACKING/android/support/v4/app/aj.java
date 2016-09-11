package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: FragmentManager */
class aj implements AnimationListener {
    private AnimationListener f525a;
    private boolean f526b;
    private View f527c;

    public aj(View view, Animation animation) {
        this.f525a = null;
        this.f526b = false;
        this.f527c = null;
        if (view != null && animation != null) {
            this.f527c = view;
        }
    }

    public aj(View view, Animation animation, AnimationListener animationListener) {
        this.f525a = null;
        this.f526b = false;
        this.f527c = null;
        if (view != null && animation != null) {
            this.f525a = animationListener;
            this.f527c = view;
        }
    }

    public void onAnimationStart(Animation animation) {
        if (this.f527c != null) {
            this.f526b = af.m823a(this.f527c, animation);
            if (this.f526b) {
                this.f527c.post(new ak(this));
            }
        }
        if (this.f525a != null) {
            this.f525a.onAnimationStart(animation);
        }
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f527c != null && this.f526b) {
            this.f527c.post(new al(this));
        }
        if (this.f525a != null) {
            this.f525a.onAnimationEnd(animation);
        }
    }

    public void onAnimationRepeat(Animation animation) {
        if (this.f525a != null) {
            this.f525a.onAnimationRepeat(animation);
        }
    }
}
