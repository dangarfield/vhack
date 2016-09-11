package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.bo;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageView */
public class ba extends ImageView implements bo {
    private am f1913a;
    private az f1914b;

    public ba(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ba(Context context, AttributeSet attributeSet, int i) {
        super(fy.m4641a(context), attributeSet, i);
        ar a = ar.m3972a();
        this.f1913a = new am(this, a);
        this.f1913a.m3955a(attributeSet, i);
        this.f1914b = new az(this, a);
        this.f1914b.m4004a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f1914b.m4003a(i);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1913a != null) {
            this.f1913a.m3951a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1913a != null) {
            this.f1913a.m3954a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1913a != null) {
            this.f1913a.m3952a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1913a != null ? this.f1913a.m3950a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1913a != null) {
            this.f1913a.m3953a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1913a != null ? this.f1913a.m3956b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1913a != null) {
            this.f1913a.m3958c();
        }
    }
}
