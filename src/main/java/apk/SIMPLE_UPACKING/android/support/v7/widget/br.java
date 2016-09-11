package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextHelperV17 */
class br extends bq {
    private static final int[] f2000b;
    private fz f2001c;
    private fz f2002d;

    static {
        f2000b = new int[]{16843666, 16843667};
    }

    br(TextView textView) {
        super(textView);
    }

    void m4075a(AttributeSet attributeSet, int i) {
        super.m4072a(attributeSet, i);
        Context context = this.a.getContext();
        ar a = ar.m3972a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2000b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f2001c = bq.m4068a(context, a, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2002d = bq.m4068a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }

    void m4074a() {
        super.m4069a();
        if (this.f2001c != null || this.f2002d != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m4071a(compoundDrawablesRelative[0], this.f2001c);
            m4071a(compoundDrawablesRelative[2], this.f2002d);
        }
    }
}
