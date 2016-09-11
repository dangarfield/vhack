package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.C0001R;

/* compiled from: SnackbarManager */
class bi implements Callback {
    final /* synthetic */ bh f365a;

    bi(bh bhVar) {
        this.f365a = bhVar;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.f365a.m563b((bk) message.obj);
                return true;
            default:
                return false;
        }
    }
}
