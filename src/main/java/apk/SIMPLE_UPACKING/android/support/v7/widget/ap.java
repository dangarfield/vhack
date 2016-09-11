package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

/* compiled from: AppCompatCheckedTextView */
public class ap extends CheckedTextView {
    private static final int[] f1878a;
    private ar f1879b;
    private bq f1880c;

    static {
        f1878a = new int[]{16843016};
    }

    public ap(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public ap(Context context, AttributeSet attributeSet, int i) {
        super(fy.m4641a(context), attributeSet, i);
        this.f1880c = bq.m4067a((TextView) this);
        this.f1880c.m4072a(attributeSet, i);
        this.f1880c.m4069a();
        this.f1879b = ar.m3972a();
        gb a = gb.m4646a(getContext(), attributeSet, f1878a, i, 0);
        setCheckMarkDrawable(a.m4649a(0));
        a.m4650a();
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f1879b != null) {
            setCheckMarkDrawable(this.f1879b.m3993a(getContext(), i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1880c != null) {
            this.f1880c.m4070a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1880c != null) {
            this.f1880c.m4069a();
        }
    }
}
