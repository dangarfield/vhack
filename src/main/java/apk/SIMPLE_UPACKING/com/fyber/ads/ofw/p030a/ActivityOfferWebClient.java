package com.fyber.ads.ofw.p030a;

import android.app.Activity;
import android.net.Uri;
import android.webkit.WebView;
import com.fyber.Fyber.Settings.UIStringIdentifier;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.ad;
import com.fyber.utils.ah;
import java.util.Locale;

/* renamed from: com.fyber.ads.ofw.a.a */
public final class ActivityOfferWebClient extends ah {
    private boolean f2489a;

    public ActivityOfferWebClient(Activity activity, boolean z) {
        super(activity);
        this.f2489a = z;
    }

    protected final void m4921a(int i, String str) {
        Activity a = m4897a();
        if (a != null) {
            boolean z;
            a.setResult(i);
            if (str == null) {
                z = true;
            } else {
                z = this.f2489a;
                if (!m4900a(str)) {
                    return;
                }
            }
            FyberLogger.m5226c("ActivityOfferWebClient", "Should close: " + this.f2489a + ", will close activity: " + z);
            if (z) {
                a.finish();
            }
        }
    }

    protected final void m4922a(String str, Uri uri) {
    }

    protected final void m4923b() {
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        UIStringIdentifier uIStringIdentifier;
        FyberLogger.m5220a("ActivityOfferWebClient", String.format(Locale.ENGLISH, "OfferWall WebView triggered an error. Error code: %d, error description: %s. Failing URL: %s", new Object[]{Integer.valueOf(i), str, str2}));
        switch (i) {
            case -7:
            case -2:
                uIStringIdentifier = UIStringIdentifier.ERROR_LOADING_OFFERWALL_NO_INTERNET_CONNECTION;
                break;
            default:
                uIStringIdentifier = UIStringIdentifier.ERROR_LOADING_OFFERWALL;
                break;
        }
        m4902b(ad.m5234a(uIStringIdentifier));
    }
}
