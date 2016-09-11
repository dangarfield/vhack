package android.support.v4.p002h;

import android.os.Bundle;
import android.support.v4.p002h.p015a.AccessibilityNodeInfoCompat;
import android.support.v4.p002h.p015a.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.h.f */
class AccessibilityDelegateCompat implements AccessibilityDelegateCompatJellyBean {
    final /* synthetic */ AccessibilityDelegateCompat f958a;
    final /* synthetic */ AccessibilityDelegateCompat f959b;

    AccessibilityDelegateCompat(AccessibilityDelegateCompat accessibilityDelegateCompat, AccessibilityDelegateCompat accessibilityDelegateCompat2) {
        this.f959b = accessibilityDelegateCompat;
        this.f958a = accessibilityDelegateCompat2;
    }

    public boolean m2377a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f958a.m1762b(view, accessibilityEvent);
    }

    public void m2379b(View view, AccessibilityEvent accessibilityEvent) {
        this.f958a.m1764d(view, accessibilityEvent);
    }

    public void m2375a(View view, Object obj) {
        this.f958a.m1758a(view, new AccessibilityNodeInfoCompat(obj));
    }

    public void m2380c(View view, AccessibilityEvent accessibilityEvent) {
        this.f958a.m1763c(view, accessibilityEvent);
    }

    public boolean m2378a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f958a.m1761a(viewGroup, view, accessibilityEvent);
    }

    public void m2374a(View view, int i) {
        this.f958a.m1757a(view, i);
    }

    public void m2381d(View view, AccessibilityEvent accessibilityEvent) {
        this.f958a.m1759a(view, accessibilityEvent);
    }

    public Object m2373a(View view) {
        AccessibilityNodeProviderCompat a = this.f958a.m1755a(view);
        return a != null ? a.m1747a() : null;
    }

    public boolean m2376a(View view, int i, Bundle bundle) {
        return this.f958a.m1760a(view, i, bundle);
    }
}
