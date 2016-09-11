package android.support.design.widget;

import android.view.View;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: Snackbar */
class aw implements bp {
    final /* synthetic */ Snackbar f350a;

    aw(Snackbar snackbar) {
        this.f350a = snackbar;
    }

    public void m536a(View view) {
        view.setVisibility(8);
        this.f350a.m423b(0);
    }

    public void m535a(int i) {
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                bh.m558a().m570d(this.f350a.f272f);
            case ModuleDescriptor.MODULE_VERSION /*1*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                bh.m558a().m569c(this.f350a.f272f);
            default:
        }
    }
}
