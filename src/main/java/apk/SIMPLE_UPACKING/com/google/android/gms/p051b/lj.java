package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.lj */
public final class lj extends mm {
    public Long f3922a;
    public String f3923b;
    public Integer f3924c;
    public lk[] f3925d;
    public li[] f3926e;
    public la[] f3927f;

    public lj() {
        m7008a();
    }

    public lj m7008a() {
        this.f3922a = null;
        this.f3923b = null;
        this.f3924c = null;
        this.f3925d = lk.m7013a();
        this.f3926e = li.m7002a();
        this.f3927f = la.m6968a();
        this.B = -1;
        return this;
    }

    public lj m7009a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            int b;
            Object obj;
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    this.f3922a = Long.valueOf(mhVar.m7116e());
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    this.f3923b = mhVar.m7122h();
                    continue;
                case R.Toolbar_subtitleTextColor /*24*/:
                    this.f3924c = Integer.valueOf(mhVar.m7118f());
                    continue;
                case R.AppCompatTheme_actionModePasteDrawable /*34*/:
                    b = mo.m7197b(mhVar, 34);
                    a = this.f3925d == null ? 0 : this.f3925d.length;
                    obj = new lk[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3925d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new lk();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new lk();
                    mhVar.m7109a(obj[a]);
                    this.f3925d = obj;
                    continue;
                case R.AppCompatTheme_dialogTheme /*42*/:
                    b = mo.m7197b(mhVar, 42);
                    a = this.f3926e == null ? 0 : this.f3926e.length;
                    obj = new li[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3926e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new li();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new li();
                    mhVar.m7109a(obj[a]);
                    this.f3926e = obj;
                    continue;
                case R.AppCompatTheme_buttonBarStyle /*50*/:
                    b = mo.m7197b(mhVar, 50);
                    a = this.f3927f == null ? 0 : this.f3927f.length;
                    obj = new la[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3927f, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new la();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new la();
                    mhVar.m7109a(obj[a]);
                    this.f3927f = obj;
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

    public void m7010a(mi miVar) {
        int i = 0;
        if (this.f3922a != null) {
            miVar.m7169b(1, this.f3922a.longValue());
        }
        if (this.f3923b != null) {
            miVar.m7162a(2, this.f3923b);
        }
        if (this.f3924c != null) {
            miVar.m7159a(3, this.f3924c.intValue());
        }
        if (this.f3925d != null && this.f3925d.length > 0) {
            for (mm mmVar : this.f3925d) {
                if (mmVar != null) {
                    miVar.m7161a(4, mmVar);
                }
            }
        }
        if (this.f3926e != null && this.f3926e.length > 0) {
            for (mm mmVar2 : this.f3926e) {
                if (mmVar2 != null) {
                    miVar.m7161a(5, mmVar2);
                }
            }
        }
        if (this.f3927f != null && this.f3927f.length > 0) {
            while (i < this.f3927f.length) {
                mm mmVar3 = this.f3927f[i];
                if (mmVar3 != null) {
                    miVar.m7161a(6, mmVar3);
                }
                i++;
            }
        }
        super.m6962a(miVar);
    }

    public /* synthetic */ mm m7011b(mh mhVar) {
        return m7009a(mhVar);
    }

    protected int m7012c() {
        int i;
        int i2 = 0;
        int c = super.m6964c();
        if (this.f3922a != null) {
            c += mi.m7148c(1, this.f3922a.longValue());
        }
        if (this.f3923b != null) {
            c += mi.m7142b(2, this.f3923b);
        }
        if (this.f3924c != null) {
            c += mi.m7140b(3, this.f3924c.intValue());
        }
        if (this.f3925d != null && this.f3925d.length > 0) {
            i = c;
            for (mm mmVar : this.f3925d) {
                if (mmVar != null) {
                    i += mi.m7141b(4, mmVar);
                }
            }
            c = i;
        }
        if (this.f3926e != null && this.f3926e.length > 0) {
            i = c;
            for (mm mmVar2 : this.f3926e) {
                if (mmVar2 != null) {
                    i += mi.m7141b(5, mmVar2);
                }
            }
            c = i;
        }
        if (this.f3927f != null && this.f3927f.length > 0) {
            while (i2 < this.f3927f.length) {
                mm mmVar3 = this.f3927f[i2];
                if (mmVar3 != null) {
                    c += mi.m7141b(6, mmVar3);
                }
                i2++;
            }
        }
        return c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lj)) {
            return false;
        }
        lj ljVar = (lj) obj;
        if (this.f3922a == null) {
            if (ljVar.f3922a != null) {
                return false;
            }
        } else if (!this.f3922a.equals(ljVar.f3922a)) {
            return false;
        }
        if (this.f3923b == null) {
            if (ljVar.f3923b != null) {
                return false;
            }
        } else if (!this.f3923b.equals(ljVar.f3923b)) {
            return false;
        }
        if (this.f3924c == null) {
            if (ljVar.f3924c != null) {
                return false;
            }
        } else if (!this.f3924c.equals(ljVar.f3924c)) {
            return false;
        }
        return !mk.m7179a(this.f3925d, ljVar.f3925d) ? false : !mk.m7179a(this.f3926e, ljVar.f3926e) ? false : mk.m7179a(this.f3927f, ljVar.f3927f);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3923b == null ? 0 : this.f3923b.hashCode()) + (((this.f3922a == null ? 0 : this.f3922a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f3924c != null) {
            i = this.f3924c.hashCode();
        }
        return ((((((hashCode + i) * 31) + mk.m7177a(this.f3925d)) * 31) + mk.m7177a(this.f3926e)) * 31) + mk.m7177a(this.f3927f);
    }
}
