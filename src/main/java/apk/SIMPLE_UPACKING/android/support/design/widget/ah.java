package android.support.design.widget;

import android.support.v4.p002h.bu;

/* compiled from: FloatingActionButtonIcs */
class ah extends ab {
    private boolean f316m;

    ah(cq cqVar, at atVar) {
        super(cqVar, atVar);
    }

    boolean m507d() {
        return true;
    }

    void m508e() {
        m504c(this.k.getRotation());
    }

    void m505a(am amVar, boolean z) {
        if (this.f316m || this.k.getVisibility() != 0) {
            if (amVar != null) {
                amVar.m510b();
            }
        } else if (!bu.m1915A(this.k) || this.k.isInEditMode()) {
            this.k.m405a(8, z);
            if (amVar != null) {
                amVar.m510b();
            }
        } else {
            this.k.animate().cancel();
            this.k.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(AnimationUtils.f285c).setListener(new ai(this, z, amVar));
        }
    }

    void m506b(am amVar, boolean z) {
        if (!this.f316m && this.k.getVisibility() == 0) {
            return;
        }
        if (!bu.m1915A(this.k) || this.k.isInEditMode()) {
            this.k.m405a(0, z);
            this.k.setAlpha(1.0f);
            this.k.setScaleY(1.0f);
            this.k.setScaleX(1.0f);
            if (amVar != null) {
                amVar.m509a();
                return;
            }
            return;
        }
        this.k.animate().cancel();
        if (this.k.getVisibility() != 0) {
            this.k.setAlpha(0.0f);
            this.k.setScaleY(0.0f);
            this.k.setScaleX(0.0f);
        }
        this.k.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(AnimationUtils.f286d).setListener(new aj(this, z, amVar));
    }

    private void m504c(float f) {
        if (this.a != null) {
            this.a.m530a(-f);
        }
        if (this.d != null) {
            this.d.m698a(-f);
        }
    }
}
