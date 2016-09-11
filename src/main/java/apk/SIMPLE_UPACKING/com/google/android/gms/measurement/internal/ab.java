package com.google.android.gms.measurement.internal;

import com.google.android.gms.C0001R;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.p051b.lf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class ab {
    final int f4645a;
    final boolean f4646b;
    final String f4647c;
    final List f4648d;
    final String f4649e;
    final boolean f4650f;

    public ab(lf lfVar) {
        boolean z;
        boolean z2 = false;
        bf.m7873a((Object) lfVar);
        if (lfVar.f3915a == null || lfVar.f3915a.intValue() == 0) {
            z = false;
        } else {
            if (lfVar.f3915a.intValue() == 6) {
                if (lfVar.f3918d == null || lfVar.f3918d.length == 0) {
                    z = false;
                }
            } else if (lfVar.f3916b == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.f4645a = lfVar.f3915a.intValue();
            if (lfVar.f3917c != null && lfVar.f3917c.booleanValue()) {
                z2 = true;
            }
            this.f4646b = z2;
            if (this.f4646b || this.f4645a == 1 || this.f4645a == 6) {
                this.f4647c = lfVar.f3916b;
            } else {
                this.f4647c = lfVar.f3916b.toUpperCase(Locale.ENGLISH);
            }
            this.f4648d = lfVar.f3918d == null ? null : m8200a(lfVar.f3918d, this.f4646b);
            if (this.f4645a == 1) {
                this.f4649e = this.f4647c;
            } else {
                this.f4649e = null;
            }
        } else {
            this.f4645a = 0;
            this.f4646b = false;
            this.f4647c = null;
            this.f4648d = null;
            this.f4649e = null;
        }
        this.f4650f = z;
    }

    private List m8200a(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        List arrayList = new ArrayList();
        for (String toUpperCase : strArr) {
            arrayList.add(toUpperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean m8201a(String str) {
        if (!this.f4650f) {
            return null;
        }
        if (!(this.f4646b || this.f4645a == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.f4645a) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return Boolean.valueOf(Pattern.compile(this.f4649e, this.f4646b ? 0 : 66).matcher(str).matches());
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return Boolean.valueOf(str.startsWith(this.f4647c));
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return Boolean.valueOf(str.endsWith(this.f4647c));
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                return Boolean.valueOf(str.contains(this.f4647c));
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return Boolean.valueOf(str.equals(this.f4647c));
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return Boolean.valueOf(this.f4648d.contains(str));
            default:
                return null;
        }
    }
}
