package com.google.android.gms.p051b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.b.hy */
public abstract class hy implements Comparable {
    private final mf f3499a;
    private final int f3500b;
    private final String f3501c;
    private final int f3502d;
    private final jl f3503e;
    private Integer f3504f;
    private iq f3505g;
    private boolean f3506h;
    private boolean f3507i;
    private boolean f3508j;
    private long f3509k;
    private kt f3510l;
    private C0209l f3511m;

    public hy(int i, String str, jl jlVar) {
        this.f3499a = mf.f4034a ? new mf() : null;
        this.f3506h = true;
        this.f3507i = false;
        this.f3508j = false;
        this.f3509k = 0;
        this.f3511m = null;
        this.f3500b = i;
        this.f3501c = str;
        this.f3503e = jlVar;
        m6186a(new bo());
        this.f3502d = hy.m6180a(str);
    }

    private static int m6180a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    private byte[] m6181a(Map map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public int m6183a(hy hyVar) {
        ia q = m6210q();
        ia q2 = hyVar.m6210q();
        return q == q2 ? this.f3504f.intValue() - hyVar.f3504f.intValue() : q2.ordinal() - q.ordinal();
    }

    public final hy m6184a(int i) {
        this.f3504f = Integer.valueOf(i);
        return this;
    }

    public hy m6185a(iq iqVar) {
        this.f3505g = iqVar;
        return this;
    }

    public hy m6186a(kt ktVar) {
        this.f3510l = ktVar;
        return this;
    }

    public hy m6187a(C0209l c0209l) {
        this.f3511m = c0209l;
        return this;
    }

    protected abstract jk m6188a(fk fkVar);

    protected lt m6189a(lt ltVar) {
        return ltVar;
    }

    public Map m6190a() {
        return Collections.emptyMap();
    }

    protected abstract void m6191a(Object obj);

    public int m6192b() {
        return this.f3500b;
    }

    public void m6193b(lt ltVar) {
        if (this.f3503e != null) {
            this.f3503e.m6602a(ltVar);
        }
    }

    public void m6194b(String str) {
        if (mf.f4034a) {
            this.f3499a.m7103a(str, Thread.currentThread().getId());
        } else if (this.f3509k == 0) {
            this.f3509k = SystemClock.elapsedRealtime();
        }
    }

    public int m6195c() {
        return this.f3502d;
    }

    void m6196c(String str) {
        if (this.f3505g != null) {
            this.f3505g.m6823b(this);
        }
        if (mf.f4034a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new hz(this, str, id));
                return;
            }
            this.f3499a.m7103a(str, id);
            this.f3499a.m7102a(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f3509k >= 3000) {
            me.m7098b("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.f3509k), toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m6183a((hy) obj);
    }

    public String m6197d() {
        return this.f3501c;
    }

    public String m6198e() {
        return m6197d();
    }

    public C0209l m6199f() {
        return this.f3511m;
    }

    public boolean m6200g() {
        return this.f3507i;
    }

    @Deprecated
    protected Map m6201h() {
        return m6205l();
    }

    @Deprecated
    protected String m6202i() {
        return m6206m();
    }

    @Deprecated
    public String m6203j() {
        return m6207n();
    }

    @Deprecated
    public byte[] m6204k() {
        Map h = m6201h();
        return (h == null || h.size() <= 0) ? null : m6181a(h, m6202i());
    }

    protected Map m6205l() {
        return null;
    }

    protected String m6206m() {
        return "UTF-8";
    }

    public String m6207n() {
        return "application/x-www-form-urlencoded; charset=" + m6206m();
    }

    public byte[] m6208o() {
        Map l = m6205l();
        return (l == null || l.size() <= 0) ? null : m6181a(l, m6206m());
    }

    public final boolean m6209p() {
        return this.f3506h;
    }

    public ia m6210q() {
        return ia.NORMAL;
    }

    public final int m6211r() {
        return this.f3510l.m6158a();
    }

    public kt m6212s() {
        return this.f3510l;
    }

    public void m6213t() {
        this.f3508j = true;
    }

    public String toString() {
        return (this.f3507i ? "[X] " : "[ ] ") + m6197d() + " " + ("0x" + Integer.toHexString(m6195c())) + " " + m6210q() + " " + this.f3504f;
    }

    public boolean m6214u() {
        return this.f3508j;
    }
}
