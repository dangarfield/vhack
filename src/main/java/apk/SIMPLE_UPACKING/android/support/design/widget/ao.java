package android.support.design.widget;

import android.content.Context;
import android.support.v4.p002h.az;
import android.support.v4.p002h.bp;
import android.support.v4.p002h.bu;
import android.support.v4.widget.as;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: HeaderBehavior */
abstract class ao extends cj {
    private Runnable f172a;
    private as f173b;
    private boolean f174c;
    private int f175d;
    private int f176e;
    private int f177f;
    private VelocityTracker f178g;

    public ao() {
        this.f175d = -1;
        this.f177f = -1;
    }

    public ao(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f175d = -1;
        this.f177f = -1;
    }

    public boolean m249a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f177f < 0) {
            this.f177f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f174c) {
            return true;
        }
        int y;
        switch (az.m1825a(motionEvent)) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.f174c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (m253c(view) && coordinatorLayout.m383a(view, x, y)) {
                    this.f176e = y;
                    this.f175d = az.m1828b(motionEvent, 0);
                    m243c();
                    break;
                }
            case ModuleDescriptor.MODULE_VERSION /*1*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.f174c = false;
                this.f175d = -1;
                if (this.f178g != null) {
                    this.f178g.recycle();
                    this.f178g = null;
                    break;
                }
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                y = this.f175d;
                if (y != -1) {
                    y = az.m1826a(motionEvent, y);
                    if (y != -1) {
                        y = (int) az.m1831d(motionEvent, y);
                        if (Math.abs(y - this.f176e) > this.f177f) {
                            this.f174c = true;
                            this.f176e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.f178g != null) {
            this.f178g.addMovement(motionEvent);
        }
        return this.f174c;
    }

    public boolean m252b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f177f < 0) {
            this.f177f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (az.m1825a(motionEvent)) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.m383a(view, (int) motionEvent.getX(), y) && m253c(view)) {
                    this.f176e = y;
                    this.f175d = az.m1828b(motionEvent, 0);
                    m243c();
                    break;
                }
                return false;
                break;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                if (this.f178g != null) {
                    this.f178g.addMovement(motionEvent);
                    this.f178g.computeCurrentVelocity(1000);
                    m248a(coordinatorLayout, view, -m246a(view), 0, bp.m1906b(this.f178g, this.f175d));
                    break;
                }
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                int a = az.m1826a(motionEvent, this.f175d);
                if (a != -1) {
                    a = (int) az.m1831d(motionEvent, a);
                    int i = this.f176e - a;
                    if (!this.f174c && Math.abs(i) > this.f177f) {
                        this.f174c = true;
                        i = i > 0 ? i - this.f177f : i + this.f177f;
                    }
                    if (this.f174c) {
                        this.f176e = a;
                        m250b(coordinatorLayout, view, i, m251b(view), 0);
                        break;
                    }
                }
                return false;
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                break;
        }
        this.f174c = false;
        this.f175d = -1;
        if (this.f178g != null) {
            this.f178g.recycle();
            this.f178g = null;
        }
        if (this.f178g != null) {
            this.f178g.addMovement(motionEvent);
        }
        return true;
    }

    int a_(CoordinatorLayout coordinatorLayout, View view, int i) {
        return m245a(coordinatorLayout, view, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int m245a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        int b = m240b();
        if (i2 == 0 || b < i2 || b > i3) {
            return 0;
        }
        int a = ar.m520a(i, i2, i3);
        if (b == a) {
            return 0;
        }
        m238a(a);
        return b - a;
    }

    int m244a() {
        return m240b();
    }

    final int m250b(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        return m245a(coordinatorLayout, view, m244a() - i, i2, i3);
    }

    final boolean m248a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, float f) {
        if (this.f172a != null) {
            view.removeCallbacks(this.f172a);
            this.f172a = null;
        }
        if (this.f173b == null) {
            this.f173b = as.m2532a(view.getContext());
        }
        this.f173b.m2536a(0, m240b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f173b.m2545g()) {
            this.f172a = new ap(this, coordinatorLayout, view);
            bu.m1931a(view, this.f172a);
            return true;
        }
        m247a(coordinatorLayout, view);
        return false;
    }

    void m247a(CoordinatorLayout coordinatorLayout, View view) {
    }

    boolean m253c(View view) {
        return false;
    }

    int m251b(View view) {
        return -view.getHeight();
    }

    int m246a(View view) {
        return view.getHeight();
    }

    private void m243c() {
        if (this.f178g == null) {
            this.f178g = VelocityTracker.obtain();
        }
    }
}
