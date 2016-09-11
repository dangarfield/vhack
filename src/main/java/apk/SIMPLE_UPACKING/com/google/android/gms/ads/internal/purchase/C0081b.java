package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.fi;

@fi
/* renamed from: com.google.android.gms.ads.internal.purchase.b */
public class C0081b {
    Object f3065a;
    private final Context f3066b;
    private final boolean f3067c;

    public C0081b(Context context) {
        this(context, true);
    }

    public C0081b(Context context, boolean z) {
        this.f3066b = context;
        this.f3067c = z;
    }

    public Bundle m5569a(String str, String str2, String str3) {
        try {
            Class loadClass = this.f3066b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.f3065a), new Object[]{Integer.valueOf(3), str, str2, "inapp", str3});
        } catch (Throwable e) {
            if (this.f3067c) {
                C0099b.m5642c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }

    public void m5570a() {
        this.f3065a = null;
    }

    public void m5571a(IBinder iBinder) {
        try {
            this.f3065a = this.f3066b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
        } catch (Exception e) {
            if (this.f3067c) {
                C0099b.m5643d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            }
        }
    }
}
