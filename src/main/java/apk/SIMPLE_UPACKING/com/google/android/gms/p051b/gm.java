package com.google.android.gms.p051b;

import android.content.Context;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.gm */
public class gm {
    public static final gq f3698a;
    private static iq f3699b;
    private static final Object f3700c;

    static {
        f3700c = new Object();
        f3698a = new gn();
    }

    public gm(Context context) {
        f3699b = gm.m6600a(context);
    }

    private static iq m6600a(Context context) {
        iq iqVar;
        synchronized (f3700c) {
            if (f3699b == null) {
                f3699b = C0199d.m6264a(context.getApplicationContext());
            }
            iqVar = f3699b;
        }
        return iqVar;
    }

    public gy m6601a(String str, Map map) {
        Object grVar = new gr();
        f3699b.m6820a(new gp(this, str, grVar, new go(this, str, grVar), map));
        return grVar;
    }
}
