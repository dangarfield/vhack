package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.C0027a;
import com.google.android.gms.ads.internal.client.C0029b;
import com.google.android.gms.ads.purchase.C0102b;

/* renamed from: com.google.android.gms.ads.e */
class C0017e extends ViewGroup {
    private final C0029b f2877a;

    public C0013a getAdListener() {
        return this.f2877a.m5360a();
    }

    public C0016c getAdSize() {
        return this.f2877a.m5370b();
    }

    public String getAdUnitId() {
        return this.f2877a.m5373d();
    }

    public C0102b getInAppPurchaseListener() {
        return this.f2877a.m5375f();
    }

    public String getMediationAdapterClassName() {
        return this.f2877a.m5377h();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int b;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            C0016c adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                b = adSize.m5338b(context);
                i3 = adSize.m5336a(context);
            } else {
                b = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            b = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(b, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void setAdListener(C0013a c0013a) {
        this.f2877a.m5363a(c0013a);
        if (c0013a != null && (c0013a instanceof C0027a)) {
            this.f2877a.m5365a((C0027a) c0013a);
        } else if (c0013a == null) {
            this.f2877a.m5365a(null);
        }
    }

    public void setAdSize(C0016c c0016c) {
        this.f2877a.m5369a(c0016c);
    }

    public void setAdUnitId(String str) {
        this.f2877a.m5367a(str);
    }

    public void setInAppPurchaseListener(C0102b c0102b) {
        this.f2877a.m5366a(c0102b);
    }
}
