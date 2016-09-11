package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: Snackbar */
final class au implements Callback {
    au() {
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                ((Snackbar) message.obj).m436b();
                return true;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                ((Snackbar) message.obj).m434a(message.arg1);
                return true;
            default:
                return false;
        }
    }
}
