package android.support.v4.p002h;

import android.view.MotionEvent;

/* compiled from: MotionEventCompatEclair */
/* renamed from: android.support.v4.h.bf */
class bf {
    public static int m1887a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m1888b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m1889c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m1890d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static int m1886a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
