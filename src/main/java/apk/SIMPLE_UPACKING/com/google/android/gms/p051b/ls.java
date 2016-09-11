package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.ls */
public final class ls extends mm {
    private static volatile ls[] f3978f;
    public Long f3979a;
    public String f3980b;
    public String f3981c;
    public Long f3982d;
    public Float f3983e;

    public ls() {
        m7056b();
    }

    public static ls[] m7053a() {
        if (f3978f == null) {
            synchronized (mk.f4051a) {
                if (f3978f == null) {
                    f3978f = new ls[0];
                }
            }
        }
        return f3978f;
    }

    public ls m7054a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    this.f3979a = Long.valueOf(mhVar.m7116e());
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    this.f3980b = mhVar.m7122h();
                    continue;
                case R.AppCompatTheme_actionMenuTextColor /*26*/:
                    this.f3981c = mhVar.m7122h();
                    continue;
                case R.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.f3982d = Long.valueOf(mhVar.m7116e());
                    continue;
                case R.AppCompatTheme_actionDropDownStyle /*45*/:
                    this.f3983e = Float.valueOf(mhVar.m7112c());
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

    public void m7055a(mi miVar) {
        if (this.f3979a != null) {
            miVar.m7169b(1, this.f3979a.longValue());
        }
        if (this.f3980b != null) {
            miVar.m7162a(2, this.f3980b);
        }
        if (this.f3981c != null) {
            miVar.m7162a(3, this.f3981c);
        }
        if (this.f3982d != null) {
            miVar.m7169b(4, this.f3982d.longValue());
        }
        if (this.f3983e != null) {
            miVar.m7158a(5, this.f3983e.floatValue());
        }
        super.m6962a(miVar);
    }

    public ls m7056b() {
        this.f3979a = null;
        this.f3980b = null;
        this.f3981c = null;
        this.f3982d = null;
        this.f3983e = null;
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m7057b(mh mhVar) {
        return m7054a(mhVar);
    }

    protected int m7058c() {
        int c = super.m6964c();
        if (this.f3979a != null) {
            c += mi.m7148c(1, this.f3979a.longValue());
        }
        if (this.f3980b != null) {
            c += mi.m7142b(2, this.f3980b);
        }
        if (this.f3981c != null) {
            c += mi.m7142b(3, this.f3981c);
        }
        if (this.f3982d != null) {
            c += mi.m7148c(4, this.f3982d.longValue());
        }
        return this.f3983e != null ? c + mi.m7139b(5, this.f3983e.floatValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ls)) {
            return false;
        }
        ls lsVar = (ls) obj;
        if (this.f3979a == null) {
            if (lsVar.f3979a != null) {
                return false;
            }
        } else if (!this.f3979a.equals(lsVar.f3979a)) {
            return false;
        }
        if (this.f3980b == null) {
            if (lsVar.f3980b != null) {
                return false;
            }
        } else if (!this.f3980b.equals(lsVar.f3980b)) {
            return false;
        }
        if (this.f3981c == null) {
            if (lsVar.f3981c != null) {
                return false;
            }
        } else if (!this.f3981c.equals(lsVar.f3981c)) {
            return false;
        }
        if (this.f3982d == null) {
            if (lsVar.f3982d != null) {
                return false;
            }
        } else if (!this.f3982d.equals(lsVar.f3982d)) {
            return false;
        }
        return this.f3983e == null ? lsVar.f3983e == null : this.f3983e.equals(lsVar.f3983e);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3982d == null ? 0 : this.f3982d.hashCode()) + (((this.f3981c == null ? 0 : this.f3981c.hashCode()) + (((this.f3980b == null ? 0 : this.f3980b.hashCode()) + (((this.f3979a == null ? 0 : this.f3979a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f3983e != null) {
            i = this.f3983e.hashCode();
        }
        return hashCode + i;
    }
}
