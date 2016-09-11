package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.lc */
public final class lc extends mm {
    private static volatile lc[] f3901e;
    public lf f3902a;
    public ld f3903b;
    public Boolean f3904c;
    public String f3905d;

    public lc() {
        m6983b();
    }

    public static lc[] m6980a() {
        if (f3901e == null) {
            synchronized (mk.f4051a) {
                if (f3901e == null) {
                    f3901e = new lc[0];
                }
            }
        }
        return f3901e;
    }

    public lc m6981a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    if (this.f3902a == null) {
                        this.f3902a = new lf();
                    }
                    mhVar.m7109a(this.f3902a);
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    if (this.f3903b == null) {
                        this.f3903b = new ld();
                    }
                    mhVar.m7109a(this.f3903b);
                    continue;
                case R.Toolbar_subtitleTextColor /*24*/:
                    this.f3904c = Boolean.valueOf(mhVar.m7121g());
                    continue;
                case R.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.f3905d = mhVar.m7122h();
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

    public void m6982a(mi miVar) {
        if (this.f3902a != null) {
            miVar.m7161a(1, this.f3902a);
        }
        if (this.f3903b != null) {
            miVar.m7161a(2, this.f3903b);
        }
        if (this.f3904c != null) {
            miVar.m7163a(3, this.f3904c.booleanValue());
        }
        if (this.f3905d != null) {
            miVar.m7162a(4, this.f3905d);
        }
        super.m6962a(miVar);
    }

    public lc m6983b() {
        this.f3902a = null;
        this.f3903b = null;
        this.f3904c = null;
        this.f3905d = null;
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m6984b(mh mhVar) {
        return m6981a(mhVar);
    }

    protected int m6985c() {
        int c = super.m6964c();
        if (this.f3902a != null) {
            c += mi.m7141b(1, this.f3902a);
        }
        if (this.f3903b != null) {
            c += mi.m7141b(2, this.f3903b);
        }
        if (this.f3904c != null) {
            c += mi.m7143b(3, this.f3904c.booleanValue());
        }
        return this.f3905d != null ? c + mi.m7142b(4, this.f3905d) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lc)) {
            return false;
        }
        lc lcVar = (lc) obj;
        if (this.f3902a == null) {
            if (lcVar.f3902a != null) {
                return false;
            }
        } else if (!this.f3902a.equals(lcVar.f3902a)) {
            return false;
        }
        if (this.f3903b == null) {
            if (lcVar.f3903b != null) {
                return false;
            }
        } else if (!this.f3903b.equals(lcVar.f3903b)) {
            return false;
        }
        if (this.f3904c == null) {
            if (lcVar.f3904c != null) {
                return false;
            }
        } else if (!this.f3904c.equals(lcVar.f3904c)) {
            return false;
        }
        return this.f3905d == null ? lcVar.f3905d == null : this.f3905d.equals(lcVar.f3905d);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3904c == null ? 0 : this.f3904c.hashCode()) + (((this.f3903b == null ? 0 : this.f3903b.hashCode()) + (((this.f3902a == null ? 0 : this.f3902a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        if (this.f3905d != null) {
            i = this.f3905d.hashCode();
        }
        return hashCode + i;
    }
}
