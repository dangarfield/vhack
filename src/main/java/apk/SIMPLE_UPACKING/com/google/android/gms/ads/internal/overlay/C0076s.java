package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.C0046n;
import com.google.android.gms.p051b.fi;

@fi
/* renamed from: com.google.android.gms.ads.internal.overlay.s */
public class C0076s extends FrameLayout implements OnClickListener {
    private final ImageButton f3056a;
    private final C0059v f3057b;

    public C0076s(Context context, int i, C0059v c0059v) {
        super(context);
        this.f3057b = c0059v;
        setOnClickListener(this);
        this.f3056a = new ImageButton(context);
        this.f3056a.setImageResource(17301527);
        this.f3056a.setBackgroundColor(0);
        this.f3056a.setOnClickListener(this);
        this.f3056a.setPadding(0, 0, 0, 0);
        this.f3056a.setContentDescription("Interstitial close button");
        int a = C0046n.m5409a().m5628a(context, i);
        addView(this.f3056a, new LayoutParams(a, a, 17));
    }

    public void m5552a(boolean z, boolean z2) {
        if (!z2) {
            this.f3056a.setVisibility(0);
        } else if (z) {
            this.f3056a.setVisibility(4);
        } else {
            this.f3056a.setVisibility(8);
        }
    }

    public void onClick(View view) {
        if (this.f3057b != null) {
            this.f3057b.m5474c();
        }
    }
}
