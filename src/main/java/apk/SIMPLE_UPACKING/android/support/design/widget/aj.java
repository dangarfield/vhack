package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: FloatingActionButtonIcs */
class aj extends AnimatorListenerAdapter {
    final /* synthetic */ boolean f321a;
    final /* synthetic */ am f322b;
    final /* synthetic */ ah f323c;

    aj(ah ahVar, boolean z, am amVar) {
        this.f323c = ahVar;
        this.f321a = z;
        this.f322b = amVar;
    }

    public void onAnimationStart(Animator animator) {
        this.f323c.k.m405a(0, this.f321a);
    }

    public void onAnimationEnd(Animator animator) {
        if (this.f322b != null) {
            this.f322b.m509a();
        }
    }
}
