package android.support.v7.p017a;

import android.content.Context;
import android.view.Window;
import android.view.Window.Callback;

/* compiled from: AppCompatDelegateImplV23 */
/* renamed from: android.support.v7.a.ac */
class ac extends aa {
    ac(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    Callback m2859a(Callback callback) {
        return new ad(this, callback);
    }
}
