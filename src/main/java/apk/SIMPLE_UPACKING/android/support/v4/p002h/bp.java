package android.support.v4.p002h;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* compiled from: VelocityTrackerCompat */
/* renamed from: android.support.v4.h.bp */
public final class bp {
    static final bs f925a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f925a = new br();
        } else {
            f925a = new bq();
        }
    }

    public static float m1905a(VelocityTracker velocityTracker, int i) {
        return f925a.m1907a(velocityTracker, i);
    }

    public static float m1906b(VelocityTracker velocityTracker, int i) {
        return f925a.m1908b(velocityTracker, i);
    }
}
