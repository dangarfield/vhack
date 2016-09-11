package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.bo;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

/* compiled from: AppCompatButton */
public class an extends Button implements bo {
    private final ar f1873a;
    private final am f1874b;
    private final bq f1875c;

    public an(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.buttonStyle);
    }

    public an(Context context, AttributeSet attributeSet, int i) {
        super(fy.m4641a(context), attributeSet, i);
        this.f1873a = ar.m3972a();
        this.f1874b = new am(this, this.f1873a);
        this.f1874b.m3955a(attributeSet, i);
        this.f1875c = bq.m4067a((TextView) this);
        this.f1875c.m4072a(attributeSet, i);
        this.f1875c.m4069a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1874b != null) {
            this.f1874b.m3951a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1874b != null) {
            this.f1874b.m3954a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1874b != null) {
            this.f1874b.m3952a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1874b != null ? this.f1874b.m3950a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1874b != null) {
            this.f1874b.m3953a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1874b != null ? this.f1874b.m3956b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1874b != null) {
            this.f1874b.m3958c();
        }
        if (this.f1875c != null) {
            this.f1875c.m4069a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1875c != null) {
            this.f1875c.m4070a(context, i);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f1875c != null) {
            this.f1875c.m4073a(z);
        }
    }
}
