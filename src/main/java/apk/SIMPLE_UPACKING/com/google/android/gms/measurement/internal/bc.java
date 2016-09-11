package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.C0354a;
import com.google.android.gms.p051b.kf;

public class bc extends cl {
    private final String f4750a;
    private final char f4751b;
    private final long f4752c;
    private final be f4753d;
    private final be f4754e;
    private final be f4755f;
    private final be f4756g;
    private final be f4757h;
    private final be f4758i;
    private final be f4759j;
    private final be f4760k;
    private final be f4761l;

    bc(bx bxVar) {
        super(bxVar);
        this.f4750a = m8601u().m8347a();
        this.f4752c = m8601u().m8331M();
        if (m8601u().m8333O()) {
            this.f4751b = m8601u().m8332N() ? 'P' : 'C';
        } else {
            this.f4751b = m8601u().m8332N() ? 'p' : 'c';
        }
        this.f4753d = new be(this, 6, false, false);
        this.f4754e = new be(this, 6, true, false);
        this.f4755f = new be(this, 6, false, true);
        this.f4756g = new be(this, 5, false, false);
        this.f4757h = new be(this, 5, true, false);
        this.f4758i = new be(this, 5, false, true);
        this.f4759j = new be(this, 4, false, false);
        this.f4760k = new be(this, 3, false, false);
        this.f4761l = new be(this, 2, false, false);
    }

    private static String m8573a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    static String m8574a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return str + Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d);
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(th.toString());
                String a = m8573a(C0354a.class.getCanonicalName());
                String a2 = m8573a(bx.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = m8573a(className);
                            if (className.equals(a) || className.equals(a2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    static String m8575a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object a = m8574a(z, obj);
        Object a2 = m8574a(z, obj2);
        Object a3 = m8574a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    public String m8576A() {
        Pair a = m8600t().f4795b.m8668a();
        return a == null ? null : String.valueOf(a.second) + ":" + ((String) a.first);
    }

    protected void m8577a() {
    }

    protected void m8578a(int i, String str) {
        Log.println(i, this.f4750a, str);
    }

    public void m8579a(int i, String str, Object obj, Object obj2, Object obj3) {
        bf.m7873a((Object) str);
        bt k = this.n.m8772k();
        if (k == null) {
            m8578a(6, "Scheduler not set. Not logging error/warn.");
        } else if (!k.m8223E()) {
            m8578a(6, "Scheduler not initialized. Not logging error/warn.");
        } else if (k.m8224F()) {
            m8578a(6, "Scheduler shutdown. Not logging error/warn.");
        } else {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String str2 = "1" + "01VDIWEA?".charAt(i) + this.f4751b + this.f4752c + ":" + m8575a(true, str, obj, obj2, obj3);
            k.m8709a(new bd(this, str2.length() > 1024 ? str.substring(0, 1024) : str2));
        }
    }

    protected void m8580a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && m8581a(i)) {
            m8578a(i, m8575a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            m8579a(i, str, obj, obj2, obj3);
        }
    }

    protected boolean m8581a(int i) {
        return Log.isLoggable(this.f4750a, i);
    }

    public be m8582b() {
        return this.f4753d;
    }

    public be m8583c() {
        return this.f4756g;
    }

    public /* bridge */ /* synthetic */ void m8584d() {
        super.m8205d();
    }

    public /* bridge */ /* synthetic */ void m8585e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8586f() {
        super.m8207f();
    }

    public /* bridge */ /* synthetic */ ai m8587g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8588h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8589i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8590j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8591k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8592l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8593m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8594n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8595o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8596p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8597q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8598r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8599s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8600t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8601u() {
        return super.m8222u();
    }

    public be m8602v() {
        return this.f4757h;
    }

    public be m8603w() {
        return this.f4758i;
    }

    public be m8604x() {
        return this.f4759j;
    }

    public be m8605y() {
        return this.f4760k;
    }

    public be m8606z() {
        return this.f4761l;
    }
}
