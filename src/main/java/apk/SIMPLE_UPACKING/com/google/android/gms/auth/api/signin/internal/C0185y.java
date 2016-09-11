package com.google.android.gms.auth.api.signin.internal;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.auth.api.signin.internal.y */
class C0185y extends LinkedHashMap {
    private final int f3355a;

    public C0185y(int i) {
        this.f3355a = i;
    }

    protected boolean removeEldestEntry(Entry entry) {
        return size() > this.f3355a;
    }
}
