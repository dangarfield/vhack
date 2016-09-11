package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: FloatingActionButtonEclairMr1 */
abstract class ae extends Animation {
    final /* synthetic */ ab f311a;
    private float f312b;
    private float f313c;

    protected abstract float m500a();

    private ae(ab abVar) {
        this.f311a = abVar;
    }

    public void reset() {
        super.reset();
        this.f312b = this.f311a.f302a.m529a();
        this.f313c = m500a() - this.f312b;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f311a.f302a.m532b(this.f312b + (this.f313c * f));
    }
}
