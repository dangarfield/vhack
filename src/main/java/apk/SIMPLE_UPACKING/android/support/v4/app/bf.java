package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* compiled from: NavUtilsJB */
class bf {
    public static Intent m974a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static boolean m976a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m977b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static String m975a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }
}
