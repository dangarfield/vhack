package com.google.android.gms.ads.p049b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C0013a;
import com.google.android.gms.ads.C0016c;
import com.google.android.gms.ads.internal.client.C0029b;

/* renamed from: com.google.android.gms.ads.b.a */
public final class C0014a extends ViewGroup {
    private final C0029b f2865a;

    public C0013a getAdListener() {
        return this.f2865a.m5360a();
    }

    public C0016c getAdSize() {
        return this.f2865a.m5370b();
    }

    public String getAdUnitId() {
        return this.f2865a.m5373d();
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
        this.f2865a.m5363a(c0013a);
    }

    public void setAdSize(C0016c c0016c) {
        this.f2865a.m5369a(c0016c);
    }

    public void setAdUnitId(String str) {
        this.f2865a.m5367a(str);
    }
}
