package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.stats.C0316b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.p051b.kf;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.i */
public class C0367i extends cl {
    private final C0374p f4920a;
    private ax f4921b;
    private Boolean f4922c;
    private final ao f4923d;
    private final ac f4924e;
    private final List f4925f;
    private final ao f4926g;

    protected C0367i(bx bxVar) {
        super(bxVar);
        this.f4925f = new ArrayList();
        this.f4924e = new ac(bxVar.m8779r());
        this.f4920a = new C0374p(this);
        this.f4923d = new C0368j(this, bxVar);
        this.f4926g = new C0369k(this, bxVar);
    }

    private boolean m8861A() {
        m8884f();
        m8225G();
        if (m8899u().m8332N()) {
            return true;
        }
        m8897s().m8606z().m8607a("Checking service availability");
        switch (C0268j.m7636b().m7638a(m8891m())) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                m8897s().m8606z().m8607a("Service available");
                return true;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                m8897s().m8606z().m8607a("Service missing");
                return false;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                m8897s().m8606z().m8607a("Service version update required");
                return false;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                m8897s().m8606z().m8607a("Service disabled");
                return false;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                m8897s().m8606z().m8607a("Service invalid");
                return false;
            case R.Toolbar_collapseIcon /*18*/:
                m8897s().m8606z().m8607a("Service updating");
                return true;
            default:
                return false;
        }
    }

    private void m8862B() {
        m8884f();
        if (m8880b()) {
            m8897s().m8606z().m8607a("Inactivity, disconnecting from AppMeasurementService");
            m8901w();
        }
    }

    private void m8863C() {
        m8884f();
        m8875y();
    }

    private void m8864D() {
        m8884f();
        m8897s().m8606z().m8608a("Processing queued up service tasks", Integer.valueOf(this.f4925f.size()));
        for (Runnable a : this.f4925f) {
            m8896r().m8709a(a);
        }
        this.f4925f.clear();
        this.f4926g.m8446c();
    }

    private void m8866a(ComponentName componentName) {
        m8884f();
        if (this.f4921b != null) {
            this.f4921b = null;
            m8897s().m8606z().m8608a("Disconnected from device MeasurementService", componentName);
            m8863C();
        }
    }

    private void m8867a(ax axVar) {
        m8884f();
        bf.m7873a((Object) axVar);
        this.f4921b = axVar;
        m8874x();
        m8864D();
    }

    private void m8870a(Runnable runnable) {
        m8884f();
        if (m8880b()) {
            runnable.run();
        } else if (((long) this.f4925f.size()) >= m8899u().m8336R()) {
            m8897s().m8582b().m8607a("Discarding data. Max runnable queue size reached");
        } else {
            this.f4925f.add(runnable);
            if (!this.n.m8787z()) {
                this.f4926g.m8444a(60000);
            }
            m8875y();
        }
    }

    private void m8874x() {
        m8884f();
        this.f4924e.m8202a();
        if (!this.n.m8787z()) {
            this.f4923d.m8444a(m8899u().m8328J());
        }
    }

    private void m8875y() {
        m8884f();
        m8225G();
        if (!m8880b()) {
            if (this.f4922c == null) {
                this.f4922c = m8898t().m8656v();
                if (this.f4922c == null) {
                    m8897s().m8606z().m8607a("State of service unknown");
                    this.f4922c = Boolean.valueOf(m8861A());
                    m8898t().m8651a(this.f4922c.booleanValue());
                }
            }
            if (this.f4922c.booleanValue()) {
                m8897s().m8606z().m8607a("Using measurement service");
                this.f4920a.m8905a();
            } else if (m8876z() && !this.n.m8787z()) {
                m8897s().m8606z().m8607a("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(m8891m(), AppMeasurementService.class));
                this.f4920a.m8907a(intent);
            } else if (m8899u().m8333O()) {
                m8897s().m8606z().m8607a("Using direct local measurement implementation");
                m8867a(new cc(this.n, true));
            } else {
                m8897s().m8582b().m8607a("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    private boolean m8876z() {
        List queryIntentServices = m8891m().getPackageManager().queryIntentServices(new Intent(m8891m(), AppMeasurementService.class), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    protected void m8877a() {
    }

    protected void m8878a(EventParcel eventParcel, String str) {
        bf.m7873a((Object) eventParcel);
        m8884f();
        m8225G();
        m8870a(new C0371m(this, str, eventParcel));
    }

    protected void m8879a(UserAttributeParcel userAttributeParcel) {
        m8884f();
        m8225G();
        m8870a(new C0372n(this, userAttributeParcel));
    }

    public boolean m8880b() {
        m8884f();
        m8225G();
        return this.f4921b != null;
    }

    protected void m8881c() {
        m8884f();
        m8225G();
        m8870a(new C0370l(this));
    }

    public /* bridge */ /* synthetic */ void m8882d() {
        super.m8205d();
    }

    public /* bridge */ /* synthetic */ void m8883e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8884f() {
        super.m8207f();
    }

    public /* bridge */ /* synthetic */ ai m8885g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8886h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8887i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8888j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8889k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8890l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8891m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8892n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8893o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8894p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8895q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8896r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8897s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8898t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8899u() {
        return super.m8222u();
    }

    protected void m8900v() {
        m8884f();
        m8225G();
        m8870a(new C0373o(this));
    }

    public void m8901w() {
        m8884f();
        m8225G();
        try {
            C0316b.m8032a().m8041a(m8891m(), this.f4920a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.f4921b = null;
    }
}
