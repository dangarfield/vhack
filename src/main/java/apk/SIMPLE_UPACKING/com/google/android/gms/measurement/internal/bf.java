package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.p051b.kf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class bf extends cl {
    public bf(bx bxVar) {
        super(bxVar);
    }

    private byte[] m8612a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected HttpURLConnection m8613a(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout((int) m8635u().m8326H());
            httpURLConnection.setReadTimeout((int) m8635u().m8327I());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    protected void m8614a() {
    }

    public void m8615a(String str, URL url, Map map, bh bhVar) {
        m8620f();
        m8225G();
        com.google.android.gms.common.internal.bf.m7873a((Object) url);
        com.google.android.gms.common.internal.bf.m7873a((Object) bhVar);
        m8632r().m8710b(new bj(this, str, url, null, map, bhVar));
    }

    public void m8616a(String str, URL url, byte[] bArr, Map map, bh bhVar) {
        m8620f();
        m8225G();
        com.google.android.gms.common.internal.bf.m7873a((Object) url);
        com.google.android.gms.common.internal.bf.m7873a((Object) bArr);
        com.google.android.gms.common.internal.bf.m7873a((Object) bhVar);
        m8632r().m8710b(new bj(this, str, url, bArr, map, bhVar));
    }

    public boolean m8617b() {
        NetworkInfo activeNetworkInfo;
        m8225G();
        try {
            activeNetworkInfo = ((ConnectivityManager) m8627m().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public /* bridge */ /* synthetic */ void m8618d() {
        super.m8205d();
    }

    public /* bridge */ /* synthetic */ void m8619e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8620f() {
        super.m8207f();
    }

    public /* bridge */ /* synthetic */ ai m8621g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8622h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8623i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8624j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8625k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8626l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8627m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8628n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8629o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8630p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8631q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8632r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8633s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8634t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8635u() {
        return super.m8222u();
    }
}
