package android.support.v7.p017a;

import android.support.v7.view.SupportActionModeWrapper;
import android.view.ActionMode;
import android.view.Window.Callback;

/* compiled from: AppCompatDelegateImplV14 */
/* renamed from: android.support.v7.a.ab */
class ab extends AppCompatDelegateImplBase {
    final /* synthetic */ aa f1123b;

    ab(aa aaVar, Callback callback) {
        this.f1123b = aaVar;
        super(aaVar, callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (this.f1123b.m2857m()) {
            return m2858a(callback);
        }
        return super.onWindowStartingActionMode(callback);
    }

    final ActionMode m2858a(ActionMode.Callback callback) {
        Object supportActionModeWrapper = new SupportActionModeWrapper(this.f1123b.a, callback);
        android.support.v7.view.ActionMode b = this.f1123b.m2830b((android.support.v7.view.ActionMode) supportActionModeWrapper);
        if (b != null) {
            return supportActionModeWrapper.m3135b(b);
        }
        return null;
    }
}
