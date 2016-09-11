package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class aa extends Handler {
    final /* synthetic */ C0122y f4369a;

    public aa(C0122y c0122y, Looper looper) {
        this.f4369a = c0122y;
        super(looper);
    }

    private void m7706a(Message message) {
        ab abVar = (ab) message.obj;
        abVar.m7709b();
        abVar.m7711d();
    }

    private boolean m7707b(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 5;
    }

    public void handleMessage(Message message) {
        if (this.f4369a.f3185b.get() != message.arg1) {
            if (m7707b(message)) {
                m7706a(message);
            }
        } else if ((message.what == 1 || message.what == 5) && !this.f4369a.m5763m()) {
            m7706a(message);
        } else if (message.what == 3) {
            ConnectionResult connectionResult = new ConnectionResult(message.arg2, null);
            this.f4369a.f3199q.m7520a(connectionResult);
            this.f4369a.m5748a(connectionResult);
        } else if (message.what == 4) {
            this.f4369a.m5734b(4, null);
            if (this.f4369a.f3206x != null) {
                this.f4369a.f3206x.m7342a(message.arg2);
            }
            this.f4369a.m5743a(message.arg2);
            this.f4369a.m5730a(4, 1, null);
        } else if (message.what == 2 && !this.f4369a.m5759h()) {
            m7706a(message);
        } else if (m7707b(message)) {
            ((ab) message.obj).m7710c();
        } else {
            Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
        }
    }
}
