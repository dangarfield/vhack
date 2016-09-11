package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    Drawable f1586a;
    Drawable f1587b;
    Drawable f1588c;
    boolean f1589d;
    boolean f1590e;
    private boolean f1591f;
    private View f1592g;
    private View f1593h;
    private View f1594i;
    private int f1595j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable actionBarBackgroundDrawableV21;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            actionBarBackgroundDrawableV21 = new ActionBarBackgroundDrawableV21(this);
        } else {
            actionBarBackgroundDrawableV21 = new ActionBarBackgroundDrawable(this);
        }
        setBackgroundDrawable(actionBarBackgroundDrawableV21);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.ActionBar);
        this.f1586a = obtainStyledAttributes.getDrawable(R.ActionBar_background);
        this.f1587b = obtainStyledAttributes.getDrawable(R.ActionBar_backgroundStacked);
        this.f1595j = obtainStyledAttributes.getDimensionPixelSize(R.ActionBar_height, -1);
        if (getId() == R.split_action_bar) {
            this.f1589d = true;
            this.f1588c = obtainStyledAttributes.getDrawable(R.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f1589d ? this.f1588c == null : this.f1586a == null && this.f1587b == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1593h = findViewById(R.action_bar);
        this.f1594i = findViewById(R.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1586a != null) {
            this.f1586a.setCallback(null);
            unscheduleDrawable(this.f1586a);
        }
        this.f1586a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1593h != null) {
                this.f1586a.setBounds(this.f1593h.getLeft(), this.f1593h.getTop(), this.f1593h.getRight(), this.f1593h.getBottom());
            }
        }
        if (this.f1589d) {
            if (this.f1588c != null) {
                z = false;
            }
        } else if (!(this.f1586a == null && this.f1587b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1587b != null) {
            this.f1587b.setCallback(null);
            unscheduleDrawable(this.f1587b);
        }
        this.f1587b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1590e && this.f1587b != null) {
                this.f1587b.setBounds(this.f1592g.getLeft(), this.f1592g.getTop(), this.f1592g.getRight(), this.f1592g.getBottom());
            }
        }
        if (this.f1589d) {
            if (this.f1588c != null) {
                z = false;
            }
        } else if (!(this.f1586a == null && this.f1587b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1588c != null) {
            this.f1588c.setCallback(null);
            unscheduleDrawable(this.f1588c);
        }
        this.f1588c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1589d && this.f1588c != null) {
                this.f1588c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1589d) {
            if (this.f1588c != null) {
                z = false;
            }
        } else if (!(this.f1586a == null && this.f1587b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1586a != null) {
            this.f1586a.setVisible(z, false);
        }
        if (this.f1587b != null) {
            this.f1587b.setVisible(z, false);
        }
        if (this.f1588c != null) {
            this.f1588c.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1586a && !this.f1589d) || ((drawable == this.f1587b && this.f1590e) || ((drawable == this.f1588c && this.f1589d) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1586a != null && this.f1586a.isStateful()) {
            this.f1586a.setState(getDrawableState());
        }
        if (this.f1587b != null && this.f1587b.isStateful()) {
            this.f1587b.setState(getDrawableState());
        }
        if (this.f1588c != null && this.f1588c.isStateful()) {
            this.f1588c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1586a != null) {
                this.f1586a.jumpToCurrentState();
            }
            if (this.f1587b != null) {
                this.f1587b.jumpToCurrentState();
            }
            if (this.f1588c != null) {
                this.f1588c.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.f1591f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1591f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(fd fdVar) {
        if (this.f1592g != null) {
            removeView(this.f1592g);
        }
        this.f1592g = fdVar;
        if (fdVar != null) {
            addView(fdVar);
            LayoutParams layoutParams = fdVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            fdVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f1592g;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    private boolean m3391a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m3392b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.f1593h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1595j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f1595j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1593h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f1592g != null && this.f1592g.getVisibility() != 8 && mode != 1073741824) {
                int b;
                if (!m3391a(this.f1593h)) {
                    b = m3392b(this.f1593h);
                } else if (m3391a(this.f1594i)) {
                    b = 0;
                } else {
                    b = m3392b(this.f1594i);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m3392b(this.f1592g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1592g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1589d) {
            int i6;
            if (this.f1586a != null) {
                if (this.f1593h.getVisibility() == 0) {
                    this.f1586a.setBounds(this.f1593h.getLeft(), this.f1593h.getTop(), this.f1593h.getRight(), this.f1593h.getBottom());
                } else if (this.f1594i == null || this.f1594i.getVisibility() != 0) {
                    this.f1586a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1586a.setBounds(this.f1594i.getLeft(), this.f1594i.getTop(), this.f1594i.getRight(), this.f1594i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f1590e = z2;
            if (!z2 || this.f1587b == null) {
                i5 = i6;
            } else {
                this.f1587b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1588c != null) {
            this.f1588c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
