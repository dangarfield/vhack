package android.support.v4.p002h.p015a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatJellyBean */
/* renamed from: android.support.v4.h.a.ae */
final class ae extends AccessibilityNodeProvider {
    final /* synthetic */ af f892a;

    ae(af afVar) {
        this.f892a = afVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f892a.m1561a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f892a.m1562a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f892a.m1563a(i, i2, bundle);
    }
}
