package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* renamed from: com.google.android.gms.auth.api.signin.c */
final class C0150c implements Comparator {
    C0150c() {
    }

    public int m5878a(Scope scope, Scope scope2) {
        return scope.m7285a().compareTo(scope2.m7285a());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5878a((Scope) obj, (Scope) obj2);
    }
}
