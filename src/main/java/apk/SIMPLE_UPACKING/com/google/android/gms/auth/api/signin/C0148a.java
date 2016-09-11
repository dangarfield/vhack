package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* renamed from: com.google.android.gms.auth.api.signin.a */
final class C0148a implements Comparator {
    C0148a() {
    }

    public int m5876a(Scope scope, Scope scope2) {
        return scope.m7285a().compareTo(scope2.m7285a());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5876a((Scope) obj, (Scope) obj2);
    }
}
