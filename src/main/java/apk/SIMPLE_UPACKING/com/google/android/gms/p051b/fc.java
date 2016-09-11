package com.google.android.gms.p051b;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.C0046n;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p047a.C0005d;
import com.google.android.gms.p047a.C0006e;

@fi
/* renamed from: com.google.android.gms.b.fc */
public final class fc extends C0006e {
    private static final fc f3626a;

    static {
        f3626a = new fc();
    }

    private fc() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public static ev m6485a(Activity activity) {
        try {
            if (!fc.m6486b(activity)) {
                ev c = f3626a.m6487c(activity);
                if (c != null) {
                    return c;
                }
            }
            C0099b.m5636a("Using AdOverlay from the client jar.");
            return C0046n.m5411b().m5407a(activity);
        } catch (fd e) {
            C0099b.m5643d(e.getMessage());
            return null;
        }
    }

    private static boolean m6486b(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new fd("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    private ev m6487c(Activity activity) {
        try {
            return ew.m5575a(((ey) m5325a(activity)).m6472a(C0005d.m5323a((Object) activity)));
        } catch (Throwable e) {
            C0099b.m5642c("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            C0099b.m5642c("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected ey m6488a(IBinder iBinder) {
        return ez.m6473a(iBinder);
    }

    protected /* synthetic */ Object m6489b(IBinder iBinder) {
        return m6488a(iBinder);
    }
}
