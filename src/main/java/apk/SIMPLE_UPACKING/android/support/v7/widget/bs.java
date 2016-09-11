package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.bo;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextView */
public class bs extends TextView implements bo {
    private ar f1418a;
    private am f1419b;
    private bq f1420c;

    public bs(Context context) {
        this(context, null);
    }

    public bs(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public bs(Context context, AttributeSet attributeSet, int i) {
        super(fy.m4641a(context), attributeSet, i);
        this.f1418a = ar.m3972a();
        this.f1419b = new am(this, this.f1418a);
        this.f1419b.m3955a(attributeSet, i);
        this.f1420c = bq.m4067a((TextView) this);
        this.f1420c.m4072a(attributeSet, i);
        this.f1420c.m4069a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1419b != null) {
            this.f1419b.m3951a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1419b != null) {
            this.f1419b.m3954a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1419b != null) {
            this.f1419b.m3952a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1419b != null ? this.f1419b.m3950a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1419b != null) {
            this.f1419b.m3953a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1419b != null ? this.f1419b.m3956b() : null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1420c != null) {
            this.f1420c.m4070a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1419b != null) {
            this.f1419b.m3958c();
        }
        if (this.f1420c != null) {
            this.f1420c.m4069a();
        }
    }
}
