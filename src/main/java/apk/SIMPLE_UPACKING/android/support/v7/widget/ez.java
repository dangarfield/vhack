package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.p002h.AccessibilityDelegateCompat;
import android.support.v4.p002h.p015a.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: RecyclerViewAccessibilityDelegate */
public class ez extends AccessibilityDelegateCompat {
    final RecyclerView f2211b;
    final AccessibilityDelegateCompat f2212c;

    public ez(RecyclerView recyclerView) {
        this.f2212c = new fa(this);
        this.f2211b = recyclerView;
    }

    private boolean m4546c() {
        return this.f2211b.m215p();
    }

    public boolean m4548a(View view, int i, Bundle bundle) {
        if (super.m1760a(view, i, bundle)) {
            return true;
        }
        if (m4546c() || this.f2211b.getLayoutManager() == null) {
            return false;
        }
        return this.f2211b.getLayoutManager().m3530a(i, bundle);
    }

    public void m4547a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.m1758a(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.m1618a(RecyclerView.class.getName());
        if (!m4546c() && this.f2211b.getLayoutManager() != null) {
            this.f2211b.getLayoutManager().m3508a(accessibilityNodeInfoCompat);
        }
    }

    public void m4550d(View view, AccessibilityEvent accessibilityEvent) {
        super.m1764d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m4546c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().m3528a(accessibilityEvent);
            }
        }
    }

    AccessibilityDelegateCompat m4549b() {
        return this.f2212c;
    }
}
