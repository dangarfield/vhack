package com.google.android.gms.p051b;

import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.li */
public final class li extends mm {
    private static volatile li[] f3919c;
    public String f3920a;
    public Boolean f3921b;

    public li() {
        m7005b();
    }

    public static li[] m7002a() {
        if (f3919c == null) {
            synchronized (mk.f4051a) {
                if (f3919c == null) {
                    f3919c = new li[0];
                }
            }
        }
        return f3919c;
    }

    public li m7003a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    this.f3920a = mhVar.m7122h();
                    continue;
                case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                    this.f3921b = Boolean.valueOf(mhVar.m7121g());
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

    public void m7004a(mi miVar) {
        if (this.f3920a != null) {
            miVar.m7162a(1, this.f3920a);
        }
        if (this.f3921b != null) {
            miVar.m7163a(2, this.f3921b.booleanValue());
        }
        super.m6962a(miVar);
    }

    public li m7005b() {
        this.f3920a = null;
        this.f3921b = null;
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m7006b(mh mhVar) {
        return m7003a(mhVar);
    }

    protected int m7007c() {
        int c = super.m6964c();
        if (this.f3920a != null) {
            c += mi.m7142b(1, this.f3920a);
        }
        return this.f3921b != null ? c + mi.m7143b(2, this.f3921b.booleanValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof li)) {
            return false;
        }
        li liVar = (li) obj;
        if (this.f3920a == null) {
            if (liVar.f3920a != null) {
                return false;
            }
        } else if (!this.f3920a.equals(liVar.f3920a)) {
            return false;
        }
        return this.f3921b == null ? liVar.f3921b == null : this.f3921b.equals(liVar.f3921b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3920a == null ? 0 : this.f3920a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
        if (this.f3921b != null) {
            i = this.f3921b.hashCode();
        }
        return hashCode + i;
    }
}
