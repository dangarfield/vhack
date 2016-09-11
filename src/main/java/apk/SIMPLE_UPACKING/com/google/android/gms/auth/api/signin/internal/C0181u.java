package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.C0155h;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.iz;
import com.google.android.gms.p051b.jc;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.auth.api.signin.internal.u */
public class C0181u {
    private final Map f3346a;

    public C0181u(Activity activity, List list, Map map) {
        bf.m7873a((Object) activity);
        bf.m7873a((Object) list);
        bf.m7873a((Object) map);
        Map hashMap = new HashMap();
        for (C0155h c0155h : list) {
            List list2 = (List) map.get(c0155h);
            if (list2 == null) {
                list2 = Collections.emptyList();
            }
            iz a = m6044a(c0155h, activity, list2);
            if (a != null) {
                hashMap.put(c0155h, a);
            }
        }
        this.f3346a = Collections.unmodifiableMap(hashMap);
    }

    private iz m6044a(C0155h c0155h, Activity activity, List list) {
        return C0155h.FACEBOOK.equals(c0155h) ? new jc(activity, list) : null;
    }

    public iz m6045a(C0155h c0155h) {
        bf.m7873a((Object) c0155h);
        return (iz) this.f3346a.get(c0155h);
    }

    public Collection m6046a() {
        return this.f3346a.values();
    }
}
