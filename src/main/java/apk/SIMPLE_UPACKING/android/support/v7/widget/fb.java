package android.support.v7.widget;

/* compiled from: RtlSpacingHelper */
class fb {
    private int f2215a;
    private int f2216b;
    private int f2217c;
    private int f2218d;
    private int f2219e;
    private int f2220f;
    private boolean f2221g;
    private boolean f2222h;

    fb() {
        this.f2215a = 0;
        this.f2216b = 0;
        this.f2217c = Integer.MIN_VALUE;
        this.f2218d = Integer.MIN_VALUE;
        this.f2219e = 0;
        this.f2220f = 0;
        this.f2221g = false;
        this.f2222h = false;
    }

    public int m4555a() {
        return this.f2215a;
    }

    public int m4558b() {
        return this.f2216b;
    }

    public int m4560c() {
        return this.f2221g ? this.f2216b : this.f2215a;
    }

    public int m4561d() {
        return this.f2221g ? this.f2215a : this.f2216b;
    }

    public void m4556a(int i, int i2) {
        this.f2217c = i;
        this.f2218d = i2;
        this.f2222h = true;
        if (this.f2221g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2215a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2216b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f2215a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2216b = i2;
        }
    }

    public void m4559b(int i, int i2) {
        this.f2222h = false;
        if (i != Integer.MIN_VALUE) {
            this.f2219e = i;
            this.f2215a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2220f = i2;
            this.f2216b = i2;
        }
    }

    public void m4557a(boolean z) {
        if (z != this.f2221g) {
            this.f2221g = z;
            if (!this.f2222h) {
                this.f2215a = this.f2219e;
                this.f2216b = this.f2220f;
            } else if (z) {
                this.f2215a = this.f2218d != Integer.MIN_VALUE ? this.f2218d : this.f2219e;
                this.f2216b = this.f2217c != Integer.MIN_VALUE ? this.f2217c : this.f2220f;
            } else {
                this.f2215a = this.f2217c != Integer.MIN_VALUE ? this.f2217c : this.f2219e;
                this.f2216b = this.f2218d != Integer.MIN_VALUE ? this.f2218d : this.f2220f;
            }
        }
    }
}
