package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.lo */
public final class lo extends mm {
    private static volatile lo[] f3942e;
    public String f3943a;
    public String f3944b;
    public Long f3945c;
    public Float f3946d;

    public lo() {
        m7034b();
    }

    public static lo[] m7031a() {
        if (f3942e == null) {
            synchronized (mk.f4051a) {
                if (f3942e == null) {
                    f3942e = new lo[0];
                }
            }
        }
        return f3942e;
    }

    public lo m7032a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    this.f3943a = mhVar.m7122h();
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    this.f3944b = mhVar.m7122h();
                    continue;
                case R.Toolbar_subtitleTextColor /*24*/:
                    this.f3945c = Long.valueOf(mhVar.m7116e());
                    continue;
                case R.AppCompatTheme_actionModeFindDrawable /*37*/:
                    this.f3946d = Float.valueOf(mhVar.m7112c());
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

    public void m7033a(mi miVar) {
        if (this.f3943a != null) {
            miVar.m7162a(1, this.f3943a);
        }
        if (this.f3944b != null) {
            miVar.m7162a(2, this.f3944b);
        }
        if (this.f3945c != null) {
            miVar.m7169b(3, this.f3945c.longValue());
        }
        if (this.f3946d != null) {
            miVar.m7158a(4, this.f3946d.floatValue());
        }
        super.m6962a(miVar);
    }

    public lo m7034b() {
        this.f3943a = null;
        this.f3944b = null;
        this.f3945c = null;
        this.f3946d = null;
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m7035b(mh mhVar) {
        return m7032a(mhVar);
    }

    protected int m7036c() {
        int c = super.m6964c();
        if (this.f3943a != null) {
            c += mi.m7142b(1, this.f3943a);
        }
        if (this.f3944b != null) {
            c += mi.m7142b(2, this.f3944b);
        }
        if (this.f3945c != null) {
            c += mi.m7148c(3, this.f3945c.longValue());
        }
        return this.f3946d != null ? c + mi.m7139b(4, this.f3946d.floatValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lo)) {
            return false;
        }
        lo loVar = (lo) obj;
        if (this.f3943a == null) {
            if (loVar.f3943a != null) {
                return false;
            }
        } else if (!this.f3943a.equals(loVar.f3943a)) {
            return false;
        }
        if (this.f3944b == null) {
            if (loVar.f3944b != null) {
                return false;
            }
        } else if (!this.f3944b.equals(loVar.f3944b)) {
            return false;
        }
        if (this.f3945c == null) {
            if (loVar.f3945c != null) {
                return false;
            }
        } else if (!this.f3945c.equals(loVar.f3945c)) {
            return false;
        }
        return this.f3946d == null ? loVar.f3946d == null : this.f3946d.equals(loVar.f3946d);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3945c == null ? 0 : this.f3945c.hashCode()) + (((this.f3944b == null ? 0 : this.f3944b.hashCode()) + (((this.f3943a == null ? 0 : this.f3943a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        if (this.f3946d != null) {
            i = this.f3946d.hashCode();
        }
        return hashCode + i;
    }
}
