package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

/* compiled from: StaggeredGridLayoutManager */
class ft {
    int f2255a;
    int f2256b;
    int f2257c;
    final int f2258d;
    final /* synthetic */ StaggeredGridLayoutManager f2259e;
    private ArrayList f2260f;

    private ft(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f2259e = staggeredGridLayoutManager;
        this.f2260f = new ArrayList();
        this.f2255a = Integer.MIN_VALUE;
        this.f2256b = Integer.MIN_VALUE;
        this.f2257c = 0;
        this.f2258d = i;
    }

    int m4593a(int i) {
        if (this.f2255a != Integer.MIN_VALUE) {
            return this.f2255a;
        }
        if (this.f2260f.size() == 0) {
            return i;
        }
        m4595a();
        return this.f2255a;
    }

    void m4595a() {
        View view = (View) this.f2260f.get(0);
        fq c = m4601c(view);
        this.f2255a = this.f2259e.f1773a.m4300a(view);
        if (c.f2254f) {
            FullSpanItem f = this.f2259e.f1778f.m3759f(c.m4251e());
            if (f != null && f.f1757b == -1) {
                this.f2255a -= f.m3744a(this.f2258d);
            }
        }
    }

    int m4598b() {
        if (this.f2255a != Integer.MIN_VALUE) {
            return this.f2255a;
        }
        m4595a();
        return this.f2255a;
    }

    int m4599b(int i) {
        if (this.f2256b != Integer.MIN_VALUE) {
            return this.f2256b;
        }
        if (this.f2260f.size() == 0) {
            return i;
        }
        m4602c();
        return this.f2256b;
    }

    void m4602c() {
        View view = (View) this.f2260f.get(this.f2260f.size() - 1);
        fq c = m4601c(view);
        this.f2256b = this.f2259e.f1773a.m4304b(view);
        if (c.f2254f) {
            FullSpanItem f = this.f2259e.f1778f.m3759f(c.m4251e());
            if (f != null && f.f1757b == 1) {
                this.f2256b = f.m3744a(this.f2258d) + this.f2256b;
            }
        }
    }

    int m4604d() {
        if (this.f2256b != Integer.MIN_VALUE) {
            return this.f2256b;
        }
        m4602c();
        return this.f2256b;
    }

    void m4596a(View view) {
        fq c = m4601c(view);
        c.f2253e = this;
        this.f2260f.add(0, view);
        this.f2255a = Integer.MIN_VALUE;
        if (this.f2260f.size() == 1) {
            this.f2256b = Integer.MIN_VALUE;
        }
        if (c.m4249c() || c.m4250d()) {
            this.f2257c += this.f2259e.f1773a.m4306c(view);
        }
    }

    void m4600b(View view) {
        fq c = m4601c(view);
        c.f2253e = this;
        this.f2260f.add(view);
        this.f2256b = Integer.MIN_VALUE;
        if (this.f2260f.size() == 1) {
            this.f2255a = Integer.MIN_VALUE;
        }
        if (c.m4249c() || c.m4250d()) {
            this.f2257c += this.f2259e.f1773a.m4306c(view);
        }
    }

    void m4597a(boolean z, int i) {
        int b;
        if (z) {
            b = m4599b(Integer.MIN_VALUE);
        } else {
            b = m4593a(Integer.MIN_VALUE);
        }
        m4606e();
        if (b != Integer.MIN_VALUE) {
            if (z && b < this.f2259e.f1773a.m4307d()) {
                return;
            }
            if (z || b <= this.f2259e.f1773a.m4305c()) {
                if (i != Integer.MIN_VALUE) {
                    b += i;
                }
                this.f2256b = b;
                this.f2255a = b;
            }
        }
    }

    void m4606e() {
        this.f2260f.clear();
        m4607f();
        this.f2257c = 0;
    }

    void m4607f() {
        this.f2255a = Integer.MIN_VALUE;
        this.f2256b = Integer.MIN_VALUE;
    }

    void m4603c(int i) {
        this.f2255a = i;
        this.f2256b = i;
    }

    void m4608g() {
        int size = this.f2260f.size();
        View view = (View) this.f2260f.remove(size - 1);
        fq c = m4601c(view);
        c.f2253e = null;
        if (c.m4249c() || c.m4250d()) {
            this.f2257c -= this.f2259e.f1773a.m4306c(view);
        }
        if (size == 1) {
            this.f2255a = Integer.MIN_VALUE;
        }
        this.f2256b = Integer.MIN_VALUE;
    }

    void m4609h() {
        View view = (View) this.f2260f.remove(0);
        fq c = m4601c(view);
        c.f2253e = null;
        if (this.f2260f.size() == 0) {
            this.f2256b = Integer.MIN_VALUE;
        }
        if (c.m4249c() || c.m4250d()) {
            this.f2257c -= this.f2259e.f1773a.m4306c(view);
        }
        this.f2255a = Integer.MIN_VALUE;
    }

    public int m4610i() {
        return this.f2257c;
    }

    fq m4601c(View view) {
        return (fq) view.getLayoutParams();
    }

    void m4605d(int i) {
        if (this.f2255a != Integer.MIN_VALUE) {
            this.f2255a += i;
        }
        if (this.f2256b != Integer.MIN_VALUE) {
            this.f2256b += i;
        }
    }

    public View m4594a(int i, int i2) {
        View view = null;
        int size;
        View view2;
        if (i2 == -1) {
            size = this.f2260f.size();
            int i3 = 0;
            while (i3 < size) {
                view2 = (View) this.f2260f.get(i3);
                if (!view2.isFocusable()) {
                    break;
                }
                boolean z;
                if (this.f2259e.m3566d(view2) > i) {
                    z = true;
                } else {
                    z = false;
                }
                if (z != this.f2259e.f1784l) {
                    break;
                }
                i3++;
                view = view2;
            }
            return view;
        }
        size = this.f2260f.size() - 1;
        while (size >= 0) {
            view2 = (View) this.f2260f.get(size);
            if (!view2.isFocusable()) {
                break;
            }
            Object obj;
            if (this.f2259e.m3566d(view2) > i) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != (!this.f2259e.f1784l ? 1 : null)) {
                break;
            }
            size--;
            view = view2;
        }
        return view;
    }
}
