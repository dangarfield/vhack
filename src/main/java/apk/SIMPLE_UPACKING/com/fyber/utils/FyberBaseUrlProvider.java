package com.fyber.utils;

import java.util.HashMap;

/* renamed from: com.fyber.utils.i */
final class FyberBaseUrlProvider extends HashMap {
    final /* synthetic */ FyberBaseUrlProvider f2820a;

    FyberBaseUrlProvider(FyberBaseUrlProvider fyberBaseUrlProvider) {
        this.f2820a = fyberBaseUrlProvider;
        put("actions", "https://service.sponsorpay.com/actions/v2");
        put("installs", "https://service.sponsorpay.com/installs/v2");
        put("vcs", "https://api.sponsorpay.com/vcs/v1/new_credit.json");
        put("videos", "https://video.fyber.com");
        put("ofw", "https://iframe.sponsorpay.com/mobile");
        put("interstitial", "https://engine.sponsorpay.com/interstitial");
        put("tracker", "https://engine.sponsorpay.com/tracker");
        put("config", "https://engine.sponsorpay.com/sdk-config");
        put("precaching", "https://engine.fyber.com/video-cache");
    }
}
