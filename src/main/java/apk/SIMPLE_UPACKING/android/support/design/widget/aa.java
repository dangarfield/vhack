package android.support.design.widget;

import android.graphics.drawable.Drawable;

/* compiled from: FloatingActionButton */
class aa implements at {
    final /* synthetic */ FloatingActionButton f288a;

    private aa(FloatingActionButton floatingActionButton) {
        this.f288a = floatingActionButton;
    }

    public float m462a() {
        return ((float) this.f288a.getSizeDimension()) / 2.0f;
    }

    public void m463a(int i, int i2, int i3, int i4) {
        this.f288a.f258g.set(i, i2, i3, i4);
        this.f288a.setPadding(this.f288a.f256e + i, this.f288a.f256e + i2, this.f288a.f256e + i3, this.f288a.f256e + i4);
    }

    public void m464a(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public boolean m465b() {
        return this.f288a.f257f;
    }
}
