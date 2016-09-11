package com.fyber.p035c.p036a;

import android.content.Context;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.fyber.p035c.DrawableLayout;

/* renamed from: com.fyber.c.a.a */
public final class CloseButtonLayout extends DrawableLayout {
    public CloseButtonLayout(Context context) {
        super(context);
        int a = m5061a(30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setShape(1);
        gradientDrawable.setAlpha(128);
        gradientDrawable.setSize(a, a);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new ArcShape(0.0f, 360.0f));
        shapeDrawable.getPaint().setColor(-1);
        shapeDrawable.getPaint().setStrokeWidth((float) Math.round(1.5f));
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setAntiAlias(true);
        shapeDrawable.setIntrinsicHeight(a);
        shapeDrawable.setIntrinsicWidth(a);
        m5062a(new LayerDrawable(new Drawable[]{shapeDrawable, gradientDrawable}));
        a = m5061a(15);
        View drawCloseXView = new DrawCloseXView(context, 1.5f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(a, a);
        layoutParams.addRule(13);
        drawCloseXView.setLayoutParams(layoutParams);
        addView(drawCloseXView);
        setContentDescription("closeButton");
    }

    public final int m5063a() {
        return m5061a(60);
    }
}
