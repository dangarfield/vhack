package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
/* renamed from: com.google.android.gms.measurement.internal.h */
class C0366h implements ActivityLifecycleCallbacks {
    final /* synthetic */ C0362d f4919a;

    private C0366h(C0362d c0362d) {
        this.f4919a = c0362d;
    }

    private boolean m8860a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f4919a.m8839a("auto", "_ldl", (Object) str);
        return true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.f4919a.m8857s().m8606z().m8607a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    String queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (queryParameter.contains("gclid")) {
                            this.f4919a.m8857s().m8605y().m8608a("Activity created with referrer", queryParameter);
                            m8860a(queryParameter);
                            return;
                        }
                        this.f4919a.m8857s().m8605y().m8607a("Activity created with data 'referrer' param without gclid");
                    }
                }
            }
        } catch (Throwable th) {
            this.f4919a.m8857s().m8582b().m8608a("Throwable caught in onActivityCreated", th);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.f4919a.m8855q().m8921c();
    }

    public void onActivityResumed(Activity activity) {
        this.f4919a.m8855q().m8920b();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
