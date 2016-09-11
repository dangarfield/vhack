package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri.Builder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.internal.C0284f;
import com.google.android.gms.p051b.kf;
import com.google.android.gms.p051b.ko;

public class aj extends ck {
    static final String f4663a;
    private Boolean f4664b;

    static {
        f4663a = String.valueOf(C0268j.f4322b / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    }

    aj(bx bxVar) {
        super(bxVar);
    }

    int m8319A() {
        return 500;
    }

    public long m8320B() {
        return (long) ((Integer) av.f4704m.m8490b()).intValue();
    }

    public long m8321C() {
        return (long) ((Integer) av.f4705n.m8490b()).intValue();
    }

    public long m8322D() {
        return (long) ((Integer) av.f4706o.m8490b()).intValue();
    }

    int m8323E() {
        return 25;
    }

    int m8324F() {
        return 50;
    }

    long m8325G() {
        return 3600000;
    }

    long m8326H() {
        return 60000;
    }

    long m8327I() {
        return 61000;
    }

    long m8328J() {
        return ((Long) av.f4691A.m8490b()).longValue();
    }

    public String m8329K() {
        return "google_app_measurement.db";
    }

    public String m8330L() {
        return "google_app_measurement2.db";
    }

    public long m8331M() {
        return (long) (C0268j.f4322b / 1000);
    }

    public boolean m8332N() {
        return C0284f.f4420a;
    }

    public boolean m8333O() {
        if (this.f4664b == null) {
            synchronized (this) {
                if (this.f4664b == null) {
                    ApplicationInfo applicationInfo = m8365m().getApplicationInfo();
                    String a = ko.m6944a(m8365m(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.f4664b = Boolean.valueOf(z);
                    }
                    if (this.f4664b == null) {
                        this.f4664b = Boolean.TRUE;
                        m8371s().m8582b().m8607a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f4664b.booleanValue();
    }

    public long m8334P() {
        return ((Long) av.f4716y.m8490b()).longValue();
    }

    public long m8335Q() {
        return ((Long) av.f4712u.m8490b()).longValue();
    }

    public long m8336R() {
        return 1000;
    }

    public long m8337S() {
        return Math.max(0, ((Long) av.f4696e.m8490b()).longValue());
    }

    public int m8338T() {
        return Math.max(0, ((Integer) av.f4702k.m8490b()).intValue());
    }

    public int m8339U() {
        return Math.max(1, ((Integer) av.f4703l.m8490b()).intValue());
    }

    public String m8340V() {
        return (String) av.f4708q.m8490b();
    }

    public long m8341W() {
        return ((Long) av.f4697f.m8490b()).longValue();
    }

    public long m8342X() {
        return Math.max(0, ((Long) av.f4709r.m8490b()).longValue());
    }

    public long m8343Y() {
        return Math.max(0, ((Long) av.f4711t.m8490b()).longValue());
    }

    public long m8344Z() {
        return ((Long) av.f4710s.m8490b()).longValue();
    }

    long m8345a(String str) {
        return m8346a(str, av.f4695d);
    }

    public long m8346a(String str, aw awVar) {
        if (str == null) {
            return ((Long) awVar.m8490b()).longValue();
        }
        Object a = m8368p().m8676a(str, awVar.m8489a());
        if (TextUtils.isEmpty(a)) {
            return ((Long) awVar.m8490b()).longValue();
        }
        try {
            return ((Long) awVar.m8488a(Long.valueOf(Long.valueOf(a).longValue()))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) awVar.m8490b()).longValue();
        }
    }

    String m8347a() {
        return (String) av.f4694c.m8490b();
    }

    public String m8348a(String str, String str2) {
        Builder builder = new Builder();
        builder.scheme((String) av.f4698g.m8490b()).authority((String) av.f4699h.m8490b()).path("config/app/" + str).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(m8331M()));
        return builder.build().toString();
    }

    public long aa() {
        return Math.max(0, ((Long) av.f4713v.m8490b()).longValue());
    }

    public long ab() {
        return Math.max(0, ((Long) av.f4714w.m8490b()).longValue());
    }

    public int ac() {
        return Math.min(20, Math.max(0, ((Integer) av.f4715x.m8490b()).intValue()));
    }

    public int m8349b() {
        return 25;
    }

    int m8350b(String str) {
        return m8351b(str, av.f4717z);
    }

    public int m8351b(String str, aw awVar) {
        if (str == null) {
            return ((Integer) awVar.m8490b()).intValue();
        }
        Object a = m8368p().m8676a(str, awVar.m8489a());
        if (TextUtils.isEmpty(a)) {
            return ((Integer) awVar.m8490b()).intValue();
        }
        try {
            return ((Integer) awVar.m8488a(Integer.valueOf(Integer.valueOf(a).intValue()))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) awVar.m8490b()).intValue();
        }
    }

    int m8352c() {
        return 32;
    }

    public int m8353c(String str) {
        return m8351b(str, av.f4700i);
    }

    public int m8354d(String str) {
        return Math.max(0, m8351b(str, av.f4701j));
    }

    public /* bridge */ /* synthetic */ void m8355d() {
        super.m8205d();
    }

    public int m8356e(String str) {
        return Math.max(0, Math.min(1000000, m8351b(str, av.f4707p)));
    }

    public /* bridge */ /* synthetic */ void m8357e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8358f() {
        super.m8207f();
    }

    public /* bridge */ /* synthetic */ ai m8359g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8360h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8361i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8362j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8363k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8364l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8365m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8366n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8367o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8368p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8369q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8370r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8371s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8372t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8373u() {
        return super.m8222u();
    }

    public int m8374v() {
        return 24;
    }

    int m8375w() {
        return 36;
    }

    int m8376x() {
        return 256;
    }

    public int m8377y() {
        return 36;
    }

    public int m8378z() {
        return 2048;
    }
}
