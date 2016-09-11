package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.p014g.ArrayMap;
import android.view.View;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.api.internal.C0234g;
import com.google.android.gms.common.api.internal.C0258z;
import com.google.android.gms.common.api.internal.ax;
import com.google.android.gms.common.internal.C0280b;
import com.google.android.gms.common.internal.C0301t;
import com.google.android.gms.common.internal.C0302u;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.lu;
import com.google.android.gms.p051b.ma;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.o */
public final class C0263o {
    private Account f4301a;
    private final Set f4302b;
    private final Set f4303c;
    private int f4304d;
    private View f4305e;
    private String f4306f;
    private String f4307g;
    private final Map f4308h;
    private final Context f4309i;
    private final Map f4310j;
    private FragmentActivity f4311k;
    private int f4312l;
    private C0230r f4313m;
    private Looper f4314n;
    private C0268j f4315o;
    private C0106g f4316p;
    private final ArrayList f4317q;
    private final ArrayList f4318r;

    public C0263o(Context context) {
        this.f4302b = new HashSet();
        this.f4303c = new HashSet();
        this.f4308h = new ArrayMap();
        this.f4310j = new ArrayMap();
        this.f4312l = -1;
        this.f4315o = C0268j.m7636b();
        this.f4316p = lu.f3986c;
        this.f4317q = new ArrayList();
        this.f4318r = new ArrayList();
        this.f4309i = context;
        this.f4314n = context.getMainLooper();
        this.f4306f = context.getPackageName();
        this.f4307g = context.getClass().getName();
    }

    private static C0121h m7618a(C0106g c0106g, Object obj, Context context, Looper looper, C0301t c0301t, C0229q c0229q, C0230r c0230r) {
        return c0106g.m5651a(context, looper, c0301t, obj, c0229q, c0230r);
    }

    private static C0280b m7619a(C0260k c0260k, Object obj, Context context, Looper looper, C0301t c0301t, C0229q c0229q, C0230r c0230r) {
        return new C0280b(context, looper, c0260k.m7615b(), c0229q, c0230r, c0301t, c0260k.m7614a(obj));
    }

    private void m7620a(ax axVar, C0257n c0257n) {
        axVar.m7323a(this.f4312l, c0257n, this.f4313m);
    }

    private void m7621a(C0257n c0257n) {
        ax a = ax.m7309a(this.f4311k);
        if (a == null) {
            new Handler(this.f4309i.getMainLooper()).post(new C0264p(this, c0257n));
        } else {
            m7620a(a, c0257n);
        }
    }

    private C0257n m7623c() {
        C0301t a = m7629a();
        C0225a c0225a = null;
        Map f = a.m7977f();
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        C0225a c0225a2 = null;
        for (C0225a c0225a3 : this.f4310j.keySet()) {
            C0225a c0225a32;
            C0121h a2;
            C0225a c0225a4;
            Object obj = this.f4310j.get(c0225a32);
            int i = 0;
            if (f.get(c0225a32) != null) {
                i = ((C0302u) f.get(c0225a32)).f4454b ? 1 : 2;
            }
            arrayMap.put(c0225a32, Integer.valueOf(i));
            C0229q c0234g = new C0234g(c0225a32, i);
            arrayList.add(c0234g);
            C0225a c0225a5;
            if (c0225a32.m7297d()) {
                C0260k b = c0225a32.m7295b();
                c0225a5 = b.m7613a() == 1 ? c0225a32 : c0225a2;
                a2 = C0263o.m7619a(b, obj, this.f4309i, this.f4314n, a, c0234g, (C0230r) c0234g);
                c0225a4 = c0225a5;
            } else {
                C0106g a3 = c0225a32.m7294a();
                c0225a5 = a3.m5650a() == 1 ? c0225a32 : c0225a2;
                a2 = C0263o.m7618a(a3, obj, this.f4309i, this.f4314n, a, c0234g, (C0230r) c0234g);
                c0225a4 = c0225a5;
            }
            arrayMap2.put(c0225a32.m7296c(), a2);
            if (!a2.m5720d()) {
                c0225a32 = c0225a;
            } else if (c0225a != null) {
                throw new IllegalStateException(c0225a32.m7298e() + " cannot be used with " + c0225a.m7298e());
            }
            c0225a2 = c0225a4;
            c0225a = c0225a32;
        }
        if (c0225a != null) {
            if (c0225a2 != null) {
                throw new IllegalStateException(c0225a.m7298e() + " cannot be used with " + c0225a2.m7298e());
            }
            bf.m7879a(this.f4301a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", c0225a.m7298e());
            bf.m7879a(this.f4302b.equals(this.f4303c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", c0225a.m7298e());
        }
        return new C0258z(this.f4309i, new ReentrantLock(), this.f4314n, a, this.f4315o, this.f4316p, arrayMap, this.f4317q, this.f4318r, arrayMap2, this.f4312l, C0258z.m7567a(arrayMap2.values(), true), arrayList);
    }

    public C0263o m7624a(Handler handler) {
        bf.m7874a((Object) handler, (Object) "Handler must not be null");
        this.f4314n = handler.getLooper();
        return this;
    }

    public C0263o m7625a(C0225a c0225a) {
        bf.m7874a((Object) c0225a, (Object) "Api must not be null");
        this.f4310j.put(c0225a, null);
        Collection a = c0225a.m7294a().m5652a(null);
        this.f4303c.addAll(a);
        this.f4302b.addAll(a);
        return this;
    }

    public C0263o m7626a(C0225a c0225a, C0139c c0139c) {
        bf.m7874a((Object) c0225a, (Object) "Api must not be null");
        bf.m7874a((Object) c0139c, (Object) "Null options are not permitted for this Api");
        this.f4310j.put(c0225a, c0139c);
        Collection a = c0225a.m7294a().m5652a(c0139c);
        this.f4303c.addAll(a);
        this.f4302b.addAll(a);
        return this;
    }

    public C0263o m7627a(C0229q c0229q) {
        bf.m7874a((Object) c0229q, (Object) "Listener must not be null");
        this.f4317q.add(c0229q);
        return this;
    }

    public C0263o m7628a(C0230r c0230r) {
        bf.m7874a((Object) c0230r, (Object) "Listener must not be null");
        this.f4318r.add(c0230r);
        return this;
    }

    public C0301t m7629a() {
        ma maVar = ma.f4007a;
        if (this.f4310j.containsKey(lu.f3990g)) {
            maVar = (ma) this.f4310j.get(lu.f3990g);
        }
        return new C0301t(this.f4301a, this.f4302b, this.f4308h, this.f4304d, this.f4305e, this.f4306f, this.f4307g, maVar);
    }

    public C0257n m7630b() {
        bf.m7882b(!this.f4310j.isEmpty(), "must call addApi() to add at least one API");
        C0257n c = m7623c();
        synchronized (C0257n.f4274a) {
            C0257n.f4274a.add(c);
        }
        if (this.f4312l >= 0) {
            m7621a(c);
        }
        return c;
    }
}
