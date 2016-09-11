package com.google.android.gms.p051b;

import android.content.SharedPreferences;

@fi
/* renamed from: com.google.android.gms.b.al */
public class al {
    private final Object f3394a;
    private boolean f3395b;
    private SharedPreferences f3396c;

    public al() {
        this.f3394a = new Object();
        this.f3395b = false;
        this.f3396c = null;
    }

    public Object m6107a(ae aeVar) {
        synchronized (this.f3394a) {
            if (this.f3395b) {
                return gv.m6610a(new am(this, aeVar));
            }
            Object b = aeVar.m6092b();
            return b;
        }
    }
}
