package com.fyber.ads.ofw;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;
import com.fyber.Fyber;
import com.fyber.Fyber.Settings.UIStringIdentifier;
import com.fyber.ads.ofw.p030a.ActivityOfferWebClient;
import com.fyber.cache.CacheManager;
import com.fyber.p025a.Credentials;
import com.fyber.utils.AbstractHttpConnection;
import com.fyber.utils.FyberBaseUrlProvider;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.HostInfo;
import com.fyber.utils.ad;
import com.fyber.utils.ae;
import com.fyber.utils.aj;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OfferWallActivity extends Activity {
    protected WebView f2481a;
    protected Map f2482b;
    private boolean f2483c;
    private ProgressDialog f2484d;
    private AlertDialog f2485e;
    private Credentials f2486f;
    private ActivityOfferWebClient f2487g;
    private String f2488h;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (HostInfo.m5287e()) {
            getWindow().requestFeature(1);
            this.f2484d = new ProgressDialog(this);
            this.f2484d.setOwnerActivity(this);
            this.f2484d.setIndeterminate(true);
            this.f2484d.setMessage(ad.m5234a(UIStringIdentifier.LOADING_OFFERWALL));
            this.f2484d.show();
            m4919a();
            this.f2481a = new WebView(getApplicationContext());
            this.f2481a.setScrollBarStyle(0);
            setContentView(this.f2481a);
            this.f2481a.getSettings().setJavaScriptEnabled(true);
            aj.m5249a(this.f2481a.getSettings());
            aj.m5250a(this.f2481a);
            this.f2487g = new ActivityOfferWebClient(this, this.f2483c);
            this.f2481a.setWebViewClient(this.f2487g);
            this.f2481a.setWebChromeClient(new OfferWallActivity(this));
            return;
        }
        setResult(-20);
        finish();
    }

    protected void m4919a() {
        Intent intent = getIntent();
        if (!Fyber.getConfigs().m4844d()) {
            SharedPreferences preferences = getPreferences(0);
            String string = preferences.getString("app.id.key", "");
            String string2 = preferences.getString("user.id.key", "");
            String string3 = preferences.getString("security.token.key", "");
            boolean z = preferences.getBoolean("precaching.enabled", false);
            Fyber withSecurityToken = Fyber.with(string, this).withUserId(string2).withSecurityToken(string3);
            if (z) {
                withSecurityToken.withManualPrecaching();
            }
            withSecurityToken.start();
            this.f2486f = Fyber.getConfigs().m4845e();
            getPreferences(0).edit().clear().commit();
        }
        this.f2486f = Fyber.getConfigs().m4845e();
        this.f2483c = intent.getBooleanExtra("EXTRA_SHOULD_CLOSE_ON_REDIRECT_KEY", m4920b());
        Serializable serializableExtra = intent.getSerializableExtra("EXTRA_KEY_VALUES_MAP");
        if (serializableExtra instanceof HashMap) {
            this.f2482b = (HashMap) serializableExtra;
        }
        String stringExtra = intent.getStringExtra("EXTRA_PLACEMENT_ID_KEY");
        if (stringExtra != null) {
            this.f2488h = stringExtra;
        }
    }

    protected void onPause() {
        if (this.f2485e != null) {
            this.f2485e.dismiss();
            this.f2485e = null;
        }
        if (this.f2484d != null) {
            this.f2484d.dismiss();
            this.f2484d = null;
        }
        getPreferences(0).edit().putString("app.id.key", this.f2486f.m4847a()).putString("user.id.key", this.f2486f.m4848b()).putString("security.token.key", this.f2486f.m4849c()).putBoolean("precaching.enabled", CacheManager.m5127a().m5138e()).apply();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        try {
            String d = ae.m5235a(FyberBaseUrlProvider.m5274a("ofw"), this.f2486f).m5245c().m5239a(this.f2488h).m5241a(this.f2482b).m5238a().m5246d();
            FyberLogger.m5223b("OfferWallActivity", "Offer Wall request url: " + d);
            this.f2481a.loadUrl(d, AbstractHttpConnection.m5265d());
        } catch (Exception e) {
            FyberLogger.m5221a("OfferWallActivity", "An exception occurred when launching the Offer Wall", e);
            this.f2487g.m4902b(e.getMessage());
        }
    }

    public boolean m4920b() {
        return false;
    }
}
