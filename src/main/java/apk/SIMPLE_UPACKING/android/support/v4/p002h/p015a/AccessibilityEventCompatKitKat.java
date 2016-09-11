package android.support.v4.p002h.p015a;

import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.h.a.f */
class AccessibilityEventCompatKitKat {
    public static void m1612a(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }

    public static int m1611a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }
}
