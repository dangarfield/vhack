package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.p002h.bu;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: AppCompatBackgroundHelper */
class am {
    private final View f1868a;
    private final ar f1869b;
    private fz f1870c;
    private fz f1871d;
    private fz f1872e;

    am(View view, ar arVar) {
        this.f1868a = view;
        this.f1869b = arVar;
    }

    void m3955a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f1868a.getContext().obtainStyledAttributes(attributeSet, R.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.f1869b.m3996b(this.f1868a.getContext(), obtainStyledAttributes.getResourceId(R.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    m3957b(b);
                }
            }
            if (obtainStyledAttributes.hasValue(R.ViewBackgroundHelper_backgroundTint)) {
                bu.m1927a(this.f1868a, obtainStyledAttributes.getColorStateList(R.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(R.ViewBackgroundHelper_backgroundTintMode)) {
                bu.m1928a(this.f1868a, cl.m4237a(obtainStyledAttributes.getInt(R.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    void m3951a(int i) {
        m3957b(this.f1869b != null ? this.f1869b.m3996b(this.f1868a.getContext(), i) : null);
    }

    void m3954a(Drawable drawable) {
        m3957b(null);
    }

    void m3952a(ColorStateList colorStateList) {
        if (this.f1871d == null) {
            this.f1871d = new fz();
        }
        this.f1871d.f2294a = colorStateList;
        this.f1871d.f2297d = true;
        m3958c();
    }

    ColorStateList m3950a() {
        return this.f1871d != null ? this.f1871d.f2294a : null;
    }

    void m3953a(Mode mode) {
        if (this.f1871d == null) {
            this.f1871d = new fz();
        }
        this.f1871d.f2295b = mode;
        this.f1871d.f2296c = true;
        m3958c();
    }

    Mode m3956b() {
        return this.f1871d != null ? this.f1871d.f2295b : null;
    }

    void m3958c() {
        Drawable background = this.f1868a.getBackground();
        if (background == null) {
            return;
        }
        if (this.f1871d != null) {
            ar.m3975a(background, this.f1871d, this.f1868a.getDrawableState());
        } else if (this.f1870c != null) {
            ar.m3975a(background, this.f1870c, this.f1868a.getDrawableState());
        } else if (m3948b(background)) {
            m3949c(background);
        }
    }

    void m3957b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1870c == null) {
                this.f1870c = new fz();
            }
            this.f1870c.f2294a = colorStateList;
            this.f1870c.f2297d = true;
        } else {
            this.f1870c = null;
        }
        m3958c();
    }

    private boolean m3948b(Drawable drawable) {
        return VERSION.SDK_INT == 21 && (drawable instanceof GradientDrawable);
    }

    private void m3949c(Drawable drawable) {
        if (this.f1872e == null) {
            this.f1872e = new fz();
        }
        fz fzVar = this.f1872e;
        fzVar.m4643a();
        ColorStateList x = bu.m1967x(this.f1868a);
        if (x != null) {
            fzVar.f2297d = true;
            fzVar.f2294a = x;
        }
        Mode y = bu.m1968y(this.f1868a);
        if (y != null) {
            fzVar.f2296c = true;
            fzVar.f2295b = y;
        }
        if (fzVar.f2297d || fzVar.f2296c) {
            ar.m3975a(drawable, fzVar, this.f1868a.getDrawableState());
        }
    }
}
