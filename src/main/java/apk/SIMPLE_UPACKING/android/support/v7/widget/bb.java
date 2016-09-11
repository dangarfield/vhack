package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.bo;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

/* compiled from: AppCompatMultiAutoCompleteTextView */
public class bb extends MultiAutoCompleteTextView implements bo {
    private static final int[] f1915a;
    private ar f1916b;
    private am f1917c;
    private bq f1918d;

    static {
        f1915a = new int[]{16843126};
    }

    public bb(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.autoCompleteTextViewStyle);
    }

    public bb(Context context, AttributeSet attributeSet, int i) {
        super(fy.m4641a(context), attributeSet, i);
        this.f1916b = ar.m3972a();
        gb a = gb.m4646a(getContext(), attributeSet, f1915a, i, 0);
        if (a.m4661f(0)) {
            setDropDownBackgroundDrawable(a.m4649a(0));
        }
        a.m4650a();
        this.f1917c = new am(this, this.f1916b);
        this.f1917c.m3955a(attributeSet, i);
        this.f1918d = bq.m4067a((TextView) this);
        this.f1918d.m4072a(attributeSet, i);
        this.f1918d.m4069a();
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1916b != null) {
            setDropDownBackgroundDrawable(this.f1916b.m3993a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1917c != null) {
            this.f1917c.m3951a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1917c != null) {
            this.f1917c.m3954a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1917c != null) {
            this.f1917c.m3952a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1917c != null ? this.f1917c.m3950a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1917c != null) {
            this.f1917c.m3953a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1917c != null ? this.f1917c.m3956b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1917c != null) {
            this.f1917c.m3958c();
        }
        if (this.f1918d != null) {
            this.f1918d.m4069a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1918d != null) {
            this.f1918d.m4070a(context, i);
        }
    }
}
