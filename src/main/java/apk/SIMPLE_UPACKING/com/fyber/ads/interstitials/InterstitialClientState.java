package com.fyber.ads.interstitials;

/* renamed from: com.fyber.ads.interstitials.f */
public enum InterstitialClientState {
    READY_TO_CHECK_OFFERS(false, true, true),
    REQUESTING_OFFERS(false, false, false),
    VALIDATING_OFFERS(false, false, false),
    READY_TO_SHOW_OFFERS(true, true, true),
    SHOWING_OFFERS(false, false, false);
    
    private final boolean f2467f;
    private final boolean f2468g;
    private final boolean f2469h;

    private InterstitialClientState(boolean z, boolean z2, boolean z3) {
        this.f2467f = z;
        this.f2469h = z2;
        this.f2468g = z3;
    }

    final boolean m4916a() {
        return this.f2467f;
    }
}
