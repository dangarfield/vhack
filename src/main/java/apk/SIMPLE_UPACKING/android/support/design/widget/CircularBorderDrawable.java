package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.p009c.ColorUtils;

/* renamed from: android.support.design.widget.l */
class CircularBorderDrawable extends Drawable {
    final Paint f420a;
    final Rect f421b;
    final RectF f422c;
    float f423d;
    private int f424e;
    private int f425f;
    private int f426g;
    private int f427h;
    private ColorStateList f428i;
    private int f429j;
    private boolean f430k;
    private float f431l;

    public void draw(Canvas canvas) {
        if (this.f430k) {
            this.f420a.setShader(m697a());
            this.f430k = false;
        }
        float strokeWidth = this.f420a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f422c;
        copyBounds(this.f421b);
        rectF.set(this.f421b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f431l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f420a);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f423d);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.f420a.setAlpha(i);
        invalidateSelf();
    }

    void m699a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f429j = colorStateList.getColorForState(getState(), this.f429j);
        }
        this.f428i = colorStateList;
        this.f430k = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f420a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.f423d > 0.0f ? -3 : -2;
    }

    final void m698a(float f) {
        if (f != this.f431l) {
            this.f431l = f;
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        this.f430k = true;
    }

    public boolean isStateful() {
        return (this.f428i != null && this.f428i.isStateful()) || super.isStateful();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f428i != null) {
            int colorForState = this.f428i.getColorForState(iArr, this.f429j);
            if (colorForState != this.f429j) {
                this.f430k = true;
                this.f429j = colorForState;
            }
        }
        if (this.f430k) {
            invalidateSelf();
        }
        return this.f430k;
    }

    private Shader m697a() {
        Rect rect = this.f421b;
        copyBounds(rect);
        float height = this.f423d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{ColorUtils.m1423a(this.f424e, this.f429j), ColorUtils.m1423a(this.f425f, this.f429j), ColorUtils.m1423a(ColorUtils.m1425b(this.f425f, 0), this.f429j), ColorUtils.m1423a(ColorUtils.m1425b(this.f427h, 0), this.f429j), ColorUtils.m1423a(this.f427h, this.f429j), ColorUtils.m1423a(this.f426g, this.f429j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }
}
