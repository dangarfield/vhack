package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.C0225a;
import com.google.android.gms.common.api.C0263o;
import com.google.android.gms.p051b.ma;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.t */
public final class C0301t {
    private final Account f4443a;
    private final Set f4444b;
    private final Set f4445c;
    private final Map f4446d;
    private final int f4447e;
    private final View f4448f;
    private final String f4449g;
    private final String f4450h;
    private final ma f4451i;
    private Integer f4452j;

    public C0301t(Account account, Set set, Map map, int i, View view, String str, String str2, ma maVar) {
        this.f4443a = account;
        this.f4444b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map = Collections.EMPTY_MAP;
        }
        this.f4446d = map;
        this.f4448f = view;
        this.f4447e = i;
        this.f4449g = str;
        this.f4450h = str2;
        this.f4451i = maVar;
        Set hashSet = new HashSet(this.f4444b);
        for (C0302u c0302u : this.f4446d.values()) {
            hashSet.addAll(c0302u.f4453a);
        }
        this.f4445c = Collections.unmodifiableSet(hashSet);
    }

    public static C0301t m7969a(Context context) {
        return new C0263o(context).m7629a();
    }

    @Deprecated
    public String m7970a() {
        return this.f4443a != null ? this.f4443a.name : null;
    }

    public Set m7971a(C0225a c0225a) {
        C0302u c0302u = (C0302u) this.f4446d.get(c0225a);
        if (c0302u == null || c0302u.f4453a.isEmpty()) {
            return this.f4444b;
        }
        Set hashSet = new HashSet(this.f4444b);
        hashSet.addAll(c0302u.f4453a);
        return hashSet;
    }

    public void m7972a(Integer num) {
        this.f4452j = num;
    }

    public Account m7973b() {
        return this.f4443a;
    }

    public Account m7974c() {
        return this.f4443a != null ? this.f4443a : new Account("<<default account>>", "com.google");
    }

    public Set m7975d() {
        return this.f4444b;
    }

    public Set m7976e() {
        return this.f4445c;
    }

    public Map m7977f() {
        return this.f4446d;
    }

    public String m7978g() {
        return this.f4449g;
    }

    public String m7979h() {
        return this.f4450h;
    }

    public ma m7980i() {
        return this.f4451i;
    }

    public Integer m7981j() {
        return this.f4452j;
    }
}
