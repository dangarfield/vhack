package android.support.v4.p002h;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
/* renamed from: android.support.v4.h.ba */
class ba implements be {
    ba() {
    }

    public int m1873a(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        return -1;
    }

    public int m1875b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float m1876c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float m1877d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public int m1872a(MotionEvent motionEvent) {
        return 1;
    }

    public int m1874b(MotionEvent motionEvent) {
        return 0;
    }

    public float m1878e(MotionEvent motionEvent, int i) {
        return 0.0f;
    }
}
