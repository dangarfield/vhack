package android.support.v4.p014g;

/* renamed from: android.support.v4.g.r */
public class SparseArrayCompat implements Cloneable {
    private static final Object f882a;
    private boolean f883b;
    private int[] f884c;
    private Object[] f885d;
    private int f886e;

    public /* synthetic */ Object clone() {
        return m1529a();
    }

    static {
        f882a = new Object();
    }

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        this.f883b = false;
        if (i == 0) {
            this.f884c = ContainerHelpers.f850a;
            this.f885d = ContainerHelpers.f852c;
        } else {
            int a = ContainerHelpers.m1495a(i);
            this.f884c = new int[a];
            this.f885d = new Object[a];
        }
        this.f886e = 0;
    }

    public SparseArrayCompat m1529a() {
        try {
            SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) super.clone();
            try {
                sparseArrayCompat.f884c = (int[]) this.f884c.clone();
                sparseArrayCompat.f885d = (Object[]) this.f885d.clone();
                return sparseArrayCompat;
            } catch (CloneNotSupportedException e) {
                return sparseArrayCompat;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public Object m1530a(int i) {
        return m1531a(i, null);
    }

    public Object m1531a(int i, Object obj) {
        int a = ContainerHelpers.m1496a(this.f884c, this.f886e, i);
        return (a < 0 || this.f885d[a] == f882a) ? obj : this.f885d[a];
    }

    public void m1533b(int i) {
        int a = ContainerHelpers.m1496a(this.f884c, this.f886e, i);
        if (a >= 0 && this.f885d[a] != f882a) {
            this.f885d[a] = f882a;
            this.f883b = true;
        }
    }

    public void m1536c(int i) {
        m1533b(i);
    }

    private void m1528d() {
        int i = this.f886e;
        int[] iArr = this.f884c;
        Object[] objArr = this.f885d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f882a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f883b = false;
        this.f886e = i2;
    }

    public void m1534b(int i, Object obj) {
        int a = ContainerHelpers.m1496a(this.f884c, this.f886e, i);
        if (a >= 0) {
            this.f885d[a] = obj;
            return;
        }
        a ^= -1;
        if (a >= this.f886e || this.f885d[a] != f882a) {
            if (this.f883b && this.f886e >= this.f884c.length) {
                m1528d();
                a = ContainerHelpers.m1496a(this.f884c, this.f886e, i) ^ -1;
            }
            if (this.f886e >= this.f884c.length) {
                int a2 = ContainerHelpers.m1495a(this.f886e + 1);
                Object obj2 = new int[a2];
                Object obj3 = new Object[a2];
                System.arraycopy(this.f884c, 0, obj2, 0, this.f884c.length);
                System.arraycopy(this.f885d, 0, obj3, 0, this.f885d.length);
                this.f884c = obj2;
                this.f885d = obj3;
            }
            if (this.f886e - a != 0) {
                System.arraycopy(this.f884c, a, this.f884c, a + 1, this.f886e - a);
                System.arraycopy(this.f885d, a, this.f885d, a + 1, this.f886e - a);
            }
            this.f884c[a] = i;
            this.f885d[a] = obj;
            this.f886e++;
            return;
        }
        this.f884c[a] = i;
        this.f885d[a] = obj;
    }

    public int m1532b() {
        if (this.f883b) {
            m1528d();
        }
        return this.f886e;
    }

    public int m1537d(int i) {
        if (this.f883b) {
            m1528d();
        }
        return this.f884c[i];
    }

    public Object m1538e(int i) {
        if (this.f883b) {
            m1528d();
        }
        return this.f885d[i];
    }

    public int m1539f(int i) {
        if (this.f883b) {
            m1528d();
        }
        return ContainerHelpers.m1496a(this.f884c, this.f886e, i);
    }

    public void m1535c() {
        int i = this.f886e;
        Object[] objArr = this.f885d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f886e = 0;
        this.f883b = false;
    }

    public String toString() {
        if (m1532b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f886e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f886e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1537d(i));
            stringBuilder.append('=');
            SparseArrayCompat e = m1538e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
