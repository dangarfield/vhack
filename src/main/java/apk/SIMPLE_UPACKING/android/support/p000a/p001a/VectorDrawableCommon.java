package android.support.p000a.p001a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.p009c.p010a.DrawableCompat;
import android.util.AttributeSet;

@TargetApi(21)
/* renamed from: android.support.a.a.k */
abstract class VectorDrawableCommon extends Drawable {
    Drawable f6a;

    VectorDrawableCommon() {
    }

    static TypedArray m0b(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f6a != null) {
            this.f6a.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.f6a != null) {
            return DrawableCompat.m1318e(this.f6a);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.f6a != null) {
            return this.f6a.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f6a != null) {
            this.f6a.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f6a != null) {
            DrawableCompat.m1306a(this.f6a, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f6a != null) {
            DrawableCompat.m1308a(this.f6a, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f6a != null) {
            this.f6a.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.f6a != null) {
            DrawableCompat.m1305a(this.f6a);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.f6a != null) {
            DrawableCompat.m1313a(this.f6a, z);
        }
    }

    public boolean isAutoMirrored() {
        if (this.f6a != null) {
            DrawableCompat.m1315b(this.f6a);
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.f6a != null) {
            DrawableCompat.m1310a(this.f6a, theme);
        }
    }

    public int getLayoutDirection() {
        if (this.f6a != null) {
            DrawableCompat.m1320g(this.f6a);
        }
        return 0;
    }

    public void clearColorFilter() {
        if (this.f6a != null) {
            this.f6a.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.f6a != null) {
            return this.f6a.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.f6a != null) {
            return this.f6a.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.f6a != null) {
            return this.f6a.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.f6a != null) {
            return this.f6a.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.f6a != null) {
            return this.f6a.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.f6a != null) {
            return this.f6a.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.f6a != null) {
            this.f6a.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.f6a != null) {
            return this.f6a.setState(iArr);
        }
        return super.setState(iArr);
    }
}
