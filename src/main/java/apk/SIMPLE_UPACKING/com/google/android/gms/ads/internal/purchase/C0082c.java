package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.eq;
import com.google.android.gms.p051b.ew;
import com.google.android.gms.p051b.fi;

@fi
/* renamed from: com.google.android.gms.ads.internal.purchase.c */
public class C0082c extends ew implements ServiceConnection {
    C0084e f3068a;
    private final Activity f3069b;
    private Context f3070c;
    private eq f3071d;
    private C0081b f3072e;
    private C0083d f3073f;
    private C0087h f3074g;
    private C0088i f3075h;
    private String f3076i;

    public C0082c(Activity activity) {
        this.f3076i = null;
        this.f3069b = activity;
        this.f3068a = C0084e.m5580a(this.f3069b.getApplicationContext());
    }

    public void m5576a() {
        GInAppPurchaseManagerInfoParcel a = GInAppPurchaseManagerInfoParcel.m5561a(this.f3069b.getIntent());
        this.f3074g = a.f3064e;
        this.f3075h = a.f3061b;
        this.f3071d = a.f3062c;
        this.f3072e = new C0081b(this.f3069b.getApplicationContext());
        this.f3070c = a.f3063d;
        if (this.f3069b.getResources().getConfiguration().orientation == 2) {
            this.f3069b.setRequestedOrientation(C0056g.m5441e().m6556a());
        } else {
            this.f3069b.setRequestedOrientation(C0056g.m5441e().m6569b());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.f3069b.bindService(intent, this, 1);
    }

    public void m5577a(int i, int i2, Intent intent) {
        if (i == 1001) {
            boolean z = false;
            try {
                int a = C0056g.m5446j().m5588a(intent);
                if (i2 == -1) {
                    C0056g.m5446j();
                    if (a == 0) {
                        if (this.f3075h.m5595a(this.f3076i, i2, intent)) {
                            z = true;
                        }
                        this.f3071d.m6463b(a);
                        this.f3069b.finish();
                        m5578a(this.f3071d.m6461a(), z, i2, intent);
                    }
                }
                this.f3068a.m5584a(this.f3073f);
                this.f3071d.m6463b(a);
                this.f3069b.finish();
                m5578a(this.f3071d.m6461a(), z, i2, intent);
            } catch (RemoteException e) {
                C0099b.m5643d("Fail to process purchase result.");
                this.f3069b.finish();
            } finally {
                this.f3076i = null;
            }
        }
    }

    protected void m5578a(String str, boolean z, int i, Intent intent) {
        if (this.f3074g != null) {
            this.f3074g.m5593a(str, z, i, intent, this.f3073f);
        }
    }

    public void m5579b() {
        this.f3069b.unbindService(this);
        this.f3072e.m5570a();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Throwable e;
        this.f3072e.m5571a(iBinder);
        try {
            this.f3076i = this.f3075h.m5594a();
            Bundle a = this.f3072e.m5569a(this.f3069b.getPackageName(), this.f3071d.m6461a(), this.f3076i);
            PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int a2 = C0056g.m5446j().m5589a(a);
                this.f3071d.m6463b(a2);
                m5578a(this.f3071d.m6461a(), false, a2, null);
                this.f3069b.finish();
                return;
            }
            this.f3073f = new C0083d(this.f3071d.m6461a(), this.f3076i);
            this.f3068a.m5586b(this.f3073f);
            this.f3069b.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            C0099b.m5642c("Error when connecting in-app billing service", e);
            this.f3069b.finish();
        } catch (SendIntentException e3) {
            e = e3;
            C0099b.m5642c("Error when connecting in-app billing service", e);
            this.f3069b.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C0099b.m5641c("In-app billing service disconnected.");
        this.f3072e.m5570a();
    }
}
