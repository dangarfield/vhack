package android.support.v4.p002h.p015a;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.h.a.t */
class AccessibilityNodeInfoCompatIcs {
    public static void m1722a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public static int m1721a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public static void m1723a(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void m1727b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static CharSequence m1726b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public static CharSequence m1728c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static CharSequence m1729d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public static CharSequence m1730e(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public static boolean m1731f(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean m1732g(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean m1733h(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean m1734i(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean m1735j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean m1736k(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean m1737l(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean m1738m(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean m1739n(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean m1740o(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public static void m1724a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void m1725a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }
}
