package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.api.C0164t;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

final class bc extends Handler {
    final /* synthetic */ ba f4211a;

    public void handleMessage(Message message) {
        switch (message.what) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                C0164t c0164t = (C0164t) message.obj;
                synchronized (this.f4211a.f4205e) {
                    if (c0164t != null) {
                        if (c0164t instanceof au) {
                            this.f4211a.f4202b.m7408a(((au) c0164t).m7401b());
                        } else {
                            this.f4211a.f4202b.m7420a(c0164t);
                        }
                        break;
                    }
                    this.f4211a.f4202b.m7408a(new Status(13, "Transform returned null"));
                    break;
                }
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: " + runtimeException.getMessage());
                throw runtimeException;
            default:
                Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
        }
    }
}
