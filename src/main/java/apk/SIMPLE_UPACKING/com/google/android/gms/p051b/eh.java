package com.google.android.gms.p051b;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.C0046n;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p047a.C0005d;
import com.google.android.gms.p047a.C0006e;

@fi
/* renamed from: com.google.android.gms.b.eh */
public final class eh extends C0006e {
    private static final eh f3610a;

    static {
        f3610a = new eh();
    }

    private eh() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static ej m6439a(Activity activity) {
        try {
            if (!eh.m6440b(activity)) {
                ej c = f3610a.m6441c(activity);
                if (c != null) {
                    return c;
                }
            }
            C0099b.m5636a("Using AdOverlay from the client jar.");
            return C0046n.m5411b().m5408b(activity);
        } catch (ei e) {
            C0099b.m5643d(e.getMessage());
            return null;
        }
    }

    private static boolean m6440b(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new ei("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private ej m6441c(Activity activity) {
        try {
            return ek.m5473a(((em) m5325a(activity)).m6455a(C0005d.m5323a((Object) activity)));
        } catch (Throwable e) {
            C0099b.m5642c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            C0099b.m5642c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected em m6442a(IBinder iBinder) {
        return en.m6456a(iBinder);
    }

    protected /* synthetic */ Object m6443b(IBinder iBinder) {
        return m6442a(iBinder);
    }
}
