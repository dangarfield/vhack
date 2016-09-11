package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* compiled from: TintTypedArray */
public class gb {
    private final Context f2300a;
    private final TypedArray f2301b;

    public static gb m4645a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new gb(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static gb m4646a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new gb(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    private gb(Context context, TypedArray typedArray) {
        this.f2300a = context;
        this.f2301b = typedArray;
    }

    public Drawable m4649a(int i) {
        if (this.f2301b.hasValue(i)) {
            int resourceId = this.f2301b.getResourceId(i, 0);
            if (resourceId != 0) {
                return ar.m3972a().m3993a(this.f2300a, resourceId);
            }
        }
        return this.f2301b.getDrawable(i);
    }

    public Drawable m4653b(int i) {
        if (this.f2301b.hasValue(i)) {
            int resourceId = this.f2301b.getResourceId(i, 0);
            if (resourceId != 0) {
                return ar.m3972a().m3994a(this.f2300a, resourceId, true);
            }
        }
        return null;
    }

    public CharSequence m4655c(int i) {
        return this.f2301b.getText(i);
    }

    public String m4657d(int i) {
        return this.f2301b.getString(i);
    }

    public boolean m4651a(int i, boolean z) {
        return this.f2301b.getBoolean(i, z);
    }

    public int m4648a(int i, int i2) {
        return this.f2301b.getInt(i, i2);
    }

    public float m4647a(int i, float f) {
        return this.f2301b.getFloat(i, f);
    }

    public int m4652b(int i, int i2) {
        return this.f2301b.getColor(i, i2);
    }

    public int m4654c(int i, int i2) {
        return this.f2301b.getInteger(i, i2);
    }

    public int m4656d(int i, int i2) {
        return this.f2301b.getDimensionPixelOffset(i, i2);
    }

    public int m4658e(int i, int i2) {
        return this.f2301b.getDimensionPixelSize(i, i2);
    }

    public int m4660f(int i, int i2) {
        return this.f2301b.getLayoutDimension(i, i2);
    }

    public int m4662g(int i, int i2) {
        return this.f2301b.getResourceId(i, i2);
    }

    public CharSequence[] m4659e(int i) {
        return this.f2301b.getTextArray(i);
    }

    public boolean m4661f(int i) {
        return this.f2301b.hasValue(i);
    }

    public void m4650a() {
        this.f2301b.recycle();
    }
}
