package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;

/* renamed from: android.support.design.widget.f */
public class AppBarLayout extends LayoutParams {
    int f414a;
    Interpolator f415b;

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f414a = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.AppBarLayout_LayoutParams);
        this.f414a = obtainStyledAttributes.getInt(R.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
        if (obtainStyledAttributes.hasValue(R.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
            this.f415b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public AppBarLayout(int i, int i2) {
        super(i, i2);
        this.f414a = 1;
    }

    public AppBarLayout(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f414a = 1;
    }

    public AppBarLayout(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f414a = 1;
    }

    public AppBarLayout(LayoutParams layoutParams) {
        super(layoutParams);
        this.f414a = 1;
    }

    public int m683a() {
        return this.f414a;
    }

    public Interpolator m684b() {
        return this.f415b;
    }
}
