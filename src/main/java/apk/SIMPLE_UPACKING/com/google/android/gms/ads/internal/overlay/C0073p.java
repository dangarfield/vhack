package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.internal.C0282d;
import com.google.android.gms.p051b.av;
import com.google.android.gms.p051b.az;
import com.google.android.gms.p051b.fi;
import com.google.android.gms.p051b.hb;
import java.util.HashMap;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.ads.internal.overlay.p */
public class C0073p extends FrameLayout implements C0070m {
    private final hb f3046a;
    private final FrameLayout f3047b;
    private final C0079w f3048c;
    private C0071n f3049d;
    private boolean f3050e;
    private boolean f3051f;
    private TextView f3052g;
    private long f3053h;
    private String f3054i;
    private String f3055j;

    public C0073p(Context context, hb hbVar, int i, az azVar, av avVar) {
        super(context);
        this.f3046a = hbVar;
        this.f3047b = new FrameLayout(context);
        addView(this.f3047b, new LayoutParams(-1, -1));
        C0282d.m7893a(hbVar.m6648g());
        this.f3049d = hbVar.m6648g().f2886b.m5524a(context, hbVar, i, azVar, avVar);
        if (this.f3049d != null) {
            this.f3047b.addView(this.f3049d, new LayoutParams(-1, -1, 17));
        }
        this.f3052g = new TextView(context);
        this.f3052g.setBackgroundColor(-16777216);
        m5527i();
        this.f3048c = new C0079w(this);
        this.f3048c.m5560b();
        if (this.f3049d != null) {
            this.f3049d.m5518a((C0070m) this);
        }
        if (this.f3049d == null) {
            m5537a("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void m5525a(hb hbVar) {
        Map hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        hbVar.m6637a("onVideoEvent", hashMap);
    }

    private void m5526a(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put("event", str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.f3046a.m6637a("onVideoEvent", hashMap);
    }

    private void m5527i() {
        if (!m5529k()) {
            this.f3047b.addView(this.f3052g, new LayoutParams(-1, -1));
            this.f3047b.bringChildToFront(this.f3052g);
        }
    }

    private void m5528j() {
        if (m5529k()) {
            this.f3047b.removeView(this.f3052g);
        }
    }

    private boolean m5529k() {
        return this.f3052g.getParent() != null;
    }

    private void m5530l() {
        if (this.f3046a.m6646e() != null && this.f3050e && !this.f3051f) {
            this.f3046a.m6646e().getWindow().clearFlags(128);
            this.f3050e = false;
        }
    }

    public void m5531a() {
        if (this.f3049d != null) {
            if (TextUtils.isEmpty(this.f3055j)) {
                m5526a("no_src", new String[0]);
                return;
            }
            this.f3049d.setMimeType(this.f3054i);
            this.f3049d.setVideoPath(this.f3055j);
        }
    }

    public void m5532a(float f) {
        if (this.f3049d != null) {
            this.f3049d.m5516a(f);
        }
    }

    public void m5533a(int i) {
        if (this.f3049d != null) {
            this.f3049d.m5517a(i);
        }
    }

    public void m5534a(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3 + 2, i4 + 2);
            layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
            this.f3047b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public void m5535a(MotionEvent motionEvent) {
        if (this.f3049d != null) {
            this.f3049d.dispatchTouchEvent(motionEvent);
        }
    }

    public void m5536a(String str) {
        this.f3055j = str;
    }

    public void m5537a(String str, String str2) {
        m5526a("error", "what", str, "extra", str2);
    }

    public void m5538b() {
        if (this.f3049d != null) {
            this.f3049d.m5521d();
        }
    }

    public void m5539c() {
        if (this.f3049d != null) {
            this.f3049d.m5519b();
        }
    }

    public void m5540d() {
        if (this.f3049d != null) {
            this.f3049d.m5522e();
        }
    }

    public void m5541e() {
        if (this.f3049d != null) {
            this.f3049d.m5523f();
        }
    }

    public void m5542f() {
        if (this.f3049d != null) {
            View textView = new TextView(this.f3049d.getContext());
            textView.setText("AdMob - " + this.f3049d.m5515a());
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.f3047b.addView(textView, new LayoutParams(-2, -2, 17));
            this.f3047b.bringChildToFront(textView);
        }
    }

    public void m5543g() {
        this.f3048c.m5559a();
        if (this.f3049d != null) {
            this.f3049d.m5520c();
        }
        m5530l();
    }

    void m5544h() {
        if (this.f3049d != null) {
            long currentPosition = (long) this.f3049d.getCurrentPosition();
            if (this.f3053h != currentPosition && currentPosition > 0) {
                m5528j();
                float f = ((float) currentPosition) / 1000.0f;
                m5526a("timeupdate", "time", String.valueOf(f));
                this.f3053h = currentPosition;
            }
        }
    }

    public void setMimeType(String str) {
        this.f3054i = str;
    }
}
