package android.support.v7.widget;

import android.support.v4.p002h.bu;
import android.support.v4.p002h.di;
import android.support.v4.p006a.AnimatorCompatHelper;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator */
public class bz extends fn {
    private ArrayList f2015b;
    private ArrayList f2016c;
    private ArrayList f2017d;
    private ArrayList f2018e;
    private ArrayList f2019f;
    private ArrayList f2020g;
    private ArrayList f2021h;
    private ArrayList f2022i;
    private ArrayList f2023j;
    private ArrayList f2024k;
    private ArrayList f2025l;

    public bz() {
        this.f2015b = new ArrayList();
        this.f2016c = new ArrayList();
        this.f2017d = new ArrayList();
        this.f2018e = new ArrayList();
        this.f2019f = new ArrayList();
        this.f2020g = new ArrayList();
        this.f2021h = new ArrayList();
        this.f2022i = new ArrayList();
        this.f2023j = new ArrayList();
        this.f2024k = new ArrayList();
        this.f2025l = new ArrayList();
    }

    public void m4212a() {
        int i;
        int i2;
        int i3;
        int i4 = !this.f2015b.isEmpty() ? 1 : 0;
        if (this.f2017d.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.f2018e.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.f2016c.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            ArrayList arrayList;
            Runnable caVar;
            Iterator it = this.f2015b.iterator();
            while (it.hasNext()) {
                m4209t((ey) it.next());
            }
            this.f2015b.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2017d);
                this.f2020g.add(arrayList);
                this.f2017d.clear();
                caVar = new ca(this, arrayList);
                if (i4 != 0) {
                    bu.m1932a(((cj) arrayList.get(0)).f2057a.f2195a, caVar, m4161f());
                } else {
                    caVar.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2018e);
                this.f2021h.add(arrayList);
                this.f2018e.clear();
                caVar = new cb(this, arrayList);
                if (i4 != 0) {
                    bu.m1932a(((ci) arrayList.get(0)).f2051a.f2195a, caVar, m4161f());
                } else {
                    caVar.run();
                }
            }
            if (i3 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f2016c);
                this.f2019f.add(arrayList2);
                this.f2016c.clear();
                Runnable ccVar = new cc(this, arrayList2);
                if (i4 == 0 && i == 0 && i2 == 0) {
                    ccVar.run();
                    return;
                }
                long d;
                long g;
                long f = i4 != 0 ? m4161f() : 0;
                if (i != 0) {
                    d = m4158d();
                } else {
                    d = 0;
                }
                if (i2 != 0) {
                    g = m4163g();
                } else {
                    g = 0;
                }
                bu.m1932a(((ey) arrayList2.get(0)).f2195a, ccVar, f + Math.max(d, g));
            }
        }
    }

    public boolean m4214a(ey eyVar) {
        m4211v(eyVar);
        this.f2015b.add(eyVar);
        return true;
    }

    private void m4209t(ey eyVar) {
        di q = bu.m1960q(eyVar.f2195a);
        this.f2024k.add(eyVar);
        q.m2285a(m4161f()).m2284a(0.0f).m2286a(new cd(this, eyVar, q)).m2293c();
    }

    public boolean m4219b(ey eyVar) {
        m4211v(eyVar);
        bu.m1939c(eyVar.f2195a, 0.0f);
        this.f2016c.add(eyVar);
        return true;
    }

    private void m4210u(ey eyVar) {
        di q = bu.m1960q(eyVar.f2195a);
        this.f2022i.add(eyVar);
        q.m2284a(1.0f).m2285a(m4159e()).m2286a(new ce(this, eyVar, q)).m2293c();
    }

    public boolean m4215a(ey eyVar, int i, int i2, int i3, int i4) {
        View view = eyVar.f2195a;
        int m = (int) (((float) i) + bu.m1956m(eyVar.f2195a));
        int n = (int) (((float) i2) + bu.m1957n(eyVar.f2195a));
        m4211v(eyVar);
        int i5 = i3 - m;
        int i6 = i4 - n;
        if (i5 == 0 && i6 == 0) {
            m4181i(eyVar);
            return false;
        }
        if (i5 != 0) {
            bu.m1923a(view, (float) (-i5));
        }
        if (i6 != 0) {
            bu.m1935b(view, (float) (-i6));
        }
        this.f2017d.add(new cj(m, n, i3, i4, null));
        return true;
    }

    private void m4201b(ey eyVar, int i, int i2, int i3, int i4) {
        View view = eyVar.f2195a;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            bu.m1960q(view).m2289b(0.0f);
        }
        if (i6 != 0) {
            bu.m1960q(view).m2292c(0.0f);
        }
        di q = bu.m1960q(view);
        this.f2023j.add(eyVar);
        q.m2285a(m4158d()).m2286a(new cf(this, eyVar, i5, i6, q)).m2293c();
    }

    public boolean m4216a(ey eyVar, ey eyVar2, int i, int i2, int i3, int i4) {
        if (eyVar == eyVar2) {
            return m4215a(eyVar, i, i2, i3, i4);
        }
        float m = bu.m1956m(eyVar.f2195a);
        float n = bu.m1957n(eyVar.f2195a);
        float f = bu.m1948f(eyVar.f2195a);
        m4211v(eyVar);
        int i5 = (int) (((float) (i3 - i)) - m);
        int i6 = (int) (((float) (i4 - i2)) - n);
        bu.m1923a(eyVar.f2195a, m);
        bu.m1935b(eyVar.f2195a, n);
        bu.m1939c(eyVar.f2195a, f);
        if (eyVar2 != null) {
            m4211v(eyVar2);
            bu.m1923a(eyVar2.f2195a, (float) (-i5));
            bu.m1935b(eyVar2.f2195a, (float) (-i6));
            bu.m1939c(eyVar2.f2195a, 0.0f);
        }
        this.f2018e.add(new ci(eyVar2, i, i2, i3, i4, null));
        return true;
    }

    private void m4196a(ci ciVar) {
        View view = null;
        ey eyVar = ciVar.f2051a;
        View view2 = eyVar == null ? null : eyVar.f2195a;
        ey eyVar2 = ciVar.f2052b;
        if (eyVar2 != null) {
            view = eyVar2.f2195a;
        }
        if (view2 != null) {
            di a = bu.m1960q(view2).m2285a(m4163g());
            this.f2025l.add(ciVar.f2051a);
            a.m2289b((float) (ciVar.f2055e - ciVar.f2053c));
            a.m2292c((float) (ciVar.f2056f - ciVar.f2054d));
            a.m2284a(0.0f).m2286a(new cg(this, ciVar, a)).m2293c();
        }
        if (view != null) {
            a = bu.m1960q(view);
            this.f2025l.add(ciVar.f2052b);
            a.m2289b(0.0f).m2292c(0.0f).m2285a(m4163g()).m2284a(1.0f).m2286a(new ch(this, ciVar, a, view)).m2293c();
        }
    }

    private void m4197a(List list, ey eyVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ci ciVar = (ci) list.get(size);
            if (m4198a(ciVar, eyVar) && ciVar.f2051a == null && ciVar.f2052b == null) {
                list.remove(ciVar);
            }
        }
    }

    private void m4200b(ci ciVar) {
        if (ciVar.f2051a != null) {
            m4198a(ciVar, ciVar.f2051a);
        }
        if (ciVar.f2052b != null) {
            m4198a(ciVar, ciVar.f2052b);
        }
    }

    private boolean m4198a(ci ciVar, ey eyVar) {
        boolean z = false;
        if (ciVar.f2052b == eyVar) {
            ciVar.f2052b = null;
        } else if (ciVar.f2051a != eyVar) {
            return false;
        } else {
            ciVar.f2051a = null;
            z = true;
        }
        bu.m1939c(eyVar.f2195a, 1.0f);
        bu.m1923a(eyVar.f2195a, 0.0f);
        bu.m1935b(eyVar.f2195a, 0.0f);
        m4167a(eyVar, z);
        return true;
    }

    public void m4221c(ey eyVar) {
        int size;
        View view = eyVar.f2195a;
        bu.m1960q(view).m2291b();
        for (size = this.f2017d.size() - 1; size >= 0; size--) {
            if (((cj) this.f2017d.get(size)).f2057a == eyVar) {
                bu.m1935b(view, 0.0f);
                bu.m1923a(view, 0.0f);
                m4181i(eyVar);
                this.f2017d.remove(size);
            }
        }
        m4197a(this.f2018e, eyVar);
        if (this.f2015b.remove(eyVar)) {
            bu.m1939c(view, 1.0f);
            m4180h(eyVar);
        }
        if (this.f2016c.remove(eyVar)) {
            bu.m1939c(view, 1.0f);
            m4182j(eyVar);
        }
        for (size = this.f2021h.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f2021h.get(size);
            m4197a(list, eyVar);
            if (list.isEmpty()) {
                this.f2021h.remove(size);
            }
        }
        for (int size2 = this.f2020g.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f2020g.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((cj) arrayList.get(size3)).f2057a == eyVar) {
                    bu.m1935b(view, 0.0f);
                    bu.m1923a(view, 0.0f);
                    m4181i(eyVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2020g.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f2019f.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f2019f.get(size);
            if (arrayList.remove(eyVar)) {
                bu.m1939c(view, 1.0f);
                m4182j(eyVar);
                if (arrayList.isEmpty()) {
                    this.f2019f.remove(size);
                }
            }
        }
        if (this.f2024k.remove(eyVar)) {
        }
        if (this.f2022i.remove(eyVar)) {
        }
        if (this.f2025l.remove(eyVar)) {
        }
        if (this.f2023j.remove(eyVar)) {
            m4208j();
        } else {
            m4208j();
        }
    }

    private void m4211v(ey eyVar) {
        AnimatorCompatHelper.m735a(eyVar.f2195a);
        m4221c(eyVar);
    }

    public boolean m4218b() {
        return (this.f2016c.isEmpty() && this.f2018e.isEmpty() && this.f2017d.isEmpty() && this.f2015b.isEmpty() && this.f2023j.isEmpty() && this.f2024k.isEmpty() && this.f2022i.isEmpty() && this.f2025l.isEmpty() && this.f2020g.isEmpty() && this.f2019f.isEmpty() && this.f2021h.isEmpty()) ? false : true;
    }

    private void m4208j() {
        if (!m4218b()) {
            m4165h();
        }
    }

    public void m4220c() {
        int size;
        for (size = this.f2017d.size() - 1; size >= 0; size--) {
            cj cjVar = (cj) this.f2017d.get(size);
            View view = cjVar.f2057a.f2195a;
            bu.m1935b(view, 0.0f);
            bu.m1923a(view, 0.0f);
            m4181i(cjVar.f2057a);
            this.f2017d.remove(size);
        }
        for (size = this.f2015b.size() - 1; size >= 0; size--) {
            m4180h((ey) this.f2015b.get(size));
            this.f2015b.remove(size);
        }
        for (size = this.f2016c.size() - 1; size >= 0; size--) {
            ey eyVar = (ey) this.f2016c.get(size);
            bu.m1939c(eyVar.f2195a, 1.0f);
            m4182j(eyVar);
            this.f2016c.remove(size);
        }
        for (size = this.f2018e.size() - 1; size >= 0; size--) {
            m4200b((ci) this.f2018e.get(size));
        }
        this.f2018e.clear();
        if (m4218b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.f2020g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2020g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    cj cjVar2 = (cj) arrayList.get(size3);
                    View view2 = cjVar2.f2057a.f2195a;
                    bu.m1935b(view2, 0.0f);
                    bu.m1923a(view2, 0.0f);
                    m4181i(cjVar2.f2057a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2020g.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2019f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2019f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    ey eyVar2 = (ey) arrayList.get(size3);
                    bu.m1939c(eyVar2.f2195a, 1.0f);
                    m4182j(eyVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2019f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2021h.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2021h.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m4200b((ci) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.f2021h.remove(arrayList);
                    }
                }
            }
            m4213a(this.f2024k);
            m4213a(this.f2023j);
            m4213a(this.f2022i);
            m4213a(this.f2025l);
            m4165h();
        }
    }

    void m4213a(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            bu.m1960q(((ey) list.get(size)).f2195a).m2291b();
        }
    }

    public boolean m4217a(ey eyVar, List list) {
        return !list.isEmpty() || super.m4152a(eyVar, list);
    }
}
