package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.ln */
public final class ln extends mm {
    private static volatile ln[] f3936f;
    public lo[] f3937a;
    public String f3938b;
    public Long f3939c;
    public Long f3940d;
    public Integer f3941e;

    public ln() {
        m7028b();
    }

    public static ln[] m7025a() {
        if (f3936f == null) {
            synchronized (mk.f4051a) {
                if (f3936f == null) {
                    f3936f = new ln[0];
                }
            }
        }
        return f3936f;
    }

    public ln m7026a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    int b = mo.m7197b(mhVar, 10);
                    a = this.f3937a == null ? 0 : this.f3937a.length;
                    Object obj = new lo[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3937a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new lo();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new lo();
                    mhVar.m7109a(obj[a]);
                    this.f3937a = obj;
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    this.f3938b = mhVar.m7122h();
                    continue;
                case R.Toolbar_subtitleTextColor /*24*/:
                    this.f3939c = Long.valueOf(mhVar.m7116e());
                    continue;
                case R.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.f3940d = Long.valueOf(mhVar.m7116e());
                    continue;
                case R.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    this.f3941e = Integer.valueOf(mhVar.m7118f());
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

    public void m7027a(mi miVar) {
        if (this.f3937a != null && this.f3937a.length > 0) {
            for (mm mmVar : this.f3937a) {
                if (mmVar != null) {
                    miVar.m7161a(1, mmVar);
                }
            }
        }
        if (this.f3938b != null) {
            miVar.m7162a(2, this.f3938b);
        }
        if (this.f3939c != null) {
            miVar.m7169b(3, this.f3939c.longValue());
        }
        if (this.f3940d != null) {
            miVar.m7169b(4, this.f3940d.longValue());
        }
        if (this.f3941e != null) {
            miVar.m7159a(5, this.f3941e.intValue());
        }
        super.m6962a(miVar);
    }

    public ln m7028b() {
        this.f3937a = lo.m7031a();
        this.f3938b = null;
        this.f3939c = null;
        this.f3940d = null;
        this.f3941e = null;
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m7029b(mh mhVar) {
        return m7026a(mhVar);
    }

    protected int m7030c() {
        int c = super.m6964c();
        if (this.f3937a != null && this.f3937a.length > 0) {
            for (mm mmVar : this.f3937a) {
                if (mmVar != null) {
                    c += mi.m7141b(1, mmVar);
                }
            }
        }
        if (this.f3938b != null) {
            c += mi.m7142b(2, this.f3938b);
        }
        if (this.f3939c != null) {
            c += mi.m7148c(3, this.f3939c.longValue());
        }
        if (this.f3940d != null) {
            c += mi.m7148c(4, this.f3940d.longValue());
        }
        return this.f3941e != null ? c + mi.m7140b(5, this.f3941e.intValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ln)) {
            return false;
        }
        ln lnVar = (ln) obj;
        if (!mk.m7179a(this.f3937a, lnVar.f3937a)) {
            return false;
        }
        if (this.f3938b == null) {
            if (lnVar.f3938b != null) {
                return false;
            }
        } else if (!this.f3938b.equals(lnVar.f3938b)) {
            return false;
        }
        if (this.f3939c == null) {
            if (lnVar.f3939c != null) {
                return false;
            }
        } else if (!this.f3939c.equals(lnVar.f3939c)) {
            return false;
        }
        if (this.f3940d == null) {
            if (lnVar.f3940d != null) {
                return false;
            }
        } else if (!this.f3940d.equals(lnVar.f3940d)) {
            return false;
        }
        return this.f3941e == null ? lnVar.f3941e == null : this.f3941e.equals(lnVar.f3941e);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3940d == null ? 0 : this.f3940d.hashCode()) + (((this.f3939c == null ? 0 : this.f3939c.hashCode()) + (((this.f3938b == null ? 0 : this.f3938b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + mk.m7177a(this.f3937a)) * 31)) * 31)) * 31)) * 31;
        if (this.f3941e != null) {
            i = this.f3941e.hashCode();
        }
        return hashCode + i;
    }
}
