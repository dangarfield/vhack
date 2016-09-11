package com.google.android.gms.p051b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.C0025b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.C0060c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@fi
/* renamed from: com.google.android.gms.b.hj */
class hj extends FrameLayout implements hb {
    private final hb f3762a;
    private final ha f3763b;

    public hj(hb hbVar) {
        super(hbVar.getContext());
        this.f3762a = hbVar;
        this.f3763b = new ha(hbVar.m6647f(), this, this);
        hc k = this.f3762a.m6652k();
        if (k != null) {
            k.m6682a((hb) this);
        }
        addView(this.f3762a.m6639b());
    }

    public WebView m6701a() {
        return this.f3762a.m6631a();
    }

    public void m6702a(int i) {
        this.f3762a.m6632a(i);
    }

    public void m6703a(Context context) {
        this.f3762a.m6633a(context);
    }

    public void m6704a(AdSizeParcel adSizeParcel) {
        this.f3762a.m6634a(adSizeParcel);
    }

    public void m6705a(C0060c c0060c) {
        this.f3762a.m6635a(c0060c);
    }

    public void m6706a(String str) {
        this.f3762a.m6636a(str);
    }

    public void m6707a(String str, Map map) {
        this.f3762a.m6637a(str, map);
    }

    public void m6708a(String str, JSONObject jSONObject) {
        this.f3762a.m6261a(str, jSONObject);
    }

    public void m6709a(boolean z) {
        this.f3762a.m6638a(z);
    }

    public View m6710b() {
        return this;
    }

    public void m6711b(int i) {
        this.f3762a.m6640b(i);
    }

    public void m6712b(C0060c c0060c) {
        this.f3762a.m6641b(c0060c);
    }

    public void m6713b(boolean z) {
        this.f3762a.m6642b(z);
    }

    public void m6714c() {
        this.f3762a.m6643c();
    }

    public void m6715c(boolean z) {
        this.f3762a.m6644c(z);
    }

    public void m6716d() {
        this.f3762a.m6645d();
    }

    public Activity m6717e() {
        return this.f3762a.m6646e();
    }

    public Context m6718f() {
        return this.f3762a.m6647f();
    }

    public C0025b m6719g() {
        return this.f3762a.m6648g();
    }

    public C0060c m6720h() {
        return this.f3762a.m6649h();
    }

    public C0060c m6721i() {
        return this.f3762a.m6650i();
    }

    public AdSizeParcel m6722j() {
        return this.f3762a.m6651j();
    }

    public hc m6723k() {
        return this.f3762a.m6652k();
    }

    public boolean m6724l() {
        return this.f3762a.m6653l();
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f3762a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        this.f3762a.loadUrl(str);
    }

    public C0202f m6725m() {
        return this.f3762a.m6654m();
    }

    public VersionInfoParcel m6726n() {
        return this.f3762a.m6655n();
    }

    public boolean m6727o() {
        return this.f3762a.m6656o();
    }

    public void onPause() {
        this.f3763b.m6629b();
        this.f3762a.onPause();
    }

    public void onResume() {
        this.f3762a.onResume();
    }

    public boolean m6728p() {
        return this.f3762a.m6657p();
    }

    public void m6729q() {
        this.f3763b.m6630c();
        this.f3762a.m6658q();
    }

    public boolean m6730r() {
        return this.f3762a.m6659r();
    }

    public ha m6731s() {
        return this.f3763b;
    }

    public void setBackgroundColor(int i) {
        this.f3762a.setBackgroundColor(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f3762a.setOnClickListener(onClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f3762a.setOnTouchListener(onTouchListener);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f3762a.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f3762a.setWebViewClient(webViewClient);
    }

    public av m6732t() {
        return this.f3762a.m6661t();
    }

    public ay m6733u() {
        return this.f3762a.m6662u();
    }

    public void m6734v() {
        this.f3762a.m6663v();
    }

    public void m6735w() {
        this.f3762a.m6664w();
    }
}
