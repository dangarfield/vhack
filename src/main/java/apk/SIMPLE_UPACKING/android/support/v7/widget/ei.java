package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p002h.bu;
import android.support.v4.p002h.p015a.AccessibilityEventCompat;
import android.support.v4.p002h.p015a.AccessibilityNodeInfoCompat;
import android.support.v4.p002h.p015a.aj;
import android.support.v7.p019d.R;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.C0001R;
import java.util.ArrayList;

/* compiled from: RecyclerView */
public abstract class ei {
    private boolean f1676a;
    private boolean f1677b;
    private boolean f1678c;
    private int f1679d;
    private int f1680e;
    bt f1681p;
    RecyclerView f1682q;
    et f1683r;
    boolean f1684s;

    public abstract ek m3500a();

    public ei() {
        this.f1676a = false;
        this.f1684s = false;
        this.f1677b = false;
        this.f1678c = true;
    }

    void m3545b(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f1682q = null;
            this.f1681p = null;
            this.f1679d = MeasureSpec.makeMeasureSpec(0, 1073741824);
            this.f1680e = MeasureSpec.makeMeasureSpec(0, 1073741824);
            return;
        }
        this.f1682q = recyclerView;
        this.f1681p = recyclerView.f144c;
        this.f1679d = MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824);
        this.f1680e = MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824);
    }

    void m3504a(int i, int i2) {
        this.f1679d = i;
        this.f1680e = i2;
    }

    void m3544b(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        int s = m3603s();
        if (s == 0) {
            this.f1682q.m196d(i, i2);
            return;
        }
        int i5 = 0;
        int i6 = Integer.MIN_VALUE;
        int i7 = Integer.MAX_VALUE;
        while (i5 < s) {
            View h = m3585h(i5);
            ek ekVar = (ek) h.getLayoutParams();
            int h2 = m3584h(h) - ekVar.leftMargin;
            int j = ekVar.rightMargin + m3588j(h);
            int i8 = m3586i(h) - ekVar.topMargin;
            int k = ekVar.bottomMargin + m3591k(h);
            if (h2 >= i7) {
                h2 = i7;
            }
            if (j <= i6) {
                j = i6;
            }
            if (i8 >= i3) {
                i8 = i3;
            }
            if (k <= i4) {
                k = i4;
            }
            i5++;
            i6 = j;
            i3 = i8;
            i7 = h2;
            i4 = k;
        }
        this.f1682q.f155p.set(i7, i3, i6, i4);
        m3506a(this.f1682q.f155p, i, i2);
    }

    public void m3506a(Rect rect, int i, int i2) {
        m3569d(m3479a(i, (rect.width() + m3608x()) + m3610z(), m3493C()), m3479a(i2, (rect.height() + m3609y()) + m3491A(), m3494D()));
    }

    public void m3595m() {
        if (this.f1682q != null) {
            this.f1682q.requestLayout();
        }
    }

    public static int m3479a(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(size, Math.max(i2, i3));
            case 1073741824:
                return size;
            default:
                return Math.max(i2, i3);
        }
    }

    public void m3529a(String str) {
        if (this.f1682q != null) {
            this.f1682q.m182a(str);
        }
    }

    public void m3563c(boolean z) {
        this.f1677b = z;
    }

    public boolean m3551b() {
        return false;
    }

    void m3557c(RecyclerView recyclerView) {
        this.f1684s = true;
        m3570d(recyclerView);
    }

    void m3547b(RecyclerView recyclerView, ep epVar) {
        this.f1684s = false;
        m3513a(recyclerView, epVar);
    }

    public boolean m3597n() {
        return this.f1684s;
    }

    public boolean m3540a(Runnable runnable) {
        if (this.f1682q != null) {
            return this.f1682q.removeCallbacks(runnable);
        }
        return false;
    }

    public void m3570d(RecyclerView recyclerView) {
    }

    @Deprecated
    public void m3574e(RecyclerView recyclerView) {
    }

    public void m3513a(RecyclerView recyclerView, ep epVar) {
        m3574e(recyclerView);
    }

    public boolean m3599o() {
        return this.f1682q != null && this.f1682q.f153n;
    }

    public void m3560c(ep epVar, ev evVar) {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public boolean m3535a(ek ekVar) {
        return ekVar != null;
    }

    public ek m3502a(LayoutParams layoutParams) {
        if (layoutParams instanceof ek) {
            return new ek((ek) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new ek((MarginLayoutParams) layoutParams);
        }
        return new ek(layoutParams);
    }

    public ek m3501a(Context context, AttributeSet attributeSet) {
        return new ek(context, attributeSet);
    }

    public int m3498a(int i, ep epVar, ev evVar) {
        return 0;
    }

    public int m3541b(int i, ep epVar, ev evVar) {
        return 0;
    }

    public boolean m3571d() {
        return false;
    }

    public boolean m3575e() {
        return false;
    }

    public void m3568d(int i) {
    }

    public boolean m3600p() {
        return this.f1683r != null && this.f1683r.m4458c();
    }

    public int m3601q() {
        return bu.m1951h(this.f1682q);
    }

    public void m3520a(View view) {
        m3521a(view, -1);
    }

    public void m3521a(View view, int i) {
        m3486a(view, i, true);
    }

    public void m3549b(View view) {
        m3550b(view, -1);
    }

    public void m3550b(View view, int i) {
        m3486a(view, i, false);
    }

    private void m3486a(View view, int i, boolean z) {
        ey c = RecyclerView.m138c(view);
        if (z || c.m4537q()) {
            this.f1682q.f145d.m4740e(c);
        } else {
            this.f1682q.f145d.m4741f(c);
        }
        ek ekVar = (ek) view.getLayoutParams();
        if (c.m4531k() || c.m4529i()) {
            if (c.m4529i()) {
                c.m4530j();
            } else {
                c.m4532l();
            }
            this.f1681p.m4083a(view, i, view.getLayoutParams(), false);
        } else if (view.getParent() == this.f1682q) {
            int b = this.f1681p.m4087b(view);
            if (i == -1) {
                i = this.f1681p.m4086b();
            }
            if (b == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1682q.indexOfChild(view));
            } else if (b != i) {
                this.f1682q.f146e.m3556c(b, i);
            }
        } else {
            this.f1681p.m4084a(view, i, false);
            ekVar.f2068c = true;
            if (this.f1683r != null && this.f1683r.m4458c()) {
                this.f1683r.m4456b(view);
            }
        }
        if (ekVar.f2069d) {
            c.f2195a.invalidate();
            ekVar.f2069d = false;
        }
    }

    public void m3561c(View view) {
        this.f1681p.m4082a(view);
    }

    public void m3579f(int i) {
        if (m3585h(i) != null) {
            this.f1681p.m4081a(i);
        }
    }

    public int m3602r() {
        return -1;
    }

    public int m3566d(View view) {
        return ((ek) view.getLayoutParams()).m4251e();
    }

    public View m3573e(View view) {
        if (this.f1682q == null) {
            return null;
        }
        View b = this.f1682q.m186b(view);
        if (b == null || this.f1681p.m4091c(b)) {
            return null;
        }
        return b;
    }

    public View m3555c(int i) {
        int s = m3603s();
        for (int i2 = 0; i2 < s; i2++) {
            View h = m3585h(i2);
            ey c = RecyclerView.m138c(h);
            if (c != null && c.m4524d() == i && !c.m4523c() && (this.f1682q.f148g.m4483a() || !c.m4537q())) {
                return h;
            }
        }
        return null;
    }

    public void m3583g(int i) {
        m3482a(i, m3585h(i));
    }

    private void m3482a(int i, View view) {
        this.f1681p.m4092d(i);
    }

    public void m3524a(View view, int i, ek ekVar) {
        ey c = RecyclerView.m138c(view);
        if (c.m4537q()) {
            this.f1682q.f145d.m4740e(c);
        } else {
            this.f1682q.f145d.m4741f(c);
        }
        this.f1681p.m4083a(view, i, ekVar, c.m4537q());
    }

    public void m3562c(View view, int i) {
        m3524a(view, i, (ek) view.getLayoutParams());
    }

    public void m3556c(int i, int i2) {
        View h = m3585h(i);
        if (h == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
        }
        m3583g(i);
        m3562c(h, i2);
    }

    public void m3527a(View view, ep epVar) {
        m3561c(view);
        epVar.m4422a(view);
    }

    public void m3505a(int i, ep epVar) {
        View h = m3585h(i);
        m3579f(i);
        epVar.m4422a(h);
    }

    public int m3603s() {
        return this.f1681p != null ? this.f1681p.m4086b() : 0;
    }

    public View m3585h(int i) {
        return this.f1681p != null ? this.f1681p.m4088b(i) : null;
    }

    public int m3604t() {
        return MeasureSpec.getMode(this.f1679d);
    }

    public int m3605u() {
        return MeasureSpec.getMode(this.f1680e);
    }

    public int m3606v() {
        return MeasureSpec.getSize(this.f1679d);
    }

    public int m3607w() {
        return MeasureSpec.getSize(this.f1680e);
    }

    public int m3608x() {
        return this.f1682q != null ? this.f1682q.getPaddingLeft() : 0;
    }

    public int m3609y() {
        return this.f1682q != null ? this.f1682q.getPaddingTop() : 0;
    }

    public int m3610z() {
        return this.f1682q != null ? this.f1682q.getPaddingRight() : 0;
    }

    public int m3491A() {
        return this.f1682q != null ? this.f1682q.getPaddingBottom() : 0;
    }

    public View m3492B() {
        if (this.f1682q == null) {
            return null;
        }
        View focusedChild = this.f1682q.getFocusedChild();
        if (focusedChild == null || this.f1681p.m4091c(focusedChild)) {
            return null;
        }
        return focusedChild;
    }

    public void m3587i(int i) {
        if (this.f1682q != null) {
            this.f1682q.m188b(i);
        }
    }

    public void m3589j(int i) {
        if (this.f1682q != null) {
            this.f1682q.m178a(i);
        }
    }

    public void m3515a(ep epVar) {
        for (int s = m3603s() - 1; s >= 0; s--) {
            m3484a(epVar, s, m3585h(s));
        }
    }

    private void m3484a(ep epVar, int i, View view) {
        ey c = RecyclerView.m138c(view);
        if (!c.m4523c()) {
            if (!c.m4534n() || c.m4537q() || this.f1682q.f156q.m4379b()) {
                m3583g(i);
                epVar.m4434c(view);
                this.f1682q.f145d.m4743h(c);
                return;
            }
            m3579f(i);
            epVar.m4428b(c);
        }
    }

    void m3548b(ep epVar) {
        int d = epVar.m4435d();
        for (int i = d - 1; i >= 0; i--) {
            View e = epVar.m4438e(i);
            ey c = RecyclerView.m138c(e);
            if (!c.m4523c()) {
                c.m4519a(false);
                if (c.m4538r()) {
                    this.f1682q.removeDetachedView(e, false);
                }
                if (this.f1682q.f147f != null) {
                    this.f1682q.f147f.m4156c(c);
                }
                c.m4519a(true);
                epVar.m4429b(e);
            }
        }
        epVar.m4439e();
        if (d > 0) {
            this.f1682q.invalidate();
        }
    }

    boolean m3538a(View view, int i, int i2, ek ekVar) {
        return (this.f1678c && m3489b(view.getMeasuredWidth(), i, ekVar.width) && m3489b(view.getMeasuredHeight(), i2, ekVar.height)) ? false : true;
    }

    boolean m3552b(View view, int i, int i2, ek ekVar) {
        return (!view.isLayoutRequested() && this.f1678c && m3489b(view.getWidth(), i, ekVar.width) && m3489b(view.getHeight(), i2, ekVar.height)) ? false : true;
    }

    private static boolean m3489b(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size < i) {
                    return false;
                }
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return true;
            case 1073741824:
                if (size != i) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public void m3522a(View view, int i, int i2) {
        ek ekVar = (ek) view.getLayoutParams();
        Rect g = this.f1682q.m203g(view);
        int i3 = (g.left + g.right) + i;
        int i4 = (g.bottom + g.top) + i2;
        i3 = m3480a(m3606v(), m3604t(), i3 + (((m3608x() + m3610z()) + ekVar.leftMargin) + ekVar.rightMargin), ekVar.width, m3571d());
        i4 = m3480a(m3607w(), m3605u(), i4 + (((m3609y() + m3491A()) + ekVar.topMargin) + ekVar.bottomMargin), ekVar.height, m3575e());
        if (m3552b(view, i3, i4, ekVar)) {
            view.measure(i3, i4);
        }
    }

    public static int m3480a(int i, int i2, int i3, int i4, boolean z) {
        int i5 = 0;
        int max = Math.max(0, i - i3);
        if (z) {
            if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                switch (i2) {
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        i5 = max;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                max = i5;
                i5 = i2;
            } else {
                if (i4 == -2) {
                    max = 0;
                }
                max = 0;
            }
        } else if (i4 >= 0) {
            i5 = 1073741824;
            max = i4;
        } else if (i4 == -1) {
            i5 = i2;
        } else {
            if (i4 == -2) {
                if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                    i5 = Integer.MIN_VALUE;
                }
            }
            max = 0;
        }
        return MeasureSpec.makeMeasureSpec(max, i5);
    }

    public int m3578f(View view) {
        Rect rect = ((ek) view.getLayoutParams()).f2067b;
        return rect.right + (view.getMeasuredWidth() + rect.left);
    }

    public int m3582g(View view) {
        Rect rect = ((ek) view.getLayoutParams()).f2067b;
        return rect.bottom + (view.getMeasuredHeight() + rect.top);
    }

    public void m3523a(View view, int i, int i2, int i3, int i4) {
        Rect rect = ((ek) view.getLayoutParams()).f2067b;
        view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
    }

    public int m3584h(View view) {
        return view.getLeft() - m3596n(view);
    }

    public int m3586i(View view) {
        return view.getTop() - m3593l(view);
    }

    public int m3588j(View view) {
        return view.getRight() + m3598o(view);
    }

    public int m3591k(View view) {
        return view.getBottom() + m3594m(view);
    }

    public void m3525a(View view, Rect rect) {
        if (this.f1682q == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(this.f1682q.m203g(view));
        }
    }

    public int m3593l(View view) {
        return ((ek) view.getLayoutParams()).f2067b.top;
    }

    public int m3594m(View view) {
        return ((ek) view.getLayoutParams()).f2067b.bottom;
    }

    public int m3596n(View view) {
        return ((ek) view.getLayoutParams()).f2067b.left;
    }

    public int m3598o(View view) {
        return ((ek) view.getLayoutParams()).f2067b.right;
    }

    public View m3503a(View view, int i, ep epVar, ev evVar) {
        return null;
    }

    public View m3567d(View view, int i) {
        return null;
    }

    public boolean m3532a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
        int x = m3608x();
        int y = m3609y();
        int v = m3606v() - m3610z();
        int w = m3607w() - m3491A();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - x);
        int min2 = Math.min(0, top - y);
        int max = Math.max(0, width - v);
        w = Math.max(0, height - w);
        if (m3601q() == 1) {
            if (max == 0) {
                max = Math.max(min, width - v);
            }
            min = max;
        } else {
            min = min != 0 ? min : Math.min(left - x, max);
        }
        max = min2 != 0 ? min2 : Math.min(top - y, w);
        if (min == 0 && max == 0) {
            return false;
        }
        if (z) {
            recyclerView.scrollBy(min, max);
        } else {
            recyclerView.m179a(min, max);
        }
        return true;
    }

    @Deprecated
    public boolean m3533a(RecyclerView recyclerView, View view, View view2) {
        return m3600p() || recyclerView.m209j();
    }

    public boolean m3531a(RecyclerView recyclerView, ev evVar, View view, View view2) {
        return m3533a(recyclerView, view, view2);
    }

    public void m3514a(dy dyVar, dy dyVar2) {
    }

    public boolean m3534a(RecyclerView recyclerView, ArrayList arrayList, int i, int i2) {
        return false;
    }

    public void m3509a(RecyclerView recyclerView) {
    }

    public void m3510a(RecyclerView recyclerView, int i, int i2) {
    }

    public void m3546b(RecyclerView recyclerView, int i, int i2) {
    }

    public void m3558c(RecyclerView recyclerView, int i, int i2) {
    }

    public void m3512a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m3558c(recyclerView, i, i2);
    }

    public void m3511a(RecyclerView recyclerView, int i, int i2, int i3) {
    }

    public int m3565d(ev evVar) {
        return 0;
    }

    public int m3543b(ev evVar) {
        return 0;
    }

    public int m3577f(ev evVar) {
        return 0;
    }

    public int m3572e(ev evVar) {
        return 0;
    }

    public int m3553c(ev evVar) {
        return 0;
    }

    public int m3581g(ev evVar) {
        return 0;
    }

    public void m3516a(ep epVar, ev evVar, int i, int i2) {
        this.f1682q.m196d(i, i2);
    }

    public void m3569d(int i, int i2) {
        this.f1682q.setMeasuredDimension(i, i2);
    }

    public int m3493C() {
        return bu.m1958o(this.f1682q);
    }

    public int m3494D() {
        return bu.m1959p(this.f1682q);
    }

    public Parcelable m3554c() {
        return null;
    }

    public void m3507a(Parcelable parcelable) {
    }

    void m3495E() {
        if (this.f1683r != null) {
            this.f1683r.m4452a();
        }
    }

    private void m3485a(et etVar) {
        if (this.f1683r == etVar) {
            this.f1683r = null;
        }
    }

    public void m3592k(int i) {
    }

    public void m3559c(ep epVar) {
        for (int s = m3603s() - 1; s >= 0; s--) {
            if (!RecyclerView.m138c(m3585h(s)).m4523c()) {
                m3505a(s, epVar);
            }
        }
    }

    void m3508a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        m3517a(this.f1682q.f142a, this.f1682q.f148g, accessibilityNodeInfoCompat);
    }

    public void m3517a(ep epVar, ev evVar, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (bu.m1938b(this.f1682q, -1) || bu.m1934a(this.f1682q, -1)) {
            accessibilityNodeInfoCompat.m1616a(8192);
            accessibilityNodeInfoCompat.m1620a(true);
        }
        if (bu.m1938b(this.f1682q, 1) || bu.m1934a(this.f1682q, 1)) {
            accessibilityNodeInfoCompat.m1616a(4096);
            accessibilityNodeInfoCompat.m1620a(true);
        }
        accessibilityNodeInfoCompat.m1619a(AccessibilityNodeInfoCompat.m1716a(m3499a(epVar, evVar), m3542b(epVar, evVar), m3576e(epVar, evVar), m3564d(epVar, evVar)));
    }

    public void m3528a(AccessibilityEvent accessibilityEvent) {
        m3519a(this.f1682q.f142a, this.f1682q.f148g, accessibilityEvent);
    }

    public void m3519a(ep epVar, ev evVar, AccessibilityEvent accessibilityEvent) {
        boolean z = true;
        aj a = AccessibilityEventCompat.m1546a(accessibilityEvent);
        if (this.f1682q != null && a != null) {
            if (!(bu.m1938b(this.f1682q, 1) || bu.m1938b(this.f1682q, -1) || bu.m1934a(this.f1682q, -1) || bu.m1934a(this.f1682q, 1))) {
                z = false;
            }
            a.m1566a(z);
            if (this.f1682q.f156q != null) {
                a.m1565a(this.f1682q.f156q.m4366a());
            }
        }
    }

    void m3526a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ey c = RecyclerView.m138c(view);
        if (c != null && !c.m4537q() && !this.f1681p.m4091c(c.f2195a)) {
            m3518a(this.f1682q.f142a, this.f1682q.f148g, view, accessibilityNodeInfoCompat);
        }
    }

    public void m3518a(ep epVar, ev evVar, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int d;
        int d2 = m3575e() ? m3566d(view) : 0;
        if (m3571d()) {
            d = m3566d(view);
        } else {
            d = 0;
        }
        accessibilityNodeInfoCompat.m1623b(AccessibilityNodeInfoCompat.m1717a(d2, 1, d, 1, false, false));
    }

    public void m3496F() {
        this.f1676a = true;
    }

    public int m3564d(ep epVar, ev evVar) {
        return 0;
    }

    public int m3499a(ep epVar, ev evVar) {
        if (this.f1682q == null || this.f1682q.f156q == null || !m3575e()) {
            return 1;
        }
        return this.f1682q.f156q.m4366a();
    }

    public int m3542b(ep epVar, ev evVar) {
        if (this.f1682q == null || this.f1682q.f156q == null || !m3571d()) {
            return 1;
        }
        return this.f1682q.f156q.m4366a();
    }

    public boolean m3576e(ep epVar, ev evVar) {
        return false;
    }

    boolean m3530a(int i, Bundle bundle) {
        return m3536a(this.f1682q.f142a, this.f1682q.f148g, i, bundle);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m3536a(android.support.v7.widget.ep r7, android.support.v7.widget.ev r8, int r9, android.os.Bundle r10) {
        /*
        r6 = this;
        r4 = -1;
        r2 = 1;
        r1 = 0;
        r0 = r6.f1682q;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        switch(r9) {
            case 4096: goto L_0x004a;
            case 8192: goto L_0x0018;
            default: goto L_0x000b;
        };
    L_0x000b:
        r0 = r1;
        r3 = r1;
    L_0x000d:
        if (r3 != 0) goto L_0x0011;
    L_0x000f:
        if (r0 == 0) goto L_0x0007;
    L_0x0011:
        r1 = r6.f1682q;
        r1.scrollBy(r0, r3);
        r1 = r2;
        goto L_0x0007;
    L_0x0018:
        r0 = r6.f1682q;
        r0 = android.support.v4.p002h.bu.m1938b(r0, r4);
        if (r0 == 0) goto L_0x007f;
    L_0x0020:
        r0 = r6.m3607w();
        r3 = r6.m3609y();
        r0 = r0 - r3;
        r3 = r6.m3491A();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x002f:
        r3 = r6.f1682q;
        r3 = android.support.v4.p002h.bu.m1934a(r3, r4);
        if (r3 == 0) goto L_0x007a;
    L_0x0037:
        r3 = r6.m3606v();
        r4 = r6.m3608x();
        r3 = r3 - r4;
        r4 = r6.m3610z();
        r3 = r3 - r4;
        r3 = -r3;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x004a:
        r0 = r6.f1682q;
        r0 = android.support.v4.p002h.bu.m1938b(r0, r2);
        if (r0 == 0) goto L_0x007d;
    L_0x0052:
        r0 = r6.m3607w();
        r3 = r6.m3609y();
        r0 = r0 - r3;
        r3 = r6.m3491A();
        r0 = r0 - r3;
    L_0x0060:
        r3 = r6.f1682q;
        r3 = android.support.v4.p002h.bu.m1934a(r3, r2);
        if (r3 == 0) goto L_0x007a;
    L_0x0068:
        r3 = r6.m3606v();
        r4 = r6.m3608x();
        r3 = r3 - r4;
        r4 = r6.m3610z();
        r3 = r3 - r4;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x007a:
        r3 = r0;
        r0 = r1;
        goto L_0x000d;
    L_0x007d:
        r0 = r1;
        goto L_0x0060;
    L_0x007f:
        r0 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ei.a(android.support.v7.widget.ep, android.support.v7.widget.ev, int, android.os.Bundle):boolean");
    }

    boolean m3539a(View view, int i, Bundle bundle) {
        return m3537a(this.f1682q.f142a, this.f1682q.f148g, view, i, bundle);
    }

    public boolean m3537a(ep epVar, ev evVar, View view, int i, Bundle bundle) {
        return false;
    }

    public static ej m3481a(Context context, AttributeSet attributeSet, int i, int i2) {
        ej ejVar = new ej();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.RecyclerView, i, i2);
        ejVar.f2145a = obtainStyledAttributes.getInt(R.RecyclerView_android_orientation, 1);
        ejVar.f2146b = obtainStyledAttributes.getInt(R.RecyclerView_spanCount, 1);
        ejVar.f2147c = obtainStyledAttributes.getBoolean(R.RecyclerView_reverseLayout, false);
        ejVar.f2148d = obtainStyledAttributes.getBoolean(R.RecyclerView_stackFromEnd, false);
        obtainStyledAttributes.recycle();
        return ejVar;
    }

    void m3580f(RecyclerView recyclerView) {
        m3504a(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    boolean m3590j() {
        return false;
    }

    boolean m3497G() {
        int s = m3603s();
        for (int i = 0; i < s; i++) {
            LayoutParams layoutParams = m3585h(i).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }
}
