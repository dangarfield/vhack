package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p007b.ContextCompat;

/* renamed from: android.support.v4.app.a */
public class ActivityCompat extends ContextCompat {
    public static void m746a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            ActivityCompatJB.m1058a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m745a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            ActivityCompatJB.m1057a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m747b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            ActivityCompat21.m942a(activity);
        } else {
            activity.finish();
        }
    }
}
