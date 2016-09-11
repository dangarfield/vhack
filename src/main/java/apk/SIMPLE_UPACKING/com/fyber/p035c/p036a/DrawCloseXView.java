package com.fyber.p035c.p036a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.view.View;

/* renamed from: com.fyber.c.a.c */
public final class DrawCloseXView extends View {
    private Paint f2644a;
    private int f2645b;

    public DrawCloseXView(Context context, float f) {
        super(context);
        this.f2644a = new Paint();
        this.f2644a.setAntiAlias(true);
        this.f2644a.setStrokeWidth(f);
        this.f2644a.setAlpha(178);
        this.f2644a.setColor(-1);
        this.f2644a.setStyle(Style.STROKE);
        this.f2644a.setStrokeJoin(Join.ROUND);
        this.f2645b = (int) (15.0f * context.getResources().getDisplayMetrics().density);
    }

    public final void onDraw(Canvas canvas) {
        canvas.drawLine(0.0f, 0.0f, (float) this.f2645b, (float) this.f2645b, this.f2644a);
        canvas.drawLine((float) this.f2645b, 0.0f, 0.0f, (float) this.f2645b, this.f2644a);
    }
}
