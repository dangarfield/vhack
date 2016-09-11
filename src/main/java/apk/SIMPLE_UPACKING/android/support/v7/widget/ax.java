package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.bo;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/* compiled from: AppCompatEditText */
public class ax extends EditText implements bo {
    private ar f1903a;
    private am f1904b;
    private bq f1905c;

    public ax(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.editTextStyle);
    }

    public ax(Context context, AttributeSet attributeSet, int i) {
        super(fy.m4641a(context), attributeSet, i);
        this.f1903a = ar.m3972a();
        this.f1904b = new am(this, this.f1903a);
        this.f1904b.m3955a(attributeSet, i);
        this.f1905c = bq.m4067a((TextView) this);
        this.f1905c.m4072a(attributeSet, i);
        this.f1905c.m4069a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1904b != null) {
            this.f1904b.m3951a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1904b != null) {
            this.f1904b.m3954a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1904b != null) {
            this.f1904b.m3952a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1904b != null ? this.f1904b.m3950a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1904b != null) {
            this.f1904b.m3953a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1904b != null ? this.f1904b.m3956b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1904b != null) {
            this.f1904b.m3958c();
        }
        if (this.f1905c != null) {
            this.f1905c.m4069a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1905c != null) {
            this.f1905c.m4070a(context, i);
        }
    }
}
