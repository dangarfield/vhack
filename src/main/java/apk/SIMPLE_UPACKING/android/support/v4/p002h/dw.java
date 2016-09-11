package android.support.v4.p002h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatJB */
/* renamed from: android.support.v4.h.dw */
final class dw extends AnimatorListenerAdapter {
    final /* synthetic */ dz f953a;
    final /* synthetic */ View f954b;

    dw(dz dzVar, View view) {
        this.f953a = dzVar;
        this.f954b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f953a.m545c(this.f954b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f953a.m544b(this.f954b);
    }

    public void onAnimationStart(Animator animator) {
        this.f953a.m543a(this.f954b);
    }
}
