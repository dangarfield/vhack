package com.fyber.ads.interstitials.p029a;

import android.app.Activity;
import android.net.Uri;
import android.webkit.WebView;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.ah;
import java.util.Locale;

/* renamed from: com.fyber.ads.interstitials.a.c */
final class ExchangeInterstitial extends ah {
    final /* synthetic */ ExchangeInterstitial f2444a;

    ExchangeInterstitial(ExchangeInterstitial exchangeInterstitial) {
        this.f2444a = exchangeInterstitial;
        super(null);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!super.shouldOverrideUrlLoading(webView, str)) {
            m4904c(str);
        }
        return true;
    }

    protected final void m4906a(int i, String str) {
        m4904c(str);
    }

    protected final Activity m4905a() {
        return this.f2444a.f2437g;
    }

    protected final void m4907a(String str, Uri uri) {
        if (str.contains("offerwall") && uri != null) {
            ExchangeInterstitial.m4882a(this.f2444a, uri);
        }
    }

    protected final void m4908b() {
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String format = String.format(Locale.ENGLISH, "Interstitials WebView triggered an error. Error code: %d, error description: %s. Failing URL: %s", new Object[]{Integer.valueOf(i), str, str2});
        FyberLogger.m5220a("ExchangeInterstitial", format);
        this.f2444a.m4867a(format);
    }

    private void m4904c(String str) {
        if (this.f2444a.f2437g != null) {
            this.f2444a.m4871d();
            m4900a(str);
        }
    }
}
       int a = exchangeInterstitial.f2441k.m5063a();
        exchangeInterstitial.f2441k.setLayoutParams(new LayoutParams(a, a, 53));
        exchangeInterstitial.f2434d.setLayoutParams(new LayoutParams(-1, -1));
        exchangeInterstitial.f2436f.addView(exchangeInterstitial.f2434d);
        exchangeInterstitial.f2436f.addView(exchangeInterstitial.f2441k);
        exchangeInterstitial.f2441k.setOnClickListener(exchangeInterstitial);
    }

    public ExchangeInterstitial(ExchangeAdapter exchangeAdapter) {
        super(exchangeAdapter);
        this.f2433c = new Handler(Looper.getMainLooper(), new ExchangeInterstitial(this));
    }

    protected final boolean m4894a(Activity activity) {
        Message obtain = Message.obtain(this.f2433c);
        obtain.what = 1;
        obtain.sendToTarget();
        this.f2437g = activity;
        int parseInt = Integer.parseInt(this.f2439i);
        boolean d = Fyber.getConfigs().m4838a().m5300d();
        if (this.f2438h.equalsIgnoreCase("portrait")) {
            if (d) {
                if (parseInt == 1) {
                    m4880a(9);
                } else {
                    m4880a(1);
                }
            } else if (parseInt == 2) {
                m4880a(9);
            } else {
                m4880a(1);
            }
        } else if (this.f2438h.equalsIgnoreCase("landscape")) {
            if (d) {
                if (parseInt == 2) {
                    m4880a(8);
                } else {
                    m4880a(0);
                }
            } else if (parseInt == 3) {
                m4880a(8);
            } else {
                m4880a(0);
            }
        }
        if (this.f2437g instanceof InterstitialActivity) {
            ((InterstitialActivity) this.f2437g).m4862a((MediationUserActivityListener) this);
        }
        activity.setContentView(this.f2436f, new LayoutParams(-1, -1));
        m4870c();
        return true;
    }

    protected final void m4890a(Context context) {
    }

    private void m4888g() {
        if (this.f2436f != null) {
            ViewGroup viewGroup = (ViewGroup) this.f2436f.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
        }
        this.f2440j = null;
    }

    public final boolean m4893a() {
        m4889h();
        return false;
    }

    public final void m4895b() {
        m4889h();
    }

    public final void onClick(View view) {
        m4889h();
    }

    private void m4889h() {
        m4872e();
        m4888g();
    }

    private void m4880a(int i) {
        this.f2437g.setRequestedOrientation(i);
    }

    public final void m4891a(Intent intent) {
        this.f2437g.startActivity(intent);
    }

    public final void m4892a(RequestError requestError) {
    }

    static /* synthetic */ WebViewClient m4884b(ExchangeInterstitial exchangeInterstitial) {
        if (exchangeInterstitial.f2435e == null) {
            exchangeInterstitial.f2435e = new ExchangeInterstitial(exchangeInterstitial);
        }
        return exchangeInterstitial.f2435e;
    }

    static /* synthetic */ void m4882a(ExchangeInterstitial exchangeInterstitial, Uri uri) {
        String queryParameter = uri.getQueryParameter("placementId");
        FyberLogger.m5223b("ExchangeInterstitial", "Placement ID - " + queryParameter);
        ((OfferWallRequester) OfferWallRequester.m5203a((RequestCallback) exchangeInterstitial).m5204a(true).m5197b(queryParameter)).m5205a(exchangeInterstitial.f2437g);
    }
}
