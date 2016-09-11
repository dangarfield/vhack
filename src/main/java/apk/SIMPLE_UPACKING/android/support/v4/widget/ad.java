package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.p002h.AccessibilityDelegateCompat;
import android.support.v4.p002h.p015a.AccessibilityEventCompat;
import android.support.v4.p002h.p015a.AccessibilityNodeInfoCompat;
import android.support.v4.p002h.p015a.aj;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

/* compiled from: NestedScrollView */
class ad extends AccessibilityDelegateCompat {
    ad() {
    }

    public boolean m2492a(View view, int i, Bundle bundle) {
        if (super.m1760a(view, i, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        int min;
        switch (i) {
            case 4096:
                min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m2449b(0, min);
                return true;
            case 8192:
                min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m2449b(0, min);
                return true;
            default:
                return false;
        }
    }

    public void m2491a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.m1758a(view, accessibilityNodeInfoCompat);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityNodeInfoCompat.m1618a(ScrollView.class.getName());
        if (nestedScrollView.isEnabled()) {
            int a = nestedScrollView.getScrollRange();
            if (a > 0) {
                accessibilityNodeInfoCompat.m1620a(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.m1616a(8192);
                }
                if (nestedScrollView.getScrollY() < a) {
                    accessibilityNodeInfoCompat.m1616a(4096);
                }
            }
        }
    }

    public void m2493d(View view, AccessibilityEvent accessibilityEvent) {
        super.m1764d(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        aj a = AccessibilityEventCompat.m1546a(accessibilityEvent);
        a.m1566a(nestedScrollView.getScrollRange() > 0);
        a.m1569d(nestedScrollView.getScrollX());
        a.m1570e(nestedScrollView.getScrollY());
        a.m1571f(nestedScrollView.getScrollX());
        a.m1572g(nestedScrollView.getScrollRange());
    }
}
