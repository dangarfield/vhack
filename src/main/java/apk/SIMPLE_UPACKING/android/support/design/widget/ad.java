package android.support.design.widget;

import android.view.animation.Animation;

/* compiled from: FloatingActionButtonEclairMr1 */
class ad extends AnimationUtils {
    final /* synthetic */ am f309a;
    final /* synthetic */ ab f310b;

    ad(ab abVar, am amVar) {
        this.f310b = abVar;
        this.f309a = amVar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f309a != null) {
            this.f309a.m509a();
        }
    }
}
