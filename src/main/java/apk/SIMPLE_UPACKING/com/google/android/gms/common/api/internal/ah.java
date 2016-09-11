package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

class ah extends ap {
    private WeakReference f4172a;

    ah(C0258z c0258z) {
        this.f4172a = new WeakReference(c0258z);
    }

    public void m7353a() {
        C0258z c0258z = (C0258z) this.f4172a.get();
        if (c0258z != null) {
            c0258z.m7578s();
        }
    }
}
