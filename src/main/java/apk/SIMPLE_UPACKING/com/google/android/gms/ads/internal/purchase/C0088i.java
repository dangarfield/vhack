package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.fi;

@fi
/* renamed from: com.google.android.gms.ads.internal.purchase.i */
public class C0088i {
    private final String f3085a;

    public String m5594a() {
        return C0056g.m5439c().m6546b();
    }

    public boolean m5595a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String b = C0056g.m5446j().m5591b(intent);
        String c = C0056g.m5446j().m5592c(intent);
        if (b == null || c == null) {
            return false;
        }
        if (!str.equals(C0056g.m5446j().m5590a(b))) {
            C0099b.m5643d("Developer payload not match.");
            return false;
        } else if (this.f3085a == null || C0089j.m5597a(this.f3085a, b, c)) {
            return true;
        } else {
            C0099b.m5643d("Fail to verify signature.");
            return false;
        }
    }
}
