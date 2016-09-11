package android.support.v4.p002h;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper */
/* renamed from: android.support.v4.h.bj */
public class bj {
    private final View f919a;
    private ViewParent f920b;
    private boolean f921c;
    private int[] f922d;

    public bj(View view) {
        this.f919a = view;
    }

    public void m1893a(boolean z) {
        if (this.f921c) {
            bu.m1969z(this.f919a);
        }
        this.f921c = z;
    }

    public boolean m1894a() {
        return this.f921c;
    }

    public boolean m1900b() {
        return this.f920b != null;
    }

    public boolean m1897a(int i) {
        if (m1900b()) {
            return true;
        }
        if (m1894a()) {
            View view = this.f919a;
            for (ViewParent parent = this.f919a.getParent(); parent != null; parent = parent.getParent()) {
                if (db.m2247a(parent, view, this.f919a, i)) {
                    this.f920b = parent;
                    db.m2248b(parent, view, this.f919a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void m1901c() {
        if (this.f920b != null) {
            db.m2242a(this.f920b, this.f919a);
            this.f920b = null;
        }
    }

    public boolean m1898a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m1894a() || this.f920b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f919a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            db.m2243a(this.f920b, this.f919a, i, i2, i3, i4);
            if (iArr != null) {
                this.f919a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m1899a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m1894a() || this.f920b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f919a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f922d == null) {
                    this.f922d = new int[2];
                }
                iArr = this.f922d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            db.m2244a(this.f920b, this.f919a, i, i2, iArr);
            if (iArr2 != null) {
                this.f919a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m1896a(float f, float f2, boolean z) {
        if (!m1894a() || this.f920b == null) {
            return false;
        }
        return db.m2246a(this.f920b, this.f919a, f, f2, z);
    }

    public boolean m1895a(float f, float f2) {
        if (!m1894a() || this.f920b == null) {
            return false;
        }
        return db.m2245a(this.f920b, this.f919a, f, f2);
    }
}
