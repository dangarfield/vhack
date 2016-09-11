package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p007b.ContextCompat;
import android.support.v4.widget.bi;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* compiled from: AppCompatRadioButton */
public class bf extends RadioButton implements bi {
    private ar f1928a;
    private aq f1929b;

    public bf(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.radioButtonStyle);
    }

    public bf(Context context, AttributeSet attributeSet, int i) {
        super(fy.m4641a(context), attributeSet, i);
        this.f1928a = ar.m3972a();
        this.f1929b = new aq(this, this.f1928a);
        this.f1929b.m3963a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f1929b != null) {
            this.f1929b.m3965c();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f1928a != null ? this.f1928a.m3993a(getContext(), i) : ContextCompat.m741a(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f1929b != null ? this.f1929b.m3959a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f1929b != null) {
            this.f1929b.m3961a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f1929b != null ? this.f1929b.m3960a() : null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f1929b != null) {
            this.f1929b.m3962a(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        return this.f1929b != null ? this.f1929b.m3964b() : null;
    }
}
