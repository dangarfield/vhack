package android.support.v4.p002h.p015a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
/* renamed from: android.support.v4.h.a.ab */
class ab implements ai {
    final /* synthetic */ AccessibilityNodeProviderCompat f890a;
    final /* synthetic */ aa f891b;

    ab(aa aaVar, AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
        this.f891b = aaVar;
        this.f890a = accessibilityNodeProviderCompat;
    }

    public boolean m1558a(int i, int i2, Bundle bundle) {
        return this.f890a.m1749a(i, i2, bundle);
    }

    public List m1557a(String str, int i) {
        List a = this.f890a.m1748a(str, i);
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((AccessibilityNodeInfoCompat) a.get(i2)).m1615a());
        }
        return arrayList;
    }

    public Object m1556a(int i) {
        AccessibilityNodeInfoCompat a = this.f890a.m1746a(i);
        if (a == null) {
            return null;
        }
        return a.m1615a();
    }

    public Object m1559b(int i) {
        AccessibilityNodeInfoCompat b = this.f890a.m1750b(i);
        if (b == null) {
            return null;
        }
        return b.m1615a();
    }
}
