package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
/* compiled from: FloatingActionButtonLollipop */
class an extends ah {
    private final Interpolator f325m;
    private InsetDrawable f326n;

    an(cq cqVar, at atVar) {
        super(cqVar, atVar);
        this.f325m = cqVar.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.k.getContext(), 17563661);
    }

    void m513a(int i) {
        if (this.c instanceof RippleDrawable) {
            ((RippleDrawable) this.c).setColor(ColorStateList.valueOf(i));
        } else {
            super.m491a(i);
        }
    }

    public void m512a(float f) {
        this.k.setElevation(f);
        if (this.l.m461b()) {
            m483g();
        }
    }

    public float m511a() {
        return this.k.getElevation();
    }

    void m518c() {
        m483g();
    }

    void m517b(Rect rect) {
        if (this.l.m461b()) {
            this.f326n = new InsetDrawable(this.c, rect.left, rect.top, rect.right, rect.bottom);
            this.l.m460a(this.f326n);
            return;
        }
        this.l.m460a(this.c);
    }

    void m515a(int[] iArr) {
    }

    void m516b() {
    }

    boolean m519d() {
        return false;
    }

    void m514a(Rect rect) {
        if (this.l.m461b()) {
            float a = this.l.m458a();
            float a2 = m511a() + this.g;
            int ceil = (int) Math.ceil((double) as.m526b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) as.m523a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
