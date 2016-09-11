package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.measurement.C0358e;
import com.google.android.gms.p051b.kf;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class ba extends cl {
    private static final X500Principal f4743a;
    private String f4744b;
    private String f4745c;
    private String f4746d;
    private String f4747e;
    private long f4748f;
    private String f4749g;

    static {
        f4743a = new X500Principal("CN=Android Debug,O=Android,C=US");
    }

    ba(bx bxVar) {
        super(bxVar);
    }

    AppMetadata m8541a(String str) {
        return new AppMetadata(m8544b(), m8545c(), m8564v(), m8565w(), m8566x(), m8567y(), str, m8562t().m8657w(), !m8562t().f4806m);
    }

    protected void m8542a() {
        String str = "Unknown";
        String str2 = "Unknown";
        PackageManager packageManager = m8555m().getPackageManager();
        String packageName = m8555m().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(m8555m().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            m8561s().m8582b().m8608a("Error retrieving package info: appName", str2);
        }
        this.f4744b = packageName;
        this.f4746d = installerPackageName;
        this.f4745c = str;
        this.f4747e = str2;
        MessageDigest e2 = ag.m8272e("MD5");
        if (e2 == null) {
            m8561s().m8582b().m8607a("Could not get MD5 instance");
            this.f4748f = -1;
        } else {
            this.f4748f = 0;
            try {
                if (!m8568z()) {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(m8555m().getPackageName(), 64);
                    if (packageInfo2.signatures != null && packageInfo2.signatures.length > 0) {
                        this.f4748f = ag.m8271c(e2.digest(packageInfo2.signatures[0].toByteArray()));
                    }
                }
            } catch (NameNotFoundException e3) {
                m8561s().m8582b().m8608a("Package name not found", e3);
            }
        }
        Status a = m8563u().m8332N() ? C0358e.m8187a(m8555m(), "-", true) : C0358e.m8186a(m8555m());
        boolean z = a != null && a.m7292e();
        if (!z) {
            m8543a(a);
        }
        if (z) {
            z = C0358e.m8189c();
            if (z) {
                m8561s().m8606z().m8607a("AppMeasurement enabled");
            } else {
                m8561s().m8604x().m8607a("AppMeasurement disabled with google_app_measurement_enable=0");
            }
        } else {
            z = false;
        }
        this.f4749g = "";
        if (!m8563u().m8332N()) {
            try {
                str = C0358e.m8188a();
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                this.f4749g = str;
                if (z) {
                    m8561s().m8606z().m8609a("App package, google app id", this.f4744b, this.f4749g);
                }
            } catch (IllegalStateException e4) {
                m8561s().m8582b().m8608a("getGoogleAppId or isMeasurementEnabled failed with exception", e4);
            }
        }
    }

    protected void m8543a(Status status) {
        if (status == null) {
            m8561s().m8582b().m8607a("GoogleService failed to initialize (no status)");
        } else {
            m8561s().m8582b().m8609a("GoogleService failed to initialize, status", Integer.valueOf(status.m7293f()), status.m7290c());
        }
    }

    String m8544b() {
        m8225G();
        return this.f4744b;
    }

    String m8545c() {
        m8225G();
        return this.f4749g;
    }

    public /* bridge */ /* synthetic */ void m8546d() {
        super.m8205d();
    }

    public /* bridge */ /* synthetic */ void m8547e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8548f() {
        super.m8207f();
    }

    public /* bridge */ /* synthetic */ ai m8549g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8550h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8551i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8552j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8553k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8554l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8555m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8556n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8557o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8558p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8559q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8560r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8561s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8562t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8563u() {
        return super.m8222u();
    }

    String m8564v() {
        m8225G();
        return this.f4745c;
    }

    String m8565w() {
        m8225G();
        return this.f4746d;
    }

    long m8566x() {
        return m8563u().m8331M();
    }

    long m8567y() {
        m8225G();
        return this.f4748f;
    }

    boolean m8568z() {
        try {
            PackageInfo packageInfo = m8555m().getPackageManager().getPackageInfo(m8555m().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(f4743a);
            }
        } catch (CertificateException e) {
            m8561s().m8582b().m8608a("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            m8561s().m8582b().m8608a("Package name not found", e2);
        }
        return true;
    }
}
