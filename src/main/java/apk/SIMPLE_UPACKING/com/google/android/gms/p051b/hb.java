package com.google.android.gms.p051b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.C0025b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.C0060c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.hb */
public interface hb extends cx {
    WebView m6631a();

    void m6632a(int i);

    void m6633a(Context context);

    void m6634a(AdSizeParcel adSizeParcel);

    void m6635a(C0060c c0060c);

    void m6636a(String str);

    void m6637a(String str, Map map);

    void m6638a(boolean z);

    View m6639b();

    void m6640b(int i);

    void m6641b(C0060c c0060c);

    void m6642b(boolean z);

    void m6643c();

    void m6644c(boolean z);

    void m6645d();

    Activity m6646e();

    Context m6647f();

    C0025b m6648g();

    Context getContext();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    C0060c m6649h();

    C0060c m6650i();

    AdSizeParcel m6651j();

    hc m6652k();

    boolean m6653l();

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    C0202f m6654m();

    void measure(int i, int i2);

    VersionInfoParcel m6655n();

    boolean m6656o();

    void onPause();

    void onResume();

    boolean m6657p();

    void m6658q();

    boolean m6659r();

    ha m6660s();

    void setBackgroundColor(int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    av m6661t();

    ay m6662u();

    void m6663v();

    void m6664w();
}
