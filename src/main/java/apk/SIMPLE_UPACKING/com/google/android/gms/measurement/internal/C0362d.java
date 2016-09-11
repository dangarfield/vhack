package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.C0355b;
import com.google.android.gms.p051b.kf;

/* renamed from: com.google.android.gms.measurement.internal.d */
public class C0362d extends cl {
    private C0366h f4902a;
    private C0355b f4903b;
    private boolean f4904c;

    protected C0362d(bx bxVar) {
        super(bxVar);
    }

    private void m8827a(String str, String str2, Bundle bundle, boolean z, String str3) {
        m8828a(str, str2, bundle, z, str3, m8850l().m6913a());
    }

    private void m8828a(String str, String str2, Bundle bundle, boolean z, String str3, long j) {
        bf.m7875a(str);
        m8853o().m8283b(str2);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            int b = m8859u().m8349b();
            int i = 0;
            for (String str4 : bundle.keySet()) {
                m8853o().m8290d(str4);
                if (ag.m8266a(str4)) {
                    int i2 = i + 1;
                    bf.m7882b(i2 <= b, "Event can't contain more then " + b + " params");
                    i = i2;
                }
                Object a = m8853o().m8275a(str4, bundle.get(str4));
                if (a != null) {
                    m8853o().m8276a(bundle2, str4, a);
                }
            }
        }
        int w = m8859u().m8375w();
        bundle2.putString("_o", str.length() <= w ? str : str.substring(0, w));
        m8836a(str, str2, j, bundle2, z, str3);
    }

    private void m8829a(String str, String str2, Object obj, long j) {
        bf.m7875a(str);
        bf.m7875a(str2);
        m8844f();
        m8842d();
        m8225G();
        if (!m8858t().m8657w()) {
            m8857s().m8605y().m8607a("User property not set since app measurement is disabled");
        } else if (this.n.m8763b()) {
            m8857s().m8605y().m8609a("Setting user property (FE)", str2, obj);
            m8849k().m8879a(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    private void m8830a(boolean z) {
        m8844f();
        m8842d();
        m8225G();
        m8857s().m8605y().m8608a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        m8858t().m8654b(z);
        m8849k().m8881c();
    }

    private void m8831b(String str, String str2, long j, Bundle bundle, boolean z, String str3) {
        bf.m7875a(str);
        bf.m7875a(str2);
        bf.m7873a((Object) bundle);
        m8844f();
        m8225G();
        if (m8858t().m8657w()) {
            if (!this.f4904c) {
                this.f4904c = true;
                m8832v();
            }
            if (z && this.f4903b != null && !ag.m8273g(str2)) {
                m8857s().m8605y().m8609a("Passing event to registered event handler (FE)", str2, bundle);
                this.f4903b.m8185a(str, str2, bundle, j);
                return;
            } else if (this.n.m8763b()) {
                m8857s().m8605y().m8609a("Logging event (FE)", str2, bundle);
                m8849k().m8878a(new EventParcel(str2, new EventParams(bundle), str, j), str3);
                return;
            } else {
                return;
            }
        }
        m8857s().m8605y().m8607a("Event not sent since app measurement is disabled");
    }

    private void m8832v() {
        try {
            m8835a(Class.forName(m8833w()));
        } catch (ClassNotFoundException e) {
            m8857s().m8604x().m8607a("Tag Manager is not found and thus will not be used");
        }
    }

    private String m8833w() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    protected void m8834a() {
    }

    public void m8835a(Class cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{m8851m()});
        } catch (Exception e) {
            m8857s().m8583c().m8608a("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    protected void m8836a(String str, String str2, long j, Bundle bundle, boolean z, String str3) {
        bf.m7873a((Object) bundle);
        m8856r().m8709a(new C0364f(this, str, str2, j, bundle, z, str3));
    }

    void m8837a(String str, String str2, long j, Object obj) {
        m8856r().m8709a(new C0365g(this, str, str2, obj, j));
    }

    public void m8838a(String str, String str2, Bundle bundle) {
        m8842d();
        m8827a(str, str2, bundle, true, null);
    }

    public void m8839a(String str, String str2, Object obj) {
        bf.m7875a(str);
        long a = m8850l().m6913a();
        m8853o().m8287c(str2);
        if (obj != null) {
            m8853o().m8284b(str2, obj);
            Object c = m8853o().m8286c(str2, obj);
            if (c != null) {
                m8837a(str, str2, a, c);
                return;
            }
            return;
        }
        m8837a(str, str2, a, null);
    }

    @TargetApi(14)
    public void m8840b() {
        if (m8851m().getApplicationContext() instanceof Application) {
            Application application = (Application) m8851m().getApplicationContext();
            if (this.f4902a == null) {
                this.f4902a = new C0366h();
            }
            application.unregisterActivityLifecycleCallbacks(this.f4902a);
            application.registerActivityLifecycleCallbacks(this.f4902a);
            m8857s().m8606z().m8607a("Registered activity lifecycle callback");
        }
    }

    public void m8841c() {
        m8844f();
        m8842d();
        m8225G();
        if (this.n.m8763b()) {
            m8849k().m8900v();
            String x = m8858t().m8658x();
            if (!TextUtils.isEmpty(x) && !x.equals(m8848j().m8449c())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", x);
                m8838a("auto", "_ou", bundle);
            }
        }
    }

    public /* bridge */ /* synthetic */ void m8842d() {
        super.m8205d();
    }

    public /* bridge */ /* synthetic */ void m8843e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8844f() {
        super.m8207f();
    }

    public /* bridge */ /* synthetic */ ai m8845g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8846h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8847i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8848j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8849k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8850l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8851m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8852n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8853o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8854p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8855q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8856r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8857s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8858t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8859u() {
        return super.m8222u();
    }
}
