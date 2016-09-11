package android.support.v4.p002h.p015a;

import android.os.Build.VERSION;

/* compiled from: AccessibilityRecordCompat */
/* renamed from: android.support.v4.h.a.aj */
public class aj {
    private static final am f894a;
    private final Object f895b;

    static {
        if (VERSION.SDK_INT >= 16) {
            f894a = new an();
        } else if (VERSION.SDK_INT >= 15) {
            f894a = new al();
        } else if (VERSION.SDK_INT >= 14) {
            f894a = new ak();
        } else {
            f894a = new ao();
        }
    }

    public aj(Object obj) {
        this.f895b = obj;
    }

    public void m1566a(boolean z) {
        f894a.m1574a(this.f895b, z);
    }

    public void m1565a(int i) {
        f894a.m1575b(this.f895b, i);
    }

    public void m1567b(int i) {
        f894a.m1573a(this.f895b, i);
    }

    public void m1568c(int i) {
        f894a.m1578e(this.f895b, i);
    }

    public void m1569d(int i) {
        f894a.m1576c(this.f895b, i);
    }

    public void m1570e(int i) {
        f894a.m1577d(this.f895b, i);
    }

    public void m1571f(int i) {
        f894a.m1579f(this.f895b, i);
    }

    public void m1572g(int i) {
        f894a.m1580g(this.f895b, i);
    }

    public int hashCode() {
        return this.f895b == null ? 0 : this.f895b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        aj ajVar = (aj) obj;
        if (this.f895b == null) {
            if (ajVar.f895b != null) {
                return false;
            }
            return true;
        } else if (this.f895b.equals(ajVar.f895b)) {
            return true;
        } else {
            return false;
        }
    }
}
