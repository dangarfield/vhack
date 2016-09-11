package com.fyber.p027f.p043a;

import com.fyber.ads.interstitials.p026b.InterstitialMediationAdapter;
import com.fyber.ads.interstitials.p029a.ExchangeInterstitial;
import com.fyber.ads.videos.p033b.RewardedVideoMediationAdapter;
import com.fyber.p027f.MediationAdapter;

/* renamed from: com.fyber.f.a.a */
public final class ExchangeAdapter extends MediationAdapter {
    private ExchangeInterstitial f2734a;

    public ExchangeAdapter() {
        this.f2734a = new ExchangeInterstitial(this);
    }

    public final RewardedVideoMediationAdapter m5167a() {
        return null;
    }

    public final /* bridge */ /* synthetic */ InterstitialMediationAdapter m5168b() {
        return this.f2734a;
    }
}
