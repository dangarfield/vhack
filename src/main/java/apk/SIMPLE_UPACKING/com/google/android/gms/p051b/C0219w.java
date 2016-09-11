package com.google.android.gms.p051b;

import java.util.Comparator;

/* renamed from: com.google.android.gms.b.w */
class C0219w implements Comparator {
    final /* synthetic */ C0218v f4118a;

    C0219w(C0218v c0218v) {
        this.f4118a = c0218v;
    }

    public int m7269a(String str, String str2) {
        return str2.length() - str.length();
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m7269a((String) obj, (String) obj2);
    }
}
