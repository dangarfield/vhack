package android.support.v7.widget;

import android.support.v4.p002h.bu;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: RecyclerView */
public final class ep {
    final ArrayList f2152a;
    final ArrayList f2153b;
    final /* synthetic */ RecyclerView f2154c;
    private ArrayList f2155d;
    private final List f2156e;
    private int f2157f;
    private eo f2158g;
    private ew f2159h;

    public ep(RecyclerView recyclerView) {
        this.f2154c = recyclerView;
        this.f2152a = new ArrayList();
        this.f2155d = null;
        this.f2153b = new ArrayList();
        this.f2156e = Collections.unmodifiableList(this.f2152a);
        this.f2157f = 2;
    }

    public void m4416a() {
        this.f2152a.clear();
        m4431c();
    }

    public void m4417a(int i) {
        this.f2157f = i;
        for (int size = this.f2153b.size() - 1; size >= 0 && this.f2153b.size() > i; size--) {
            m4436d(size);
        }
    }

    public List m4425b() {
        return this.f2156e;
    }

    boolean m4423a(ey eyVar) {
        if (eyVar.m4537q()) {
            return this.f2154c.f148g.m4483a();
        }
        if (eyVar.f2196b < 0 || eyVar.f2196b >= this.f2154c.f156q.m4366a()) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + eyVar);
        } else if (!this.f2154c.f148g.m4483a() && this.f2154c.f156q.m4367a(eyVar.f2196b) != eyVar.m4528h()) {
            return false;
        } else {
            if (!this.f2154c.f156q.m4379b() || eyVar.m4527g() == this.f2154c.f156q.m4374b(eyVar.f2196b)) {
                return true;
            }
            return false;
        }
    }

    public int m4424b(int i) {
        if (i >= 0 && i < this.f2154c.f148g.m4487e()) {
            return !this.f2154c.f148g.m4483a() ? i : this.f2154c.f143b.m3932b(i);
        } else {
            throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f2154c.f148g.m4487e());
        }
    }

    public View m4430c(int i) {
        return m4415a(i, false);
    }

    View m4415a(int i, boolean z) {
        boolean z2 = true;
        if (i < 0 || i >= this.f2154c.f148g.m4487e()) {
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.f2154c.f148g.m4487e());
        }
        ey f;
        boolean z3;
        ey eyVar;
        boolean z4;
        int b;
        boolean z5;
        int b2;
        LayoutParams layoutParams;
        ek ekVar;
        if (this.f2154c.f148g.m4483a()) {
            f = m4442f(i);
            ey eyVar2 = f;
            z3 = f != null;
            eyVar = eyVar2;
        } else {
            eyVar = null;
            z3 = false;
        }
        if (eyVar == null) {
            eyVar = m4413a(i, -1, z);
            if (eyVar != null) {
                if (m4423a(eyVar)) {
                    z4 = true;
                } else {
                    if (!z) {
                        eyVar.m4522b(4);
                        if (eyVar.m4529i()) {
                            this.f2154c.removeDetachedView(eyVar.f2195a, false);
                            eyVar.m4530j();
                        } else if (eyVar.m4531k()) {
                            eyVar.m4532l();
                        }
                        m4428b(eyVar);
                    }
                    eyVar = null;
                    z4 = z3;
                }
                if (eyVar == null) {
                    b = this.f2154c.f143b.m3932b(i);
                    if (b >= 0 || b >= this.f2154c.f156q.m4366a()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f2154c.f148g.m4487e());
                    }
                    int a = this.f2154c.f156q.m4367a(b);
                    if (this.f2154c.f156q.m4379b()) {
                        eyVar = m4414a(this.f2154c.f156q.m4374b(b), a, z);
                        if (eyVar != null) {
                            eyVar.f2196b = b;
                            z4 = true;
                        }
                    }
                    if (eyVar == null && this.f2159h != null) {
                        View a2 = this.f2159h.m4488a(this, i, a);
                        if (a2 != null) {
                            eyVar = this.f2154c.m176a(a2);
                            if (eyVar == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            } else if (eyVar.m4523c()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                    if (eyVar == null) {
                        eyVar = m4441f().m4403a(a);
                        if (eyVar != null) {
                            eyVar.m4542v();
                            if (RecyclerView.f117j) {
                                m4412f(eyVar);
                            }
                        }
                    }
                    if (eyVar == null) {
                        f = this.f2154c.f156q.m4375b(this.f2154c, a);
                        z5 = z4;
                        if (z5 && !this.f2154c.f148g.m4483a() && f.m4520a(8192)) {
                            f.m4514a(0, 8192);
                            if (this.f2154c.f148g.f2183i) {
                                this.f2154c.m120a(f, this.f2154c.f147f.m4147a(this.f2154c.f148g, f, ec.m4145d(f) | 4096, f.m4541u()));
                            }
                        }
                        int i2;
                        if (!this.f2154c.f148g.m4483a() && f.m4536p()) {
                            f.f2200f = i;
                            i2 = 0;
                        } else if (f.m4536p() || f.m4535o() || f.m4534n()) {
                            b2 = this.f2154c.f143b.m3932b(i);
                            f.f2205k = this.f2154c;
                            this.f2154c.f156q.m4378b(f, b2);
                            m4411d(f.f2195a);
                            if (this.f2154c.f148g.m4483a()) {
                                f.f2200f = i;
                            }
                            z4 = true;
                        } else {
                            i2 = 0;
                        }
                        layoutParams = f.f2195a.getLayoutParams();
                        if (layoutParams != null) {
                            ekVar = (ek) this.f2154c.generateDefaultLayoutParams();
                            f.f2195a.setLayoutParams(ekVar);
                        } else if (this.f2154c.checkLayoutParams(layoutParams)) {
                            ekVar = (ek) layoutParams;
                        } else {
                            ekVar = (ek) this.f2154c.generateLayoutParams(layoutParams);
                            f.f2195a.setLayoutParams(ekVar);
                        }
                        ekVar.f2066a = f;
                        if (!z5 || r3 == 0) {
                            z2 = false;
                        }
                        ekVar.f2069d = z2;
                        return f.f2195a;
                    }
                }
                f = eyVar;
                z5 = z4;
                f.m4514a(0, 8192);
                if (this.f2154c.f148g.f2183i) {
                    this.f2154c.m120a(f, this.f2154c.f147f.m4147a(this.f2154c.f148g, f, ec.m4145d(f) | 4096, f.m4541u()));
                }
                if (!this.f2154c.f148g.m4483a()) {
                }
                if (f.m4536p()) {
                }
                b2 = this.f2154c.f143b.m3932b(i);
                f.f2205k = this.f2154c;
                this.f2154c.f156q.m4378b(f, b2);
                m4411d(f.f2195a);
                if (this.f2154c.f148g.m4483a()) {
                    f.f2200f = i;
                }
                z4 = true;
                layoutParams = f.f2195a.getLayoutParams();
                if (layoutParams != null) {
                    ekVar = (ek) this.f2154c.generateDefaultLayoutParams();
                    f.f2195a.setLayoutParams(ekVar);
                } else if (this.f2154c.checkLayoutParams(layoutParams)) {
                    ekVar = (ek) layoutParams;
                } else {
                    ekVar = (ek) this.f2154c.generateLayoutParams(layoutParams);
                    f.f2195a.setLayoutParams(ekVar);
                }
                ekVar.f2066a = f;
                z2 = false;
                ekVar.f2069d = z2;
                return f.f2195a;
            }
        }
        z4 = z3;
        if (eyVar == null) {
            b = this.f2154c.f143b.m3932b(i);
            if (b >= 0) {
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f2154c.f148g.m4487e());
        }
        f = eyVar;
        z5 = z4;
        f.m4514a(0, 8192);
        if (this.f2154c.f148g.f2183i) {
            this.f2154c.m120a(f, this.f2154c.f147f.m4147a(this.f2154c.f148g, f, ec.m4145d(f) | 4096, f.m4541u()));
        }
        if (!this.f2154c.f148g.m4483a()) {
        }
        if (f.m4536p()) {
        }
        b2 = this.f2154c.f143b.m3932b(i);
        f.f2205k = this.f2154c;
        this.f2154c.f156q.m4378b(f, b2);
        m4411d(f.f2195a);
        if (this.f2154c.f148g.m4483a()) {
            f.f2200f = i;
        }
        z4 = true;
        layoutParams = f.f2195a.getLayoutParams();
        if (layoutParams != null) {
            ekVar = (ek) this.f2154c.generateDefaultLayoutParams();
            f.f2195a.setLayoutParams(ekVar);
        } else if (this.f2154c.checkLayoutParams(layoutParams)) {
            ekVar = (ek) this.f2154c.generateLayoutParams(layoutParams);
            f.f2195a.setLayoutParams(ekVar);
        } else {
            ekVar = (ek) layoutParams;
        }
        ekVar.f2066a = f;
        z2 = false;
        ekVar.f2069d = z2;
        return f.f2195a;
    }

    private void m4411d(View view) {
        if (this.f2154c.m208i()) {
            if (bu.m1946e(view) == 0) {
                bu.m1940c(view, 1);
            }
            if (!bu.m1937b(view)) {
                bu.m1929a(view, this.f2154c.ag.m4549b());
            }
        }
    }

    private void m4412f(ey eyVar) {
        if (eyVar.f2195a instanceof ViewGroup) {
            m4410a((ViewGroup) eyVar.f2195a, false);
        }
    }

    private void m4410a(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                m4410a((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }

    public void m4422a(View view) {
        ey c = RecyclerView.m138c(view);
        if (c.m4538r()) {
            this.f2154c.removeDetachedView(view, false);
        }
        if (c.m4529i()) {
            c.m4530j();
        } else if (c.m4531k()) {
            c.m4532l();
        }
        m4428b(c);
    }

    void m4431c() {
        for (int size = this.f2153b.size() - 1; size >= 0; size--) {
            m4436d(size);
        }
        this.f2153b.clear();
    }

    void m4436d(int i) {
        m4433c((ey) this.f2153b.get(i));
        this.f2153b.remove(i);
    }

    void m4428b(ey eyVar) {
        boolean z = true;
        int i = 0;
        if (eyVar.m4529i() || eyVar.f2195a.getParent() != null) {
            StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(eyVar.m4529i()).append(" isAttached:");
            if (eyVar.f2195a.getParent() == null) {
                z = false;
            }
            throw new IllegalArgumentException(append.append(z).toString());
        } else if (eyVar.m4538r()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + eyVar);
        } else if (eyVar.m4523c()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        } else {
            int i2;
            boolean c = eyVar.m4502C();
            boolean z2 = this.f2154c.f156q != null && c && this.f2154c.f156q.m4380b(eyVar);
            if (z2 || eyVar.m4543w()) {
                if (!eyVar.m4520a(14)) {
                    int size = this.f2153b.size();
                    if (size == this.f2157f && size > 0) {
                        m4436d(0);
                    }
                    if (size < this.f2157f) {
                        this.f2153b.add(eyVar);
                        z2 = true;
                        if (z2) {
                            m4433c(eyVar);
                            i = 1;
                            i2 = z2;
                        } else {
                            z = z2;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    z = z2;
                } else {
                    m4433c(eyVar);
                    i = 1;
                    i2 = z2;
                }
            } else {
                i2 = 0;
            }
            this.f2154c.f145d.m4742g(eyVar);
            if (i2 == 0 && r1 == 0 && c) {
                eyVar.f2205k = null;
            }
        }
    }

    void m4433c(ey eyVar) {
        bu.m1929a(eyVar.f2195a, null);
        m4440e(eyVar);
        eyVar.f2205k = null;
        m4441f().m4407a(eyVar);
    }

    void m4429b(View view) {
        ey c = RecyclerView.m138c(view);
        c.f2208o = null;
        c.f2209p = false;
        c.m4532l();
        m4428b(c);
    }

    void m4434c(View view) {
        ey c = RecyclerView.m138c(view);
        if (!c.m4520a(12) && c.m4544x() && !this.f2154c.m143c(c)) {
            if (this.f2155d == null) {
                this.f2155d = new ArrayList();
            }
            c.m4517a(this, true);
            this.f2155d.add(c);
        } else if (!c.m4534n() || c.m4537q() || this.f2154c.f156q.m4379b()) {
            c.m4517a(this, false);
            this.f2152a.add(c);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
    }

    void m4437d(ey eyVar) {
        if (eyVar.f2209p) {
            this.f2155d.remove(eyVar);
        } else {
            this.f2152a.remove(eyVar);
        }
        eyVar.f2208o = null;
        eyVar.f2209p = false;
        eyVar.m4532l();
    }

    int m4435d() {
        return this.f2152a.size();
    }

    View m4438e(int i) {
        return ((ey) this.f2152a.get(i)).f2195a;
    }

    void m4439e() {
        this.f2152a.clear();
        if (this.f2155d != null) {
            this.f2155d.clear();
        }
    }

    ey m4442f(int i) {
        int i2 = 0;
        if (this.f2155d != null) {
            int size = this.f2155d.size();
            if (size != 0) {
                ey eyVar;
                int i3 = 0;
                while (i3 < size) {
                    eyVar = (ey) this.f2155d.get(i3);
                    if (eyVar.m4531k() || eyVar.m4524d() != i) {
                        i3++;
                    } else {
                        eyVar.m4522b(32);
                        return eyVar;
                    }
                }
                if (this.f2154c.f156q.m4379b()) {
                    int b = this.f2154c.f143b.m3932b(i);
                    if (b > 0 && b < this.f2154c.f156q.m4366a()) {
                        long b2 = this.f2154c.f156q.m4374b(b);
                        while (i2 < size) {
                            eyVar = (ey) this.f2155d.get(i2);
                            if (eyVar.m4531k() || eyVar.m4527g() != b2) {
                                i2++;
                            } else {
                                eyVar.m4522b(32);
                                return eyVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    ey m4413a(int i, int i2, boolean z) {
        int i3 = 0;
        int size = this.f2152a.size();
        int i4 = 0;
        while (i4 < size) {
            View a;
            ey eyVar = (ey) this.f2152a.get(i4);
            if (eyVar.m4531k() || eyVar.m4524d() != i || eyVar.m4534n() || (!this.f2154c.f148g.f2182h && eyVar.m4537q())) {
                i4++;
            } else if (i2 == -1 || eyVar.m4528h() == i2) {
                eyVar.m4522b(32);
                return eyVar;
            } else {
                Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + eyVar.m4528h() + " but expected " + i2 + ")");
                if (!z) {
                    a = this.f2154c.f144c.m4079a(i, i2);
                    if (a != null) {
                        eyVar = RecyclerView.m138c(a);
                        this.f2154c.f144c.m4094e(a);
                        i3 = this.f2154c.f144c.m4087b(a);
                        if (i3 != -1) {
                            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + eyVar);
                        }
                        this.f2154c.f144c.m4092d(i3);
                        m4434c(a);
                        eyVar.m4522b(8224);
                        return eyVar;
                    }
                }
                i4 = this.f2153b.size();
                while (i3 < i4) {
                    eyVar = (ey) this.f2153b.get(i3);
                    if (eyVar.m4534n() || eyVar.m4524d() != i) {
                        i3++;
                    } else if (z) {
                        return eyVar;
                    } else {
                        this.f2153b.remove(i3);
                        return eyVar;
                    }
                }
                return null;
            }
        }
        if (z) {
            a = this.f2154c.f144c.m4079a(i, i2);
            if (a != null) {
                eyVar = RecyclerView.m138c(a);
                this.f2154c.f144c.m4094e(a);
                i3 = this.f2154c.f144c.m4087b(a);
                if (i3 != -1) {
                    this.f2154c.f144c.m4092d(i3);
                    m4434c(a);
                    eyVar.m4522b(8224);
                    return eyVar;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + eyVar);
            }
        }
        i4 = this.f2153b.size();
        while (i3 < i4) {
            eyVar = (ey) this.f2153b.get(i3);
            if (eyVar.m4534n()) {
            }
            i3++;
        }
        return null;
    }

    ey m4414a(long j, int i, boolean z) {
        int size;
        for (size = this.f2152a.size() - 1; size >= 0; size--) {
            ey eyVar = (ey) this.f2152a.get(size);
            if (eyVar.m4527g() == j && !eyVar.m4531k()) {
                if (i == eyVar.m4528h()) {
                    eyVar.m4522b(32);
                    if (!eyVar.m4537q() || this.f2154c.f148g.m4483a()) {
                        return eyVar;
                    }
                    eyVar.m4514a(2, 14);
                    return eyVar;
                } else if (!z) {
                    this.f2152a.remove(size);
                    this.f2154c.removeDetachedView(eyVar.f2195a, false);
                    m4429b(eyVar.f2195a);
                }
            }
        }
        for (size = this.f2153b.size() - 1; size >= 0; size--) {
            eyVar = (ey) this.f2153b.get(size);
            if (eyVar.m4527g() == j) {
                if (i == eyVar.m4528h()) {
                    if (z) {
                        return eyVar;
                    }
                    this.f2153b.remove(size);
                    return eyVar;
                } else if (!z) {
                    m4436d(size);
                }
            }
        }
        return null;
    }

    void m4440e(ey eyVar) {
        if (this.f2154c.f157r != null) {
            this.f2154c.f157r.m4446a(eyVar);
        }
        if (this.f2154c.f156q != null) {
            this.f2154c.f156q.m4371a(eyVar);
        }
        if (this.f2154c.f148g != null) {
            this.f2154c.f145d.m4742g(eyVar);
        }
    }

    void m4419a(dy dyVar, dy dyVar2, boolean z) {
        m4416a();
        m4441f().m4406a(dyVar, dyVar2, z);
    }

    void m4418a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = this.f2153b.size();
        for (int i6 = 0; i6 < size; i6++) {
            ey eyVar = (ey) this.f2153b.get(i6);
            if (eyVar != null && eyVar.f2196b >= r3 && eyVar.f2196b <= r2) {
                if (eyVar.f2196b == i) {
                    eyVar.m4516a(i2 - i, false);
                } else {
                    eyVar.m4516a(i3, false);
                }
            }
        }
    }

    void m4426b(int i, int i2) {
        int size = this.f2153b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ey eyVar = (ey) this.f2153b.get(i3);
            if (eyVar != null && eyVar.f2196b >= i) {
                eyVar.m4516a(i2, true);
            }
        }
    }

    void m4427b(int i, int i2, boolean z) {
        int i3 = i + i2;
        for (int size = this.f2153b.size() - 1; size >= 0; size--) {
            ey eyVar = (ey) this.f2153b.get(size);
            if (eyVar != null) {
                if (eyVar.f2196b >= i3) {
                    eyVar.m4516a(-i2, z);
                } else if (eyVar.f2196b >= i) {
                    eyVar.m4522b(8);
                    m4436d(size);
                }
            }
        }
    }

    void m4421a(ew ewVar) {
        this.f2159h = ewVar;
    }

    void m4420a(eo eoVar) {
        if (this.f2158g != null) {
            this.f2158g.m4408b();
        }
        this.f2158g = eoVar;
        if (eoVar != null) {
            this.f2158g.m4405a(this.f2154c.getAdapter());
        }
    }

    eo m4441f() {
        if (this.f2158g == null) {
            this.f2158g = new eo();
        }
        return this.f2158g;
    }

    void m4432c(int i, int i2) {
        int i3 = i + i2;
        for (int size = this.f2153b.size() - 1; size >= 0; size--) {
            ey eyVar = (ey) this.f2153b.get(size);
            if (eyVar != null) {
                int d = eyVar.m4524d();
                if (d >= i && d < i3) {
                    eyVar.m4522b(2);
                    m4436d(size);
                }
            }
        }
    }

    void m4443g() {
        if (this.f2154c.f156q == null || !this.f2154c.f156q.m4379b()) {
            m4431c();
            return;
        }
        int size = this.f2153b.size();
        for (int i = 0; i < size; i++) {
            ey eyVar = (ey) this.f2153b.get(i);
            if (eyVar != null) {
                eyVar.m4522b(6);
                eyVar.m4518a(null);
            }
        }
    }

    void m4444h() {
        int i;
        int i2 = 0;
        int size = this.f2153b.size();
        for (i = 0; i < size; i++) {
            ((ey) this.f2153b.get(i)).m4513a();
        }
        size = this.f2152a.size();
        for (i = 0; i < size; i++) {
            ((ey) this.f2152a.get(i)).m4513a();
        }
        if (this.f2155d != null) {
            i = this.f2155d.size();
            while (i2 < i) {
                ((ey) this.f2155d.get(i2)).m4513a();
                i2++;
            }
        }
    }

    void m4445i() {
        int size = this.f2153b.size();
        for (int i = 0; i < size; i++) {
            ek ekVar = (ek) ((ey) this.f2153b.get(i)).f2195a.getLayoutParams();
            if (ekVar != null) {
                ekVar.f2068c = true;
            }
        }
    }
}
