package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.b.ld */
public final class ld extends mm {
    public Integer f3906a;
    public Boolean f3907b;
    public String f3908c;
    public String f3909d;
    public String f3910e;

    public ld() {
        m6986a();
    }

    public ld m6986a() {
        this.f3906a = null;
        this.f3907b = null;
        this.f3908c = null;
        this.f3909d = null;
        this.f3910e = null;
        this.B = -1;
        return this;
    }

    public ld m6987a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    a = mhVar.m7118f();
                    switch (a) {
                        case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        case ModuleDescriptor.MODULE_VERSION /*1*/:
                        case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                            this.f3906a = Integer.valueOf(a);
                            break;
                        default:
                            continue;
                    }
                case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                    this.f3907b = Boolean.valueOf(mhVar.m7121g());
                    continue;
                case R.AppCompatTheme_actionMenuTextColor /*26*/:
                    this.f3908c = mhVar.m7122h();
                    continue;
                case R.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.f3909d = mhVar.m7122h();
                    continue;
                case R.AppCompatTheme_dialogTheme /*42*/:
                    this.f3910e = mhVar.m7122h();
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

    public void m6988a(mi miVar) {
        if (this.f3906a != null) {
            miVar.m7159a(1, this.f3906a.intValue());
        }
        if (this.f3907b != null) {
            miVar.m7163a(2, this.f3907b.booleanValue());
        }
        if (this.f3908c != null) {
            miVar.m7162a(3, this.f3908c);
        }
        if (this.f3909d != null) {
            miVar.m7162a(4, this.f3909d);
        }
        if (this.f3910e != null) {
            miVar.m7162a(5, this.f3910e);
        }
        super.m6962a(miVar);
    }

    public /* synthetic */ mm m6989b(mh mhVar) {
        return m6987a(mhVar);
    }

    protected int m6990c() {
        int c = super.m6964c();
        if (this.f3906a != null) {
            c += mi.m7140b(1, this.f3906a.intValue());
        }
        if (this.f3907b != null) {
            c += mi.m7143b(2, this.f3907b.booleanValue());
        }
        if (this.f3908c != null) {
            c += mi.m7142b(3, this.f3908c);
        }
        if (this.f3909d != null) {
            c += mi.m7142b(4, this.f3909d);
        }
        return this.f3910e != null ? c + mi.m7142b(5, this.f3910e) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ld)) {
            return false;
        }
        ld ldVar = (ld) obj;
        if (this.f3906a == null) {
            if (ldVar.f3906a != null) {
                return false;
            }
        } else if (!this.f3906a.equals(ldVar.f3906a)) {
            return false;
        }
        if (this.f3907b == null) {
            if (ldVar.f3907b != null) {
                return false;
            }
        } else if (!this.f3907b.equals(ldVar.f3907b)) {
            return false;
        }
        if (this.f3908c == null) {
            if (ldVar.f3908c != null) {
                return false;
            }
        } else if (!this.f3908c.equals(ldVar.f3908c)) {
            return false;
        }
        if (this.f3909d == null) {
            if (ldVar.f3909d != null) {
                return false;
            }
        } else if (!this.f3909d.equals(ldVar.f3909d)) {
            return false;
        }
        return this.f3910e == null ? ldVar.f3910e == null : this.f3910e.equals(ldVar.f3910e);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3909d == null ? 0 : this.f3909d.hashCode()) + (((this.f3908c == null ? 0 : this.f3908c.hashCode()) + (((this.f3907b == null ? 0 : this.f3907b.hashCode()) + (((this.f3906a == null ? 0 : this.f3906a.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f3910e != null) {
            i = this.f3910e.hashCode();
        }
        return hashCode + i;
    }
}
