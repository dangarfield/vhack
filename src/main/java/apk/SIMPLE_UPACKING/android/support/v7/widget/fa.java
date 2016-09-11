package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.p002h.AccessibilityDelegateCompat;
import android.support.v4.p002h.p015a.AccessibilityNodeInfoCompat;
import android.view.View;

/* compiled from: RecyclerViewAccessibilityDelegate */
class fa extends AccessibilityDelegateCompat {
    final /* synthetic */ ez f2214b;

    fa(ez ezVar) {
        this.f2214b = ezVar;
    }

    public void m4553a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.m1758a(view, accessibilityNodeInfoCompat);
        if (!this.f2214b.m4546c() && this.f2214b.f2211b.getLayoutManager() != null) {
            this.f2214b.f2211b.getLayoutManager().m3526a(view, accessibilityNodeInfoCompat);
        }
    }

    public boolean m4554a(View view, int i, Bundle bundle) {
        if (super.m1760a(view, i, bundle)) {
            return true;
        }
        if (this.f2214b.m4546c() || this.f2214b.f2211b.getLayoutManager() == null) {
            return false;
        }
        return this.f2214b.f2211b.getLayoutManager().m3539a(view, i, bundle);
    }
}
