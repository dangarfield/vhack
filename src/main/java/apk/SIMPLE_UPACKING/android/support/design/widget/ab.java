package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.support.design.R;
import android.support.v4.p009c.p010a.DrawableCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* compiled from: FloatingActionButtonEclairMr1 */
class ab extends ak {
    as f302a;
    private int f303m;
    private bl f304n;
    private boolean f305o;

    ab(cq cqVar, at atVar) {
        super(cqVar, atVar);
        this.f303m = cqVar.getResources().getInteger(17694720);
        this.f304n = new bl();
        this.f304n.m583a((View) cqVar);
        this.f304n.m585a(h, m486a(new af()));
        this.f304n.m585a(i, m486a(new af()));
        this.f304n.m585a(j, m486a(new ag()));
    }

    void m492a(ColorStateList colorStateList) {
        if (this.b != null) {
            DrawableCompat.m1309a(this.b, colorStateList);
        }
        if (this.d != null) {
            this.d.m699a(colorStateList);
        }
    }

    void m493a(Mode mode) {
        if (this.b != null) {
            DrawableCompat.m1312a(this.b, mode);
        }
    }

    void m491a(int i) {
        if (this.c != null) {
            DrawableCompat.m1309a(this.c, m488b(i));
        }
    }

    float m489a() {
        return this.f;
    }

    void m490a(float f) {
        if (this.f302a != null) {
            this.f302a.m531a(f, this.g + f);
            m483g();
        }
    }

    void m496a(int[] iArr) {
        this.f304n.m584a(iArr);
    }

    void m497b() {
        this.f304n.m586b();
    }

    void m495a(am amVar, boolean z) {
        if (!this.f305o && this.k.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), R.design_fab_out);
            loadAnimation.setInterpolator(AnimationUtils.f285c);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new ac(this, z, amVar));
            this.k.startAnimation(loadAnimation);
        } else if (amVar != null) {
            amVar.m510b();
        }
    }

    void m498b(am amVar, boolean z) {
        if (this.k.getVisibility() != 0 || this.f305o) {
            this.k.clearAnimation();
            this.k.m405a(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), R.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(AnimationUtils.f286d);
            loadAnimation.setAnimationListener(new ad(this, amVar));
            this.k.startAnimation(loadAnimation);
        } else if (amVar != null) {
            amVar.m509a();
        }
    }

    void m499c() {
    }

    void m494a(Rect rect) {
        this.f302a.getPadding(rect);
    }

    private Animation m486a(Animation animation) {
        animation.setInterpolator(AnimationUtils.f284b);
        animation.setDuration((long) this.f303m);
        return animation;
    }

    private static ColorStateList m488b(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{i, i, h};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }
}
