package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: FloatingActionButtonImpl */
abstract class ak {
    static final int[] f289h;
    static final int[] f290i;
    static final int[] f291j;
    private final Rect f292a;
    Drawable f293b;
    Drawable f294c;
    CircularBorderDrawable f295d;
    Drawable f296e;
    float f297f;
    float f298g;
    final cq f299k;
    final at f300l;
    private OnPreDrawListener f301m;

    abstract float m467a();

    abstract void m468a(float f);

    abstract void m469a(int i);

    abstract void m470a(ColorStateList colorStateList);

    abstract void m471a(Mode mode);

    abstract void m472a(Rect rect);

    abstract void m473a(am amVar, boolean z);

    abstract void m474a(int[] iArr);

    abstract void m475b();

    abstract void m478b(am amVar, boolean z);

    abstract void m479c();

    static {
        f289h = new int[]{16842919, 16842910};
        f290i = new int[]{16842908, 16842910};
        f291j = new int[0];
    }

    ak(cq cqVar, at atVar) {
        this.f292a = new Rect();
        this.f299k = cqVar;
        this.f300l = atVar;
    }

    final void m476b(float f) {
        if (this.f297f != f) {
            this.f297f = f;
            m468a(f);
        }
    }

    final Drawable m482f() {
        return this.f296e;
    }

    final void m483g() {
        Rect rect = this.f292a;
        m472a(rect);
        m477b(rect);
        this.f300l.m459a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void m477b(Rect rect) {
    }

    void m484h() {
        if (m480d()) {
            m466j();
            this.f299k.getViewTreeObserver().addOnPreDrawListener(this.f301m);
        }
    }

    void m485i() {
        if (this.f301m != null) {
            this.f299k.getViewTreeObserver().removeOnPreDrawListener(this.f301m);
            this.f301m = null;
        }
    }

    boolean m480d() {
        return false;
    }

    void m481e() {
    }

    private void m466j() {
        if (this.f301m == null) {
            this.f301m = new al(this);
        }
    }
}
