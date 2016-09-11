package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.bo;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/* compiled from: AppCompatAutoCompleteTextView */
public class al extends AutoCompleteTextView implements bo {
    private static final int[] f1711a;
    private ar f1712b;
    private am f1713c;
    private bq f1714d;

    static {
        f1711a = new int[]{16843126};
    }

    public al(Context context) {
        this(context, null);
    }

    public al(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.autoCompleteTextViewStyle);
    }

    public al(Context context, AttributeSet attributeSet, int i) {
        super(fy.m4641a(context), attributeSet, i);
        this.f1712b = ar.m3972a();
        gb a = gb.m4646a(getContext(), attributeSet, f1711a, i, 0);
        if (a.m4661f(0)) {
            setDropDownBackgroundDrawable(a.m4649a(0));
        }
        a.m4650a();
        this.f1713c = new am(this, this.f1712b);
        this.f1713c.m3955a(attributeSet, i);
        this.f1714d = bq.m4067a((TextView) this);
        this.f1714d.m4072a(attributeSet, i);
        this.f1714d.m4069a();
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1712b != null) {
            setDropDownBackgroundDrawable(this.f1712b.m3993a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1713c != null) {
            this.f1713c.m3951a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1713c != null) {
            this.f1713c.m3954a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1713c != null) {
            this.f1713c.m3952a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1713c != null ? this.f1713c.m3950a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1713c != null) {
            this.f1713c.m3953a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1713c != null ? this.f1713c.m3956b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1713c != null) {
            this.f1713c.m3958c();
        }
        if (this.f1714d != null) {
            this.f1714d.m4069a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1714d != null) {
            this.f1714d.m4070a(context, i);
        }
    }
}
