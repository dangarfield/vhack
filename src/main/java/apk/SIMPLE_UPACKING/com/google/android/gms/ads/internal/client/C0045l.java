package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import com.google.android.gms.ads.internal.C0024a;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.ej;
import com.google.android.gms.p051b.ev;
import com.google.android.gms.p051b.fi;

@fi
/* renamed from: com.google.android.gms.ads.internal.client.l */
public class C0045l {
    public static String f2952a;
    private C0023m f2953b;

    static {
        f2952a = null;
    }

    public C0045l() {
        C0024a.m5344a();
        if (f2952a != null) {
            try {
                this.f2953b = (C0023m) C0045l.class.getClassLoader().loadClass(f2952a).newInstance();
                return;
            } catch (Throwable e) {
                C0099b.m5642c("Failed to instantiate ClientApi class.", e);
                this.f2953b = new C0031d();
                return;
            }
        }
        C0099b.m5643d("No client jar implementation found.");
        this.f2953b = new C0031d();
    }

    public ev m5407a(Activity activity) {
        return this.f2953b.m5342a(activity);
    }

    public ej m5408b(Activity activity) {
        return this.f2953b.m5343b(activity);
    }
}
