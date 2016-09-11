package com.google.android.gms.p051b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.C0056g;

@fi
/* renamed from: com.google.android.gms.b.fq */
public class fq extends Handler {
    public fq(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Throwable e) {
            C0056g.m5442f().m6500a(e, false);
            throw e;
        }
    }
}
