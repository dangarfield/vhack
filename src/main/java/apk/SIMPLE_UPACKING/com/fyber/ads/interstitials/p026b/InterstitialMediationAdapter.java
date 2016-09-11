package com.fyber.ads.interstitials.p026b;

import android.app.Activity;
import android.content.Context;
import com.fyber.ads.interstitials.InterstitialAd;
import com.fyber.ads.interstitials.InterstitialClient;
import com.fyber.ads.interstitials.InterstitialEvent;
import com.fyber.p027f.MediationAdapter;
import java.lang.ref.WeakReference;

/* renamed from: com.fyber.ads.interstitials.b.a */
public abstract class InterstitialMediationAdapter {
    protected MediationAdapter f2428a;
    protected WeakReference f2429b;
    private InterstitialAd f2430c;
    private boolean f2431d;
    private boolean f2432e;

    protected abstract void m4866a(Context context);

    protected abstract boolean m4868a(Activity activity);

    public InterstitialMediationAdapter(MediationAdapter mediationAdapter) {
        this.f2432e = false;
        this.f2428a = mediationAdapter;
    }

    public final boolean m4869a(Activity activity, InterstitialAd interstitialAd) {
        if (this.f2431d) {
            this.f2432e = false;
            this.f2430c = interstitialAd;
            this.f2429b = new WeakReference(activity);
            return m4868a(activity);
        }
        m4866a((Context) activity);
        return false;
    }

    protected void m4870c() {
        m4865a(InterstitialEvent.ShowImpression, null);
    }

    protected void m4871d() {
        if (!this.f2432e) {
            this.f2432e = true;
            m4865a(InterstitialEvent.ShowClick, null);
        }
    }

    protected void m4872e() {
        if (!this.f2432e) {
            m4865a(InterstitialEvent.ShowClose, null);
        }
        m4864a();
        m4866a(m4873f());
    }

    protected void m4867a(String str) {
        m4864a();
        m4865a(InterstitialEvent.ShowError, str);
        m4866a(m4873f());
    }

    private void m4865a(InterstitialEvent interstitialEvent, String str) {
        if (this.f2430c != null) {
            InterstitialClient.f2453a.m4913a(this.f2430c, interstitialEvent, str);
        }
    }

    private void m4864a() {
        this.f2432e = false;
        this.f2431d = false;
    }

    protected Activity m4873f() {
        if (this.f2429b != null) {
            return (Activity) this.f2429b.get();
        }
        return null;
    }
}
