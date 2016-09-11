package android.support.v7.p017a;

import android.view.ActionMode;
import android.view.Window.Callback;
import com.google.android.gms.C0001R;

/* compiled from: AppCompatDelegateImplV23 */
/* renamed from: android.support.v7.a.ad */
class ad extends ab {
    final /* synthetic */ ac f1124c;

    ad(ac acVar, Callback callback) {
        this.f1124c = acVar;
        super(acVar, callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        if (this.f1124c.m2857m()) {
            switch (i) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    return m2858a(callback);
            }
        }
        return super.onWindowStartingActionMode(callback, i);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
