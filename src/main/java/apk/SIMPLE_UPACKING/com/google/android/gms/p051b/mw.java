package com.google.android.gms.p051b;

import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* renamed from: com.google.android.gms.b.mw */
public class mw implements mz {
    protected final HttpClient f4083a;

    public mw(HttpClient httpClient) {
        this.f4083a = httpClient;
    }

    private static void m7232a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, hy hyVar) {
        byte[] o = hyVar.m6208o();
        if (o != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(o));
        }
    }

    private static void m7233a(HttpUriRequest httpUriRequest, Map map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    static HttpUriRequest m7234b(hy hyVar, Map map) {
        HttpEntityEnclosingRequestBase httpPost;
        switch (hyVar.m6192b()) {
            case -1:
                byte[] k = hyVar.m6204k();
                if (k == null) {
                    return new HttpGet(hyVar.m6197d());
                }
                HttpUriRequest httpPost2 = new HttpPost(hyVar.m6197d());
                httpPost2.addHeader("Content-Type", hyVar.m6203j());
                httpPost2.setEntity(new ByteArrayEntity(k));
                return httpPost2;
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return new HttpGet(hyVar.m6197d());
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                httpPost = new HttpPost(hyVar.m6197d());
                httpPost.addHeader("Content-Type", hyVar.m6207n());
                mw.m7232a(httpPost, hyVar);
                return httpPost;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                httpPost = new HttpPut(hyVar.m6197d());
                httpPost.addHeader("Content-Type", hyVar.m6207n());
                mw.m7232a(httpPost, hyVar);
                return httpPost;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return new HttpDelete(hyVar.m6197d());
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                return new HttpHead(hyVar.m6197d());
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return new HttpOptions(hyVar.m6197d());
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return new HttpTrace(hyVar.m6197d());
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                httpPost = new mx(hyVar.m6197d());
                httpPost.addHeader("Content-Type", hyVar.m6207n());
                mw.m7232a(httpPost, hyVar);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    public HttpResponse m7235a(hy hyVar, Map map) {
        HttpUriRequest b = mw.m7234b(hyVar, map);
        mw.m7233a(b, map);
        mw.m7233a(b, hyVar.m6190a());
        m7236a(b);
        HttpParams params = b.getParams();
        int r = hyVar.m6211r();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, r);
        return this.f4083a.execute(b);
    }

    protected void m7236a(HttpUriRequest httpUriRequest) {
    }
}
