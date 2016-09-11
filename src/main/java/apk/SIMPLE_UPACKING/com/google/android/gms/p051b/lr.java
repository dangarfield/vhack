package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.lr */
public final class lr extends mm {
    public long[] f3976a;
    public long[] f3977b;

    public lr() {
        m7048a();
    }

    public lr m7048a() {
        this.f3976a = mo.f4053b;
        this.f3977b = mo.f4053b;
        this.B = -1;
        return this;
    }

    public lr m7049a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            int b;
            Object obj;
            int c;
            Object obj2;
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    b = mo.m7197b(mhVar, 8);
                    a = this.f3976a == null ? 0 : this.f3976a.length;
                    obj = new long[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3976a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = mhVar.m7114d();
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = mhVar.m7114d();
                    this.f3976a = obj;
                    continue;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    c = mhVar.m7113c(mhVar.m7123i());
                    b = mhVar.m7129o();
                    a = 0;
                    while (mhVar.m7127m() > 0) {
                        mhVar.m7114d();
                        a++;
                    }
                    mhVar.m7117e(b);
                    b = this.f3976a == null ? 0 : this.f3976a.length;
                    obj2 = new long[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.f3976a, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = mhVar.m7114d();
                        b++;
                    }
                    this.f3976a = obj2;
                    mhVar.m7115d(c);
                    continue;
                case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                    b = mo.m7197b(mhVar, 16);
                    a = this.f3977b == null ? 0 : this.f3977b.length;
                    obj = new long[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3977b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = mhVar.m7114d();
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = mhVar.m7114d();
                    this.f3977b = obj;
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    c = mhVar.m7113c(mhVar.m7123i());
                    b = mhVar.m7129o();
                    a = 0;
                    while (mhVar.m7127m() > 0) {
                        mhVar.m7114d();
                        a++;
                    }
                    mhVar.m7117e(b);
                    b = this.f3977b == null ? 0 : this.f3977b.length;
                    obj2 = new long[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.f3977b, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = mhVar.m7114d();
                        b++;
                    }
                    this.f3977b = obj2;
                    mhVar.m7115d(c);
                    continue;
                default:
                    if (!mo.m7195a(mhVar, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public void m7050a(mi miVar) {
        int i = 0;
        if (this.f3976a != null && this.f3976a.length > 0) {
            for (long a : this.f3976a) {
                miVar.m7160a(1, a);
            }
        }
        if (this.f3977b != null && this.f3977b.length > 0) {
            while (i < this.f3977b.length) {
                miVar.m7160a(2, this.f3977b[i]);
                i++;
            }
        }
        super.m6962a(miVar);
    }

    public /* synthetic */ mm m7051b(mh mhVar) {
        return m7049a(mhVar);
    }

    protected int m7052c() {
        int i;
        int i2;
        int i3 = 0;
        int c = super.m6964c();
        if (this.f3976a == null || this.f3976a.length <= 0) {
            i = c;
        } else {
            i2 = 0;
            for (long c2 : this.f3976a) {
                i2 += mi.m7149c(c2);
            }
            i = (c + i2) + (this.f3976a.length * 1);
        }
        if (this.f3977b == null || this.f3977b.length <= 0) {
            return i;
        }
        i2 = 0;
        while (i3 < this.f3977b.length) {
            i2 += mi.m7149c(this.f3977b[i3]);
            i3++;
        }
        return (i + i2) + (this.f3977b.length * 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lr)) {
            return false;
        }
        lr lrVar = (lr) obj;
        return !mk.m7178a(this.f3976a, lrVar.f3976a) ? false : mk.m7178a(this.f3977b, lrVar.f3977b);
    }

    public int hashCode() {
        return ((((getClass().getName().hashCode() + 527) * 31) + mk.m7176a(this.f3976a)) * 31) + mk.m7176a(this.f3977b);
    }
}
