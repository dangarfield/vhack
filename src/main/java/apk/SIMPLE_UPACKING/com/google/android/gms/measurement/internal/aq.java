package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.p051b.kf;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class aq extends cl {
    private long f4678a;
    private String f4679b;

    aq(bx bxVar) {
        super(bxVar);
    }

    protected void m8447a() {
        Calendar instance = Calendar.getInstance();
        this.f4678a = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        this.f4679b = locale.getLanguage().toLowerCase(Locale.ENGLISH) + "-" + locale.getCountry().toLowerCase(Locale.ENGLISH);
    }

    public String m8448b() {
        m8225G();
        return Build.MODEL;
    }

    public String m8449c() {
        m8225G();
        return VERSION.RELEASE;
    }

    public /* bridge */ /* synthetic */ void m8450d() {
        super.m8205d();
    }

    public /* bridge */ /* synthetic */ void m8451e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8452f() {
        super.m8207f();
    }

    public /* bridge */ /* synthetic */ ai m8453g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8454h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8455i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8456j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8457k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8458l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8459m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8460n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8461o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8462p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8463q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8464r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8465s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8466t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8467u() {
        return super.m8222u();
    }

    public long m8468v() {
        m8225G();
        return this.f4678a;
    }

    public String m8469w() {
        m8225G();
        return this.f4679b;
    }
}
