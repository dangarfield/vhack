package com.google.android.gms.p051b;

import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* renamed from: com.google.android.gms.b.na */
public class na implements mz {
    private final nb f4087a;
    private final SSLSocketFactory f4088b;

    public na() {
        this(null);
    }

    public na(nb nbVar) {
        this(nbVar, null);
    }

    public na(nb nbVar, SSLSocketFactory sSLSocketFactory) {
        this.f4087a = nbVar;
        this.f4088b = sSLSocketFactory;
    }

    private HttpURLConnection m7244a(URL url, hy hyVar) {
        HttpURLConnection a = m7248a(url);
        int r = hyVar.m6211r();
        a.setConnectTimeout(r);
        a.setReadTimeout(r);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f4088b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f4088b);
        }
        return a;
    }

    private static HttpEntity m7245a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void m7246a(HttpURLConnection httpURLConnection, hy hyVar) {
        switch (hyVar.m6192b()) {
            case -1:
                byte[] k = hyVar.m6204k();
                if (k != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", hyVar.m6203j());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(k);
                    dataOutputStream.close();
                }
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                httpURLConnection.setRequestMethod("GET");
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                httpURLConnection.setRequestMethod("POST");
                na.m7247b(httpURLConnection, hyVar);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                httpURLConnection.setRequestMethod("PUT");
                na.m7247b(httpURLConnection, hyVar);
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                httpURLConnection.setRequestMethod("DELETE");
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                httpURLConnection.setRequestMethod("HEAD");
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                httpURLConnection.setRequestMethod("OPTIONS");
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                httpURLConnection.setRequestMethod("TRACE");
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                httpURLConnection.setRequestMethod("PATCH");
                na.m7247b(httpURLConnection, hyVar);
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void m7247b(HttpURLConnection httpURLConnection, hy hyVar) {
        byte[] o = hyVar.m6208o();
        if (o != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", hyVar.m6207n());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(o);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection m7248a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse m7249a(hy hyVar, Map map) {
        String a;
        String d = hyVar.m6197d();
        HashMap hashMap = new HashMap();
        hashMap.putAll(hyVar.m6190a());
        hashMap.putAll(map);
        if (this.f4087a != null) {
            a = this.f4087a.m7250a(d);
            if (a == null) {
                throw new IOException("URL blocked by rewriter: " + d);
            }
        }
        a = d;
        HttpURLConnection a2 = m7244a(new URL(a), hyVar);
        for (String a3 : hashMap.keySet()) {
            a2.addRequestProperty(a3, (String) hashMap.get(a3));
        }
        na.m7246a(a2, hyVar);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(na.m7245a(a2));
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
