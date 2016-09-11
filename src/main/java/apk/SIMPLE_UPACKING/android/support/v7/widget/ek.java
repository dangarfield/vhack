package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: RecyclerView */
public class ek extends MarginLayoutParams {
    ey f2066a;
    final Rect f2067b;
    boolean f2068c;
    boolean f2069d;

    public ek(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2067b = new Rect();
        this.f2068c = true;
        this.f2069d = false;
    }

    public ek(int i, int i2) {
        super(i, i2);
        this.f2067b = new Rect();
        this.f2068c = true;
        this.f2069d = false;
    }

    public ek(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f2067b = new Rect();
        this.f2068c = true;
        this.f2069d = false;
    }

    public ek(LayoutParams layoutParams) {
        super(layoutParams);
        this.f2067b = new Rect();
        this.f2068c = true;
        this.f2069d = false;
    }

    public ek(ek ekVar) {
        super(ekVar);
        this.f2067b = new Rect();
        this.f2068c = true;
        this.f2069d = false;
    }

    public boolean m4249c() {
        return this.f2066a.m4537q();
    }

    public boolean m4250d() {
        return this.f2066a.m4544x();
    }

    public int m4251e() {
        return this.f2066a.m4524d();
    }
}
