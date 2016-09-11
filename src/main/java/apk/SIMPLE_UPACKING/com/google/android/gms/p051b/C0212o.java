package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@fi
@TargetApi(14)
/* renamed from: com.google.android.gms.b.o */
public class C0212o implements ActivityLifecycleCallbacks {
    private Activity f4089a;
    private Context f4090b;
    private final Object f4091c;

    private void m7251a(Activity activity) {
        synchronized (this.f4091c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f4089a = activity;
            }
        }
    }

    public Activity m7252a() {
        return this.f4089a;
    }

    public Context m7253b() {
        return this.f4090b;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        synchronized (this.f4091c) {
            if (this.f4089a == null) {
                return;
            }
            if (this.f4089a.equals(activity)) {
                this.f4089a = null;
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        m7251a(activity);
    }

    public void onActivityResumed(Activity activity) {
        m7251a(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        m7251a(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
