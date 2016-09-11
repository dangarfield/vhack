package com.fyber.ads.interstitials;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.fyber.p027f.MediationUserActivityListener;

public class InterstitialActivity extends Activity implements InterstitialAdListener {
    private MediationUserActivityListener f2427a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        InterstitialClient.f2453a.m4914a((InterstitialAdListener) this);
        InterstitialClient.f2453a.m4915a((Activity) this);
    }

    public void m4860a() {
    }

    public void m4861a(InterstitialAdCloseReason interstitialAdCloseReason) {
        Intent intent = new Intent();
        intent.putExtra("AD_STATUS", interstitialAdCloseReason);
        setResult(-1, intent);
        finish();
    }

    public void m4863a(String str) {
        Intent intent = new Intent();
        intent.putExtra("AD_STATUS", InterstitialAdCloseReason.ReasonError);
        intent.putExtra("ERROR_MESSAGE", str);
        setResult(-1, intent);
        finish();
    }

    public void m4862a(MediationUserActivityListener mediationUserActivityListener) {
        if (this.f2427a == null) {
            this.f2427a = mediationUserActivityListener;
        }
    }

    protected void onUserLeaveHint() {
        if (this.f2427a != null) {
            this.f2427a.m4875b();
        }
        super.onUserLeaveHint();
    }

    public void onBackPressed() {
        if (this.f2427a != null) {
            this.f2427a.m4874a();
        }
        super.onBackPressed();
    }
}
