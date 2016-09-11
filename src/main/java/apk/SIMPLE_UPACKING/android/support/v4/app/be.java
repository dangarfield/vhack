package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* compiled from: NavUtils */
class be extends bd {
    be() {
    }

    public Intent m969a(Activity activity) {
        Intent a = bf.m974a(activity);
        if (a == null) {
            return m972b(activity);
        }
        return a;
    }

    Intent m972b(Activity activity) {
        return super.m965a(activity);
    }

    public boolean m971a(Activity activity, Intent intent) {
        return bf.m976a(activity, intent);
    }

    public void m973b(Activity activity, Intent intent) {
        bf.m977b(activity, intent);
    }

    public String m970a(Context context, ActivityInfo activityInfo) {
        String a = bf.m975a(activityInfo);
        if (a == null) {
            return super.m966a(context, activityInfo);
        }
        return a;
    }
}
