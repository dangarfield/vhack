package android.support.v4.p002h.p015a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatKitKat */
/* renamed from: android.support.v4.h.a.ah */
final class ah extends AccessibilityNodeProvider {
    final /* synthetic */ ai f893a;

    ah(ai aiVar) {
        this.f893a = aiVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f893a.m1552a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f893a.m1553a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f893a.m1554a(i, i2, bundle);
    }

    public AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.f893a.m1555b(i);
    }
}
