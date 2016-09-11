package com.fyber.ads.interstitials;

import android.app.Activity;
import android.content.Context;
import com.fyber.p027f.MediationCoordinator;
import com.fyber.p034b.InterstitialEventNetworkOperation;
import com.fyber.utils.FyberLogger;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.fyber.ads.interstitials.d */
public final class InterstitialClient {
    public static final InterstitialClient f2453a;
    private InterstitialClientState f2454b;
    private InterstitialAd f2455c;
    private Context f2456d;
    private String f2457e;
    private InterstitialAdListener f2458f;

    static {
        f2453a = new InterstitialClient();
    }

    private InterstitialClient() {
        this.f2454b = InterstitialClientState.READY_TO_CHECK_OFFERS;
    }

    private void m4912a(InterstitialClientState interstitialClientState) {
        this.f2454b = interstitialClientState;
        switch (InterstitialClient.f2459a[this.f2454b.ordinal()]) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f2456d = null;
            default:
        }
    }

    public final boolean m4915a(Activity activity) {
        if (!this.f2454b.m4916a()) {
            return false;
        }
        boolean a = MediationCoordinator.f2739a.m5172a(activity, this.f2455c);
        if (!a) {
            return a;
        }
        if (this.f2458f != null) {
            this.f2458f.m4857a();
        }
        m4912a(InterstitialClientState.SHOWING_OFFERS);
        return a;
    }

    public final void m4913a(InterstitialAd interstitialAd, InterstitialEvent interstitialEvent, String str) {
        InterstitialEventNetworkOperation.m5016a(this.f2457e, interstitialAd, interstitialEvent);
        switch (InterstitialClient.f2460b[interstitialEvent.ordinal()]) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                m4912a(InterstitialClientState.READY_TO_CHECK_OFFERS);
                if (this.f2458f != null) {
                    this.f2458f.m4858a(InterstitialAdCloseReason.ReasonUserClickedOnAd);
                    return;
                }
                return;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                m4912a(InterstitialClientState.READY_TO_CHECK_OFFERS);
                if (this.f2458f != null) {
                    this.f2458f.m4858a(InterstitialAdCloseReason.ReasonUserClosedAd);
                    return;
                }
                return;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                m4912a(InterstitialClientState.READY_TO_CHECK_OFFERS);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                break;
            default:
                return;
        }
        FyberLogger.m5223b("InterstitialClient", "An error occurred. Message: " + str);
        if (this.f2458f != null) {
            this.f2458f.m4859a(str);
        }
    }

    public final void m4914a(InterstitialAdListener interstitialAdListener) {
        this.f2458f = interstitialAdListener;
    }
}
