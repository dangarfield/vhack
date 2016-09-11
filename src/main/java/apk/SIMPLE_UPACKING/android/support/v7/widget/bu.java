package android.support.v7.widget;

/* compiled from: ChildHelper */
class bu {
    long f2006a;
    bu f2007b;

    bu() {
        this.f2006a = 0;
    }

    void m4098a(int i) {
        if (i >= 64) {
            m4096b();
            this.f2007b.m4098a(i - 64);
            return;
        }
        this.f2006a |= 1 << i;
    }

    private void m4096b() {
        if (this.f2007b == null) {
            this.f2007b = new bu();
        }
    }

    void m4100b(int i) {
        if (i < 64) {
            this.f2006a &= (1 << i) ^ -1;
        } else if (this.f2007b != null) {
            this.f2007b.m4100b(i - 64);
        }
    }

    boolean m4101c(int i) {
        if (i < 64) {
            return (this.f2006a & (1 << i)) != 0;
        } else {
            m4096b();
            return this.f2007b.m4101c(i - 64);
        }
    }

    void m4097a() {
        this.f2006a = 0;
        if (this.f2007b != null) {
            this.f2007b.m4097a();
        }
    }

    void m4099a(int i, boolean z) {
        if (i >= 64) {
            m4096b();
            this.f2007b.m4099a(i - 64, z);
            return;
        }
        boolean z2 = (this.f2006a & Long.MIN_VALUE) != 0;
        long j = (1 << i) - 1;
        this.f2006a = (((j ^ -1) & this.f2006a) << 1) | (this.f2006a & j);
        if (z) {
            m4098a(i);
        } else {
            m4100b(i);
        }
        if (z2 || this.f2007b != null) {
            m4096b();
            this.f2007b.m4099a(0, z2);
        }
    }

    boolean m4102d(int i) {
        if (i >= 64) {
            m4096b();
            return this.f2007b.m4102d(i - 64);
        }
        long j = 1 << i;
        boolean z = (this.f2006a & j) != 0;
        this.f2006a &= j ^ -1;
        j--;
        this.f2006a = Long.rotateRight((j ^ -1) & this.f2006a, 1) | (this.f2006a & j);
        if (this.f2007b == null) {
            return z;
        }
        if (this.f2007b.m4101c(0)) {
            m4098a(63);
        }
        this.f2007b.m4102d(0);
        return z;
    }

    int m4103e(int i) {
        if (this.f2007b == null) {
            if (i >= 64) {
                return Long.bitCount(this.f2006a);
            }
            return Long.bitCount(this.f2006a & ((1 << i) - 1));
        } else if (i < 64) {
            return Long.bitCount(this.f2006a & ((1 << i) - 1));
        } else {
            return this.f2007b.m4103e(i - 64) + Long.bitCount(this.f2006a);
        }
    }

    public String toString() {
        return this.f2007b == null ? Long.toBinaryString(this.f2006a) : this.f2007b.toString() + "xx" + Long.toBinaryString(this.f2006a);
    }
}
