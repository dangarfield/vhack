package android.support.v4.p014g;

/* renamed from: android.support.v4.g.p */
public class Pools implements Pools {
    private final Object[] f880a;
    private int f881b;

    public Pools(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f880a = new Object[i];
    }

    public Object m1526a() {
        if (this.f881b <= 0) {
            return null;
        }
        int i = this.f881b - 1;
        Object obj = this.f880a[i];
        this.f880a[i] = null;
        this.f881b--;
        return obj;
    }

    public boolean m1527a(Object obj) {
        if (m1525b(obj)) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.f881b >= this.f880a.length) {
            return false;
        } else {
            this.f880a[this.f881b] = obj;
            this.f881b++;
            return true;
        }
    }

    private boolean m1525b(Object obj) {
        for (int i = 0; i < this.f881b; i++) {
            if (this.f880a[i] == obj) {
                return true;
            }
        }
        return false;
    }
}
