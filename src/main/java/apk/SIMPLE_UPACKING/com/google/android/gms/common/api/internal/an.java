package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

final class an extends Handler {
    final /* synthetic */ al f4189a;

    an(al alVar, Looper looper) {
        this.f4189a = alVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                ((am) message.obj).m7392a(this.f4189a);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                throw ((RuntimeException) message.obj);
            default:
                Log.w("GACStateManager", "Unknown message id: " + message.what);
        }
    }
}
