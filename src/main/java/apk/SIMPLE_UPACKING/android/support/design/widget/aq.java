package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.p002h.GravityCompat;
import android.support.v4.p002h.bu;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

/* compiled from: HeaderScrollingViewBehavior */
abstract class aq extends cj {
    private final Rect f188a;
    private final Rect f189b;
    private int f190c;
    private int f191d;

    abstract View m292a(List list);

    public aq() {
        this.f188a = new Rect();
        this.f189b = new Rect();
        this.f190c = 0;
    }

    public aq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f188a = new Rect();
        this.f189b = new Rect();
        this.f190c = 0;
    }

    public boolean m293a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View a = m292a(coordinatorLayout.m393d(view));
            if (a != null) {
                if (bu.m1963t(a) && !bu.m1963t(view)) {
                    bu.m1933a(view, true);
                    if (bu.m1963t(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                if (bu.m1915A(a)) {
                    int size = MeasureSpec.getSize(i3);
                    if (size == 0) {
                        size = coordinatorLayout.getHeight();
                    }
                    coordinatorLayout.m378a(view, i, i2, MeasureSpec.makeMeasureSpec(m294b(a) + (size - a.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                    return true;
                }
            }
        }
        return false;
    }

    protected void m296b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View a = m292a(coordinatorLayout.m393d(view));
        if (a != null) {
            CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) view.getLayoutParams();
            Rect rect = this.f188a;
            rect.set(coordinatorLayout.getPaddingLeft() + coordinatorLayout2.leftMargin, a.getBottom() + coordinatorLayout2.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - coordinatorLayout2.rightMargin, ((coordinatorLayout.getHeight() + a.getBottom()) - coordinatorLayout.getPaddingBottom()) - coordinatorLayout2.bottomMargin);
            Rect rect2 = this.f189b;
            GravityCompat.m2408a(m289c(coordinatorLayout2.f437c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = m297c(a);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.f190c = rect2.top - a.getBottom();
            return;
        }
        super.m241b(coordinatorLayout, view, i);
        this.f190c = 0;
    }

    float m290a(View view) {
        return 1.0f;
    }

    final int m297c(View view) {
        return this.f191d == 0 ? 0 : ar.m520a(Math.round(m290a(view) * ((float) this.f191d)), 0, this.f191d);
    }

    private static int m289c(int i) {
        return i == 0 ? 8388659 : i;
    }

    int m294b(View view) {
        return view.getMeasuredHeight();
    }

    final int m291a() {
        return this.f190c;
    }

    public final void m295b(int i) {
        this.f191d = i;
    }
}
