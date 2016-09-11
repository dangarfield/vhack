package android.support.design.widget;

import android.support.v4.p002h.az;
import android.support.v4.widget.bj;
import android.support.v4.widget.bm;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public class SwipeDismissBehavior extends CoordinatorLayout {
    private bj f273a;
    private bp f274b;
    private boolean f275c;
    private float f276d;
    private boolean f277e;
    private int f278f;
    private float f279g;
    private float f280h;
    private float f281i;
    private final bm f282j;

    public SwipeDismissBehavior() {
        this.f276d = 0.0f;
        this.f278f = 2;
        this.f279g = 0.5f;
        this.f280h = 0.0f;
        this.f281i = 0.5f;
        this.f282j = new bo(this);
    }

    public void m451a(bp bpVar) {
        this.f274b = bpVar;
    }

    public void m450a(int i) {
        this.f278f = i;
    }

    public void m449a(float f) {
        this.f280h = m444c(0.0f, f, 1.0f);
    }

    public void m454b(float f) {
        this.f281i = m444c(0.0f, f, 1.0f);
    }

    public boolean m452a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        switch (az.m1825a(motionEvent)) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                if (this.f275c) {
                    this.f275c = false;
                    return false;
                }
                break;
            default:
                boolean z;
                if (coordinatorLayout.m383a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    z = false;
                } else {
                    z = true;
                }
                this.f275c = z;
                break;
        }
        if (this.f275c) {
            return false;
        }
        m440a((ViewGroup) coordinatorLayout);
        return this.f273a.m2636a(motionEvent);
    }

    public boolean m455b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f273a == null) {
            return false;
        }
        this.f273a.m2641b(motionEvent);
        return true;
    }

    public boolean m453a(View view) {
        return true;
    }

    private void m440a(ViewGroup viewGroup) {
        if (this.f273a == null) {
            this.f273a = this.f277e ? bj.m2615a(viewGroup, this.f276d, this.f282j) : bj.m2616a(viewGroup, this.f282j);
        }
    }

    private static float m444c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    private static int m442b(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    static float m437a(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
