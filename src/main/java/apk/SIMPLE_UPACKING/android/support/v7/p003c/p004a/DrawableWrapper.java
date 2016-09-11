package android.support.v7.p003c.p004a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p009c.p010a.DrawableCompat;

/* renamed from: android.support.v7.c.a.a */
public class DrawableWrapper extends Drawable implements Callback {
    private Drawable f330a;

    public DrawableWrapper(Drawable drawable) {
        m521a(drawable);
    }

    public void draw(Canvas canvas) {
        this.f330a.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.f330a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f330a.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f330a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f330a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f330a.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f330a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f330a.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f330a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f330a.setState(iArr);
    }

    public int[] getState() {
        return this.f330a.getState();
    }

    public void jumpToCurrentState() {
        DrawableCompat.m1305a(this.f330a);
    }

    public Drawable getCurrent() {
        return this.f330a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f330a.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f330a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f330a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f330a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f330a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f330a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f330a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f330a.getPadding(rect);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.f330a.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        DrawableCompat.m1313a(this.f330a, z);
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.m1315b(this.f330a);
    }

    public void setTint(int i) {
        DrawableCompat.m1307a(this.f330a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.m1309a(this.f330a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        DrawableCompat.m1312a(this.f330a, mode);
    }

    public void setHotspot(float f, float f2) {
        DrawableCompat.m1306a(this.f330a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        DrawableCompat.m1308a(this.f330a, i, i2, i3, i4);
    }

    public Drawable m522b() {
        return this.f330a;
    }

    public void m521a(Drawable drawable) {
        if (this.f330a != null) {
            this.f330a.setCallback(null);
        }
        this.f330a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
