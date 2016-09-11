package android.support.v7.widget;

import android.util.Log;
import android.view.animation.Interpolator;

/* compiled from: RecyclerView */
public class eu {
    private int f2168a;
    private int f2169b;
    private int f2170c;
    private int f2171d;
    private Interpolator f2172e;
    private boolean f2173f;
    private int f2174g;

    boolean m4464a() {
        return this.f2171d >= 0;
    }

    private void m4461a(RecyclerView recyclerView) {
        if (this.f2171d >= 0) {
            int i = this.f2171d;
            this.f2171d = -1;
            recyclerView.m146e(i);
            this.f2173f = false;
        } else if (this.f2173f) {
            m4463b();
            if (this.f2172e != null) {
                recyclerView.ab.m4497a(this.f2168a, this.f2169b, this.f2170c, this.f2172e);
            } else if (this.f2170c == Integer.MIN_VALUE) {
                recyclerView.ab.m4499b(this.f2168a, this.f2169b);
            } else {
                recyclerView.ab.m4495a(this.f2168a, this.f2169b, this.f2170c);
            }
            this.f2174g++;
            if (this.f2174g > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.f2173f = false;
        } else {
            this.f2174g = 0;
        }
    }

    private void m4463b() {
        if (this.f2172e != null && this.f2170c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (this.f2170c < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
    }
}
