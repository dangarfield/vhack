package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.bo;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* compiled from: AppCompatImageButton */
public class ay extends ImageButton implements bo {
    private am f1906a;
    private az f1907b;

    public ay(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.imageButtonStyle);
    }

    public ay(Context context, AttributeSet attributeSet, int i) {
        super(fy.m4641a(context), attributeSet, i);
        ar a = ar.m3972a();
        this.f1906a = new am(this, a);
        this.f1906a.m3955a(attributeSet, i);
        this.f1907b = new az(this, a);
        this.f1907b.m4004a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f1907b.m4003a(i);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1906a != null) {
            this.f1906a.m3951a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1906a != null) {
            this.f1906a.m3954a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1906a != null) {
            this.f1906a.m3952a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1906a != null ? this.f1906a.m3950a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1906a != null) {
            this.f1906a.m3953a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1906a != null ? this.f1906a.m3956b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1906a != null) {
            this.f1906a.m3958c();
        }
    }
}
