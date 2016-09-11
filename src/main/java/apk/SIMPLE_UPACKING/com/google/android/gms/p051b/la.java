package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.la */
public final class la extends mm {
    private static volatile la[] f3891d;
    public Integer f3892a;
    public le[] f3893b;
    public lb[] f3894c;

    public la() {
        m6971b();
    }

    public static la[] m6968a() {
        if (f3891d == null) {
            synchronized (mk.f4051a) {
                if (f3891d == null) {
                    f3891d = new la[0];
                }
            }
        }
        return f3891d;
    }

    public la m6969a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            int b;
            Object obj;
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    this.f3892a = Integer.valueOf(mhVar.m7118f());
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    b = mo.m7197b(mhVar, 18);
                    a = this.f3893b == null ? 0 : this.f3893b.length;
                    obj = new le[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3893b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new le();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new le();
                    mhVar.m7109a(obj[a]);
                    this.f3893b = obj;
                    continue;
                case R.AppCompatTheme_actionMenuTextColor /*26*/:
                    b = mo.m7197b(mhVar, 26);
                    a = this.f3894c == null ? 0 : this.f3894c.length;
                    obj = new lb[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3894c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new lb();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new lb();
                    mhVar.m7109a(obj[a]);
                    this.f3894c = obj;
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

    public void m6970a(mi miVar) {
        int i = 0;
        if (this.f3892a != null) {
            miVar.m7159a(1, this.f3892a.intValue());
        }
        if (this.f3893b != null && this.f3893b.length > 0) {
            for (mm mmVar : this.f3893b) {
                if (mmVar != null) {
                    miVar.m7161a(2, mmVar);
                }
            }
        }
        if (this.f3894c != null && this.f3894c.length > 0) {
            while (i < this.f3894c.length) {
                mm mmVar2 = this.f3894c[i];
                if (mmVar2 != null) {
                    miVar.m7161a(3, mmVar2);
                }
                i++;
            }
        }
        super.m6962a(miVar);
    }

    public la m6971b() {
        this.f3892a = null;
        this.f3893b = le.m6991a();
        this.f3894c = lb.m6974a();
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m6972b(mh mhVar) {
        return m6969a(mhVar);
    }

    protected int m6973c() {
        int i = 0;
        int c = super.m6964c();
        if (this.f3892a != null) {
            c += mi.m7140b(1, this.f3892a.intValue());
        }
        if (this.f3893b != null && this.f3893b.length > 0) {
            int i2 = c;
            for (mm mmVar : this.f3893b) {
                if (mmVar != null) {
                    i2 += mi.m7141b(2, mmVar);
                }
            }
            c = i2;
        }
        if (this.f3894c != null && this.f3894c.length > 0) {
            while (i < this.f3894c.length) {
                mm mmVar2 = this.f3894c[i];
                if (mmVar2 != null) {
                    c += mi.m7141b(3, mmVar2);
                }
                i++;
            }
        }
        return c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof la)) {
            return false;
        }
        la laVar = (la) obj;
        if (this.f3892a == null) {
            if (laVar.f3892a != null) {
                return false;
            }
        } else if (!this.f3892a.equals(laVar.f3892a)) {
            return false;
        }
        return !mk.m7179a(this.f3893b, laVar.f3893b) ? false : mk.m7179a(this.f3894c, laVar.f3894c);
    }

    public int hashCode() {
        return (((((this.f3892a == null ? 0 : this.f3892a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + mk.m7177a(this.f3893b)) * 31) + mk.m7177a(this.f3894c);
    }
}
