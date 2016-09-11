package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p002h.p015a.AccessibilityEventCompat;
import android.support.v4.p002h.p015a.aj;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.List;

public class LinearLayoutManager extends ei {
    private cw f1685a;
    private boolean f1686b;
    private boolean f1687c;
    private boolean f1688d;
    private boolean f1689e;
    private boolean f1690f;
    int f1691i;
    dp f1692j;
    boolean f1693k;
    int f1694l;
    int f1695m;
    SavedState f1696n;
    final cu f1697o;

    public class SavedState implements Parcelable {
        public static final Creator CREATOR;
        int f1706a;
        int f1707b;
        boolean f1708c;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.f1706a = parcel.readInt();
            this.f1707b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f1708c = z;
        }

        public SavedState(SavedState savedState) {
            this.f1706a = savedState.f1706a;
            this.f1707b = savedState.f1707b;
            this.f1708c = savedState.f1708c;
        }

        boolean m3714a() {
            return this.f1706a >= 0;
        }

        void m3715b() {
            this.f1706a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1706a);
            parcel.writeInt(this.f1707b);
            parcel.writeInt(this.f1708c ? 1 : 0);
        }

        static {
            CREATOR = new cx();
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f1687c = false;
        this.f1693k = false;
        this.f1688d = false;
        this.f1689e = true;
        this.f1694l = -1;
        this.f1695m = Integer.MIN_VALUE;
        this.f1696n = null;
        this.f1697o = new cu(this);
        m3654b(i);
        m3655b(z);
        m3563c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1687c = false;
        this.f1693k = false;
        this.f1688d = false;
        this.f1689e = true;
        this.f1694l = -1;
        this.f1695m = Integer.MIN_VALUE;
        this.f1696n = null;
        this.f1697o = new cu(this);
        ej a = ei.m3481a(context, attributeSet, i, i2);
        m3654b(a.f2145a);
        m3655b(a.f2147c);
        m3651a(a.f2148d);
        m3563c(true);
    }

    public ek m3641a() {
        return new ek(-2, -2);
    }

    public void m3646a(RecyclerView recyclerView, ep epVar) {
        super.m3513a(recyclerView, epVar);
        if (this.f1690f) {
            m3559c(epVar);
            epVar.m4416a();
        }
    }

    public void m3649a(AccessibilityEvent accessibilityEvent) {
        super.m3528a(accessibilityEvent);
        if (m3603s() > 0) {
            aj a = AccessibilityEventCompat.m1546a(accessibilityEvent);
            a.m1567b(m3675k());
            a.m1568c(m3676l());
        }
    }

    public Parcelable m3659c() {
        if (this.f1696n != null) {
            return new SavedState(this.f1696n);
        }
        Parcelable savedState = new SavedState();
        if (m3603s() > 0) {
            m3672h();
            boolean z = this.f1686b ^ this.f1693k;
            savedState.f1708c = z;
            View J;
            if (z) {
                J = m3613J();
                savedState.f1707b = this.f1692j.m4307d() - this.f1692j.m4304b(J);
                savedState.f1706a = m3566d(J);
                return savedState;
            }
            J = m3612I();
            savedState.f1706a = m3566d(J);
            savedState.f1707b = this.f1692j.m4300a(J) - this.f1692j.m4305c();
            return savedState;
        }
        savedState.m3715b();
        return savedState;
    }

    public void m3645a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f1696n = (SavedState) parcelable;
            m3595m();
        }
    }

    public boolean m3664d() {
        return this.f1691i == 0;
    }

    public boolean m3667e() {
        return this.f1691i == 1;
    }

    public void m3651a(boolean z) {
        m3650a(null);
        if (this.f1688d != z) {
            this.f1688d = z;
            m3595m();
        }
    }

    public int m3668f() {
        return this.f1691i;
    }

    public void m3654b(int i) {
        if (i == 0 || i == 1) {
            m3650a(null);
            if (i != this.f1691i) {
                this.f1691i = i;
                this.f1692j = null;
                m3595m();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    private void m3611H() {
        boolean z = true;
        if (this.f1691i == 1 || !m3671g()) {
            this.f1693k = this.f1687c;
            return;
        }
        if (this.f1687c) {
            z = false;
        }
        this.f1693k = z;
    }

    public void m3655b(boolean z) {
        m3650a(null);
        if (z != this.f1687c) {
            this.f1687c = z;
            m3595m();
        }
    }

    public View m3660c(int i) {
        int s = m3603s();
        if (s == 0) {
            return null;
        }
        int d = i - m3566d(m3585h(0));
        if (d >= 0 && d < s) {
            View h = m3585h(d);
            if (m3566d(h) == i) {
                return h;
            }
        }
        return super.m3555c(i);
    }

    protected int m3640a(ev evVar) {
        if (evVar.m4486d()) {
            return this.f1692j.m4310f();
        }
        return 0;
    }

    public void m3661c(ep epVar, ev evVar) {
        if (!(this.f1696n == null && this.f1694l == -1) && evVar.m4487e() == 0) {
            m3559c(epVar);
            return;
        }
        int i;
        int d;
        boolean z;
        if (this.f1696n != null && this.f1696n.m3714a()) {
            this.f1694l = this.f1696n.f1706a;
        }
        m3672h();
        this.f1685a.f2091a = false;
        m3611H();
        this.f1697o.m4262a();
        this.f1697o.f2085c = this.f1693k ^ this.f1688d;
        m3621a(epVar, evVar, this.f1697o);
        int a = m3640a(evVar);
        if (this.f1685a.f2100j >= 0) {
            i = 0;
        } else {
            i = a;
            a = 0;
        }
        i += this.f1692j.m4305c();
        a += this.f1692j.m4311g();
        if (!(!evVar.m4483a() || this.f1694l == -1 || this.f1695m == Integer.MIN_VALUE)) {
            View c = m3660c(this.f1694l);
            if (c != null) {
                if (this.f1693k) {
                    d = (this.f1692j.m4307d() - this.f1692j.m4304b(c)) - this.f1695m;
                } else {
                    d = this.f1695m - (this.f1692j.m4300a(c) - this.f1692j.m4305c());
                }
                if (d > 0) {
                    i += d;
                } else {
                    a -= d;
                }
            }
        }
        d = this.f1697o.f2085c ? this.f1693k ? 1 : -1 : this.f1693k ? -1 : 1;
        m3647a(epVar, evVar, this.f1697o, d);
        m3515a(epVar);
        cw cwVar = this.f1685a;
        if (this.f1692j.m4312h() == 0) {
            z = true;
        } else {
            z = false;
        }
        cwVar.f2102l = z;
        this.f1685a.f2099i = evVar.m4483a();
        int i2;
        if (this.f1697o.f2085c) {
            m3625b(this.f1697o);
            this.f1685a.f2098h = i;
            m3639a(epVar, this.f1685a, evVar, false);
            i = this.f1685a.f2092b;
            i2 = this.f1685a.f2094d;
            if (this.f1685a.f2093c > 0) {
                a += this.f1685a.f2093c;
            }
            m3617a(this.f1697o);
            this.f1685a.f2098h = a;
            cw cwVar2 = this.f1685a;
            cwVar2.f2094d += this.f1685a.f2095e;
            m3639a(epVar, this.f1685a, evVar, false);
            d = this.f1685a.f2092b;
            if (this.f1685a.f2093c > 0) {
                a = this.f1685a.f2093c;
                m3631f(i2, i);
                this.f1685a.f2098h = a;
                m3639a(epVar, this.f1685a, evVar, false);
                a = this.f1685a.f2092b;
            } else {
                a = i;
            }
            i = a;
            a = d;
        } else {
            m3617a(this.f1697o);
            this.f1685a.f2098h = a;
            m3639a(epVar, this.f1685a, evVar, false);
            a = this.f1685a.f2092b;
            d = this.f1685a.f2094d;
            if (this.f1685a.f2093c > 0) {
                i += this.f1685a.f2093c;
            }
            m3625b(this.f1697o);
            this.f1685a.f2098h = i;
            cw cwVar3 = this.f1685a;
            cwVar3.f2094d += this.f1685a.f2095e;
            m3639a(epVar, this.f1685a, evVar, false);
            i = this.f1685a.f2092b;
            if (this.f1685a.f2093c > 0) {
                i2 = this.f1685a.f2093c;
                m3629e(d, a);
                this.f1685a.f2098h = i2;
                m3639a(epVar, this.f1685a, evVar, false);
                a = this.f1685a.f2092b;
            }
        }
        if (m3603s() > 0) {
            int b;
            if ((this.f1693k ^ this.f1688d) != 0) {
                d = m3614a(a, epVar, evVar, true);
                i += d;
                a += d;
                b = m3623b(i, epVar, evVar, false);
                i += b;
                a += b;
            } else {
                d = m3623b(i, epVar, evVar, true);
                i += d;
                a += d;
                b = m3614a(a, epVar, evVar, false);
                i += b;
                a += b;
            }
        }
        m3627b(epVar, evVar, i, a);
        if (!evVar.m4483a()) {
            this.f1694l = -1;
            this.f1695m = Integer.MIN_VALUE;
            this.f1692j.m4301a();
        }
        this.f1686b = this.f1688d;
        this.f1696n = null;
    }

    void m3647a(ep epVar, ev evVar, cu cuVar, int i) {
    }

    private void m3627b(ep epVar, ev evVar, int i, int i2) {
        if (evVar.m4484b() && m3603s() != 0 && !evVar.m4483a() && m3656b()) {
            int i3 = 0;
            int i4 = 0;
            List b = epVar.m4425b();
            int size = b.size();
            int d = m3566d(m3585h(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                ey eyVar = (ey) b.get(i5);
                if (eyVar.m4537q()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((eyVar.m4524d() < d) != this.f1693k ? -1 : 1) == -1) {
                        i7 = this.f1692j.m4306c(eyVar.f2195a) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.f1692j.m4306c(eyVar.f2195a) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.f1685a.f2101k = b;
            if (i3 > 0) {
                m3631f(m3566d(m3612I()), i);
                this.f1685a.f2098h = i3;
                this.f1685a.f2093c = 0;
                this.f1685a.m4269a();
                m3639a(epVar, this.f1685a, evVar, false);
            }
            if (i4 > 0) {
                m3629e(m3566d(m3613J()), i2);
                this.f1685a.f2098h = i4;
                this.f1685a.f2093c = 0;
                this.f1685a.m4269a();
                m3639a(epVar, this.f1685a, evVar, false);
            }
            this.f1685a.f2101k = null;
        }
    }

    private void m3621a(ep epVar, ev evVar, cu cuVar) {
        if (!m3622a(evVar, cuVar) && !m3628b(epVar, evVar, cuVar)) {
            cuVar.m4264b();
            cuVar.f2083a = this.f1688d ? evVar.m4487e() - 1 : 0;
        }
    }

    private boolean m3628b(ep epVar, ev evVar, cu cuVar) {
        boolean z = false;
        if (m3603s() == 0) {
            return false;
        }
        View B = m3492B();
        if (B != null && cuVar.m4261a(B, evVar)) {
            cuVar.m4263a(B);
            return true;
        } else if (this.f1686b != this.f1688d) {
            return false;
        } else {
            B = cuVar.f2085c ? m3630f(epVar, evVar) : m3632g(epVar, evVar);
            if (B == null) {
                return false;
            }
            cuVar.m4265b(B);
            if (!evVar.m4483a() && m3656b()) {
                if (this.f1692j.m4300a(B) >= this.f1692j.m4307d() || this.f1692j.m4304b(B) < this.f1692j.m4305c()) {
                    z = true;
                }
                if (z) {
                    cuVar.f2084b = cuVar.f2085c ? this.f1692j.m4307d() : this.f1692j.m4305c();
                }
            }
            return true;
        }
    }

    private boolean m3622a(ev evVar, cu cuVar) {
        boolean z = false;
        if (evVar.m4483a() || this.f1694l == -1) {
            return false;
        }
        if (this.f1694l < 0 || this.f1694l >= evVar.m4487e()) {
            this.f1694l = -1;
            this.f1695m = Integer.MIN_VALUE;
            return false;
        }
        cuVar.f2083a = this.f1694l;
        if (this.f1696n != null && this.f1696n.m3714a()) {
            cuVar.f2085c = this.f1696n.f1708c;
            if (cuVar.f2085c) {
                cuVar.f2084b = this.f1692j.m4307d() - this.f1696n.f1707b;
                return true;
            }
            cuVar.f2084b = this.f1692j.m4305c() + this.f1696n.f1707b;
            return true;
        } else if (this.f1695m == Integer.MIN_VALUE) {
            View c = m3660c(this.f1694l);
            if (c == null) {
                if (m3603s() > 0) {
                    boolean z2;
                    if (this.f1694l < m3566d(m3585h(0))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 == this.f1693k) {
                        z = true;
                    }
                    cuVar.f2085c = z;
                }
                cuVar.m4264b();
                return true;
            } else if (this.f1692j.m4306c(c) > this.f1692j.m4310f()) {
                cuVar.m4264b();
                return true;
            } else if (this.f1692j.m4300a(c) - this.f1692j.m4305c() < 0) {
                cuVar.f2084b = this.f1692j.m4305c();
                cuVar.f2085c = false;
                return true;
            } else if (this.f1692j.m4307d() - this.f1692j.m4304b(c) < 0) {
                cuVar.f2084b = this.f1692j.m4307d();
                cuVar.f2085c = true;
                return true;
            } else {
                cuVar.f2084b = cuVar.f2085c ? this.f1692j.m4304b(c) + this.f1692j.m4303b() : this.f1692j.m4300a(c);
                return true;
            }
        } else {
            cuVar.f2085c = this.f1693k;
            if (this.f1693k) {
                cuVar.f2084b = this.f1692j.m4307d() - this.f1695m;
                return true;
            }
            cuVar.f2084b = this.f1692j.m4305c() + this.f1695m;
            return true;
        }
    }

    private int m3614a(int i, ep epVar, ev evVar, boolean z) {
        int d = this.f1692j.m4307d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -m3657c(-d, epVar, evVar);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.f1692j.m4307d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.f1692j.m4302a(i2);
        return d + i2;
    }

    private int m3623b(int i, ep epVar, ev evVar, boolean z) {
        int c = i - this.f1692j.m4305c();
        if (c <= 0) {
            return 0;
        }
        c = -m3657c(c, epVar, evVar);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.f1692j.m4305c();
        if (i2 <= 0) {
            return c;
        }
        this.f1692j.m4302a(-i2);
        return c - i2;
    }

    private void m3617a(cu cuVar) {
        m3629e(cuVar.f2083a, cuVar.f2084b);
    }

    private void m3629e(int i, int i2) {
        this.f1685a.f2093c = this.f1692j.m4307d() - i2;
        this.f1685a.f2095e = this.f1693k ? -1 : 1;
        this.f1685a.f2094d = i;
        this.f1685a.f2096f = 1;
        this.f1685a.f2092b = i2;
        this.f1685a.f2097g = Integer.MIN_VALUE;
    }

    private void m3625b(cu cuVar) {
        m3631f(cuVar.f2083a, cuVar.f2084b);
    }

    private void m3631f(int i, int i2) {
        this.f1685a.f2093c = i2 - this.f1692j.m4305c();
        this.f1685a.f2094d = i;
        this.f1685a.f2095e = this.f1693k ? 1 : -1;
        this.f1685a.f2096f = -1;
        this.f1685a.f2092b = i2;
        this.f1685a.f2097g = Integer.MIN_VALUE;
    }

    protected boolean m3671g() {
        return m3601q() == 1;
    }

    void m3672h() {
        if (this.f1685a == null) {
            this.f1685a = m3673i();
        }
        if (this.f1692j == null) {
            this.f1692j = dp.m4298a(this, this.f1691i);
        }
    }

    cw m3673i() {
        return new cw();
    }

    public void m3663d(int i) {
        this.f1694l = i;
        this.f1695m = Integer.MIN_VALUE;
        if (this.f1696n != null) {
            this.f1696n.m3715b();
        }
        m3595m();
    }

    public int m3638a(int i, ep epVar, ev evVar) {
        if (this.f1691i == 1) {
            return 0;
        }
        return m3657c(i, epVar, evVar);
    }

    public int m3652b(int i, ep epVar, ev evVar) {
        if (this.f1691i == 0) {
            return 0;
        }
        return m3657c(i, epVar, evVar);
    }

    public int m3653b(ev evVar) {
        return m3633h(evVar);
    }

    public int m3658c(ev evVar) {
        return m3633h(evVar);
    }

    public int m3662d(ev evVar) {
        return m3635i(evVar);
    }

    public int m3666e(ev evVar) {
        return m3635i(evVar);
    }

    public int m3669f(ev evVar) {
        return m3637j(evVar);
    }

    public int m3670g(ev evVar) {
        return m3637j(evVar);
    }

    private int m3633h(ev evVar) {
        boolean z = false;
        if (m3603s() == 0) {
            return 0;
        }
        m3672h();
        dp dpVar = this.f1692j;
        View a = m3615a(!this.f1689e, true);
        if (!this.f1689e) {
            z = true;
        }
        return fc.m4563a(evVar, dpVar, a, m3624b(z, true), this, this.f1689e, this.f1693k);
    }

    private int m3635i(ev evVar) {
        boolean z = false;
        if (m3603s() == 0) {
            return 0;
        }
        m3672h();
        dp dpVar = this.f1692j;
        View a = m3615a(!this.f1689e, true);
        if (!this.f1689e) {
            z = true;
        }
        return fc.m4562a(evVar, dpVar, a, m3624b(z, true), this, this.f1689e);
    }

    private int m3637j(ev evVar) {
        boolean z = false;
        if (m3603s() == 0) {
            return 0;
        }
        m3672h();
        dp dpVar = this.f1692j;
        View a = m3615a(!this.f1689e, true);
        if (!this.f1689e) {
            z = true;
        }
        return fc.m4564b(evVar, dpVar, a, m3624b(z, true), this, this.f1689e);
    }

    private void m3616a(int i, int i2, boolean z, ev evVar) {
        int b;
        int i3 = 1;
        this.f1685a.f2102l = this.f1692j.m4312h() == 0;
        this.f1685a.f2098h = m3640a(evVar);
        this.f1685a.f2096f = i;
        View J;
        cw cwVar;
        if (i == 1) {
            cw cwVar2 = this.f1685a;
            cwVar2.f2098h += this.f1692j.m4311g();
            J = m3613J();
            cwVar = this.f1685a;
            if (this.f1693k) {
                i3 = -1;
            }
            cwVar.f2095e = i3;
            this.f1685a.f2094d = m3566d(J) + this.f1685a.f2095e;
            this.f1685a.f2092b = this.f1692j.m4304b(J);
            b = this.f1692j.m4304b(J) - this.f1692j.m4307d();
        } else {
            J = m3612I();
            cwVar = this.f1685a;
            cwVar.f2098h += this.f1692j.m4305c();
            cwVar = this.f1685a;
            if (!this.f1693k) {
                i3 = -1;
            }
            cwVar.f2095e = i3;
            this.f1685a.f2094d = m3566d(J) + this.f1685a.f2095e;
            this.f1685a.f2092b = this.f1692j.m4300a(J);
            b = (-this.f1692j.m4300a(J)) + this.f1692j.m4305c();
        }
        this.f1685a.f2093c = i2;
        if (z) {
            cw cwVar3 = this.f1685a;
            cwVar3.f2093c -= b;
        }
        this.f1685a.f2097g = b;
    }

    int m3657c(int i, ep epVar, ev evVar) {
        if (m3603s() == 0 || i == 0) {
            return 0;
        }
        this.f1685a.f2091a = true;
        m3672h();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m3616a(i2, abs, true, evVar);
        int a = this.f1685a.f2097g + m3639a(epVar, this.f1685a, evVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f1692j.m4302a(-i);
        this.f1685a.f2100j = i;
        return i;
    }

    public void m3650a(String str) {
        if (this.f1696n == null) {
            super.m3529a(str);
        }
    }

    private void m3619a(ep epVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    m3505a(i3, epVar);
                }
                return;
            }
            while (i > i2) {
                m3505a(i, epVar);
                i--;
            }
        }
    }

    private void m3618a(ep epVar, int i) {
        if (i >= 0) {
            int s = m3603s();
            int i2;
            if (this.f1693k) {
                for (i2 = s - 1; i2 >= 0; i2--) {
                    if (this.f1692j.m4304b(m3585h(i2)) > i) {
                        m3619a(epVar, s - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < s; i2++) {
                if (this.f1692j.m4304b(m3585h(i2)) > i) {
                    m3619a(epVar, 0, i2);
                    return;
                }
            }
        }
    }

    private void m3626b(ep epVar, int i) {
        int s = m3603s();
        if (i >= 0) {
            int e = this.f1692j.m4309e() - i;
            int i2;
            if (this.f1693k) {
                for (i2 = 0; i2 < s; i2++) {
                    if (this.f1692j.m4300a(m3585h(i2)) < e) {
                        m3619a(epVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = s - 1; i2 >= 0; i2--) {
                if (this.f1692j.m4300a(m3585h(i2)) < e) {
                    m3619a(epVar, s - 1, i2);
                    return;
                }
            }
        }
    }

    private void m3620a(ep epVar, cw cwVar) {
        if (cwVar.f2091a && !cwVar.f2102l) {
            if (cwVar.f2096f == -1) {
                m3626b(epVar, cwVar.f2097g);
            } else {
                m3618a(epVar, cwVar.f2097g);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int m3639a(android.support.v7.widget.ep r8, android.support.v7.widget.cw r9, android.support.v7.widget.ev r10, boolean r11) {
        /*
        r7 = this;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r1 = r9.f2093c;
        r0 = r9.f2097g;
        if (r0 == r6) goto L_0x0016;
    L_0x0008:
        r0 = r9.f2093c;
        if (r0 >= 0) goto L_0x0013;
    L_0x000c:
        r0 = r9.f2097g;
        r2 = r9.f2093c;
        r0 = r0 + r2;
        r9.f2097g = r0;
    L_0x0013:
        r7.m3620a(r8, r9);
    L_0x0016:
        r0 = r9.f2093c;
        r2 = r9.f2098h;
        r0 = r0 + r2;
        r2 = new android.support.v7.widget.cv;
        r2.<init>();
    L_0x0020:
        r3 = r9.f2102l;
        if (r3 != 0) goto L_0x0026;
    L_0x0024:
        if (r0 <= 0) goto L_0x0036;
    L_0x0026:
        r3 = r9.m4271a(r10);
        if (r3 == 0) goto L_0x0036;
    L_0x002c:
        r2.m4266a();
        r7.m3648a(r8, r10, r9, r2);
        r3 = r2.f2088b;
        if (r3 == 0) goto L_0x003b;
    L_0x0036:
        r0 = r9.f2093c;
        r0 = r1 - r0;
        return r0;
    L_0x003b:
        r3 = r9.f2092b;
        r4 = r2.f2087a;
        r5 = r9.f2096f;
        r4 = r4 * r5;
        r3 = r3 + r4;
        r9.f2092b = r3;
        r3 = r2.f2089c;
        if (r3 == 0) goto L_0x0055;
    L_0x0049:
        r3 = r7.f1685a;
        r3 = r3.f2101k;
        if (r3 != 0) goto L_0x0055;
    L_0x004f:
        r3 = r10.m4483a();
        if (r3 != 0) goto L_0x005f;
    L_0x0055:
        r3 = r9.f2093c;
        r4 = r2.f2087a;
        r3 = r3 - r4;
        r9.f2093c = r3;
        r3 = r2.f2087a;
        r0 = r0 - r3;
    L_0x005f:
        r3 = r9.f2097g;
        if (r3 == r6) goto L_0x0078;
    L_0x0063:
        r3 = r9.f2097g;
        r4 = r2.f2087a;
        r3 = r3 + r4;
        r9.f2097g = r3;
        r3 = r9.f2093c;
        if (r3 >= 0) goto L_0x0075;
    L_0x006e:
        r3 = r9.f2097g;
        r4 = r9.f2093c;
        r3 = r3 + r4;
        r9.f2097g = r3;
    L_0x0075:
        r7.m3620a(r8, r9);
    L_0x0078:
        if (r11 == 0) goto L_0x0020;
    L_0x007a:
        r3 = r2.f2090d;
        if (r3 == 0) goto L_0x0020;
    L_0x007e:
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.a(android.support.v7.widget.ep, android.support.v7.widget.cw, android.support.v7.widget.ev, boolean):int");
    }

    void m3648a(ep epVar, ev evVar, cw cwVar, cv cvVar) {
        View a = cwVar.m4268a(epVar);
        if (a == null) {
            cvVar.f2088b = true;
            return;
        }
        int v;
        int d;
        int i;
        int i2;
        ek ekVar = (ek) a.getLayoutParams();
        if (cwVar.f2101k == null) {
            if (this.f1693k == (cwVar.f2096f == -1)) {
                m3549b(a);
            } else {
                m3550b(a, 0);
            }
        } else {
            boolean z;
            boolean z2 = this.f1693k;
            if (cwVar.f2096f == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 == z) {
                m3520a(a);
            } else {
                m3521a(a, 0);
            }
        }
        m3522a(a, 0, 0);
        cvVar.f2087a = this.f1692j.m4306c(a);
        if (this.f1691i == 1) {
            if (m3671g()) {
                v = m3606v() - m3610z();
                d = v - this.f1692j.m4308d(a);
            } else {
                d = m3608x();
                v = this.f1692j.m4308d(a) + d;
            }
            if (cwVar.f2096f == -1) {
                i = cwVar.f2092b - cvVar.f2087a;
                i2 = v;
                v = cwVar.f2092b;
            } else {
                i = cwVar.f2092b;
                i2 = v;
                v = cwVar.f2092b + cvVar.f2087a;
            }
        } else {
            i = m3609y();
            v = this.f1692j.m4308d(a) + i;
            if (cwVar.f2096f == -1) {
                d = cwVar.f2092b - cvVar.f2087a;
                i2 = cwVar.f2092b;
            } else {
                d = cwVar.f2092b;
                i2 = cwVar.f2092b + cvVar.f2087a;
            }
        }
        m3523a(a, d + ekVar.leftMargin, i + ekVar.topMargin, i2 - ekVar.rightMargin, v - ekVar.bottomMargin);
        if (ekVar.m4249c() || ekVar.m4250d()) {
            cvVar.f2089c = true;
        }
        cvVar.f2090d = a.isFocusable();
    }

    boolean m3674j() {
        return (m3605u() == 1073741824 || m3604t() == 1073741824 || !m3497G()) ? false : true;
    }

    int m3665e(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return -1;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return 1;
            case R.Toolbar_maxButtonHeight /*17*/:
                if (this.f1691i != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case R.AppCompatTheme_actionModeCopyDrawable /*33*/:
                if (this.f1691i != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case R.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                if (this.f1691i != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case 130:
                if (this.f1691i == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View m3612I() {
        return m3585h(this.f1693k ? m3603s() - 1 : 0);
    }

    private View m3613J() {
        return m3585h(this.f1693k ? 0 : m3603s() - 1);
    }

    private View m3615a(boolean z, boolean z2) {
        if (this.f1693k) {
            return m3642a(m3603s() - 1, -1, z, z2);
        }
        return m3642a(0, m3603s(), z, z2);
    }

    private View m3624b(boolean z, boolean z2) {
        if (this.f1693k) {
            return m3642a(0, m3603s(), z, z2);
        }
        return m3642a(m3603s() - 1, -1, z, z2);
    }

    private View m3630f(ep epVar, ev evVar) {
        return this.f1693k ? m3634h(epVar, evVar) : m3636i(epVar, evVar);
    }

    private View m3632g(ep epVar, ev evVar) {
        return this.f1693k ? m3636i(epVar, evVar) : m3634h(epVar, evVar);
    }

    private View m3634h(ep epVar, ev evVar) {
        return m3643a(epVar, evVar, 0, m3603s(), evVar.m4487e());
    }

    private View m3636i(ep epVar, ev evVar) {
        return m3643a(epVar, evVar, m3603s() - 1, -1, evVar.m4487e());
    }

    View m3643a(ep epVar, ev evVar, int i, int i2, int i3) {
        View view = null;
        m3672h();
        int c = this.f1692j.m4305c();
        int d = this.f1692j.m4307d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m3585h(i);
            int d2 = m3566d(h);
            if (d2 >= 0 && d2 < i3) {
                if (((ek) h.getLayoutParams()).m4249c()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                } else if (this.f1692j.m4300a(h) < d && this.f1692j.m4304b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                }
            }
            view3 = view;
            h = view2;
            i += i4;
            view = view3;
            view2 = h;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public int m3675k() {
        View a = m3642a(0, m3603s(), false, true);
        return a == null ? -1 : m3566d(a);
    }

    public int m3676l() {
        View a = m3642a(m3603s() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return m3566d(a);
    }

    View m3642a(int i, int i2, boolean z, boolean z2) {
        m3672h();
        int c = this.f1692j.m4305c();
        int d = this.f1692j.m4307d();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View h = m3585h(i);
            int a = this.f1692j.m4300a(h);
            int b = this.f1692j.m4304b(h);
            if (a < d && b > c) {
                if (!z) {
                    return h;
                }
                if (a >= c && b <= d) {
                    return h;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = h;
                }
            }
            h = view;
            i += i3;
            view = h;
        }
        return view;
    }

    public View m3644a(View view, int i, ep epVar, ev evVar) {
        m3611H();
        if (m3603s() == 0) {
            return null;
        }
        int e = m3665e(i);
        if (e == Integer.MIN_VALUE) {
            return null;
        }
        View g;
        m3672h();
        if (e == -1) {
            g = m3632g(epVar, evVar);
        } else {
            g = m3630f(epVar, evVar);
        }
        if (g == null) {
            return null;
        }
        View I;
        m3672h();
        m3616a(e, (int) (0.33333334f * ((float) this.f1692j.m4310f())), false, evVar);
        this.f1685a.f2097g = Integer.MIN_VALUE;
        this.f1685a.f2091a = false;
        m3639a(epVar, this.f1685a, evVar, true);
        if (e == -1) {
            I = m3612I();
        } else {
            I = m3613J();
        }
        if (I == g || !I.isFocusable()) {
            return null;
        }
        return I;
    }

    public boolean m3656b() {
        return this.f1696n == null && this.f1686b == this.f1688d;
    }
}
