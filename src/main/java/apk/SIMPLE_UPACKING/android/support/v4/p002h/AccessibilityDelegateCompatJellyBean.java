package android.support.v4.p002h;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* renamed from: android.support.v4.h.l */
final class AccessibilityDelegateCompatJellyBean extends AccessibilityDelegate {
    final /* synthetic */ AccessibilityDelegateCompatJellyBean f961a;

    AccessibilityDelegateCompatJellyBean(AccessibilityDelegateCompatJellyBean accessibilityDelegateCompatJellyBean) {
        this.f961a = accessibilityDelegateCompatJellyBean;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f961a.m2368a(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f961a.m2370b(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f961a.m2366a(view, (Object) accessibilityNodeInfo);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f961a.m2371c(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f961a.m2369a(viewGroup, view, accessibilityEvent);
    }

    public void sendAccessibilityEvent(View view, int i) {
        this.f961a.m2365a(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f961a.m2372d(view, accessibilityEvent);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return (AccessibilityNodeProvider) this.f961a.m2364a(view);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.f961a.m2367a(view, i, bundle);
    }
}
