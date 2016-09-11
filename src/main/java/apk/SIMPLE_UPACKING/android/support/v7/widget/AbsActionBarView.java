package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p002h.az;
import android.support.v4.p002h.bu;
import android.support.v4.p002h.di;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* renamed from: android.support.v7.widget.a */
abstract class AbsActionBarView extends ViewGroup {
    protected final AbsActionBarView f1596a;
    protected final Context f1597b;
    protected ActionMenuView f1598c;
    protected ActionMenuPresenter f1599d;
    protected int f1600e;
    protected di f1601f;
    private boolean f1602g;
    private boolean f1603h;

    AbsActionBarView(Context context) {
        this(context, null);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1596a = new AbsActionBarView(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1597b = context;
        } else {
            this.f1597b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.ActionBar, R.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1599d != null) {
            this.f1599d.m4768a(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = az.m1825a(motionEvent);
        if (a == 0) {
            this.f1602g = false;
        }
        if (!this.f1602g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1602g = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1602g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = az.m1825a(motionEvent);
        if (a == 9) {
            this.f1603h = false;
        }
        if (!this.f1603h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1603h = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1603h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1600e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f1600e;
    }

    public int getAnimatedVisibility() {
        if (this.f1601f != null) {
            return this.f1596a.f1910a;
        }
        return getVisibility();
    }

    public di m3398a(int i, long j) {
        if (this.f1601f != null) {
            this.f1601f.m2291b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                bu.m1939c((View) this, 0.0f);
            }
            di a = bu.m1960q(this).m2284a(1.0f);
            a.m2285a(j);
            a.m2286a(this.f1596a.m4005a(a, i));
            return a;
        }
        a = bu.m1960q(this).m2284a(0.0f);
        a.m2285a(j);
        a.m2286a(this.f1596a.m4005a(a, i));
        return a;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1601f != null) {
                this.f1601f.m2291b();
            }
            super.setVisibility(i);
        }
    }

    public boolean m3399a() {
        if (this.f1599d != null) {
            return this.f1599d.m4782d();
        }
        return false;
    }

    protected int m3396a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected static int m3393a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m3397a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
