package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.lm */
public final class lm extends mm {
    private static volatile lm[] f3931e;
    public Integer f3932a;
    public lr f3933b;
    public lr f3934c;
    public Boolean f3935d;

    public lm() {
        m7022b();
    }

    public static lm[] m7019a() {
        if (f3931e == null) {
            synchronized (mk.f4051a) {
                if (f3931e == null) {
                    f3931e = new lm[0];
                }
            }
        }
        return f3931e;
    }

    public lm m7020a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    this.f3932a = Integer.valueOf(mhVar.m7118f());
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    if (this.f3933b == null) {
                        this.f3933b = new lr();
                    }
                    mhVar.m7109a(this.f3933b);
                    continue;
                case R.AppCompatTheme_actionMenuTextColor /*26*/:
                    if (this.f3934c == null) {
                        this.f3934c = new lr();
                    }
                    mhVar.m7109a(this.f3934c);
                    continue;
                case R.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.f3935d = Boolean.valueOf(mhVar.m7121g());
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

    public void m7021a(mi miVar) {
        if (this.f3932a != null) {
            miVar.m7159a(1, this.f3932a.intValue());
        }
        if (this.f3933b != null) {
            miVar.m7161a(2, this.f3933b);
        }
        if (this.f3934c != null) {
            miVar.m7161a(3, this.f3934c);
        }
        if (this.f3935d != null) {
            miVar.m7163a(4, this.f3935d.booleanValue());
        }
        super.m6962a(miVar);
    }

    public lm m7022b() {
        this.f3932a = null;
        this.f3933b = null;
        this.f3934c = null;
        this.f3935d = null;
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m7023b(mh mhVar) {
        return m7020a(mhVar);
    }

    protected int m7024c() {
        int c = super.m6964c();
        if (this.f3932a != null) {
            c += mi.m7140b(1, this.f3932a.intValue());
        }
        if (this.f3933b != null) {
            c += mi.m7141b(2, this.f3933b);
        }
        if (this.f3934c != null) {
            c += mi.m7141b(3, this.f3934c);
        }
        return this.f3935d != null ? c + mi.m7143b(4, this.f3935d.booleanValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lm)) {
            return false;
        }
        lm lmVar = (lm) obj;
        if (this.f3932a == null) {
            if (lmVar.f3932a != null) {
                return false;
            }
        } else if (!this.f3932a.equals(lmVar.f3932a)) {
            return false;
        }
        if (this.f3933b == null) {
            if (lmVar.f3933b != null) {
                return false;
            }
        } else if (!this.f3933b.equals(lmVar.f3933b)) {
            return false;
        }
        if (this.f3934c == null) {
            if (lmVar.f3934c != null) {
                return false;
            }
        } else if (!this.f3934c.equals(lmVar.f3934c)) {
            return false;
        }
        return this.f3935d == null ? lmVar.f3935d == null : this.f3935d.equals(lmVar.f3935d);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3934c == null ? 0 : this.f3934c.hashCode()) + (((this.f3933b == null ? 0 : this.f3933b.hashCode()) + (((this.f3932a == null ? 0 : this.f3932a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        if (this.f3935d != null) {
            i = this.f3935d.hashCode();
        }
        return hashCode + i;
    }
}
