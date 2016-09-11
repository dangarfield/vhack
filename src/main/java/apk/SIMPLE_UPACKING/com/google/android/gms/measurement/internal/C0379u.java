package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.p051b.kf;

/* renamed from: com.google.android.gms.measurement.internal.u */
public class C0379u extends cl {
    private Handler f4946a;
    private long f4947b;
    private final Runnable f4948c;
    private final ao f4949d;
    private final ao f4950e;

    C0379u(bx bxVar) {
        super(bxVar);
        this.f4948c = new C0380v(this);
        this.f4949d = new C0382x(this, this.n);
        this.f4950e = new C0383y(this, this.n);
    }

    private void m8910a(long j) {
        m8924f();
        m8916w();
        this.f4949d.m8446c();
        this.f4950e.m8446c();
        m8937s().m8606z().m8608a("Activity resumed, time", Long.valueOf(j));
        this.f4947b = j;
        if (m8930l().m6913a() - m8938t().f4802i.m8663a() > m8938t().f4804k.m8663a()) {
            m8938t().f4803j.m8660a(true);
            m8938t().f4805l.m8664a(0);
        }
        if (m8938t().f4803j.m8661a()) {
            this.f4949d.m8444a(Math.max(0, m8938t().f4801h.m8663a() - m8938t().f4805l.m8663a()));
        } else {
            this.f4950e.m8444a(Math.max(0, 3600000 - m8938t().f4805l.m8663a()));
        }
    }

    private void m8913b(long j) {
        m8924f();
        m8916w();
        this.f4949d.m8446c();
        this.f4950e.m8446c();
        m8937s().m8606z().m8608a("Activity paused, time", Long.valueOf(j));
        if (this.f4947b != 0) {
            m8938t().f4805l.m8664a(m8938t().f4805l.m8663a() + (j - this.f4947b));
        }
        m8938t().f4804k.m8664a(m8930l().m6913a());
        synchronized (this) {
            if (!m8938t().f4803j.m8661a()) {
                this.f4946a.postDelayed(this.f4948c, 1000);
            }
        }
    }

    private void m8916w() {
        synchronized (this) {
            if (this.f4946a == null) {
                this.f4946a = new Handler(Looper.getMainLooper());
            }
        }
    }

    private void m8917x() {
        m8924f();
        m8937s().m8606z().m8608a("Session started, time", Long.valueOf(m8930l().m6914b()));
        m8938t().f4803j.m8660a(false);
        m8926h().m8838a("auto", "_s", new Bundle());
    }

    private void m8918y() {
        m8924f();
        long b = m8930l().m6914b();
        if (this.f4947b == 0) {
            this.f4947b = b - 3600000;
        }
        long a = m8938t().f4805l.m8663a() + (b - this.f4947b);
        m8938t().f4805l.m8664a(a);
        m8937s().m8606z().m8608a("Recording user engagement, ms", Long.valueOf(a));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", a);
        m8926h().m8838a("auto", "_e", bundle);
        m8938t().f4805l.m8664a(0);
        this.f4947b = b;
        this.f4950e.m8444a(Math.max(0, 3600000 - m8938t().f4805l.m8663a()));
    }

    protected void m8919a() {
    }

    protected void m8920b() {
        synchronized (this) {
            m8916w();
            this.f4946a.removeCallbacks(this.f4948c);
        }
        m8936r().m8709a(new C0384z(this, m8930l().m6914b()));
    }

    protected void m8921c() {
        m8936r().m8709a(new aa(this, m8930l().m6914b()));
    }

    public /* bridge */ /* synthetic */ void m8922d() {
        super.m8205d();
    }

    public /* bridge */ /* synthetic */ void m8923e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8924f() {
        super.m8207f();
    }

    public /* bridge */ /* synthetic */ ai m8925g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8926h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8927i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8928j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8929k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8930l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8931m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8932n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8933o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8934p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8935q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8936r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8937s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8938t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8939u() {
        return super.m8222u();
    }

    public void m8940v() {
        m8924f();
        m8937s().m8605y().m8607a("Application backgrounded. Logging engagement");
        long a = m8938t().f4805l.m8663a();
        if (a > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", a);
            m8926h().m8838a("auto", "_e", bundle);
            m8938t().f4805l.m8664a(0);
            return;
        }
        m8937s().m8583c().m8608a("Not logging non-positive engagement time", Long.valueOf(a));
    }
}
