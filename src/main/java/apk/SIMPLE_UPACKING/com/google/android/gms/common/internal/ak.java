package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.stats.C0316b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.HashMap;

final class ak extends aj implements Callback {
    private final HashMap f4395a;
    private final Context f4396b;
    private final Handler f4397c;
    private final C0316b f4398d;
    private final long f4399e;

    ak(Context context) {
        this.f4395a = new HashMap();
        this.f4396b = context.getApplicationContext();
        this.f4397c = new Handler(context.getMainLooper(), this);
        this.f4398d = C0316b.m8032a();
        this.f4399e = 5000;
    }

    private boolean m7741a(al alVar, ServiceConnection serviceConnection, String str) {
        boolean a;
        bf.m7874a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f4395a) {
            am amVar = (am) this.f4395a.get(alVar);
            if (amVar != null) {
                this.f4397c.removeMessages(0, amVar);
                if (!amVar.m7756a(serviceConnection)) {
                    amVar.m7753a(serviceConnection, str);
                    switch (amVar.m7757b()) {
                        case ModuleDescriptor.MODULE_VERSION /*1*/:
                            serviceConnection.onServiceConnected(amVar.m7762e(), amVar.m7761d());
                            break;
                        case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                            amVar.m7754a(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + alVar);
            }
            amVar = new am(this, alVar);
            amVar.m7753a(serviceConnection, str);
            amVar.m7754a(str);
            this.f4395a.put(alVar, amVar);
            a = amVar.m7755a();
        }
        return a;
    }

    private void m7743b(al alVar, ServiceConnection serviceConnection, String str) {
        bf.m7874a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f4395a) {
            am amVar = (am) this.f4395a.get(alVar);
            if (amVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + alVar);
            } else if (amVar.m7756a(serviceConnection)) {
                amVar.m7758b(serviceConnection, str);
                if (amVar.m7760c()) {
                    this.f4397c.sendMessageDelayed(this.f4397c.obtainMessage(0, amVar), this.f4399e);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + alVar);
            }
        }
    }

    public boolean m7745a(String str, ServiceConnection serviceConnection, String str2) {
        return m7741a(new al(str), serviceConnection, str2);
    }

    public void m7746b(String str, ServiceConnection serviceConnection, String str2) {
        m7743b(new al(str), serviceConnection, str2);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                am amVar = (am) message.obj;
                synchronized (this.f4395a) {
                    if (amVar.m7760c()) {
                        if (amVar.m7755a()) {
                            amVar.m7759b("GmsClientSupervisor");
                        }
                        this.f4395a.remove(amVar.f4408g);
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
