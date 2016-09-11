package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.lk */
public final class lk extends mm {
    private static volatile lk[] f3928c;
    public String f3929a;
    public String f3930b;

    public lk() {
        m7016b();
    }

    public static lk[] m7013a() {
        if (f3928c == null) {
            synchronized (mk.f4051a) {
                if (f3928c == null) {
                    f3928c = new lk[0];
                }
            }
        }
        return f3928c;
    }

    public lk m7014a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    this.f3929a = mhVar.m7122h();
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    this.f3930b = mhVar.m7122h();
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

    public void m7015a(mi miVar) {
        if (this.f3929a != null) {
            miVar.m7162a(1, this.f3929a);
        }
        if (this.f3930b != null) {
            miVar.m7162a(2, this.f3930b);
        }
        super.m6962a(miVar);
    }

    public lk m7016b() {
        this.f3929a = null;
        this.f3930b = null;
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m7017b(mh mhVar) {
        return m7014a(mhVar);
    }

    protected int m7018c() {
        int c = super.m6964c();
        if (this.f3929a != null) {
            c += mi.m7142b(1, this.f3929a);
        }
        return this.f3930b != null ? c + mi.m7142b(2, this.f3930b) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lk)) {
            return false;
        }
        lk lkVar = (lk) obj;
        if (this.f3929a == null) {
            if (lkVar.f3929a != null) {
                return false;
            }
        } else if (!this.f3929a.equals(lkVar.f3929a)) {
            return false;
        }
        return this.f3930b == null ? lkVar.f3930b == null : this.f3930b.equals(lkVar.f3930b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3929a == null ? 0 : this.f3929a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
        if (this.f3930b != null) {
            i = this.f3930b.hashCode();
        }
        return hashCode + i;
    }
}
