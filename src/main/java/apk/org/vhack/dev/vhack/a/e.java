package org.vhack.dev.vhack.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.a.a.a.b;

/* compiled from: IabHelper */
class e implements ServiceConnection {
    final /* synthetic */ l a;
    final /* synthetic */ d b;

    e(d dVar, l lVar) {
        this.b = dVar;
        this.a = lVar;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.b.c("Billing service disconnected.");
        this.b.i = null;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (!this.b.d) {
            this.b.c("Billing service connected.");
            this.b.i = b.a(iBinder);
            String packageName = this.b.h.getPackageName();
            try {
                this.b.c("Checking for in-app billing 3 support.");
                int a = this.b.i.getUpdate(3, packageName, "inapp");
                if (a != 0) {
                    if (this.a != null) {
                        this.a.a(new n(a, "Error checking for billing v3 support."));
                    }
                    this.b.e = false;
                    return;
                }
                this.b.c("In-app billing version 3 supported for " + packageName);
                int a2 = this.b.i.getUpdate(3, packageName, "subs");
                if (a2 == 0) {
                    this.b.c("Subscriptions AVAILABLE.");
                    this.b.e = true;
                } else {
                    this.b.c("Subscriptions NOT AVAILABLE. Response: " + a2);
                }
                this.b.c = true;
                if (this.a != null) {
                    this.a.a(new n(0, "Setup successful."));
                }
            } catch (RemoteException e) {
                if (this.a != null) {
                    this.a.a(new n(-1001, "RemoteException while setting up in-app billing."));
                }
                e.printStackTrace();
            }
        }
    }
}
