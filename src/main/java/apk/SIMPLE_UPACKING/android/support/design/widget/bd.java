package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: Snackbar */
final class bd extends SwipeDismissBehavior {
    final /* synthetic */ Snackbar f359a;

    bd(Snackbar snackbar) {
        this.f359a = snackbar;
    }

    public boolean m555a(View view) {
        return view instanceof SnackbarLayout;
    }

    public boolean m553a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
        if (coordinatorLayout.m383a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            switch (motionEvent.getActionMasked()) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    bh.m558a().m569c(this.f359a.f272f);
                    break;
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    bh.m558a().m570d(this.f359a.f272f);
                    break;
            }
        }
        return super.m452a(coordinatorLayout, (View) snackbarLayout, motionEvent);
    }
}
