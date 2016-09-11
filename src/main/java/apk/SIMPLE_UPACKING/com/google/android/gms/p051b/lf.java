package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.b.lf */
public final class lf extends mm {
    public Integer f3915a;
    public String f3916b;
    public Boolean f3917c;
    public String[] f3918d;

    public lf() {
        m6997a();
    }

    public lf m6997a() {
        this.f3915a = null;
        this.f3916b = null;
        this.f3917c = null;
        this.f3918d = mo.f4057f;
        this.B = -1;
        return this;
    }

    public lf m6998a(mh mhVar) {
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
                        case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                            this.f3915a = Integer.valueOf(a);
                            break;
                        default:
                            continue;
                    }
                case R.Toolbar_collapseIcon /*18*/:
                    this.f3916b = mhVar.m7122h();
                    continue;
                case R.Toolbar_subtitleTextColor /*24*/:
                    this.f3917c = Boolean.valueOf(mhVar.m7121g());
                    continue;
                case R.AppCompatTheme_actionModePasteDrawable /*34*/:
                    int b = mo.m7197b(mhVar, 34);
                    a = this.f3918d == null ? 0 : this.f3918d.length;
                    Object obj = new String[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3918d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = mhVar.m7122h();
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = mhVar.m7122h();
                    this.f3918d = obj;
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

    public void m6999a(mi miVar) {
        if (this.f3915a != null) {
            miVar.m7159a(1, this.f3915a.intValue());
        }
        if (this.f3916b != null) {
            miVar.m7162a(2, this.f3916b);
        }
        if (this.f3917c != null) {
            miVar.m7163a(3, this.f3917c.booleanValue());
        }
        if (this.f3918d != null && this.f3918d.length > 0) {
            for (String str : this.f3918d) {
                if (str != null) {
                    miVar.m7162a(4, str);
                }
            }
        }
        super.m6962a(miVar);
    }

    public /* synthetic */ mm m7000b(mh mhVar) {
        return m6998a(mhVar);
    }

    protected int m7001c() {
        int i = 0;
        int c = super.m6964c();
        if (this.f3915a != null) {
            c += mi.m7140b(1, this.f3915a.intValue());
        }
        if (this.f3916b != null) {
            c += mi.m7142b(2, this.f3916b);
        }
        if (this.f3917c != null) {
            c += mi.m7143b(3, this.f3917c.booleanValue());
        }
        if (this.f3918d == null || this.f3918d.length <= 0) {
            return c;
        }
        int i2 = 0;
        int i3 = 0;
        while (i < this.f3918d.length) {
            String str = this.f3918d[i];
            if (str != null) {
                i3++;
                i2 += mi.m7145b(str);
            }
            i++;
        }
        return (c + i2) + (i3 * 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lf)) {
            return false;
        }
        lf lfVar = (lf) obj;
        if (this.f3915a == null) {
            if (lfVar.f3915a != null) {
                return false;
            }
        } else if (!this.f3915a.equals(lfVar.f3915a)) {
            return false;
        }
        if (this.f3916b == null) {
            if (lfVar.f3916b != null) {
                return false;
            }
        } else if (!this.f3916b.equals(lfVar.f3916b)) {
            return false;
        }
        if (this.f3917c == null) {
            if (lfVar.f3917c != null) {
                return false;
            }
        } else if (!this.f3917c.equals(lfVar.f3917c)) {
            return false;
        }
        return mk.m7179a(this.f3918d, lfVar.f3918d);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3916b == null ? 0 : this.f3916b.hashCode()) + (((this.f3915a == null ? 0 : this.f3915a.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f3917c != null) {
            i = this.f3917c.hashCode();
        }
        return ((hashCode + i) * 31) + mk.m7177a(this.f3918d);
    }
}
