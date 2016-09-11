package android.support.v4.p014g;

import java.util.Map;

/* renamed from: android.support.v4.g.q */
public class SimpleArrayMap {
    static Object[] f838b;
    static int f839c;
    static Object[] f840d;
    static int f841e;
    int[] f842f;
    Object[] f843g;
    int f844h;

    int m1458a(Object obj, int i) {
        int i2 = this.f844h;
        if (i2 == 0) {
            return -1;
        }
        int a = ContainerHelpers.m1496a(this.f842f, i2, i);
        if (a < 0 || obj.equals(this.f843g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f842f[i3] == i) {
            if (obj.equals(this.f843g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f842f[a] == i) {
            if (obj.equals(this.f843g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    int m1456a() {
        int i = this.f844h;
        if (i == 0) {
            return -1;
        }
        int a = ContainerHelpers.m1496a(this.f842f, i, 0);
        if (a < 0 || this.f843g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f842f[i2] == 0) {
            if (this.f843g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f842f[a] == 0) {
            if (this.f843g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void m1455e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (f840d != null) {
                    objArr = f840d;
                    this.f843g = objArr;
                    f840d = (Object[]) objArr[0];
                    this.f842f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f841e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (f838b != null) {
                    objArr = f838b;
                    this.f843g = objArr;
                    f838b = (Object[]) objArr[0];
                    this.f842f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f839c--;
                    return;
                }
            }
        }
        this.f842f = new int[i];
        this.f843g = new Object[(i << 1)];
    }

    private static void m1454a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (f841e < 10) {
                    objArr[0] = f840d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f840d = objArr;
                    f841e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (f839c < 10) {
                    objArr[0] = f838b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f838b = objArr;
                    f839c++;
                }
            }
        }
    }

    public SimpleArrayMap() {
        this.f842f = ContainerHelpers.f850a;
        this.f843g = ContainerHelpers.f852c;
        this.f844h = 0;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.f842f = ContainerHelpers.f850a;
            this.f843g = ContainerHelpers.f852c;
        } else {
            m1455e(i);
        }
        this.f844h = 0;
    }

    public void clear() {
        if (this.f844h != 0) {
            SimpleArrayMap.m1454a(this.f842f, this.f843g, this.f844h);
            this.f842f = ContainerHelpers.f850a;
            this.f843g = ContainerHelpers.f852c;
            this.f844h = 0;
        }
    }

    public void m1460a(int i) {
        if (this.f842f.length < i) {
            Object obj = this.f842f;
            Object obj2 = this.f843g;
            m1455e(i);
            if (this.f844h > 0) {
                System.arraycopy(obj, 0, this.f842f, 0, this.f844h);
                System.arraycopy(obj2, 0, this.f843g, 0, this.f844h << 1);
            }
            SimpleArrayMap.m1454a(obj, obj2, this.f844h);
        }
    }

    public boolean containsKey(Object obj) {
        return m1457a(obj) >= 0;
    }

    public int m1457a(Object obj) {
        return obj == null ? m1456a() : m1458a(obj, obj.hashCode());
    }

    int m1462b(Object obj) {
        int i = 1;
        int i2 = this.f844h * 2;
        Object[] objArr = this.f843g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m1462b(obj) >= 0;
    }

    public Object get(Object obj) {
        int a = m1457a(obj);
        return a >= 0 ? this.f843g[(a << 1) + 1] : null;
    }

    public Object m1463b(int i) {
        return this.f843g[i << 1];
    }

    public Object m1464c(int i) {
        return this.f843g[(i << 1) + 1];
    }

    public Object m1459a(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object obj2 = this.f843g[i2];
        this.f843g[i2] = obj;
        return obj2;
    }

    public boolean isEmpty() {
        return this.f844h <= 0;
    }

    public Object put(Object obj, Object obj2) {
        int a;
        int i;
        int i2 = 8;
        if (obj == null) {
            a = m1456a();
            i = 0;
        } else {
            i = obj.hashCode();
            a = m1458a(obj, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            Object obj3 = this.f843g[i3];
            this.f843g[i3] = obj2;
            return obj3;
        }
        a ^= -1;
        if (this.f844h >= this.f842f.length) {
            if (this.f844h >= 8) {
                i2 = this.f844h + (this.f844h >> 1);
            } else if (this.f844h < 4) {
                i2 = 4;
            }
            Object obj4 = this.f842f;
            Object obj5 = this.f843g;
            m1455e(i2);
            if (this.f842f.length > 0) {
                System.arraycopy(obj4, 0, this.f842f, 0, obj4.length);
                System.arraycopy(obj5, 0, this.f843g, 0, obj5.length);
            }
            SimpleArrayMap.m1454a(obj4, obj5, this.f844h);
        }
        if (a < this.f844h) {
            System.arraycopy(this.f842f, a, this.f842f, a + 1, this.f844h - a);
            System.arraycopy(this.f843g, a << 1, this.f843g, (a + 1) << 1, (this.f844h - a) << 1);
        }
        this.f842f[a] = i;
        this.f843g[a << 1] = obj;
        this.f843g[(a << 1) + 1] = obj2;
        this.f844h++;
        return null;
    }

    public void m1461a(SimpleArrayMap simpleArrayMap) {
        int i = 0;
        int i2 = simpleArrayMap.f844h;
        m1460a(this.f844h + i2);
        if (this.f844h != 0) {
            while (i < i2) {
                put(simpleArrayMap.m1463b(i), simpleArrayMap.m1464c(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(simpleArrayMap.f842f, 0, this.f842f, 0, i2);
            System.arraycopy(simpleArrayMap.f843g, 0, this.f843g, 0, i2 << 1);
            this.f844h = i2;
        }
    }

    public Object remove(Object obj) {
        int a = m1457a(obj);
        if (a >= 0) {
            return m1465d(a);
        }
        return null;
    }

    public Object m1465d(int i) {
        int i2 = 8;
        Object obj = this.f843g[(i << 1) + 1];
        if (this.f844h <= 1) {
            SimpleArrayMap.m1454a(this.f842f, this.f843g, this.f844h);
            this.f842f = ContainerHelpers.f850a;
            this.f843g = ContainerHelpers.f852c;
            this.f844h = 0;
        } else if (this.f842f.length <= 8 || this.f844h >= this.f842f.length / 3) {
            this.f844h--;
            if (i < this.f844h) {
                System.arraycopy(this.f842f, i + 1, this.f842f, i, this.f844h - i);
                System.arraycopy(this.f843g, (i + 1) << 1, this.f843g, i << 1, (this.f844h - i) << 1);
            }
            this.f843g[this.f844h << 1] = null;
            this.f843g[(this.f844h << 1) + 1] = null;
        } else {
            if (this.f844h > 8) {
                i2 = this.f844h + (this.f844h >> 1);
            }
            Object obj2 = this.f842f;
            Object obj3 = this.f843g;
            m1455e(i2);
            this.f844h--;
            if (i > 0) {
                System.arraycopy(obj2, 0, this.f842f, 0, i);
                System.arraycopy(obj3, 0, this.f843g, 0, i << 1);
            }
            if (i < this.f844h) {
                System.arraycopy(obj2, i + 1, this.f842f, i, this.f844h - i);
                System.arraycopy(obj3, (i + 1) << 1, this.f843g, i << 1, (this.f844h - i) << 1);
            }
        }
        return obj;
    }

    public int size() {
        return this.f844h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f844h) {
            try {
                Object b = m1463b(i);
                Object c = m1464c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
                        return false;
                    }
                } else if (!c.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f842f;
        Object[] objArr = this.f843g;
        int i = this.f844h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f844h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f844h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            SimpleArrayMap b = m1463b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1464c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
