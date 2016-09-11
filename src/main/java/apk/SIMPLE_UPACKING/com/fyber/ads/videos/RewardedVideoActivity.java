package com.fyber.ads.videos;

import android.webkit.ValueCallback;

/* renamed from: com.fyber.ads.videos.b */
final class RewardedVideoActivity implements ValueCallback {
    final /* synthetic */ RewardedVideoActivity f2578a;

    RewardedVideoActivity(RewardedVideoActivity rewardedVideoActivity) {
        this.f2578a = rewardedVideoActivity;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.f2578a.f2493c = ((Boolean) obj).booleanValue();
        this.f2578a.m4928b();
    }
}
