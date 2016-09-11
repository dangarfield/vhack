package com.google.android.gms.measurement.internal;

import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.p051b.ld;

class bm {
    final boolean f4785a;
    final int f4786b;
    long f4787c;
    float f4788d;
    long f4789e;
    float f4790f;
    long f4791g;
    float f4792h;
    final boolean f4793i;

    public bm(ld ldVar) {
        boolean z;
        boolean z2 = true;
        bf.m7873a((Object) ldVar);
        if (ldVar.f3906a == null || ldVar.f3906a.intValue() == 0) {
            z = false;
        } else {
            if (ldVar.f3906a.intValue() != 4) {
                if (ldVar.f3908c == null) {
                    z = false;
                }
            } else if (ldVar.f3909d == null || ldVar.f3910e == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.f4786b = ldVar.f3906a.intValue();
            if (ldVar.f3907b == null || !ldVar.f3907b.booleanValue()) {
                z2 = false;
            }
            this.f4785a = z2;
            if (ldVar.f3906a.intValue() == 4) {
                if (this.f4785a) {
                    this.f4790f = Float.parseFloat(ldVar.f3909d);
                    this.f4792h = Float.parseFloat(ldVar.f3910e);
                } else {
                    this.f4789e = Long.parseLong(ldVar.f3909d);
                    this.f4791g = Long.parseLong(ldVar.f3910e);
                }
            } else if (this.f4785a) {
                this.f4788d = Float.parseFloat(ldVar.f3908c);
            } else {
                this.f4787c = Long.parseLong(ldVar.f3908c);
            }
        } else {
            this.f4786b = 0;
            this.f4785a = false;
        }
        this.f4793i = z;
    }

    public Boolean m8643a(float f) {
        boolean z = true;
        boolean z2 = false;
        if (!this.f4793i) {
            return null;
        }
        if (!this.f4785a) {
            return null;
        }
        switch (this.f4786b) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                if (f >= this.f4788d) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                if (f <= this.f4788d) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                if (f == this.f4788d || Math.abs(f - this.f4788d) < 2.0f * Math.max(Math.ulp(f), Math.ulp(this.f4788d))) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                if (f < this.f4790f || f > this.f4792h) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }

    public Boolean m8644a(long j) {
        boolean z = true;
        if (!this.f4793i) {
            return null;
        }
        if (this.f4785a) {
            return null;
        }
        switch (this.f4786b) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                if (j >= this.f4787c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                if (j <= this.f4787c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                if (j != this.f4787c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                if (j < this.f4789e || j > this.f4791g) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }
}
