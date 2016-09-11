package android.support.v7.widget;

/* compiled from: StaggeredGridLayoutManager */
class fp {
    int f2248a;
    int f2249b;
    boolean f2250c;
    boolean f2251d;
    final /* synthetic */ StaggeredGridLayoutManager f2252e;

    private fp(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f2252e = staggeredGridLayoutManager;
    }

    void m4583a() {
        this.f2248a = -1;
        this.f2249b = Integer.MIN_VALUE;
        this.f2250c = false;
        this.f2251d = false;
    }

    void m4585b() {
        this.f2249b = this.f2250c ? this.f2252e.f1773a.m4307d() : this.f2252e.f1773a.m4305c();
    }

    void m4584a(int i) {
        if (this.f2250c) {
            this.f2249b = this.f2252e.f1773a.m4307d() - i;
        } else {
            this.f2249b = this.f2252e.f1773a.m4305c() + i;
        }
    }
}
