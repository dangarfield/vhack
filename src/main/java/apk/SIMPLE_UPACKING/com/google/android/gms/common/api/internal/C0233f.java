package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.api.C0224w;
import com.google.android.gms.common.api.C0231x;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.common.api.internal.f */
public class C0233f extends Handler {
    public C0233f() {
        this(Looper.getMainLooper());
    }

    public C0233f(Looper looper) {
        super(looper);
    }

    public void m7422a() {
        removeMessages(2);
    }

    public void m7423a(C0231x c0231x, C0224w c0224w) {
        sendMessage(obtainMessage(1, new Pair(c0231x, c0224w)));
    }

    protected void m7424b(C0231x c0231x, C0224w c0224w) {
        try {
            c0231x.m7348a(c0224w);
        } catch (RuntimeException e) {
            C0165e.m5972b(c0224w);
            throw e;
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                Pair pair = (Pair) message.obj;
                m7424b((C0231x) pair.first, (C0224w) pair.second);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                ((C0165e) message.obj).m5980d(Status.f4134d);
            default:
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
        }
    }
}
