package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p009c.p010a.DrawableCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.android.gms.C0001R;
import java.lang.reflect.Field;

/* compiled from: ListViewCompat */
public class dl extends ListView {
    private static final int[] f2106g;
    final Rect f2107a;
    int f2108b;
    int f2109c;
    int f2110d;
    int f2111e;
    protected int f2112f;
    private Field f2113h;
    private dm f2114i;

    static {
        f2106g = new int[]{0};
    }

    public dl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2107a = new Rect();
        this.f2108b = 0;
        this.f2109c = 0;
        this.f2110d = 0;
        this.f2111e = 0;
        try {
            this.f2113h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2113h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.f2114i = drawable != null ? new dm(drawable) : null;
        super.setSelector(this.f2114i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2108b = rect.left;
        this.f2109c = rect.top;
        this.f2110d = rect.right;
        this.f2111e = rect.bottom;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m4281b();
    }

    protected void dispatchDraw(Canvas canvas) {
        m4279a(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.f2112f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void m4281b() {
        Drawable selector = getSelector();
        if (selector != null && m4283c()) {
            selector.setState(getDrawableState());
        }
    }

    protected boolean m4283c() {
        return m4280a() && isPressed();
    }

    protected boolean m4280a() {
        return false;
    }

    protected void m4279a(Canvas canvas) {
        if (!this.f2107a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f2107a);
                selector.draw(canvas);
            }
        }
    }

    protected void m4278a(int i, View view, float f, float f2) {
        m4277a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            DrawableCompat.m1306a(selector, f, f2);
        }
    }

    protected void m4277a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m4282b(i, view);
        if (z2) {
            Rect rect = this.f2107a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            DrawableCompat.m1306a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m4282b(int i, View view) {
        Rect rect = this.f2107a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2108b;
        rect.top -= this.f2109c;
        rect.right += this.f2110d;
        rect.bottom += this.f2111e;
        try {
            boolean z = this.f2113h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f2113h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int m4276a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, listPaddingTop);
            view.forceLayout();
            if (i8 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingTop += view.getMeasuredHeight();
            if (listPaddingTop < i4) {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            } else if (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) {
                return i4;
            } else {
                return i6;
            }
        }
        return listPaddingBottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f2114i != null) {
            this.f2114i.m4290a(z);
        }
    }
}
