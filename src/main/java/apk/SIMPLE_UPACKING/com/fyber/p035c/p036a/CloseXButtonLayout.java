package com.fyber.p035c.p036a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.fyber.p035c.DrawableLayout;

/* renamed from: com.fyber.c.a.b */
public final class CloseXButtonLayout extends DrawableLayout {
    public CloseXButtonLayout(Context context) {
        super(context);
        int a = m5061a(15);
        View drawCloseXView = new DrawCloseXView(context, 4.5f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(a, a);
        layoutParams.addRule(13, -1);
        drawCloseXView.setLayoutParams(layoutParams);
        setPadding(this.a, this.a, this.a, this.a);
        addView(drawCloseXView);
    }
}
