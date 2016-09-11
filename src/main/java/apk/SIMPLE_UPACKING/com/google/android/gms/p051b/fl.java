package com.google.android.gms.p051b;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.C0273r;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

@fi
/* renamed from: com.google.android.gms.b.fl */
public class fl {
    private final Object f3638a;
    private final String f3639b;
    private final fm f3640c;
    private BigInteger f3641d;
    private final HashSet f3642e;
    private final HashMap f3643f;
    private boolean f3644g;
    private boolean f3645h;
    private int f3646i;
    private boolean f3647j;
    private Context f3648k;
    private VersionInfoParcel f3649l;
    private ao f3650m;
    private boolean f3651n;
    private C0212o f3652o;
    private C0213p f3653p;
    private C0211n f3654q;
    private final LinkedList f3655r;
    private final fh f3656s;
    private Boolean f3657t;
    private String f3658u;
    private boolean f3659v;
    private boolean f3660w;

    public fl(fx fxVar) {
        this.f3638a = new Object();
        this.f3641d = BigInteger.ONE;
        this.f3642e = new HashSet();
        this.f3643f = new HashMap();
        this.f3644g = false;
        this.f3645h = true;
        this.f3646i = 0;
        this.f3647j = false;
        this.f3650m = null;
        this.f3651n = true;
        this.f3652o = null;
        this.f3653p = null;
        this.f3654q = null;
        this.f3655r = new LinkedList();
        this.f3656s = null;
        this.f3657t = null;
        this.f3659v = false;
        this.f3660w = false;
        this.f3639b = fxVar.m6546b();
        this.f3640c = new fm(this.f3639b);
    }

    public ao m6497a() {
        ao aoVar;
        synchronized (this.f3638a) {
            aoVar = this.f3650m;
        }
        return aoVar;
    }

    public String m6498a(int i, String str) {
        Resources resources = this.f3649l.f3095e ? this.f3648k.getResources() : C0273r.m7665d(this.f3648k);
        return resources == null ? str : resources.getString(i);
    }

    public void m6499a(Boolean bool) {
        synchronized (this.f3638a) {
            this.f3657t = bool;
        }
    }

    public void m6500a(Throwable th, boolean z) {
        new fh(this.f3648k, this.f3649l, null, null).m6493a(th, z);
    }

    public String m6501b() {
        String str;
        synchronized (this.f3638a) {
            str = this.f3658u;
        }
        return str;
    }

    public Boolean m6502c() {
        Boolean bool;
        synchronized (this.f3638a) {
            bool = this.f3657t;
        }
        return bool;
    }
}
