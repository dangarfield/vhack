package com.fyber.ads.interstitials;

/* renamed from: com.fyber.ads.interstitials.g */
public enum InterstitialEvent {
    ValidationRequest("request"),
    ValidationFill("fill"),
    ValidationNoFill("no_fill"),
    ValidationError("error"),
    ShowImpression("impression"),
    ShowClick("click"),
    ShowClose("close"),
    ShowError("error"),
    NotIntegrated("no_sdk");
    
    private final String f2480j;

    private InterstitialEvent(String str) {
        this.f2480j = str;
    }

    public final String toString() {
        return this.f2480j;
    }
}
