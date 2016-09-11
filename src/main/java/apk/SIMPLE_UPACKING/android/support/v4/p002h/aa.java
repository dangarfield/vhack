package android.support.v4.p002h;

import android.view.KeyEvent;

/* compiled from: KeyEventCompatHoneycomb */
/* renamed from: android.support.v4.h.aa */
class aa {
    public static int m1765a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m1766a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }
}
