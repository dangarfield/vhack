package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.C0155h;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.bf;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.auth.api.signin.internal.s */
public final class C0179s {
    public static void m6040a(SignInConfiguration signInConfiguration, List list, Map map) {
        bf.m7873a((Object) signInConfiguration);
        bf.m7873a((Object) list);
        bf.m7873a((Object) map);
        GoogleSignInOptions d = signInConfiguration.m5904d();
        if (d != null) {
            list.add(C0155h.GOOGLE);
            List linkedList = new LinkedList();
            Iterator it = d.m5854a().iterator();
            while (it.hasNext()) {
                linkedList.add(((Scope) it.next()).m7285a());
            }
            map.put(C0155h.GOOGLE, linkedList);
        }
    }
}
