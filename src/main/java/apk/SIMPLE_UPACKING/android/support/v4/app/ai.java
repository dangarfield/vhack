package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;

/* compiled from: FragmentManager */
class ai extends aj {
    final /* synthetic */ Fragment f528a;
    final /* synthetic */ af f529b;

    ai(af afVar, View view, Animation animation, Fragment fragment) {
        this.f529b = afVar;
        this.f528a = fragment;
        super(view, animation);
    }

    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        if (this.f528a.f729l != null) {
            this.f528a.f729l = null;
            this.f529b.m846a(this.f528a, this.f528a.f730m, 0, 0, false);
        }
    }
}
