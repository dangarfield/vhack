package android.support.v7.widget;

import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: AdapterHelper */
class ak {
    int f1864a;
    int f1865b;
    Object f1866c;
    int f1867d;

    ak(int i, int i2, int i3, Object obj) {
        this.f1864a = i;
        this.f1865b = i2;
        this.f1867d = i3;
        this.f1866c = obj;
    }

    String m3947a() {
        switch (this.f1864a) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return "add";
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return "rm";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                return "up";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                return "mv";
            default:
                return "??";
        }
    }

    public String toString() {
        return Integer.toHexString(System.identityHashCode(this)) + "[" + m3947a() + ",s:" + this.f1865b + "c:" + this.f1867d + ",p:" + this.f1866c + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ak akVar = (ak) obj;
        if (this.f1864a != akVar.f1864a) {
            return false;
        }
        if (this.f1864a == 8 && Math.abs(this.f1867d - this.f1865b) == 1 && this.f1867d == akVar.f1865b && this.f1865b == akVar.f1867d) {
            return true;
        }
        if (this.f1867d != akVar.f1867d) {
            return false;
        }
        if (this.f1865b != akVar.f1865b) {
            return false;
        }
        if (this.f1866c != null) {
            if (this.f1866c.equals(akVar.f1866c)) {
                return true;
            }
            return false;
        } else if (akVar.f1866c != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (((this.f1864a * 31) + this.f1865b) * 31) + this.f1867d;
    }
}
