package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: FloatingActionButtonIcs */
class ai extends AnimatorListenerAdapter {
    final /* synthetic */ boolean f317a;
    final /* synthetic */ am f318b;
    final /* synthetic */ ah f319c;
    private boolean f320d;

    ai(ah ahVar, boolean z, am amVar) {
        this.f319c = ahVar;
        this.f317a = z;
        this.f318b = amVar;
    }

    public void onAnimationStart(Animator animator) {
        this.f319c.f316m = true;
        this.f320d = false;
        this.f319c.k.m405a(0, this.f317a);
    }

    public void onAnimationCancel(Animator animator) {
        this.f319c.f316m = false;
        this.f320d = true;
    }

    public void onAnimationEnd(Animator animator) {
        this.f319c.f316m = false;
        if (!this.f320d) {
            this.f319c.k.m405a(8, this.f317a);
            if (this.f318b != null) {
                this.f318b.m510b();
            }
        }
    }
}
