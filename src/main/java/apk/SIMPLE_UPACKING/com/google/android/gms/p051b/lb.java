package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.lb */
public final class lb extends mm {
    private static volatile lb[] f3895f;
    public Integer f3896a;
    public String f3897b;
    public lc[] f3898c;
    public Boolean f3899d;
    public ld f3900e;

    public lb() {
        m6977b();
    }

    public static lb[] m6974a() {
        if (f3895f == null) {
            synchronized (mk.f4051a) {
                if (f3895f == null) {
                    f3895f = new lb[0];
                }
            }
        }
        return f3895f;
    }

    public lb m6975a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    this.f3896a = Integer.valueOf(mhVar.m7118f());
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    this.f3897b = mhVar.m7122h();
                    continue;
                case R.AppCompatTheme_actionMenuTextColor /*26*/:
                    int b = mo.m7197b(mhVar, 26);
                    a = this.f3898c == null ? 0 : this.f3898c.length;
                    Object obj = new lc[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3898c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new lc();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new lc();
                    mhVar.m7109a(obj[a]);
                    this.f3898c = obj;
                    continue;
                case R.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.f3899d = Boolean.valueOf(mhVar.m7121g());
                    continue;
                case R.AppCompatTheme_dialogTheme /*42*/:
                    if (this.f3900e == null) {
                        this.f3900e = new ld();
                    }
                    mhVar.m7109a(this.f3900e);
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

    public void m6976a(mi miVar) {
        if (this.f3896a != null) {
            miVar.m7159a(1, this.f3896a.intValue());
        }
        if (this.f3897b != null) {
            miVar.m7162a(2, this.f3897b);
        }
        if (this.f3898c != null && this.f3898c.length > 0) {
            for (mm mmVar : this.f3898c) {
                if (mmVar != null) {
                    miVar.m7161a(3, mmVar);
                }
            }
        }
        if (this.f3899d != null) {
            miVar.m7163a(4, this.f3899d.booleanValue());
        }
        if (this.f3900e != null) {
            miVar.m7161a(5, this.f3900e);
        }
        super.m6962a(miVar);
    }

    public lb m6977b() {
        this.f3896a = null;
        this.f3897b = null;
        this.f3898c = lc.m6980a();
        this.f3899d = null;
        this.f3900e = null;
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m6978b(mh mhVar) {
        return m6975a(mhVar);
    }

    protected int m6979c() {
        int c = super.m6964c();
        if (this.f3896a != null) {
            c += mi.m7140b(1, this.f3896a.intValue());
        }
        if (this.f3897b != null) {
            c += mi.m7142b(2, this.f3897b);
        }
        if (this.f3898c != null && this.f3898c.length > 0) {
            int i = c;
            for (mm mmVar : this.f3898c) {
                if (mmVar != null) {
                    i += mi.m7141b(3, mmVar);
                }
            }
            c = i;
        }
        if (this.f3899d != null) {
            c += mi.m7143b(4, this.f3899d.booleanValue());
        }
        return this.f3900e != null ? c + mi.m7141b(5, this.f3900e) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lb)) {
            return false;
        }
        lb lbVar = (lb) obj;
        if (this.f3896a == null) {
            if (lbVar.f3896a != null) {
                return false;
            }
        } else if (!this.f3896a.equals(lbVar.f3896a)) {
            return false;
        }
        if (this.f3897b == null) {
            if (lbVar.f3897b != null) {
                return false;
            }
        } else if (!this.f3897b.equals(lbVar.f3897b)) {
            return false;
        }
        if (!mk.m7179a(this.f3898c, lbVar.f3898c)) {
            return false;
        }
        if (this.f3899d == null) {
            if (lbVar.f3899d != null) {
                return false;
            }
        } else if (!this.f3899d.equals(lbVar.f3899d)) {
            return false;
        }
        return this.f3900e == null ? lbVar.f3900e == null : this.f3900e.equals(lbVar.f3900e);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3899d == null ? 0 : this.f3899d.hashCode()) + (((((this.f3897b == null ? 0 : this.f3897b.hashCode()) + (((this.f3896a == null ? 0 : this.f3896a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + mk.m7177a(this.f3898c)) * 31)) * 31;
        if (this.f3900e != null) {
            i = this.f3900e.hashCode();
        }
        return hashCode + i;
    }
}
