package com.google.android.gms.ads.p048a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C0013a;
import com.google.android.gms.ads.C0016c;
import com.google.android.gms.ads.C0019f;
import com.google.android.gms.ads.internal.client.C0029b;

/* renamed from: com.google.android.gms.ads.a.d */
public final class C0011d extends ViewGroup {
    private final C0029b f2864a;

    public C0013a getAdListener() {
        return this.f2864a.m5360a();
    }

    public C0016c getAdSize() {
        return this.f2864a.m5370b();
    }

    public C0016c[] getAdSizes() {
        return this.f2864a.m5372c();
    }

    public String getAdUnitId() {
        return this.f2864a.m5373d();
    }

    public C0008a getAppEventListener() {
        return this.f2864a.m5374e();
    }

    public String getMediationAdapterClassName() {
        return this.f2864a.m5377h();
    }

    public C0010c getOnCustomRenderedAdLoadedListener() {
        return this.f2864a.m5376g();
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
        this.f2864a.m5363a(c0013a);
    }

    public void setAdSizes(C0016c... c0016cArr) {
        if (c0016cArr == null || c0016cArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f2864a.m5371b(c0016cArr);
    }

    public void setAdUnitId(String str) {
        this.f2864a.m5367a(str);
    }

    public void setAppEventListener(C0008a c0008a) {
        this.f2864a.m5361a(c0008a);
    }

    public void setCorrelator(C0019f c0019f) {
        this.f2864a.m5364a(c0019f);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.f2864a.m5368a(z);
    }

    public void setOnCustomRenderedAdLoadedListener(C0010c c0010c) {
        this.f2864a.m5362a(c0010c);
    }
}
