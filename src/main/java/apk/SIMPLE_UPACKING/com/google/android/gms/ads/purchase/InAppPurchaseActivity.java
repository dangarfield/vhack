package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.ev;
import com.google.android.gms.p051b.fc;

public class InAppPurchaseActivity extends Activity {
    private ev f3103a;

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.f3103a != null) {
                this.f3103a.m5573a(i, i2, intent);
            }
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3103a = fc.m6485a((Activity) this);
        if (this.f3103a == null) {
            C0099b.m5643d("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.f3103a.m5572a();
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.f3103a != null) {
                this.f3103a.m5574b();
            }
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
