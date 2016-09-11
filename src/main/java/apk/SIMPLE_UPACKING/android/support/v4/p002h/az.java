package android.support.v4.p002h;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
/* renamed from: android.support.v4.h.az */
public final class az {
    static final be f913a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f913a = new bd();
        } else if (VERSION.SDK_INT >= 9) {
            f913a = new bc();
        } else if (VERSION.SDK_INT >= 5) {
            f913a = new bb();
        } else {
            f913a = new ba();
        }
    }

    public static int m1825a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m1827b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m1826a(MotionEvent motionEvent, int i) {
        return f913a.m1866a(motionEvent, i);
    }

    public static int m1828b(MotionEvent motionEvent, int i) {
        return f913a.m1868b(motionEvent, i);
    }

    public static float m1829c(MotionEvent motionEvent, int i) {
        return f913a.m1869c(motionEvent, i);
    }

    public static float m1831d(MotionEvent motionEvent, int i) {
        return f913a.m1870d(motionEvent, i);
    }

    public static int m1830c(MotionEvent motionEvent) {
        return f913a.m1865a(motionEvent);
    }

    public static int m1832d(MotionEvent motionEvent) {
        return f913a.m1867b(motionEvent);
    }

    public static float m1833e(MotionEvent motionEvent, int i) {
        return f913a.m1871e(motionEvent, i);
    }
}
