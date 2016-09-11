package android.support.v7.widget;

import android.util.SparseIntArray;

/* compiled from: GridLayoutManager */
public abstract class cq {
    final SparseIntArray f2064a;
    private boolean f2065b;

    public abstract int m4241a(int i);

    public cq() {
        this.f2064a = new SparseIntArray();
        this.f2065b = false;
    }

    public void m4243a() {
        this.f2064a.clear();
    }

    int m4245b(int i, int i2) {
        if (!this.f2065b) {
            return m4242a(i, i2);
        }
        int i3 = this.f2064a.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        i3 = m4242a(i, i2);
        this.f2064a.put(i, i3);
        return i3;
    }

    public int m4242a(int i, int i2) {
        int a = m4241a(i);
        if (a == i2) {
            return 0;
        }
        int b;
        int a2;
        int i3;
        if (this.f2065b && this.f2064a.size() > 0) {
            b = m4244b(i);
            if (b >= 0) {
                a2 = this.f2064a.get(b) + m4241a(b);
                b++;
                i3 = b;
                while (i3 < i) {
                    b = m4241a(i3);
                    a2 += b;
                    if (a2 == i2) {
                        b = 0;
                    } else if (a2 <= i2) {
                        b = a2;
                    }
                    i3++;
                    a2 = b;
                }
                if (a2 + a > i2) {
                    return a2;
                }
                return 0;
            }
        }
        b = 0;
        a2 = 0;
        i3 = b;
        while (i3 < i) {
            b = m4241a(i3);
            a2 += b;
            if (a2 == i2) {
                b = 0;
            } else if (a2 <= i2) {
                b = a2;
            }
            i3++;
            a2 = b;
        }
        if (a2 + a > i2) {
            return 0;
        }
        return a2;
    }

    int m4244b(int i) {
        int i2 = 0;
        int size = this.f2064a.size() - 1;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            if (this.f2064a.keyAt(i3) < i) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        size = i2 - 1;
        if (size < 0 || size >= this.f2064a.size()) {
            return -1;
        }
        return this.f2064a.keyAt(size);
    }

    public int m4246c(int i, int i2) {
        int a = m4241a(i);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            int a2 = m4241a(i3);
            i5 += a2;
            if (i5 == i2) {
                i4++;
                a2 = 0;
            } else if (i5 > i2) {
                i4++;
            } else {
                a2 = i5;
            }
            i3++;
            i5 = a2;
        }
        if (i5 + a > i2) {
            return i4 + 1;
        }
        return i4;
    }
}
