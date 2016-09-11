package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.v7.p003c.p004a.DrawableWrapper;

/* compiled from: ShadowDrawableWrapper */
class as extends DrawableWrapper {
    static final double f331a;
    final Paint f332b;
    final Paint f333c;
    final RectF f334d;
    float f335e;
    Path f336f;
    float f337g;
    float f338h;
    float f339i;
    float f340j;
    private boolean f341k;
    private final int f342l;
    private final int f343m;
    private final int f344n;
    private boolean f345o;
    private float f346p;
    private boolean f347q;

    static {
        f331a = Math.cos(Math.toRadians(45.0d));
    }

    private static int m527c(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f332b.setAlpha(i);
        this.f333c.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        this.f341k = true;
    }

    void m531a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float c = (float) m527c(f);
        float c2 = (float) m527c(f2);
        if (c > c2) {
            if (!this.f347q) {
                this.f347q = true;
            }
            c = c2;
        }
        if (this.f340j != c || this.f338h != c2) {
            this.f340j = c;
            this.f338h = c2;
            this.f339i = (float) Math.round(c * 1.5f);
            this.f337g = c2;
            this.f341k = true;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m523a(this.f338h, this.f335e, this.f345o));
        int ceil2 = (int) Math.ceil((double) m526b(this.f338h, this.f335e, this.f345o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float m523a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - f331a) * ((double) f2)));
        }
        return 1.5f * f;
    }

    public static float m526b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - f331a) * ((double) f2)));
        }
        return f;
    }

    public int getOpacity() {
        return -3;
    }

    public void draw(Canvas canvas) {
        if (this.f341k) {
            m525a(getBounds());
            this.f341k = false;
        }
        m524a(canvas);
        super.draw(canvas);
    }

    final void m530a(float f) {
        if (this.f346p != f) {
            this.f346p = f;
            invalidateSelf();
        }
    }

    private void m524a(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.f346p, this.f334d.centerX(), this.f334d.centerY());
        float f = (-this.f335e) - this.f339i;
        float f2 = this.f335e;
        Object obj = this.f334d.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f334d.height() - (2.0f * f2) > 0.0f ? 1 : null;
        float f3 = f2 / ((this.f340j - (this.f340j * 0.5f)) + f2);
        float f4 = f2 / ((this.f340j - (this.f340j * 0.25f)) + f2);
        float f5 = f2 / (f2 + (this.f340j - (this.f340j * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.f334d.left + f2, this.f334d.top + f2);
        canvas.scale(f3, f4);
        canvas.drawPath(this.f336f, this.f332b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f334d.width() - (2.0f * f2), -this.f335e, this.f333c);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f334d.right - f2, this.f334d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f336f, this.f332b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f334d.width() - (2.0f * f2), this.f339i + (-this.f335e), this.f333c);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f334d.left + f2, this.f334d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f336f, this.f332b);
        if (obj2 != null) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.f334d.height() - (2.0f * f2), -this.f335e, this.f333c);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.f334d.right - f2, this.f334d.top + f2);
        canvas.scale(f3, f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f336f, this.f332b);
        if (obj2 != null) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.f334d.height() - (2.0f * f2), -this.f335e, this.f333c);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
    }

    private void m528c() {
        RectF rectF = new RectF(-this.f335e, -this.f335e, this.f335e, this.f335e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f339i, -this.f339i);
        if (this.f336f == null) {
            this.f336f = new Path();
        } else {
            this.f336f.reset();
        }
        this.f336f.setFillType(FillType.EVEN_ODD);
        this.f336f.moveTo(-this.f335e, 0.0f);
        this.f336f.rLineTo(-this.f339i, 0.0f);
        this.f336f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f336f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f336f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.f335e / f;
            float f3 = f2 + ((1.0f - f2) / 2.0f);
            float[] fArr = new float[]{0.0f, f2, f3, 1.0f};
            f2 = 0.0f;
            this.f332b.setShader(new RadialGradient(0.0f, f2, f, new int[]{0, this.f342l, this.f343m, this.f344n}, fArr, TileMode.CLAMP));
        }
        f = 0.0f;
        this.f333c.setShader(new LinearGradient(0.0f, rectF.top, f, rectF2.top, new int[]{this.f342l, this.f343m, this.f344n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f333c.setAntiAlias(false);
    }

    private void m525a(Rect rect) {
        float f = this.f338h * 1.5f;
        this.f334d.set(((float) rect.left) + this.f338h, ((float) rect.top) + f, ((float) rect.right) - this.f338h, ((float) rect.bottom) - f);
        m522b().setBounds((int) this.f334d.left, (int) this.f334d.top, (int) this.f334d.right, (int) this.f334d.bottom);
        m528c();
    }

    public void m532b(float f) {
        m531a(f, this.f338h);
    }

    public float m529a() {
        return this.f340j;
    }
}
