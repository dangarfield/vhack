package android.support.design.widget;

import android.view.animation.Animation;

/* compiled from: FloatingActionButtonEclairMr1 */
class ac extends AnimationUtils {
    final /* synthetic */ boolean f306a;
    final /* synthetic */ am f307b;
    final /* synthetic */ ab f308c;

    ac(ab abVar, boolean z, am amVar) {
        this.f308c = abVar;
        this.f306a = z;
        this.f307b = amVar;
    }

    public void onAnimationStart(Animation animation) {
        this.f308c.f305o = true;
    }

    public void onAnimationEnd(Animation animation) {
        this.f308c.f305o = false;
        this.f308c.k.m405a(8, this.f306a);
        if (this.f307b != null) {
            this.f307b.m510b();
        }
    }
}
