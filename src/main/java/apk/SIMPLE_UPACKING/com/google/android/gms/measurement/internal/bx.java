package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p014g.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.C0354a;
import com.google.android.gms.p051b.kf;
import com.google.android.gms.p051b.lj;
import com.google.android.gms.p051b.lm;
import com.google.android.gms.p051b.ln;
import com.google.android.gms.p051b.lp;
import com.google.android.gms.p051b.lq;
import com.google.android.gms.p051b.ls;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class bx {
    private static C0361c f4846a;
    private static volatile bx f4847b;
    private final Context f4848c;
    private final aj f4849d;
    private final bn f4850e;
    private final bc f4851f;
    private final bt f4852g;
    private final C0379u f4853h;
    private final bs f4854i;
    private final C0354a f4855j;
    private final ag f4856k;
    private final ak f4857l;
    private final bf f4858m;
    private final kf f4859n;
    private final C0367i f4860o;
    private final aq f4861p;
    private final C0362d f4862q;
    private final ba f4863r;
    private final bk f4864s;
    private final ad f4865t;
    private final ai f4866u;
    private final boolean f4867v;
    private Boolean f4868w;
    private List f4869x;
    private int f4870y;
    private int f4871z;

    bx(C0361c c0361c) {
        bf.m7873a((Object) c0361c);
        this.f4848c = c0361c.f4874a;
        this.f4859n = c0361c.m8801l(this);
        this.f4849d = c0361c.m8789a(this);
        bn b = c0361c.m8791b(this);
        b.m8226H();
        this.f4850e = b;
        bc c = c0361c.m8792c(this);
        c.m8226H();
        this.f4851f = c;
        m8767f().m8604x().m8608a("App measurement is starting up, version", Long.valueOf(m8765d().m8331M()));
        m8767f().m8604x().m8607a("To enable debug logging run: adb shell setprop log.tag.GMPM VERBOSE");
        m8767f().m8605y().m8607a("Debug logging enabled");
        this.f4856k = c0361c.m8798i(this);
        aq n = c0361c.m8803n(this);
        n.m8226H();
        this.f4861p = n;
        ba o = c0361c.m8804o(this);
        o.m8226H();
        this.f4863r = o;
        ak j = c0361c.m8799j(this);
        j.m8226H();
        this.f4857l = j;
        ai r = c0361c.m8807r(this);
        r.m8226H();
        this.f4866u = r;
        bf k = c0361c.m8800k(this);
        k.m8226H();
        this.f4858m = k;
        C0367i m = c0361c.m8802m(this);
        m.m8226H();
        this.f4860o = m;
        C0362d h = c0361c.m8797h(this);
        h.m8226H();
        this.f4862q = h;
        ad q = c0361c.m8806q(this);
        q.m8226H();
        this.f4865t = q;
        this.f4864s = c0361c.m8805p(this);
        this.f4855j = c0361c.m8796g(this);
        C0379u e = c0361c.m8794e(this);
        e.m8226H();
        this.f4853h = e;
        bs f = c0361c.m8795f(this);
        f.m8226H();
        this.f4854i = f;
        bt d = c0361c.m8793d(this);
        d.m8226H();
        this.f4852g = d;
        if (this.f4870y != this.f4871z) {
            m8767f().m8582b().m8609a("Not all components initialized", Integer.valueOf(this.f4870y), Integer.valueOf(this.f4871z));
        }
        this.f4867v = true;
        if (!(this.f4849d.m8332N() || m8787z())) {
            if (!(this.f4848c.getApplicationContext() instanceof Application)) {
                m8767f().m8583c().m8607a("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                m8773l().m8840b();
            } else {
                m8767f().m8605y().m8607a("Not tracking deep linking pre-ICS");
            }
        }
        this.f4852g.m8709a(new by(this));
    }

    private boolean m8731E() {
        m8786y();
        return this.f4869x != null;
    }

    private boolean m8732F() {
        m8786y();
        m8751a();
        return m8776o().m8392C() || !TextUtils.isEmpty(m8776o().m8430x());
    }

    private void m8733G() {
        m8786y();
        m8751a();
        if (m8763b() && m8732F()) {
            long H = m8734H();
            if (H == 0) {
                m8783v().m8641b();
                m8784w().m8231b();
                return;
            } else if (m8777p().m8617b()) {
                long a = m8766e().f4798e.m8663a();
                long X = m8765d().m8342X();
                if (!m8775n().m8280a(a, X)) {
                    H = Math.max(H, a + X);
                }
                m8783v().m8641b();
                H -= m8779r().m6913a();
                if (H <= 0) {
                    m8784w().m8230a(1);
                    return;
                }
                m8767f().m8606z().m8608a("Upload scheduled in approximately ms", Long.valueOf(H));
                m8784w().m8230a(H);
                return;
            } else {
                m8783v().m8640a();
                m8784w().m8231b();
                return;
            }
        }
        m8783v().m8641b();
        m8784w().m8231b();
    }

    private long m8734H() {
        long a = m8779r().m6913a();
        long aa = m8765d().aa();
        long Y = m8765d().m8343Y();
        long a2 = m8766e().f4796c.m8663a();
        long a3 = m8766e().f4797d.m8663a();
        long max = Math.max(m8776o().m8390A(), m8776o().m8391B());
        if (max == 0) {
            return 0;
        }
        max = a - Math.abs(max - a);
        a3 = a - Math.abs(a3 - a);
        a = Math.max(a - Math.abs(a2 - a), a3);
        aa += max;
        if (!m8775n().m8280a(a, Y)) {
            aa = a + Y;
        }
        if (a3 == 0 || a3 < max) {
            return aa;
        }
        for (int i = 0; i < m8765d().ac(); i++) {
            aa += ((long) (1 << i)) * m8765d().ab();
            if (aa > a3) {
                return aa;
            }
        }
        return 0;
    }

    public static bx m8735a(Context context) {
        bf.m7873a((Object) context);
        bf.m7873a(context.getApplicationContext());
        if (f4847b == null) {
            synchronized (bx.class) {
                if (f4847b == null) {
                    f4847b = (f4846a != null ? f4846a : new C0361c(context)).m8790a();
                }
            }
        }
        return f4847b;
    }

    private void m8736a(int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        m8786y();
        m8751a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.f4869x;
        this.f4869x = null;
        if ((i == 200 || i == 204) && th == null) {
            m8766e().f4796c.m8664a(m8779r().m6913a());
            m8766e().f4797d.m8664a(0);
            m8733G();
            m8767f().m8606z().m8609a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            m8776o().m8415b();
            try {
                for (Long longValue : list) {
                    m8776o().m8398a(longValue.longValue());
                }
                m8776o().m8421c();
                if (m8777p().m8617b() && m8732F()) {
                    m8749C();
                } else {
                    m8733G();
                }
            } finally {
                m8776o().m8428v();
            }
        } else {
            m8767f().m8606z().m8609a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            m8766e().f4797d.m8664a(m8779r().m6913a());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                m8766e().f4798e.m8664a(m8779r().m6913a());
            }
            m8733G();
        }
    }

    private void m8737a(Bundle bundle, int i) {
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", (long) i);
        }
    }

    private void m8740a(ck ckVar) {
        if (ckVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private void m8741a(String str, int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        m8786y();
        m8751a();
        bf.m7875a(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        m8776o().m8415b();
        C0360b b = m8776o().m8412b(str);
        int i3 = ((i == 200 || i == 204 || i == 304) && th == null) ? 1 : 0;
        if (i3 != 0 || i == 404) {
            if (i == 404 || i == 304) {
                if (m8771j().m8675a(str) == null && !m8771j().m8678a(str, null)) {
                    return;
                }
            } else if (!m8771j().m8678a(str, bArr)) {
                m8776o().m8428v();
                return;
            }
            try {
                b.m8521f(m8779r().m6913a());
                m8776o().m8403a(b);
                if (i == 404) {
                    m8767f().m8583c().m8607a("Config not found. Using empty config");
                } else {
                    m8767f().m8606z().m8609a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (m8777p().m8617b() && m8732F()) {
                    m8749C();
                } else {
                    m8733G();
                }
            } finally {
                m8776o().m8428v();
            }
        } else {
            b.m8523g(m8779r().m6913a());
            m8776o().m8403a(b);
            m8767f().m8606z().m8609a("Fetching config failed. code, error", Integer.valueOf(i), th);
            m8766e().f4797d.m8664a(m8779r().m6913a());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                m8766e().f4798e.m8664a(m8779r().m6913a());
            }
            m8733G();
        }
        m8776o().m8421c();
        m8776o().m8428v();
    }

    private void m8742a(List list) {
        bf.m7881b(!list.isEmpty());
        if (this.f4869x != null) {
            m8767f().m8582b().m8607a("Set uploading progress before finishing the previous upload");
        } else {
            this.f4869x = new ArrayList(list);
        }
    }

    private boolean m8743a(String str, long j) {
        m8776o().m8415b();
        try {
            am cbVar = new cb();
            m8776o().m8406a(str, j, cbVar);
            if (cbVar.m8811a()) {
                m8776o().m8421c();
                m8776o().m8428v();
                return false;
            }
            int i;
            lq lqVar = cbVar.f4876a;
            lqVar.f3951b = new ln[cbVar.f4878c.size()];
            int i2 = 0;
            int i3 = 0;
            while (i3 < cbVar.f4878c.size()) {
                if (m8771j().m8679b(cbVar.f4876a.f3964o, ((ln) cbVar.f4878c.get(i3)).f3938b)) {
                    m8767f().m8606z().m8608a("Dropping blacklisted raw event", ((ln) cbVar.f4878c.get(i3)).f3938b);
                    i = i2;
                } else {
                    int i4 = i2 + 1;
                    lqVar.f3951b[i2] = (ln) cbVar.f4878c.get(i3);
                    i = i4;
                }
                i3++;
                i2 = i;
            }
            if (i2 < cbVar.f4878c.size()) {
                lqVar.f3951b = (ln[]) Arrays.copyOf(lqVar.f3951b, i2);
            }
            lqVar.f3949A = m8744a(cbVar.f4876a.f3964o, cbVar.f4876a.f3952c, lqVar.f3951b);
            lqVar.f3954e = lqVar.f3951b[0].f3939c;
            lqVar.f3955f = lqVar.f3951b[0].f3939c;
            for (i = 1; i < lqVar.f3951b.length; i++) {
                ln lnVar = lqVar.f3951b[i];
                if (lnVar.f3939c.longValue() < lqVar.f3954e.longValue()) {
                    lqVar.f3954e = lnVar.f3939c;
                }
                if (lnVar.f3939c.longValue() > lqVar.f3955f.longValue()) {
                    lqVar.f3955f = lnVar.f3939c;
                }
            }
            String str2 = cbVar.f4876a.f3964o;
            C0360b b = m8776o().m8412b(str2);
            if (b == null) {
                m8767f().m8582b().m8607a("Bundling raw events w/o app info");
            } else {
                long g = b.m8522g();
                lqVar.f3957h = g != 0 ? Long.valueOf(g) : null;
                long f = b.m8520f();
                if (f != 0) {
                    g = f;
                }
                lqVar.f3956g = g != 0 ? Long.valueOf(g) : null;
                b.m8536p();
                lqVar.f3972w = Integer.valueOf((int) b.m8533m());
                b.m8505a(lqVar.f3954e.longValue());
                b.m8509b(lqVar.f3955f.longValue());
                m8776o().m8403a(b);
            }
            lqVar.f3973x = m8767f().m8576A();
            m8776o().m8400a(lqVar);
            m8776o().m8409a(cbVar.f4877b);
            m8776o().m8426f(str2);
            m8776o().m8421c();
            return true;
        } finally {
            m8776o().m8428v();
        }
    }

    private lm[] m8744a(String str, ls[] lsVarArr, ln[] lnVarArr) {
        bf.m7875a(str);
        return m8785x().m8317a(str, lnVarArr, lsVarArr);
    }

    private void m8745b(cl clVar) {
        if (clVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!clVar.m8223E()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void m8746c(AppMetadata appMetadata) {
        Object obj = 1;
        m8786y();
        m8751a();
        bf.m7873a((Object) appMetadata);
        bf.m7875a(appMetadata.f4618b);
        C0360b b = m8776o().m8412b(appMetadata.f4618b);
        String b2 = m8766e().m8653b(appMetadata.f4618b);
        Object obj2 = null;
        if (b == null) {
            C0360b c0360b = new C0360b(this, appMetadata.f4618b);
            c0360b.m8506a(m8766e().m8652b());
            c0360b.m8513c(b2);
            b = c0360b;
            obj2 = 1;
        } else if (!b2.equals(b.m8517e())) {
            b.m8513c(b2);
            b.m8506a(m8766e().m8652b());
            int i = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f4619c) || appMetadata.f4619c.equals(b.m8514d()))) {
            b.m8510b(appMetadata.f4619c);
            obj2 = 1;
        }
        if (!(appMetadata.f4622f == 0 || appMetadata.f4622f == b.m8528j())) {
            b.m8512c(appMetadata.f4622f);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f4620d) || appMetadata.f4620d.equals(b.m8524h()))) {
            b.m8516d(appMetadata.f4620d);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f4621e) || appMetadata.f4621e.equals(b.m8526i()))) {
            b.m8519e(appMetadata.f4621e);
            obj2 = 1;
        }
        if (appMetadata.f4623g != b.m8530k()) {
            b.m8515d(appMetadata.f4623g);
            obj2 = 1;
        }
        if (appMetadata.f4625i != b.m8532l()) {
            b.m8507a(appMetadata.f4625i);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            m8776o().m8403a(b);
        }
    }

    long m8747A() {
        return ((((m8779r().m6913a() + m8766e().m8655c()) / 1000) / 60) / 60) / 24;
    }

    void m8748B() {
        if (m8765d().m8332N()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public void m8749C() {
        Map map = null;
        int i = 0;
        m8786y();
        m8751a();
        if (!m8765d().m8332N()) {
            Boolean v = m8766e().m8656v();
            if (v == null) {
                m8767f().m8583c().m8607a("Upload data called on the client side before use of service was decided");
                return;
            } else if (v.booleanValue()) {
                m8767f().m8582b().m8607a("Upload called in the client side when service should be used");
                return;
            }
        }
        if (m8731E()) {
            m8767f().m8583c().m8607a("Uploading requested multiple times");
        } else if (m8777p().m8617b()) {
            long a = m8779r().m6913a();
            m8760a(a - m8765d().m8341W());
            long a2 = m8766e().f4796c.m8663a();
            if (a2 != 0) {
                m8767f().m8605y().m8608a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(a - a2)));
            }
            String x = m8776o().m8430x();
            if (TextUtils.isEmpty(x)) {
                String b = m8776o().m8414b(a - m8765d().m8341W());
                if (!TextUtils.isEmpty(b)) {
                    C0360b b2 = m8776o().m8412b(b);
                    if (b2 != null) {
                        String a3 = m8765d().m8348a(b2.m8514d(), b2.m8511c());
                        try {
                            URL url = new URL(a3);
                            m8767f().m8606z().m8608a("Fetching remote configuration", b2.m8508b());
                            lj a4 = m8771j().m8675a(b2.m8508b());
                            if (!(a4 == null || a4.f3922a == null)) {
                                map = new ArrayMap();
                                map.put("Config-Version", String.valueOf(a4.f3922a));
                            }
                            m8777p().m8615a(b, url, map, new ca(this));
                            return;
                        } catch (MalformedURLException e) {
                            m8767f().m8582b().m8608a("Failed to parse config URL. Not fetching", a3);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            List<Pair> a5 = m8776o().m8396a(x, m8765d().m8353c(x), m8765d().m8354d(x));
            if (!a5.isEmpty()) {
                lq lqVar;
                Object obj;
                List subList;
                for (Pair pair : a5) {
                    lqVar = (lq) pair.first;
                    if (!TextUtils.isEmpty(lqVar.f3968s)) {
                        obj = lqVar.f3968s;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    for (int i2 = 0; i2 < a5.size(); i2++) {
                        lqVar = (lq) ((Pair) a5.get(i2)).first;
                        if (!TextUtils.isEmpty(lqVar.f3968s) && !lqVar.f3968s.equals(obj)) {
                            subList = a5.subList(0, i2);
                            break;
                        }
                    }
                }
                subList = a5;
                lp lpVar = new lp();
                lpVar.f3947a = new lq[subList.size()];
                List arrayList = new ArrayList(subList.size());
                while (i < lpVar.f3947a.length) {
                    lpVar.f3947a[i] = (lq) ((Pair) subList.get(i)).first;
                    arrayList.add(((Pair) subList.get(i)).second);
                    lpVar.f3947a[i].f3967r = Long.valueOf(m8765d().m8331M());
                    lpVar.f3947a[i].f3953d = Long.valueOf(a);
                    lpVar.f3947a[i].f3975z = Boolean.valueOf(m8765d().m8332N());
                    i++;
                }
                Object b3 = m8767f().m8581a(2) ? ag.m8270b(lpVar) : null;
                byte[] a6 = m8775n().m8281a(lpVar);
                String V = m8765d().m8340V();
                try {
                    URL url2 = new URL(V);
                    m8742a(arrayList);
                    m8766e().f4797d.m8664a(a);
                    Object obj2 = "?";
                    if (lpVar.f3947a.length > 0) {
                        obj2 = lpVar.f3947a[0].f3964o;
                    }
                    m8767f().m8606z().m8610a("Uploading data. app, uncompressed size, data", obj2, Integer.valueOf(a6.length), b3);
                    m8777p().m8616a(x, url2, a6, null, new bz(this));
                } catch (MalformedURLException e2) {
                    m8767f().m8582b().m8608a("Failed to parse upload URL. Not uploading", V);
                }
            }
        } else {
            m8767f().m8583c().m8607a("Network not connected, ignoring upload request");
            m8733G();
        }
    }

    void m8750D() {
        this.f4871z++;
    }

    void m8751a() {
        if (!this.f4867v) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    void m8752a(AppMetadata appMetadata) {
        m8786y();
        m8751a();
        bf.m7875a(appMetadata.f4618b);
        m8746c(appMetadata);
    }

    void m8753a(EventParcel eventParcel, AppMetadata appMetadata) {
        long nanoTime = System.nanoTime();
        m8786y();
        m8751a();
        String str = appMetadata.f4618b;
        bf.m7875a(str);
        if (!TextUtils.isEmpty(appMetadata.f4619c)) {
            if (!appMetadata.f4625i) {
                m8746c(appMetadata);
            } else if (m8771j().m8679b(str, eventParcel.f4630b)) {
                m8767f().m8606z().m8608a("Dropping blacklisted event", eventParcel.f4630b);
            } else {
                if (m8767f().m8581a(2)) {
                    m8767f().m8606z().m8608a("Logging event", eventParcel);
                }
                m8776o().m8415b();
                try {
                    Bundle b = eventParcel.f4631c.m8197b();
                    m8746c(appMetadata);
                    if ("_iap".equals(eventParcel.f4630b) || "ecommerce_purchase".equals(eventParcel.f4630b)) {
                        Object string = b.getString("currency");
                        long j = b.getLong("value");
                        if (!TextUtils.isEmpty(string) && j > 0) {
                            String toUpperCase = string.toUpperCase(Locale.US);
                            if (toUpperCase.matches("[A-Z]{3}")) {
                                af afVar;
                                String str2 = "_ltv_" + toUpperCase;
                                af c = m8776o().m8420c(str, str2);
                                if (c == null || !(c.f4662d instanceof Long)) {
                                    m8776o().m8404a(str, m8765d().m8350b(str) - 1);
                                    afVar = new af(str, str2, m8779r().m6913a(), Long.valueOf(j));
                                } else {
                                    afVar = new af(str, str2, m8779r().m6913a(), Long.valueOf(j + ((Long) c.f4662d).longValue()));
                                }
                                m8776o().m8410a(afVar);
                            }
                        }
                    }
                    boolean a = ag.m8266a(eventParcel.f4630b);
                    boolean a2 = ag.m8265a(b);
                    ak o = m8776o();
                    long A = m8747A();
                    boolean z = a && a2;
                    al a3 = o.m8393a(A, str, a, z);
                    A = a3.f4669b - m8765d().m8320B();
                    if (A > 0) {
                        if (A % 1000 == 1) {
                            m8767f().m8583c().m8608a("Data loss. Too many events logged. count", Long.valueOf(a3.f4669b));
                        }
                        m8776o().m8421c();
                        return;
                    }
                    as a4;
                    if (a) {
                        A = a3.f4668a - m8765d().m8321C();
                        if (A > 0) {
                            m8758a(str, 2);
                            if (A % 1000 == 1) {
                                m8767f().m8583c().m8608a("Data loss. Too many public events logged. count", Long.valueOf(a3.f4668a));
                            }
                            m8776o().m8421c();
                            m8776o().m8428v();
                            return;
                        }
                    }
                    if (a && a2) {
                        if (a3.f4670c - m8765d().m8322D() > 0) {
                            b.remove("_c");
                            m8737a(b, 4);
                        }
                    }
                    long c2 = m8776o().m8418c(str);
                    if (c2 > 0) {
                        m8767f().m8583c().m8608a("Data lost. Too many events stored on disk, deleted", Long.valueOf(c2));
                    }
                    ar arVar = new ar(this, eventParcel.f4632d, str, eventParcel.f4630b, eventParcel.f4633e, 0, b);
                    as a5 = m8776o().m8394a(str, arVar.f4681b);
                    if (a5 != null) {
                        arVar = arVar.m8471a(this, a5.f4690e);
                        a4 = a5.m8473a(arVar.f4683d);
                    } else if (m8776o().m8427g(str) >= ((long) m8765d().m8319A())) {
                        m8767f().m8583c().m8609a("Too many event names used, ignoring event. name, supported count", arVar.f4681b, Integer.valueOf(m8765d().m8319A()));
                        m8758a(str, 1);
                        m8776o().m8428v();
                        return;
                    } else {
                        a4 = new as(str, arVar.f4681b, 0, 0, arVar.f4683d);
                    }
                    m8776o().m8402a(a4);
                    m8756a(arVar, appMetadata);
                    m8776o().m8421c();
                    if (m8767f().m8581a(2)) {
                        m8767f().m8606z().m8608a("Event recorded", arVar);
                    }
                    m8776o().m8428v();
                    m8733G();
                    m8767f().m8606z().m8608a("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } finally {
                    m8776o().m8428v();
                }
            }
        }
    }

    void m8754a(EventParcel eventParcel, String str) {
        C0360b b = m8776o().m8412b(str);
        if (b == null || TextUtils.isEmpty(b.m8524h())) {
            m8767f().m8605y().m8608a("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = m8778q().getPackageManager().getPackageInfo(str, 0).versionName;
            if (!(b.m8524h() == null || b.m8524h().equals(str2))) {
                m8767f().m8583c().m8608a("App version does not match; dropping event", str);
                return;
            }
        } catch (NameNotFoundException e) {
            m8767f().m8583c().m8608a("Could not find package", str);
        }
        m8753a(eventParcel, new AppMetadata(str, b.m8514d(), b.m8524h(), b.m8526i(), b.m8528j(), b.m8530k(), null, b.m8532l(), false));
    }

    void m8755a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        m8786y();
        m8751a();
        if (!TextUtils.isEmpty(appMetadata.f4619c)) {
            if (appMetadata.f4625i) {
                m8775n().m8287c(userAttributeParcel.f4635b);
                Object c = m8775n().m8286c(userAttributeParcel.f4635b, userAttributeParcel.m8198a());
                if (c != null) {
                    af afVar = new af(appMetadata.f4618b, userAttributeParcel.f4635b, userAttributeParcel.f4636c, c);
                    m8767f().m8605y().m8609a("Setting user property", afVar.f4660b, c);
                    m8776o().m8415b();
                    try {
                        m8746c(appMetadata);
                        boolean a = m8776o().m8410a(afVar);
                        m8776o().m8421c();
                        if (a) {
                            m8767f().m8605y().m8609a("User property set", afVar.f4660b, afVar.f4662d);
                        } else {
                            m8767f().m8603w().m8609a("Ignoring user property. Value too long", afVar.f4660b, afVar.f4662d);
                        }
                        m8776o().m8428v();
                        return;
                    } catch (Throwable th) {
                        m8776o().m8428v();
                    }
                } else {
                    return;
                }
            }
            m8746c(appMetadata);
        }
    }

    void m8756a(ar arVar, AppMetadata appMetadata) {
        m8786y();
        m8751a();
        bf.m7873a((Object) arVar);
        bf.m7873a((Object) appMetadata);
        bf.m7875a(arVar.f4680a);
        bf.m7881b(arVar.f4680a.equals(appMetadata.f4618b));
        lq lqVar = new lq();
        lqVar.f3950a = Integer.valueOf(1);
        lqVar.f3958i = "android";
        lqVar.f3964o = appMetadata.f4618b;
        lqVar.f3963n = appMetadata.f4621e;
        lqVar.f3965p = appMetadata.f4620d;
        lqVar.f3966q = Long.valueOf(appMetadata.f4622f);
        lqVar.f3974y = appMetadata.f4619c;
        lqVar.f3971v = appMetadata.f4623g == 0 ? null : Long.valueOf(appMetadata.f4623g);
        Pair a = m8766e().m8649a(appMetadata.f4618b);
        if (!(a == null || a.first == null || a.second == null)) {
            lqVar.f3968s = (String) a.first;
            lqVar.f3969t = (Boolean) a.second;
        }
        lqVar.f3960k = m8781t().m8448b();
        lqVar.f3959j = m8781t().m8449c();
        lqVar.f3962m = Integer.valueOf((int) m8781t().m8468v());
        lqVar.f3961l = m8781t().m8469w();
        lqVar.f3967r = null;
        lqVar.f3953d = null;
        lqVar.f3954e = null;
        lqVar.f3955f = null;
        C0360b b = m8776o().m8412b(appMetadata.f4618b);
        if (b == null) {
            b = new C0360b(this, appMetadata.f4618b);
            b.m8506a(m8766e().m8652b());
            b.m8510b(appMetadata.f4619c);
            b.m8513c(m8766e().m8653b(appMetadata.f4618b));
            b.m8518e(0);
            b.m8505a(0);
            b.m8509b(0);
            b.m8516d(appMetadata.f4620d);
            b.m8519e(appMetadata.f4621e);
            b.m8512c(appMetadata.f4622f);
            b.m8515d(appMetadata.f4623g);
            b.m8507a(appMetadata.f4625i);
            m8776o().m8403a(b);
        }
        lqVar.f3970u = b.m8511c();
        List a2 = m8776o().m8395a(appMetadata.f4618b);
        lqVar.f3952c = new ls[a2.size()];
        for (int i = 0; i < a2.size(); i++) {
            ls lsVar = new ls();
            lqVar.f3952c[i] = lsVar;
            lsVar.f3980b = ((af) a2.get(i)).f4660b;
            lsVar.f3979a = Long.valueOf(((af) a2.get(i)).f4661c);
            m8775n().m8278a(lsVar, ((af) a2.get(i)).f4662d);
        }
        try {
            m8776o().m8401a(arVar, m8776o().m8411b(lqVar));
        } catch (IOException e) {
            m8767f().m8582b().m8608a("Data loss. Failed to insert raw event metadata", e);
        }
    }

    void m8757a(cl clVar) {
        this.f4870y++;
    }

    void m8758a(String str, int i) {
    }

    public void m8759a(boolean z) {
        m8733G();
    }

    boolean m8760a(long j) {
        return m8743a(null, j);
    }

    public void m8761b(AppMetadata appMetadata) {
        m8786y();
        m8751a();
        bf.m7873a((Object) appMetadata);
        bf.m7875a(appMetadata.f4618b);
        if (!TextUtils.isEmpty(appMetadata.f4619c)) {
            if (appMetadata.f4625i) {
                long a = m8779r().m6913a();
                m8776o().m8415b();
                try {
                    Bundle bundle;
                    C0360b b = m8776o().m8412b(appMetadata.f4618b);
                    if (!(b == null || b.m8524h() == null || b.m8524h().equals(appMetadata.f4620d))) {
                        bundle = new Bundle();
                        bundle.putString("_pv", b.m8524h());
                        m8753a(new EventParcel("_au", new EventParams(bundle), "auto", a), appMetadata);
                    }
                    m8746c(appMetadata);
                    if (m8776o().m8394a(appMetadata.f4618b, "_f") == null) {
                        m8755a(new UserAttributeParcel("_fot", a, Long.valueOf(((a / 3600000) + 1) * 3600000), "auto"), appMetadata);
                        bundle = new Bundle();
                        bundle.putLong("_c", 1);
                        m8753a(new EventParcel("_f", new EventParams(bundle), "auto", a), appMetadata);
                    } else if (appMetadata.f4626j) {
                        m8753a(new EventParcel("_cd", new EventParams(new Bundle()), "auto", a), appMetadata);
                    }
                    m8776o().m8421c();
                } finally {
                    m8776o().m8428v();
                }
            } else {
                m8746c(appMetadata);
            }
        }
    }

    void m8762b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        m8786y();
        m8751a();
        if (!TextUtils.isEmpty(appMetadata.f4619c)) {
            if (appMetadata.f4625i) {
                m8767f().m8605y().m8608a("Removing user property", userAttributeParcel.f4635b);
                m8776o().m8415b();
                try {
                    m8746c(appMetadata);
                    m8776o().m8417b(appMetadata.f4618b, userAttributeParcel.f4635b);
                    m8776o().m8421c();
                    m8767f().m8605y().m8608a("User property removed", userAttributeParcel.f4635b);
                } finally {
                    m8776o().m8428v();
                }
            } else {
                m8746c(appMetadata);
            }
        }
    }

    protected boolean m8763b() {
        boolean z = true;
        m8751a();
        m8786y();
        if (this.f4868w == null) {
            boolean z2 = m8775n().m8293f("android.permission.INTERNET") && m8775n().m8293f("android.permission.ACCESS_NETWORK_STATE") && AppMeasurementReceiver.m8178a(m8778q()) && AppMeasurementService.m8181a(m8778q());
            this.f4868w = Boolean.valueOf(z2);
            if (this.f4868w.booleanValue() && !m8765d().m8332N()) {
                if (TextUtils.isEmpty(m8782u().m8545c())) {
                    z = false;
                }
                this.f4868w = Boolean.valueOf(z);
            }
        }
        return this.f4868w.booleanValue();
    }

    protected void m8764c() {
        m8786y();
        if (!m8787z() || (this.f4852g.m8223E() && !this.f4852g.m8224F())) {
            m8776o().m8431y();
            if (m8763b()) {
                if (!(m8765d().m8332N() || m8787z() || TextUtils.isEmpty(m8782u().m8545c()))) {
                    m8773l().m8841c();
                }
            } else if (m8766e().m8657w()) {
                if (!m8775n().m8293f("android.permission.INTERNET")) {
                    m8767f().m8582b().m8607a("App is missing INTERNET permission");
                }
                if (!m8775n().m8293f("android.permission.ACCESS_NETWORK_STATE")) {
                    m8767f().m8582b().m8607a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!AppMeasurementReceiver.m8178a(m8778q())) {
                    m8767f().m8582b().m8607a("AppMeasurementReceiver not registered/enabled");
                }
                if (!AppMeasurementService.m8181a(m8778q())) {
                    m8767f().m8582b().m8607a("AppMeasurementService not registered/enabled");
                }
                m8767f().m8582b().m8607a("Uploading is not possible. App measurement disabled");
            }
            m8733G();
            return;
        }
        m8767f().m8582b().m8607a("Scheduler shutting down before Scion.start() called");
    }

    public aj m8765d() {
        return this.f4849d;
    }

    public bn m8766e() {
        m8740a(this.f4850e);
        return this.f4850e;
    }

    public bc m8767f() {
        m8745b(this.f4851f);
        return this.f4851f;
    }

    public bc m8768g() {
        return (this.f4851f == null || !this.f4851f.m8223E()) ? null : this.f4851f;
    }

    public bt m8769h() {
        m8745b(this.f4852g);
        return this.f4852g;
    }

    public C0379u m8770i() {
        m8745b(this.f4853h);
        return this.f4853h;
    }

    public bs m8771j() {
        m8745b(this.f4854i);
        return this.f4854i;
    }

    bt m8772k() {
        return this.f4852g;
    }

    public C0362d m8773l() {
        m8745b(this.f4862q);
        return this.f4862q;
    }

    public C0354a m8774m() {
        return this.f4855j;
    }

    public ag m8775n() {
        m8740a(this.f4856k);
        return this.f4856k;
    }

    public ak m8776o() {
        m8745b(this.f4857l);
        return this.f4857l;
    }

    public bf m8777p() {
        m8745b(this.f4858m);
        return this.f4858m;
    }

    public Context m8778q() {
        return this.f4848c;
    }

    public kf m8779r() {
        return this.f4859n;
    }

    public C0367i m8780s() {
        m8745b(this.f4860o);
        return this.f4860o;
    }

    public aq m8781t() {
        m8745b(this.f4861p);
        return this.f4861p;
    }

    public ba m8782u() {
        m8745b(this.f4863r);
        return this.f4863r;
    }

    public bk m8783v() {
        if (this.f4864s != null) {
            return this.f4864s;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public ad m8784w() {
        m8745b(this.f4865t);
        return this.f4865t;
    }

    public ai m8785x() {
        m8745b(this.f4866u);
        return this.f4866u;
    }

    public void m8786y() {
        m8769h().m8713f();
    }

    protected boolean m8787z() {
        return false;
    }
}
