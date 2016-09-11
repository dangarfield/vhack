package android.support.v7.widget;

import android.support.v4.p014g.Pools;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterHelper */
class ai implements OpReorderer {
    final ArrayList f1856a;
    final ArrayList f1857b;
    final aj f1858c;
    Runnable f1859d;
    final boolean f1860e;
    final dn f1861f;
    private Pools f1862g;
    private int f1863h;

    ai(aj ajVar) {
        this(ajVar, false);
    }

    ai(aj ajVar, boolean z) {
        this.f1862g = new Pools(30);
        this.f1856a = new ArrayList();
        this.f1857b = new ArrayList();
        this.f1863h = 0;
        this.f1858c = ajVar;
        this.f1860e = z;
        this.f1861f = new dn(this);
    }

    void m3927a() {
        m3930a(this.f1856a);
        m3930a(this.f1857b);
        this.f1863h = 0;
    }

    void m3933b() {
        this.f1861f.m4294a(this.f1856a);
        int size = this.f1856a.size();
        for (int i = 0; i < size; i++) {
            ak akVar = (ak) this.f1856a.get(i);
            switch (akVar.f1864a) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    m3923f(akVar);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    m3919c(akVar);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    m3920d(akVar);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    m3918b(akVar);
                    break;
            }
            if (this.f1859d != null) {
                this.f1859d.run();
            }
        }
        this.f1856a.clear();
    }

    void m3935c() {
        int size = this.f1857b.size();
        for (int i = 0; i < size; i++) {
            this.f1858c.m3944b((ak) this.f1857b.get(i));
        }
        m3930a(this.f1857b);
        this.f1863h = 0;
    }

    private void m3918b(ak akVar) {
        m3924g(akVar);
    }

    private void m3919c(ak akVar) {
        int i = akVar.f1865b;
        int i2 = akVar.f1865b + akVar.f1867d;
        Object obj = -1;
        int i3 = akVar.f1865b;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.f1858c.m3939a(i3) != null || m3921d(i3)) {
                if (obj == null) {
                    m3922e(m3926a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    m3924g(m3926a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != akVar.f1867d) {
            m3928a(akVar);
            akVar = m3926a(2, i, i4, null);
        }
        if (obj == null) {
            m3922e(akVar);
        } else {
            m3924g(akVar);
        }
    }

    private void m3920d(ak akVar) {
        int i = akVar.f1865b;
        int i2 = akVar.f1865b + akVar.f1867d;
        int i3 = akVar.f1865b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f1858c.m3939a(i3) != null || m3921d(i3)) {
                if (obj == null) {
                    m3922e(m3926a(4, i, i4, akVar.f1866c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m3924g(m3926a(4, i, i4, akVar.f1866c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != akVar.f1867d) {
            Object obj4 = akVar.f1866c;
            m3928a(akVar);
            akVar = m3926a(4, i, i4, obj4);
        }
        if (obj == null) {
            m3922e(akVar);
        } else {
            m3924g(akVar);
        }
    }

    private void m3922e(ak akVar) {
        if (akVar.f1864a == 1 || akVar.f1864a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int b = m3917b(akVar.f1865b, akVar.f1864a);
        int i2 = akVar.f1865b;
        switch (akVar.f1864a) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                i = 0;
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + akVar);
        }
        int i3 = 1;
        int i4 = b;
        b = i2;
        for (i2 = 1; i2 < akVar.f1867d; i2++) {
            Object obj;
            int b2 = m3917b(akVar.f1865b + (i * i2), akVar.f1864a);
            int i5;
            switch (akVar.f1864a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    if (b2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    if (b2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                ak a = m3926a(akVar.f1864a, i4, i3, akVar.f1866c);
                m3929a(a, b);
                m3928a(a);
                if (akVar.f1864a == 4) {
                    b += i3;
                }
                i3 = 1;
                i4 = b2;
            }
        }
        Object obj2 = akVar.f1866c;
        m3928a(akVar);
        if (i3 > 0) {
            ak a2 = m3926a(akVar.f1864a, i4, i3, obj2);
            m3929a(a2, b);
            m3928a(a2);
        }
    }

    void m3929a(ak akVar, int i) {
        this.f1858c.m3942a(akVar);
        switch (akVar.f1864a) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f1858c.m3940a(i, akVar.f1867d);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                this.f1858c.m3941a(i, akVar.f1867d, akVar.f1866c);
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int m3917b(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.f1857b.size() - 1; size >= 0; size--) {
            ak akVar = (ak) this.f1857b.get(size);
            if (akVar.f1864a == 8) {
                int i5;
                int i6;
                if (akVar.f1865b < akVar.f1867d) {
                    i5 = akVar.f1865b;
                    i3 = akVar.f1867d;
                } else {
                    i5 = akVar.f1867d;
                    i3 = akVar.f1865b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < akVar.f1865b) {
                        if (i2 == 1) {
                            akVar.f1865b++;
                            akVar.f1867d++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            akVar.f1865b--;
                            akVar.f1867d--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == akVar.f1865b) {
                    if (i2 == 1) {
                        akVar.f1867d++;
                    } else if (i2 == 2) {
                        akVar.f1867d--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        akVar.f1865b++;
                    } else if (i2 == 2) {
                        akVar.f1865b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (akVar.f1865b <= i4) {
                if (akVar.f1864a == 1) {
                    i4 -= akVar.f1867d;
                } else if (akVar.f1864a == 2) {
                    i4 += akVar.f1867d;
                }
            } else if (i2 == 1) {
                akVar.f1865b++;
            } else if (i2 == 2) {
                akVar.f1865b--;
            }
        }
        for (i3 = this.f1857b.size() - 1; i3 >= 0; i3--) {
            akVar = (ak) this.f1857b.get(i3);
            if (akVar.f1864a == 8) {
                if (akVar.f1867d == akVar.f1865b || akVar.f1867d < 0) {
                    this.f1857b.remove(i3);
                    m3928a(akVar);
                }
            } else if (akVar.f1867d <= 0) {
                this.f1857b.remove(i3);
                m3928a(akVar);
            }
        }
        return i4;
    }

    private boolean m3921d(int i) {
        int size = this.f1857b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ak akVar = (ak) this.f1857b.get(i2);
            if (akVar.f1864a == 8) {
                if (m3925a(akVar.f1867d, i2 + 1) == i) {
                    return true;
                }
            } else if (akVar.f1864a == 1) {
                int i3 = akVar.f1865b + akVar.f1867d;
                for (int i4 = akVar.f1865b; i4 < i3; i4++) {
                    if (m3925a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m3923f(ak akVar) {
        m3924g(akVar);
    }

    private void m3924g(ak akVar) {
        this.f1857b.add(akVar);
        switch (akVar.f1864a) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f1858c.m3945c(akVar.f1865b, akVar.f1867d);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f1858c.m3943b(akVar.f1865b, akVar.f1867d);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                this.f1858c.m3941a(akVar.f1865b, akVar.f1867d, akVar.f1866c);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                this.f1858c.m3946d(akVar.f1865b, akVar.f1867d);
            default:
                throw new IllegalArgumentException("Unknown update op type for " + akVar);
        }
    }

    boolean m3936d() {
        return this.f1856a.size() > 0;
    }

    boolean m3931a(int i) {
        return (this.f1863h & i) != 0;
    }

    int m3932b(int i) {
        return m3925a(i, 0);
    }

    int m3925a(int i, int i2) {
        int size = this.f1857b.size();
        int i3 = i;
        while (i2 < size) {
            ak akVar = (ak) this.f1857b.get(i2);
            if (akVar.f1864a == 8) {
                if (akVar.f1865b == i3) {
                    i3 = akVar.f1867d;
                } else {
                    if (akVar.f1865b < i3) {
                        i3--;
                    }
                    if (akVar.f1867d <= i3) {
                        i3++;
                    }
                }
            } else if (akVar.f1865b > i3) {
                continue;
            } else if (akVar.f1864a == 2) {
                if (i3 < akVar.f1865b + akVar.f1867d) {
                    return -1;
                }
                i3 -= akVar.f1867d;
            } else if (akVar.f1864a == 1) {
                i3 += akVar.f1867d;
            }
            i2++;
        }
        return i3;
    }

    void m3937e() {
        m3935c();
        int size = this.f1856a.size();
        for (int i = 0; i < size; i++) {
            ak akVar = (ak) this.f1856a.get(i);
            switch (akVar.f1864a) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    this.f1858c.m3944b(akVar);
                    this.f1858c.m3945c(akVar.f1865b, akVar.f1867d);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    this.f1858c.m3944b(akVar);
                    this.f1858c.m3940a(akVar.f1865b, akVar.f1867d);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    this.f1858c.m3944b(akVar);
                    this.f1858c.m3941a(akVar.f1865b, akVar.f1867d, akVar.f1866c);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    this.f1858c.m3944b(akVar);
                    this.f1858c.m3946d(akVar.f1865b, akVar.f1867d);
                    break;
            }
            if (this.f1859d != null) {
                this.f1859d.run();
            }
        }
        m3930a(this.f1856a);
        this.f1863h = 0;
    }

    public int m3934c(int i) {
        int size = this.f1856a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            ak akVar = (ak) this.f1856a.get(i3);
            switch (akVar.f1864a) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    if (akVar.f1865b > i2) {
                        break;
                    }
                    i2 += akVar.f1867d;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    if (akVar.f1865b <= i2) {
                        if (akVar.f1865b + akVar.f1867d <= i2) {
                            i2 -= akVar.f1867d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    if (akVar.f1865b != i2) {
                        if (akVar.f1865b < i2) {
                            i2--;
                        }
                        if (akVar.f1867d > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = akVar.f1867d;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    boolean m3938f() {
        return (this.f1857b.isEmpty() || this.f1856a.isEmpty()) ? false : true;
    }

    public ak m3926a(int i, int i2, int i3, Object obj) {
        ak akVar = (ak) this.f1862g.m1523a();
        if (akVar == null) {
            return new ak(i, i2, i3, obj);
        }
        akVar.f1864a = i;
        akVar.f1865b = i2;
        akVar.f1867d = i3;
        akVar.f1866c = obj;
        return akVar;
    }

    public void m3928a(ak akVar) {
        if (!this.f1860e) {
            akVar.f1866c = null;
            this.f1862g.m1524a(akVar);
        }
    }

    void m3930a(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m3928a((ak) list.get(i));
        }
        list.clear();
    }
}
