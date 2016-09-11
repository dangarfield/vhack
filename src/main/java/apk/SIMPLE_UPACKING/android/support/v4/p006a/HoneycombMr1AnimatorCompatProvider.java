package android.support.v4.p006a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: android.support.v4.a.d */
class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {
    private TimeInterpolator f454a;

    HoneycombMr1AnimatorCompatProvider() {
    }

    public void m738a(View view) {
        if (this.f454a == null) {
            this.f454a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f454a);
    }
}
