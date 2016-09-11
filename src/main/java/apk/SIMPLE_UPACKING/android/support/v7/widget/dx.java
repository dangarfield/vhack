package android.support.v7.widget;

import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: RecyclerView */
class dx implements aj {
    final /* synthetic */ RecyclerView f2135a;

    dx(RecyclerView recyclerView) {
        this.f2135a = recyclerView;
    }

    public ey m4357a(int i) {
        ey a = this.f2135a.m175a(i, true);
        if (a == null || this.f2135a.f144c.m4091c(a.f2195a)) {
            return null;
        }
        return a;
    }

    public void m4358a(int i, int i2) {
        this.f2135a.m181a(i, i2, true);
        this.f2135a.f149h = true;
        ev.m4466a(this.f2135a.f148g, i2);
    }

    public void m4361b(int i, int i2) {
        this.f2135a.m181a(i, i2, false);
        this.f2135a.f149h = true;
    }

    public void m4359a(int i, int i2, Object obj) {
        this.f2135a.m180a(i, i2, obj);
        this.f2135a.f150i = true;
    }

    public void m4360a(ak akVar) {
        m4364c(akVar);
    }

    void m4364c(ak akVar) {
        switch (akVar.f1864a) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f2135a.f146e.m3510a(this.f2135a, akVar.f1865b, akVar.f1867d);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f2135a.f146e.m3546b(this.f2135a, akVar.f1865b, akVar.f1867d);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                this.f2135a.f146e.m3512a(this.f2135a, akVar.f1865b, akVar.f1867d, akVar.f1866c);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                this.f2135a.f146e.m3511a(this.f2135a, akVar.f1865b, akVar.f1867d, 1);
            default:
        }
    }

    public void m4362b(ak akVar) {
        m4364c(akVar);
    }

    public void m4363c(int i, int i2) {
        this.f2135a.m201f(i, i2);
        this.f2135a.f149h = true;
    }

    public void m4365d(int i, int i2) {
        this.f2135a.m198e(i, i2);
        this.f2135a.f149h = true;
    }
}
