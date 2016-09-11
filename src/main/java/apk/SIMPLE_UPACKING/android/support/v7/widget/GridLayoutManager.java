package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.p002h.p015a.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean f1698a;
    int f1699b;
    int[] f1700c;
    View[] f1701d;
    final SparseIntArray f1702e;
    final SparseIntArray f1703f;
    cq f1704g;
    final Rect f1705h;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1698a = false;
        this.f1699b = -1;
        this.f1702e = new SparseIntArray();
        this.f1703f = new SparseIntArray();
        this.f1704g = new co();
        this.f1705h = new Rect();
        m3698a(ei.m3481a(context, attributeSet, i, i2).f2146b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f1698a = false;
        this.f1699b = -1;
        this.f1702e = new SparseIntArray();
        this.f1703f = new SparseIntArray();
        this.f1704g = new co();
        this.f1705h = new Rect();
        m3698a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f1698a = false;
        this.f1699b = -1;
        this.f1702e = new SparseIntArray();
        this.f1703f = new SparseIntArray();
        this.f1704g = new co();
        this.f1705h = new Rect();
        m3698a(i);
    }

    public void m3707a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.m3651a(false);
    }

    public int m3692a(ep epVar, ev evVar) {
        if (this.i == 0) {
            return this.f1699b;
        }
        if (evVar.m4487e() < 1) {
            return 0;
        }
        return m3681a(epVar, evVar, evVar.m4487e() - 1) + 1;
    }

    public int m3710b(ep epVar, ev evVar) {
        if (this.i == 1) {
            return this.f1699b;
        }
        if (evVar.m4487e() < 1) {
            return 0;
        }
        return m3681a(epVar, evVar, evVar.m4487e() - 1) + 1;
    }

    public void m3706a(ep epVar, ev evVar, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof cp) {
            cp cpVar = (cp) layoutParams;
            int a = m3681a(epVar, evVar, cpVar.m4251e());
            if (this.i == 0) {
                int a2 = cpVar.m4256a();
                int b = cpVar.m4257b();
                boolean z = this.f1699b > 1 && cpVar.m4257b() == this.f1699b;
                accessibilityNodeInfoCompat.m1623b(AccessibilityNodeInfoCompat.m1717a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = cpVar.m4256a();
            int b2 = cpVar.m4257b();
            boolean z2 = this.f1699b > 1 && cpVar.m4257b() == this.f1699b;
            accessibilityNodeInfoCompat.m1623b(AccessibilityNodeInfoCompat.m1717a(a, 1, a3, b2, z2, false));
            return;
        }
        super.m3526a(view, accessibilityNodeInfoCompat);
    }

    public void m3713c(ep epVar, ev evVar) {
        if (evVar.m4483a()) {
            m3678I();
        }
        super.m3661c(epVar, evVar);
        m3677H();
        if (!evVar.m4483a()) {
            this.f1698a = false;
        }
    }

    private void m3677H() {
        this.f1702e.clear();
        this.f1703f.clear();
    }

    private void m3678I() {
        int s = m3603s();
        for (int i = 0; i < s; i++) {
            cp cpVar = (cp) m3585h(i).getLayoutParams();
            int e = cpVar.m4251e();
            this.f1702e.put(e, cpVar.m4257b());
            this.f1703f.put(e, cpVar.m4256a());
        }
    }

    public void m3701a(RecyclerView recyclerView, int i, int i2) {
        this.f1704g.m4243a();
    }

    public void m3700a(RecyclerView recyclerView) {
        this.f1704g.m4243a();
    }

    public void m3711b(RecyclerView recyclerView, int i, int i2) {
        this.f1704g.m4243a();
    }

    public void m3703a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f1704g.m4243a();
    }

    public void m3702a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f1704g.m4243a();
    }

    public ek m3693a() {
        if (this.i == 0) {
            return new cp(-2, -1);
        }
        return new cp(-1, -2);
    }

    public ek m3694a(Context context, AttributeSet attributeSet) {
        return new cp(context, attributeSet);
    }

    public ek m3695a(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new cp((MarginLayoutParams) layoutParams);
        }
        return new cp(layoutParams);
    }

    public boolean m3708a(ek ekVar) {
        return ekVar instanceof cp;
    }

    private void m3679J() {
        int v;
        if (m3668f() == 1) {
            v = (m3606v() - m3610z()) - m3608x();
        } else {
            v = (m3607w() - m3491A()) - m3609y();
        }
        m3690l(v);
    }

    public void m3699a(Rect rect, int i, int i2) {
        if (this.f1700c == null) {
            super.m3506a(rect, i, i2);
        }
        int z = m3610z() + m3608x();
        int y = m3609y() + m3491A();
        if (this.i == 1) {
            y = ei.m3479a(i2, y + rect.height(), m3494D());
            z = ei.m3479a(i, z + this.f1700c[this.f1700c.length - 1], m3493C());
        } else {
            z = ei.m3479a(i, z + rect.width(), m3493C());
            y = ei.m3479a(i2, y + this.f1700c[this.f1700c.length - 1], m3494D());
        }
        m3569d(z, y);
    }

    private void m3690l(int i) {
        this.f1700c = m3685a(this.f1700c, this.f1699b, i);
    }

    static int[] m3685a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    void m3704a(ep epVar, ev evVar, cu cuVar, int i) {
        super.m3647a(epVar, evVar, cuVar, i);
        m3679J();
        if (evVar.m4487e() > 0 && !evVar.m4483a()) {
            m3688b(epVar, evVar, cuVar, i);
        }
        m3680K();
    }

    private void m3680K() {
        if (this.f1701d == null || this.f1701d.length != this.f1699b) {
            this.f1701d = new View[this.f1699b];
        }
    }

    public int m3691a(int i, ep epVar, ev evVar) {
        m3679J();
        m3680K();
        return super.m3638a(i, epVar, evVar);
    }

    public int m3709b(int i, ep epVar, ev evVar) {
        m3679J();
        m3680K();
        return super.m3652b(i, epVar, evVar);
    }

    private void m3688b(ep epVar, ev evVar, cu cuVar, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = m3687b(epVar, evVar, cuVar.f2083a);
        if (obj != null) {
            while (b > 0 && cuVar.f2083a > 0) {
                cuVar.f2083a--;
                b = m3687b(epVar, evVar, cuVar.f2083a);
            }
            return;
        }
        int e = evVar.m4487e() - 1;
        int i2 = cuVar.f2083a;
        int i3 = b;
        while (i2 < e) {
            b = m3687b(epVar, evVar, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        cuVar.f2083a = i2;
    }

    View m3696a(ep epVar, ev evVar, int i, int i2, int i3) {
        View view = null;
        m3672h();
        int c = this.j.m4305c();
        int d = this.j.m4307d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m3585h(i);
            int d2 = m3566d(h);
            if (d2 >= 0 && d2 < i3) {
                if (m3687b(epVar, evVar, d2) != 0) {
                    view3 = view;
                    h = view2;
                } else if (((ek) h.getLayoutParams()).m4249c()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.j.m4300a(h) < d && this.j.m4304b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = h;
            }
            view3 = view;
            h = view2;
            i += i4;
            view = view3;
            view2 = h;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    private int m3681a(ep epVar, ev evVar, int i) {
        if (!evVar.m4483a()) {
            return this.f1704g.m4246c(i, this.f1699b);
        }
        int b = epVar.m4424b(i);
        if (b != -1) {
            return this.f1704g.m4246c(b, this.f1699b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int m3687b(ep epVar, ev evVar, int i) {
        if (!evVar.m4483a()) {
            return this.f1704g.m4245b(i, this.f1699b);
        }
        int i2 = this.f1703f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = epVar.m4424b(i);
        if (i2 != -1) {
            return this.f1704g.m4245b(i2, this.f1699b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int m3689c(ep epVar, ev evVar, int i) {
        if (!evVar.m4483a()) {
            return this.f1704g.m4241a(i);
        }
        int i2 = this.f1702e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = epVar.m4424b(i);
        if (i2 != -1) {
            return this.f1704g.m4241a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    void m3705a(ep epVar, ev evVar, cw cwVar, cv cvVar) {
        int i = this.j.m4313i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = m3603s() > 0 ? this.f1700c[this.f1699b] : 0;
        if (obj != null) {
            m3679J();
        }
        boolean z = cwVar.f2095e == 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f1699b;
        if (!z) {
            i5 = m3687b(epVar, evVar, cwVar.f2094d) + m3689c(epVar, evVar, cwVar.f2094d);
        }
        while (i3 < this.f1699b && cwVar.m4271a(evVar) && i5 > 0) {
            int i6 = cwVar.f2094d;
            int c = m3689c(epVar, evVar, i6);
            if (c <= this.f1699b) {
                i5 -= c;
                if (i5 >= 0) {
                    View a = cwVar.m4268a(epVar);
                    if (a == null) {
                        break;
                    }
                    i4 += c;
                    this.f1701d[i3] = a;
                    i3++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i6 + " requires " + c + " spans but GridLayoutManager has only " + this.f1699b + " spans.");
        }
        if (i3 == 0) {
            cvVar.f2088b = true;
            return;
        }
        View view;
        int a2;
        int a3;
        m3683a(epVar, evVar, i3, i4, z);
        int i7 = 0;
        float f = 0.0f;
        c = 0;
        while (i7 < i3) {
            View view2 = this.f1701d[i7];
            if (cwVar.f2101k == null) {
                if (z) {
                    m3549b(view2);
                } else {
                    m3550b(view2, 0);
                }
            } else if (z) {
                m3520a(view2);
            } else {
                m3521a(view2, 0);
            }
            cp cpVar = (cp) view2.getLayoutParams();
            int a4 = ei.m3480a(this.f1700c[cpVar.f2070e + cpVar.f2071f] - this.f1700c[cpVar.f2070e], i, 0, this.i == 0 ? cpVar.height : cpVar.width, false);
            int a5 = ei.m3480a(this.j.m4310f(), this.j.m4312h(), 0, this.i == 1 ? cpVar.height : cpVar.width, true);
            if (this.i == 1) {
                m3684a(view2, a4, a5, cpVar.height == -1, false);
            } else {
                m3684a(view2, a5, a4, cpVar.width == -1, false);
            }
            i6 = this.j.m4306c(view2);
            if (i6 <= c) {
                i6 = c;
            }
            float d = (1.0f * ((float) this.j.m4308d(view2))) / ((float) cpVar.f2071f);
            if (d <= f) {
                d = f;
            }
            i7++;
            f = d;
            c = i6;
        }
        if (obj != null) {
            m3682a(f, i2);
            c = 0;
            int i8 = 0;
            while (i8 < i3) {
                view = this.f1701d[i8];
                cpVar = (cp) view.getLayoutParams();
                a2 = ei.m3480a(this.f1700c[cpVar.f2070e + cpVar.f2071f] - this.f1700c[cpVar.f2070e], 1073741824, 0, this.i == 0 ? cpVar.height : cpVar.width, false);
                a3 = ei.m3480a(this.j.m4310f(), this.j.m4312h(), 0, this.i == 1 ? cpVar.height : cpVar.width, true);
                if (this.i == 1) {
                    m3684a(view, a2, a3, false, true);
                } else {
                    m3684a(view, a3, a2, false, true);
                }
                i5 = this.j.m4306c(view);
                if (i5 <= c) {
                    i5 = c;
                }
                i8++;
                c = i5;
            }
        }
        a3 = MeasureSpec.makeMeasureSpec(c, 1073741824);
        for (i6 = 0; i6 < i3; i6++) {
            view = this.f1701d[i6];
            if (this.j.m4306c(view) != c) {
                cpVar = (cp) view.getLayoutParams();
                a2 = ei.m3480a(this.f1700c[cpVar.f2070e + cpVar.f2071f] - this.f1700c[cpVar.f2070e], 1073741824, 0, this.i == 0 ? cpVar.height : cpVar.width, false);
                if (this.i == 1) {
                    m3684a(view, a2, a3, true, true);
                } else {
                    m3684a(view, a3, a2, true, true);
                }
            }
        }
        cvVar.f2087a = c;
        i6 = 0;
        i5 = 0;
        if (this.i == 1) {
            if (cwVar.f2096f == -1) {
                i5 = cwVar.f2092b;
                i6 = i5 - c;
                c = 0;
                i4 = 0;
            } else {
                i6 = cwVar.f2092b;
                i5 = i6 + c;
                c = 0;
                i4 = 0;
            }
        } else if (cwVar.f2096f == -1) {
            i4 = cwVar.f2092b;
            int i9 = i4;
            i4 -= c;
            c = i9;
        } else {
            i4 = cwVar.f2092b;
            c += i4;
        }
        int i10 = 0;
        a2 = i4;
        i4 = c;
        c = i6;
        i6 = i5;
        while (i10 < i3) {
            int i11;
            int i12;
            view = this.f1701d[i10];
            cpVar = (cp) view.getLayoutParams();
            if (this.i != 1) {
                c = this.f1700c[cpVar.f2070e] + m3609y();
                i6 = this.j.m4308d(view) + c;
                i11 = i4;
                i12 = a2;
            } else if (m3671g()) {
                i4 = m3608x() + this.f1700c[cpVar.f2070e + cpVar.f2071f];
                i11 = i4;
                i12 = i4 - this.j.m4308d(view);
            } else {
                a2 = this.f1700c[cpVar.f2070e] + m3608x();
                i11 = this.j.m4308d(view) + a2;
                i12 = a2;
            }
            m3523a(view, i12 + cpVar.leftMargin, c + cpVar.topMargin, i11 - cpVar.rightMargin, i6 - cpVar.bottomMargin);
            if (cpVar.m4249c() || cpVar.m4250d()) {
                cvVar.f2089c = true;
            }
            cvVar.f2090d |= view.isFocusable();
            i10++;
            i4 = i11;
            a2 = i12;
        }
        Arrays.fill(this.f1701d, null);
    }

    private void m3682a(float f, int i) {
        m3690l(Math.max(Math.round(((float) this.f1699b) * f), i));
    }

    private void m3684a(View view, int i, int i2, boolean z, boolean z2) {
        boolean a;
        m3525a(view, this.f1705h);
        ek ekVar = (ek) view.getLayoutParams();
        if (z || this.i == 1) {
            i = m3686b(i, ekVar.leftMargin + this.f1705h.left, ekVar.rightMargin + this.f1705h.right);
        }
        if (z || this.i == 0) {
            i2 = m3686b(i2, ekVar.topMargin + this.f1705h.top, ekVar.bottomMargin + this.f1705h.bottom);
        }
        if (z2) {
            a = m3538a(view, i, i2, ekVar);
        } else {
            a = m3552b(view, i, i2, ekVar);
        }
        if (a) {
            view.measure(i, i2);
        }
    }

    private int m3686b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    private void m3683a(ep epVar, ev evVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = i - 1;
            i3 = -1;
            i = -1;
        }
        if (this.i == 1 && m3671g()) {
            i5 = this.f1699b - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.f1701d[i5];
            cp cpVar = (cp) view.getLayoutParams();
            cpVar.f2071f = m3689c(epVar, evVar, m3566d(view));
            if (i6 != -1 || cpVar.f2071f <= 1) {
                cpVar.f2070e = i7;
            } else {
                cpVar.f2070e = i7 - (cpVar.f2071f - 1);
            }
            i7 += cpVar.f2071f * i6;
        }
    }

    public void m3698a(int i) {
        if (i != this.f1699b) {
            this.f1698a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f1699b = i;
            this.f1704g.m4243a();
        }
    }

    public View m3697a(View view, int i, ep epVar, ev evVar) {
        View e = m3573e(view);
        if (e == null) {
            return null;
        }
        cp cpVar = (cp) e.getLayoutParams();
        int a = cpVar.f2070e;
        int a2 = cpVar.f2070e + cpVar.f2071f;
        if (super.m3644a(view, i, epVar, evVar) == null) {
            return null;
        }
        int s;
        int i2;
        int i3;
        if (((m3665e(i) == 1) != this.k ? 1 : null) != null) {
            s = m3603s() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            s = 0;
            i2 = 1;
            i3 = m3603s();
        }
        Object obj = (this.i == 1 && m3671g()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = s;
        while (i6 != i3) {
            View h = m3585h(i6);
            if (h == e) {
                break;
            }
            View view3;
            if (h.isFocusable()) {
                cpVar = (cp) h.getLayoutParams();
                int a3 = cpVar.f2070e;
                int a4 = cpVar.f2070e + cpVar.f2071f;
                if (a3 == a && a4 == a2) {
                    return h;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = cpVar.f2070e;
                    s = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = h;
                } else {
                    s = i5;
                    i5 = i4;
                    view3 = view2;
                }
            } else {
                s = i5;
                i5 = i4;
                view3 = view2;
            }
            i6 += i2;
            view2 = view3;
            i4 = i5;
            i5 = s;
        }
        return view2;
    }

    public boolean m3712b() {
        return this.n == null && !this.f1698a;
    }
}
