package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.google.android.gms.iid.i */
class C0352i extends Handler {
    final /* synthetic */ C0351h f4598a;

    C0352i(C0351h c0351h, Looper looper) {
        this.f4598a = c0351h;
        super(looper);
    }

    public void handleMessage(Message message) {
        this.f4598a.m8159a(message);
    }
}
