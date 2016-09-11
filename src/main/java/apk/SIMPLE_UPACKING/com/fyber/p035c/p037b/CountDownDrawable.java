package com.fyber.p035c.p037b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: com.fyber.c.b.a */
public final class CountDownDrawable extends Drawable {
    private Paint f2646a;
    private float f2647b;

    public CountDownDrawable() {
        this.f2646a = new Paint(1);
        this.f2646a.setColor(-1);
        this.f2646a.setAntiAlias(true);
        this.f2646a.setStrokeWidth((float) Math.round(1.5f));
        this.f2646a.setStyle(Style.STROKE);
    }

    public final void draw(Canvas canvas) {
        canvas.drawArc(new RectF(getBounds()), -90.0f, -this.f2647b, false, this.f2646a);
    }

    public final void m5064a(float f) {
        if (this.f2647b >= 0.0f) {
            this.f2647b = f;
            invalidateSelf();
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
