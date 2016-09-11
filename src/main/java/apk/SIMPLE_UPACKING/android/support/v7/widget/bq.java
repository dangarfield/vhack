package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p018b.R;
import android.support.v7.p020e.AllCapsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextHelper */
class bq {
    private static final int[] f1993b;
    private static final int[] f1994c;
    final TextView f1995a;
    private fz f1996d;
    private fz f1997e;
    private fz f1998f;
    private fz f1999g;

    static bq m4067a(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new br(textView);
        }
        return new bq(textView);
    }

    static {
        f1993b = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
        f1994c = new int[]{R.textAllCaps};
    }

    bq(TextView textView) {
        this.f1995a = textView;
    }

    void m4072a(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.f1995a.getContext();
        ar a = ar.m3972a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1993b, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.f1996d = m4068a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.f1997e = m4068a(context, a, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f1998f = m4068a(context, a, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.f1999g = m4068a(context, a, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.f1995a.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean z2;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, R.TextAppearance);
                if (obtainStyledAttributes2.hasValue(R.TextAppearance_textAllCaps)) {
                    z = obtainStyledAttributes2.getBoolean(R.TextAppearance_textAllCaps, false);
                    i3 = 1;
                } else {
                    z2 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                z2 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f1994c, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i3;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                m4073a(z);
            }
        }
    }

    void m4070a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, f1994c);
        if (obtainStyledAttributes.getBoolean(0, false)) {
            m4073a(true);
        }
        obtainStyledAttributes.recycle();
    }

    void m4073a(boolean z) {
        this.f1995a.setTransformationMethod(z ? new AllCapsTransformationMethod(this.f1995a.getContext()) : null);
    }

    void m4069a() {
        if (this.f1996d != null || this.f1997e != null || this.f1998f != null || this.f1999g != null) {
            Drawable[] compoundDrawables = this.f1995a.getCompoundDrawables();
            m4071a(compoundDrawables[0], this.f1996d);
            m4071a(compoundDrawables[1], this.f1997e);
            m4071a(compoundDrawables[2], this.f1998f);
            m4071a(compoundDrawables[3], this.f1999g);
        }
    }

    final void m4071a(Drawable drawable, fz fzVar) {
        if (drawable != null && fzVar != null) {
            ar.m3975a(drawable, fzVar, this.f1995a.getDrawableState());
        }
    }

    protected static fz m4068a(Context context, ar arVar, int i) {
        ColorStateList b = arVar.m3996b(context, i);
        if (b == null) {
            return null;
        }
        fz fzVar = new fz();
        fzVar.f2297d = true;
        fzVar.f2294a = b;
        return fzVar;
    }
}
