package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.p003c.p004a.DrawableWrapper;

/* compiled from: ListViewCompat */
class dm extends DrawableWrapper {
    private boolean f2127a;

    public dm(Drawable drawable) {
        super(drawable);
        this.f2127a = true;
    }

    void m4290a(boolean z) {
        this.f2127a = z;
    }

    public boolean setState(int[] iArr) {
        if (this.f2127a) {
            return super.setState(iArr);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        if (this.f2127a) {
            super.draw(canvas);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f2127a) {
            super.setHotspot(f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f2127a) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f2127a) {
            return super.setVisible(z, z2);
        }
        return false;
    }
}
