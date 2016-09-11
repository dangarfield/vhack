package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: com.google.android.gms.gcm.e */
class C0340e extends Handler {
    final /* synthetic */ C0339d f4559a;

    C0340e(C0339d c0339d, Looper looper) {
        this.f4559a = c0339d;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("GCM", "Dropping invalid message");
        }
        Intent intent = (Intent) message.obj;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            this.f4559a.f4558j.add(intent);
        } else if (!this.f4559a.m8093b(intent)) {
            intent.setPackage(this.f4559a.f4555f.getPackageName());
            this.f4559a.f4555f.sendBroadcast(intent);
        }
    }
}
