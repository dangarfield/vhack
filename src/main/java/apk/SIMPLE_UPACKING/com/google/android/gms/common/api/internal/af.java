package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

final class af extends Handler {
    final /* synthetic */ C0258z f4168a;

    af(C0258z c0258z, Looper looper) {
        this.f4168a = c0258z;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f4168a.m7579t();
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f4168a.m7578s();
            default:
                Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
        }
    }
}
