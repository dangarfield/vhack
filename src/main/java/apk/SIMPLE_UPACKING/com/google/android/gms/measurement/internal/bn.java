package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.measurement.C0358e;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;

class bn extends cl {
    static final Pair f4794a;
    public final br f4795b;
    public final bq f4796c;
    public final bq f4797d;
    public final bq f4798e;
    public final bq f4799f;
    public final bq f4800g;
    public final bq f4801h;
    public final bq f4802i;
    public final bp f4803j;
    public final bq f4804k;
    public final bq f4805l;
    public boolean f4806m;
    private SharedPreferences f4807o;
    private String f4808p;
    private boolean f4809q;
    private long f4810r;
    private final SecureRandom f4811s;

    static {
        f4794a = new Pair("", Long.valueOf(0));
    }

    bn(bx bxVar) {
        super(bxVar);
        this.f4795b = new br("health_monitor", m8222u().m8337S(), null);
        this.f4796c = new bq(this, "last_upload", 0);
        this.f4797d = new bq(this, "last_upload_attempt", 0);
        this.f4798e = new bq(this, "backoff", 0);
        this.f4799f = new bq(this, "last_delete_stale", 0);
        this.f4801h = new bq(this, "time_before_start", 10000);
        this.f4802i = new bq(this, "session_timeout", 1800000);
        this.f4803j = new bp(this, "start_new_session", true);
        this.f4804k = new bq(this, "last_pause_time", 0);
        this.f4805l = new bq(this, "time_active", 0);
        this.f4811s = new SecureRandom();
        this.f4800g = new bq(this, "midnight_offset", 0);
    }

    private SharedPreferences m8648y() {
        m8207f();
        m8225G();
        return this.f4807o;
    }

    Pair m8649a(String str) {
        m8207f();
        long b = m8213l().m6914b();
        if (this.f4808p != null && b < this.f4810r) {
            return new Pair(this.f4808p, Boolean.valueOf(this.f4809q));
        }
        this.f4810r = b + m8222u().m8345a(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(m8214m());
            this.f4808p = advertisingIdInfo.getId();
            this.f4809q = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            m8220s().m8605y().m8608a("Unable to get advertising id", th);
            this.f4808p = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f4808p, Boolean.valueOf(this.f4809q));
    }

    protected void m8650a() {
        this.f4807o = m8214m().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f4806m = this.f4807o.getBoolean("has_been_opened", false);
        if (!this.f4806m) {
            Editor edit = this.f4807o.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    void m8651a(boolean z) {
        m8207f();
        m8220s().m8606z().m8608a("Setting useService", Boolean.valueOf(z));
        Editor edit = m8648y().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    String m8652b() {
        this.f4811s.nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    String m8653b(String str) {
        String str2 = (String) m8649a(str).first;
        if (ag.m8272e("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, ag.m8272e("MD5").digest(str2.getBytes()))});
    }

    void m8654b(boolean z) {
        m8207f();
        m8220s().m8606z().m8608a("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = m8648y().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    long m8655c() {
        m8225G();
        m8207f();
        long a = this.f4800g.m8663a();
        if (a != 0) {
            return a;
        }
        a = (long) (this.f4811s.nextInt(86400000) + 1);
        this.f4800g.m8664a(a);
        return a;
    }

    Boolean m8656v() {
        m8207f();
        return !m8648y().contains("use_service") ? null : Boolean.valueOf(m8648y().getBoolean("use_service", false));
    }

    boolean m8657w() {
        m8207f();
        return m8648y().getBoolean("measurement_enabled", !C0358e.m8190d());
    }

    protected String m8658x() {
        m8207f();
        String string = m8648y().getString("previous_os_version", null);
        String c = m8211j().m8449c();
        if (!(TextUtils.isEmpty(c) || c.equals(string))) {
            Editor edit = m8648y().edit();
            edit.putString("previous_os_version", c);
            edit.apply();
        }
        return string;
    }
}
