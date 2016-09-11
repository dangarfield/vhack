package android.support.v4.p002h.p015a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.h.a.a */
public final class AccessibilityEventCompat {
    private static final AccessibilityEventCompat f889a;

    static {
        if (VERSION.SDK_INT >= 19) {
            f889a = new AccessibilityEventCompat();
        } else if (VERSION.SDK_INT >= 14) {
            f889a = new AccessibilityEventCompat();
        } else {
            f889a = new AccessibilityEventCompat();
        }
    }

    public static aj m1546a(AccessibilityEvent accessibilityEvent) {
        return new aj(accessibilityEvent);
    }

    public static void m1547a(AccessibilityEvent accessibilityEvent, int i) {
        f889a.m1606a(accessibilityEvent, i);
    }

    public static int m1548b(AccessibilityEvent accessibilityEvent) {
        return f889a.m1605a(accessibilityEvent);
    }
}
