package com.fyber.p035c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

/* renamed from: com.fyber.c.a */
public class DrawableLayout extends RelativeLayout {
    protected final int f2643a;

    public DrawableLayout(Context context) {
        super(context);
        this.f2643a = m5061a(15);
    }

    protected final ImageView m5062a(Drawable drawable) {
        View imageView = new ImageView(getContext());
        imageView.setImageDrawable(drawable);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setPadding(this.f2643a, this.f2643a, this.f2643a, this.f2643a);
        addView(imageView);
        return imageView;
    }

    protected final int m5061a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }
}
