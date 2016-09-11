package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p009c.p010a.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* compiled from: AppCompatCompoundButtonHelper */
class aq {
    private final CompoundButton f1881a;
    private final ar f1882b;
    private ColorStateList f1883c;
    private Mode f1884d;
    private boolean f1885e;
    private boolean f1886f;
    private boolean f1887g;

    aq(CompoundButton compoundButton, ar arVar) {
        this.f1883c = null;
        this.f1884d = null;
        this.f1885e = false;
        this.f1886f = false;
        this.f1881a = compoundButton;
        this.f1882b = arVar;
    }

    void m3963a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f1881a.getContext().obtainStyledAttributes(attributeSet, R.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(R.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f1881a.setButtonDrawable(this.f1882b.m3993a(this.f1881a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(R.CompoundButton_buttonTint)) {
                CompoundButtonCompat.m2660a(this.f1881a, obtainStyledAttributes.getColorStateList(R.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(R.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.m2661a(this.f1881a, cl.m4237a(obtainStyledAttributes.getInt(R.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    void m3961a(ColorStateList colorStateList) {
        this.f1883c = colorStateList;
        this.f1885e = true;
        m3966d();
    }

    ColorStateList m3960a() {
        return this.f1883c;
    }

    void m3962a(Mode mode) {
        this.f1884d = mode;
        this.f1886f = true;
        m3966d();
    }

    Mode m3964b() {
        return this.f1884d;
    }

    void m3965c() {
        if (this.f1887g) {
            this.f1887g = false;
            return;
        }
        this.f1887g = true;
        m3966d();
    }

    void m3966d() {
        Drawable a = CompoundButtonCompat.m2659a(this.f1881a);
        if (a == null) {
            return;
        }
        if (this.f1885e || this.f1886f) {
            a = DrawableCompat.m1319f(a).mutate();
            if (this.f1885e) {
                DrawableCompat.m1309a(a, this.f1883c);
            }
            if (this.f1886f) {
                DrawableCompat.m1312a(a, this.f1884d);
            }
            if (a.isStateful()) {
                a.setState(this.f1881a.getDrawableState());
            }
            this.f1881a.setButtonDrawable(a);
        }
    }

    int m3959a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = CompoundButtonCompat.m2659a(this.f1881a);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
