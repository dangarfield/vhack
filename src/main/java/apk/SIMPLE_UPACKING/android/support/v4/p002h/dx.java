package android.support.v4.p002h;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatKK */
/* renamed from: android.support.v4.h.dx */
class dx {
    public static void m2346a(View view, eb ebVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (ebVar != null) {
            animatorUpdateListener = new dy(ebVar, view);
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
