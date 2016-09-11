package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.le */
public final class le extends mm {
    private static volatile le[] f3911d;
    public Integer f3912a;
    public String f3913b;
    public lc f3914c;

    public le() {
        m6994b();
    }

    public static le[] m6991a() {
        if (f3911d == null) {
            synchronized (mk.f4051a) {
                if (f3911d == null) {
                    f3911d = new le[0];
                }
            }
        }
        return f3911d;
    }

    public le m6992a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    this.f3912a = Integer.valueOf(mhVar.m7118f());
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    this.f3913b = mhVar.m7122h();
                    continue;
                case R.AppCompatTheme_actionMenuTextColor /*26*/:
                    if (this.f3914c == null) {
                        this.f3914c = new lc();
                    }
                    mhVar.m7109a(this.f3914c);
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

    public void m6993a(mi miVar) {
        if (this.f3912a != null) {
            miVar.m7159a(1, this.f3912a.intValue());
        }
        if (this.f3913b != null) {
            miVar.m7162a(2, this.f3913b);
        }
        if (this.f3914c != null) {
            miVar.m7161a(3, this.f3914c);
        }
        super.m6962a(miVar);
    }

    public le m6994b() {
        this.f3912a = null;
        this.f3913b = null;
        this.f3914c = null;
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m6995b(mh mhVar) {
        return m6992a(mhVar);
    }

    protected int m6996c() {
        int c = super.m6964c();
        if (this.f3912a != null) {
            c += mi.m7140b(1, this.f3912a.intValue());
        }
        if (this.f3913b != null) {
            c += mi.m7142b(2, this.f3913b);
        }
        return this.f3914c != null ? c + mi.m7141b(3, this.f3914c) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof le)) {
            return false;
        }
        le leVar = (le) obj;
        if (this.f3912a == null) {
            if (leVar.f3912a != null) {
                return false;
            }
        } else if (!this.f3912a.equals(leVar.f3912a)) {
            return false;
        }
        if (this.f3913b == null) {
            if (leVar.f3913b != null) {
                return false;
            }
        } else if (!this.f3913b.equals(leVar.f3913b)) {
            return false;
        }
        return this.f3914c == null ? leVar.f3914c == null : this.f3914c.equals(leVar.f3914c);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3913b == null ? 0 : this.f3913b.hashCode()) + (((this.f3912a == null ? 0 : this.f3912a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f3914c != null) {
            i = this.f3914c.hashCode();
        }
        return hashCode + i;
    }
}
