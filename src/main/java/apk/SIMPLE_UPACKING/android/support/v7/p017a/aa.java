package android.support.v7.p017a;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.view.Window.Callback;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: AppCompatDelegateImplV14 */
/* renamed from: android.support.v7.a.aa */
class aa extends AppCompatDelegateImplV11 {
    private static ba f1117r;
    private int f1118s;
    private boolean f1119t;
    private boolean f1120u;

    aa(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.f1118s = -100;
        this.f1120u = true;
    }

    public void m2854a(Bundle bundle) {
        super.m2822a(bundle);
        if (bundle != null && this.f1118s == -100) {
            this.f1118s = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback m2853a(Callback callback) {
        return new ab(this, callback);
    }

    public boolean m2857m() {
        return this.f1120u;
    }

    public boolean m2856h() {
        this.f1119t = true;
        return m2850e(m2851r());
    }

    private int m2849d(int i) {
        switch (i) {
            case -1:
                switch (((UiModeManager) this.a.getSystemService("uimode")).getNightMode()) {
                    case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        return 0;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        return 2;
                    default:
                        return 1;
                }
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return m2852s().m2937a() ? 2 : 1;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return 2;
            default:
                return 1;
        }
    }

    public void m2855c(Bundle bundle) {
        super.m2767c(bundle);
        if (this.f1118s != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f1118s);
        }
    }

    private int m2851r() {
        return m2849d(this.f1118s == -100 ? AppCompatDelegate.m2737i() : this.f1118s);
    }

    private boolean m2850e(int i) {
        int i2;
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i3 = configuration.uiMode & 48;
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                i2 = 16;
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                i2 = 32;
                break;
            default:
                i2 = 0;
                break;
        }
        if (i3 == i2) {
            return false;
        }
        configuration.uiMode = (configuration.uiMode & -49) | i2;
        resources.updateConfiguration(configuration, null);
        return true;
    }

    private ba m2852s() {
        if (f1117r == null) {
            f1117r = new ba(this.a.getApplicationContext());
        }
        return f1117r;
    }
}
