package android.support.v4.p002h.p015a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.h.a.z */
class AccessibilityNodeProviderCompat implements af {
    final /* synthetic */ AccessibilityNodeProviderCompat f902a;
    final /* synthetic */ AccessibilityNodeProviderCompat f903b;

    AccessibilityNodeProviderCompat(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat, AccessibilityNodeProviderCompat accessibilityNodeProviderCompat2) {
        this.f903b = accessibilityNodeProviderCompat;
        this.f902a = accessibilityNodeProviderCompat2;
    }

    public boolean m1754a(int i, int i2, Bundle bundle) {
        return this.f902a.m1749a(i, i2, bundle);
    }

    public List m1753a(String str, int i) {
        List a = this.f902a.m1748a(str, i);
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((AccessibilityNodeInfoCompat) a.get(i2)).m1615a());
        }
        return arrayList;
    }

    public Object m1752a(int i) {
        AccessibilityNodeInfoCompat a = this.f902a.m1746a(i);
        if (a == null) {
            return null;
        }
        return a.m1615a();
    }
}
