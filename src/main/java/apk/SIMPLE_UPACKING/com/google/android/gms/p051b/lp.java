package com.google.android.gms.p051b;

import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.lp */
public final class lp extends mm {
    public lq[] f3947a;

    public lp() {
        m7037a();
    }

    public lp m7037a() {
        this.f3947a = lq.m7042a();
        this.B = -1;
        return this;
    }

    public lp m7038a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    int b = mo.m7197b(mhVar, 10);
                    a = this.f3947a == null ? 0 : this.f3947a.length;
                    Object obj = new lq[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3947a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new lq();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new lq();
                    mhVar.m7109a(obj[a]);
                    this.f3947a = obj;
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

    public void m7039a(mi miVar) {
        if (this.f3947a != null && this.f3947a.length > 0) {
            for (mm mmVar : this.f3947a) {
                if (mmVar != null) {
                    miVar.m7161a(1, mmVar);
                }
            }
        }
        super.m6962a(miVar);
    }

    public /* synthetic */ mm m7040b(mh mhVar) {
        return m7038a(mhVar);
    }

    protected int m7041c() {
        int c = super.m6964c();
        if (this.f3947a != null && this.f3947a.length > 0) {
            for (mm mmVar : this.f3947a) {
                if (mmVar != null) {
                    c += mi.m7141b(1, mmVar);
                }
            }
        }
        return c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lp)) {
            return false;
        }
        return mk.m7179a(this.f3947a, ((lp) obj).f3947a);
    }

    public int hashCode() {
        return ((getClass().getName().hashCode() + 527) * 31) + mk.m7177a(this.f3947a);
    }
}
