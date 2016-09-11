package android.support.v7.widget;

import android.support.v4.p002h.bu;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: RecyclerView */
public abstract class ey {
    private static final List f2194m;
    public final View f2195a;
    int f2196b;
    int f2197c;
    long f2198d;
    int f2199e;
    int f2200f;
    ey f2201g;
    ey f2202h;
    List f2203i;
    List f2204j;
    RecyclerView f2205k;
    private int f2206l;
    private int f2207n;
    private ep f2208o;
    private boolean f2209p;
    private int f2210q;

    static {
        f2194m = Collections.EMPTY_LIST;
    }

    void m4515a(int i, int i2, boolean z) {
        m4522b(8);
        m4516a(i2, z);
        this.f2196b = i;
    }

    void m4516a(int i, boolean z) {
        if (this.f2197c == -1) {
            this.f2197c = this.f2196b;
        }
        if (this.f2200f == -1) {
            this.f2200f = this.f2196b;
        }
        if (z) {
            this.f2200f += i;
        }
        this.f2196b += i;
        if (this.f2195a.getLayoutParams() != null) {
            ((ek) this.f2195a.getLayoutParams()).f2068c = true;
        }
    }

    void m4513a() {
        this.f2197c = -1;
        this.f2200f = -1;
    }

    void m4521b() {
        if (this.f2197c == -1) {
            this.f2197c = this.f2196b;
        }
    }

    boolean m4523c() {
        return (this.f2206l & 128) != 0;
    }

    public final int m4524d() {
        return this.f2200f == -1 ? this.f2196b : this.f2200f;
    }

    public final int m4525e() {
        if (this.f2205k == null) {
            return -1;
        }
        return this.f2205k.m144d(this);
    }

    public final int m4526f() {
        return this.f2197c;
    }

    public final long m4527g() {
        return this.f2198d;
    }

    public final int m4528h() {
        return this.f2199e;
    }

    boolean m4529i() {
        return this.f2208o != null;
    }

    void m4530j() {
        this.f2208o.m4437d(this);
    }

    boolean m4531k() {
        return (this.f2206l & 32) != 0;
    }

    void m4532l() {
        this.f2206l &= -33;
    }

    void m4533m() {
        this.f2206l &= -257;
    }

    void m4517a(ep epVar, boolean z) {
        this.f2208o = epVar;
        this.f2209p = z;
    }

    boolean m4534n() {
        return (this.f2206l & 4) != 0;
    }

    boolean m4535o() {
        return (this.f2206l & 2) != 0;
    }

    boolean m4536p() {
        return (this.f2206l & 1) != 0;
    }

    boolean m4537q() {
        return (this.f2206l & 8) != 0;
    }

    boolean m4520a(int i) {
        return (this.f2206l & i) != 0;
    }

    boolean m4538r() {
        return (this.f2206l & 256) != 0;
    }

    boolean m4539s() {
        return (this.f2206l & 512) != 0 || m4534n();
    }

    void m4514a(int i, int i2) {
        this.f2206l = (this.f2206l & (i2 ^ -1)) | (i & i2);
    }

    void m4522b(int i) {
        this.f2206l |= i;
    }

    void m4518a(Object obj) {
        if (obj == null) {
            m4522b(1024);
        } else if ((this.f2206l & 1024) == 0) {
            m4511y();
            this.f2203i.add(obj);
        }
    }

    private void m4511y() {
        if (this.f2203i == null) {
            this.f2203i = new ArrayList();
            this.f2204j = Collections.unmodifiableList(this.f2203i);
        }
    }

    void m4540t() {
        if (this.f2203i != null) {
            this.f2203i.clear();
        }
        this.f2206l &= -1025;
    }

    List m4541u() {
        if ((this.f2206l & 1024) != 0) {
            return f2194m;
        }
        if (this.f2203i == null || this.f2203i.size() == 0) {
            return f2194m;
        }
        return this.f2204j;
    }

    void m4542v() {
        this.f2206l = 0;
        this.f2196b = -1;
        this.f2197c = -1;
        this.f2198d = -1;
        this.f2200f = -1;
        this.f2207n = 0;
        this.f2201g = null;
        this.f2202h = null;
        m4540t();
        this.f2210q = 0;
    }

    private void m4512z() {
        this.f2210q = bu.m1946e(this.f2195a);
        bu.m1940c(this.f2195a, 4);
    }

    private void m4500A() {
        bu.m1940c(this.f2195a, this.f2210q);
        this.f2210q = 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f2196b + " id=" + this.f2198d + ", oldPos=" + this.f2197c + ", pLpos:" + this.f2200f);
        if (m4529i()) {
            stringBuilder.append(" scrap ").append(this.f2209p ? "[changeScrap]" : "[attachedScrap]");
        }
        if (m4534n()) {
            stringBuilder.append(" invalid");
        }
        if (!m4536p()) {
            stringBuilder.append(" unbound");
        }
        if (m4535o()) {
            stringBuilder.append(" update");
        }
        if (m4537q()) {
            stringBuilder.append(" removed");
        }
        if (m4523c()) {
            stringBuilder.append(" ignored");
        }
        if (m4538r()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!m4543w()) {
            stringBuilder.append(" not recyclable(" + this.f2207n + ")");
        }
        if (m4539s()) {
            stringBuilder.append(" undefined adapter position");
        }
        if (this.f2195a.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m4519a(boolean z) {
        this.f2207n = z ? this.f2207n - 1 : this.f2207n + 1;
        if (this.f2207n < 0) {
            this.f2207n = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && this.f2207n == 1) {
            this.f2206l |= 16;
        } else if (z && this.f2207n == 0) {
            this.f2206l &= -17;
        }
    }

    public final boolean m4543w() {
        return (this.f2206l & 16) == 0 && !bu.m1942c(this.f2195a);
    }

    private boolean m4501B() {
        return (this.f2206l & 16) != 0;
    }

    private boolean m4502C() {
        return (this.f2206l & 16) == 0 && bu.m1942c(this.f2195a);
    }

    boolean m4544x() {
        return (this.f2206l & 2) != 0;
    }
}
