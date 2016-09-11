package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* renamed from: android.support.v4.app.d */
class ActivityCompatJB {
    public static void m1058a(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void m1057a(Activity activity) {
        activity.finishAffinity();
    }
}
