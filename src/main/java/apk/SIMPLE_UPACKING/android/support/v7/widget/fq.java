package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: StaggeredGridLayoutManager */
public class fq extends ek {
    ft f2253e;
    boolean f2254f;

    public fq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public fq(int i, int i2) {
        super(i, i2);
    }

    public fq(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public fq(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public boolean m4586a() {
        return this.f2254f;
    }

    public final int m4587b() {
        if (this.f2253e == null) {
            return -1;
        }
        return this.f2253e.f2258d;
    }
}
