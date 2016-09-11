package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.p051b.kf;

public class ad extends cl {
    private boolean f4657a;
    private final AlarmManager f4658b;

    protected ad(bx bxVar) {
        super(bxVar);
        this.f4658b = (AlarmManager) m8241m().getSystemService("alarm");
    }

    private PendingIntent m8228c() {
        Intent intent = new Intent(m8241m(), AppMeasurementReceiver.class);
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(m8241m(), 0, intent, 0);
    }

    protected void m8229a() {
        this.f4658b.cancel(m8228c());
    }

    public void m8230a(long j) {
        m8225G();
        bf.m7881b(j > 0);
        bf.m7878a(AppMeasurementReceiver.m8178a(m8241m()), (Object) "Receiver not registered/enabled");
        bf.m7878a(AppMeasurementService.m8181a(m8241m()), (Object) "Service not registered/enabled");
        m8231b();
        long b = m8240l().m6914b() + j;
        this.f4657a = true;
        this.f4658b.setInexactRepeating(2, b, Math.max(m8249u().m8344Z(), j), m8228c());
    }

    public void m8231b() {
        m8225G();
        this.f4657a = false;
        this.f4658b.cancel(m8228c());
    }

    public /* bridge */ /* synthetic */ void m8232d() {
        super.m8205d();
    }

    public /* bridge */ /* synthetic */ void m8233e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8234f() {
        super.m8207f();
    }

    public /* bridge */ /* synthetic */ ai m8235g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8236h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8237i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8238j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8239k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8240l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8241m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8242n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8243o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8244p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8245q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8246r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8247s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8248t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8249u() {
        return super.m8222u();
    }
}
