package com.fyber.p034b;

import com.fyber.Fyber;
import com.fyber.ads.interstitials.InterstitialAd;
import com.fyber.ads.interstitials.InterstitialEvent;
import com.fyber.utils.FyberBaseUrlProvider;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.HttpConnection;
import com.fyber.utils.StringUtils;
import com.fyber.utils.ae;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.fyber.b.d */
public final class InterstitialEventNetworkOperation extends NetworkOperation {
    private InterstitialAd f2621b;

    public static void m5016a(String str, InterstitialAd interstitialAd, InterstitialEvent interstitialEvent) {
        if (StringUtils.m5259a(str) || interstitialEvent == null) {
            FyberLogger.m5223b("InterstitialEventNetworkOperation", "The event cannot be sent, a required field is missing.");
        } else if (Fyber.getConfigs().m4844d()) {
            if (interstitialAd != null) {
                FyberLogger.m5223b("InterstitialEventNetworkOperation", String.format("Notifying tracker of event=%s with request_id=%s for ad_id=%s and provider_type=%s ", new Object[]{interstitialEvent, str, interstitialAd.m4910b(), interstitialAd.m4909a()}));
            } else {
                FyberLogger.m5223b("InterstitialEventNetworkOperation", String.format("Notifying tracker of event=%s with request_id=%s", new Object[]{interstitialEvent, str}));
            }
            Fyber.getConfigs().m4841a(new InterstitialEventNetworkOperation(ae.m5235a(FyberBaseUrlProvider.m5274a("tracker"), Fyber.getConfigs().m4845e()).m5244b(str).m5240a("event", interstitialEvent.toString()).m5240a("ad_format", "interstitial").m5240a("rewarded", "0").m5238a(), interstitialAd));
        } else {
            FyberLogger.m5223b("InterstitialEventNetworkOperation", "It appears that Fyber SDK has not been started yet.");
        }
    }

    private InterstitialEventNetworkOperation(ae aeVar, InterstitialAd interstitialAd) {
        super(aeVar);
        this.f2621b = interstitialAd;
    }

    protected final boolean m5019a() {
        if (this.f2621b != null) {
            this.a.m5240a("ad_id", this.f2621b.m4910b()).m5240a("provider_type", this.f2621b.m4909a());
            JSONObject c = this.f2621b.m4911c();
            if (c != null) {
                ae aeVar = this.a;
                Iterator keys = c.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    try {
                        Object obj = c.get(str);
                        if (obj != null) {
                            aeVar.m5240a(str, obj.toString());
                        }
                    } catch (JSONException e) {
                        FyberLogger.m5220a("InterstitialEventNetworkOperation", e.getMessage());
                    }
                }
            }
        }
        return true;
    }

    protected final String m5020b() {
        return "InterstitialEventNetworkOperation";
    }

    protected final /* synthetic */ Object m5017a(HttpConnection httpConnection) {
        FyberLogger.m5223b("InterstitialEventNetworkOperation", "Event communication successful - " + (httpConnection.m5271b() == 200));
        return null;
    }

    protected final /* synthetic */ Object m5018a(IOException iOException) {
        FyberLogger.m5220a("InterstitialEventNetworkOperation", "An exception occurred when trying to send advertiser callback: " + iOException);
        return null;
    }
}
