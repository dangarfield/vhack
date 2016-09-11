package com.fyber.ads.videos;

/* renamed from: com.fyber.ads.videos.m */
public enum RewardedVideoOffersStatus {
    MUST_QUERY_SERVER_FOR_OFFERS(false, true, true),
    QUERYING_SERVER_FOR_OFFERS(false, false, false),
    READY_TO_SHOW_OFFERS(true, true, true),
    SHOWING_OFFERS(false, false, false),
    USER_ENGAGED(false, false, false);
    
    private final boolean f2617f;
    private final boolean f2618g;
    private final boolean f2619h;

    private RewardedVideoOffersStatus(boolean z, boolean z2, boolean z3) {
        this.f2617f = z;
        this.f2619h = z2;
        this.f2618g = z3;
    }

    final boolean m5010a() {
        return this.f2617f;
    }
}
