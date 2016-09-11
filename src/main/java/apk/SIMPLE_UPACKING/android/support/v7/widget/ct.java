package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: LinearLayoutCompat */
public class ct extends MarginLayoutParams {
    public float f2081g;
    public int f2082h;

    public ct(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2082h = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.LinearLayoutCompat_Layout);
        this.f2081g = obtainStyledAttributes.getFloat(R.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
        this.f2082h = obtainStyledAttributes.getInt(R.LinearLayoutCompat_Layout_android_layout_gravity, -1);
        obtainStyledAttributes.recycle();
    }

    public ct(int i, int i2) {
        super(i, i2);
        this.f2082h = -1;
        this.f2081g = 0.0f;
    }

    public ct(LayoutParams layoutParams) {
        super(layoutParams);
        this.f2082h = -1;
    }
}
