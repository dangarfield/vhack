package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: GridLayoutManager */
public class cp extends ek {
    private int f2070e;
    private int f2071f;

    public cp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2070e = -1;
        this.f2071f = 0;
    }

    public cp(int i, int i2) {
        super(i, i2);
        this.f2070e = -1;
        this.f2071f = 0;
    }

    public cp(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f2070e = -1;
        this.f2071f = 0;
    }

    public cp(LayoutParams layoutParams) {
        super(layoutParams);
        this.f2070e = -1;
        this.f2071f = 0;
    }

    public int m4256a() {
        return this.f2070e;
    }

    public int m4257b() {
        return this.f2071f;
    }
}
