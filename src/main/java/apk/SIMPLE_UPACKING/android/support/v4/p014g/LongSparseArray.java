package android.support.v4.p014g;

/* renamed from: android.support.v4.g.f */
public class LongSparseArray implements Cloneable {
    private static final Object f855a;
    private boolean f856b;
    private long[] f857c;
    private Object[] f858d;
    private int f859e;

    public /* synthetic */ Object clone() {
        return m1504a();
    }

    static {
        f855a = new Object();
    }

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.f856b = false;
        if (i == 0) {
            this.f857c = ContainerHelpers.f851b;
            this.f858d = ContainerHelpers.f852c;
        } else {
            int b = ContainerHelpers.m1499b(i);
            this.f857c = new long[b];
            this.f858d = new Object[b];
        }
        this.f859e = 0;
    }

    public LongSparseArray m1504a() {
        try {
            LongSparseArray longSparseArray = (LongSparseArray) super.clone();
            try {
                longSparseArray.f857c = (long[]) this.f857c.clone();
                longSparseArray.f858d = (Object[]) this.f858d.clone();
                return longSparseArray;
            } catch (CloneNotSupportedException e) {
                return longSparseArray;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public Object m1505a(long j) {
        return m1506a(j, null);
    }

    public Object m1506a(long j, Object obj) {
        int a = ContainerHelpers.m1497a(this.f857c, this.f859e, j);
        return (a < 0 || this.f858d[a] == f855a) ? obj : this.f858d[a];
    }

    public void m1510b(long j) {
        int a = ContainerHelpers.m1497a(this.f857c, this.f859e, j);
        if (a >= 0 && this.f858d[a] != f855a) {
            this.f858d[a] = f855a;
            this.f856b = true;
        }
    }

    public void m1507a(int i) {
        if (this.f858d[i] != f855a) {
            this.f858d[i] = f855a;
            this.f856b = true;
        }
    }

    private void m1503d() {
        int i = this.f859e;
        long[] jArr = this.f857c;
        Object[] objArr = this.f858d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f855a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f856b = false;
        this.f859e = i2;
    }

    public void m1511b(long j, Object obj) {
        int a = ContainerHelpers.m1497a(this.f857c, this.f859e, j);
        if (a >= 0) {
            this.f858d[a] = obj;
            return;
        }
        a ^= -1;
        if (a >= this.f859e || this.f858d[a] != f855a) {
            if (this.f856b && this.f859e >= this.f857c.length) {
                m1503d();
                a = ContainerHelpers.m1497a(this.f857c, this.f859e, j) ^ -1;
            }
            if (this.f859e >= this.f857c.length) {
                int b = ContainerHelpers.m1499b(this.f859e + 1);
                Object obj2 = new long[b];
                Object obj3 = new Object[b];
                System.arraycopy(this.f857c, 0, obj2, 0, this.f857c.length);
                System.arraycopy(this.f858d, 0, obj3, 0, this.f858d.length);
                this.f857c = obj2;
                this.f858d = obj3;
            }
            if (this.f859e - a != 0) {
                System.arraycopy(this.f857c, a, this.f857c, a + 1, this.f859e - a);
                System.arraycopy(this.f858d, a, this.f858d, a + 1, this.f859e - a);
            }
            this.f857c[a] = j;
            this.f858d[a] = obj;
            this.f859e++;
            return;
        }
        this.f857c[a] = j;
        this.f858d[a] = obj;
    }

    public int m1508b() {
        if (this.f856b) {
            m1503d();
        }
        return this.f859e;
    }

    public long m1509b(int i) {
        if (this.f856b) {
            m1503d();
        }
        return this.f857c[i];
    }

    public Object m1512c(int i) {
        if (this.f856b) {
            m1503d();
        }
        return this.f858d[i];
    }

    public void m1513c() {
        int i = this.f859e;
        Object[] objArr = this.f858d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f859e = 0;
        this.f856b = false;
    }

    public String toString() {
        if (m1508b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f859e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f859e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1509b(i));
            stringBuilder.append('=');
            LongSparseArray c = m1512c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
