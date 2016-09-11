package android.support.v4.p002h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatICS */
/* renamed from: android.support.v4.h.du */
final class du extends AnimatorListenerAdapter {
    final /* synthetic */ dz f951a;
    final /* synthetic */ View f952b;

    du(dz dzVar, View view) {
        this.f951a = dzVar;
        this.f952b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f951a.m545c(this.f952b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f951a.m544b(this.f952b);
    }

    public void onAnimationStart(Animator animator) {
        this.f951a.m543a(this.f952b);
    }
}
