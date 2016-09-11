package com.google.android.gms.p051b;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.C0001R;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.Map;
import java.util.Set;

@fi
/* renamed from: com.google.android.gms.b.dv */
public class dv extends ef {
    static final Set f3558a;
    private String f3559b;
    private boolean f3560c;
    private int f3561d;
    private int f3562e;
    private int f3563f;
    private int f3564g;
    private int f3565h;
    private int f3566i;
    private final Object f3567j;
    private final hb f3568k;
    private final Activity f3569l;
    private AdSizeParcel f3570m;
    private ImageView f3571n;
    private LinearLayout f3572o;
    private eg f3573p;
    private PopupWindow f3574q;
    private RelativeLayout f3575r;
    private ViewGroup f3576s;

    static {
        f3558a = kg.m6921a("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public dv(hb hbVar, eg egVar) {
        super(hbVar, "resize");
        this.f3559b = "top-right";
        this.f3560c = true;
        this.f3561d = 0;
        this.f3562e = 0;
        this.f3563f = -1;
        this.f3564g = 0;
        this.f3565h = 0;
        this.f3566i = -1;
        this.f3567j = new Object();
        this.f3568k = hbVar;
        this.f3569l = hbVar.m6646e();
        this.f3573p = egVar;
    }

    private void m6395b(Map map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.f3566i = C0056g.m5439c().m6519a((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.f3563f = C0056g.m5439c().m6519a((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.f3564g = C0056g.m5439c().m6519a((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.f3565h = C0056g.m5439c().m6519a((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.f3560c = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.f3559b = str;
        }
    }

    private int[] m6396d() {
        if (!m6404c()) {
            return null;
        }
        if (this.f3560c) {
            return new int[]{this.f3561d + this.f3564g, this.f3562e + this.f3565h};
        }
        int[] b = C0056g.m5439c().m6549b(this.f3569l);
        int[] d = C0056g.m5439c().m6554d(this.f3569l);
        int i = b[0];
        int i2 = this.f3561d + this.f3564g;
        int i3 = this.f3562e + this.f3565h;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.f3566i + i2 > i) {
            i2 = i - this.f3566i;
        }
        if (i3 < d[0]) {
            i3 = d[0];
        } else if (this.f3563f + i3 > d[1]) {
            i3 = d[1] - this.f3563f;
        }
        return new int[]{i2, i3};
    }

    void m6397a(int i, int i2) {
        if (this.f3573p != null) {
            this.f3573p.m6438a(i, i2, this.f3566i, this.f3563f);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6398a(java.util.Map r13) {
        /*
        r12 = this;
        r4 = -1;
        r5 = 1;
        r3 = 0;
        r6 = r12.f3567j;
        monitor-enter(r6);
        r1 = r12.f3569l;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0011;
    L_0x000a:
        r1 = "Not an activity context. Cannot resize.";
        r12.m6386b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m6651j();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0023;
    L_0x0019:
        r1 = "Webview is not yet available, size is not set.";
        r12.m6386b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        throw r1;
    L_0x0023:
        r1 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m6651j();	 Catch:{ all -> 0x0020 }
        r1 = r1.f2913e;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0034;
    L_0x002d:
        r1 = "Is interstitial. Cannot resize an interstitial.";
        r12.m6386b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0034:
        r1 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m6656o();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0043;
    L_0x003c:
        r1 = "Cannot resize an expanded banner.";
        r12.m6386b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0043:
        r12.m6395b(r13);	 Catch:{ all -> 0x0020 }
        r1 = r12.m6400a();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0053;
    L_0x004c:
        r1 = "Invalid width and height options. Cannot resize.";
        r12.m6386b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0053:
        r1 = r12.f3569l;	 Catch:{ all -> 0x0020 }
        r7 = r1.getWindow();	 Catch:{ all -> 0x0020 }
        if (r7 == 0) goto L_0x0061;
    L_0x005b:
        r1 = r7.getDecorView();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0068;
    L_0x0061:
        r1 = "Activity context is not ready, cannot get window or decor view.";
        r12.m6386b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0068:
        r8 = r12.m6396d();	 Catch:{ all -> 0x0020 }
        if (r8 != 0) goto L_0x0075;
    L_0x006e:
        r1 = "Resize location out of screen or close button is not visible.";
        r12.m6386b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0075:
        r1 = com.google.android.gms.ads.internal.client.C0046n.m5409a();	 Catch:{ all -> 0x0020 }
        r2 = r12.f3569l;	 Catch:{ all -> 0x0020 }
        r9 = r12.f3566i;	 Catch:{ all -> 0x0020 }
        r9 = r1.m5628a(r2, r9);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.client.C0046n.m5409a();	 Catch:{ all -> 0x0020 }
        r2 = r12.f3569l;	 Catch:{ all -> 0x0020 }
        r10 = r12.f3563f;	 Catch:{ all -> 0x0020 }
        r10 = r1.m5628a(r2, r10);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m6639b();	 Catch:{ all -> 0x0020 }
        r2 = r1.getParent();	 Catch:{ all -> 0x0020 }
        if (r2 == 0) goto L_0x01d5;
    L_0x0099:
        r1 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x01d5;
    L_0x009d:
        r0 = r2;
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0020 }
        r1 = r0;
        r11 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r11 = r11.m6639b();	 Catch:{ all -> 0x0020 }
        r1.removeView(r11);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3574q;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01ce;
    L_0x00ae:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x0020 }
        r12.f3576s = r2;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.C0056g.m5439c();	 Catch:{ all -> 0x0020 }
        r2 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m6639b();	 Catch:{ all -> 0x0020 }
        r1 = r1.m6520a(r2);	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.ImageView;	 Catch:{ all -> 0x0020 }
        r11 = r12.f3569l;	 Catch:{ all -> 0x0020 }
        r2.<init>(r11);	 Catch:{ all -> 0x0020 }
        r12.f3571n = r2;	 Catch:{ all -> 0x0020 }
        r2 = r12.f3571n;	 Catch:{ all -> 0x0020 }
        r2.setImageBitmap(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m6651j();	 Catch:{ all -> 0x0020 }
        r12.f3570m = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f3576s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f3571n;	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
    L_0x00dd:
        r1 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.f3569l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.f3575r = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f3575r;	 Catch:{ all -> 0x0020 }
        r2 = 0;
        r1.setBackgroundColor(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3575r;	 Catch:{ all -> 0x0020 }
        r2 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0020 }
        r2.<init>(r9, r10);	 Catch:{ all -> 0x0020 }
        r1.setLayoutParams(r2);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.C0056g.m5439c();	 Catch:{ all -> 0x0020 }
        r2 = r12.f3575r;	 Catch:{ all -> 0x0020 }
        r11 = 0;
        r1 = r1.m6522a(r2, r9, r10, r11);	 Catch:{ all -> 0x0020 }
        r12.f3574q = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f3574q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setOutsideTouchable(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3574q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setTouchable(r2);	 Catch:{ all -> 0x0020 }
        r2 = r12.f3574q;	 Catch:{ all -> 0x0020 }
        r1 = r12.f3560c;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01dd;
    L_0x0115:
        r1 = r5;
    L_0x0116:
        r2.setClippingEnabled(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3575r;	 Catch:{ all -> 0x0020 }
        r2 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m6639b();	 Catch:{ all -> 0x0020 }
        r9 = -1;
        r10 = -1;
        r1.addView(r2, r9, r10);	 Catch:{ all -> 0x0020 }
        r1 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.f3569l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.f3572o = r1;	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.client.C0046n.m5409a();	 Catch:{ all -> 0x0020 }
        r9 = r12.f3569l;	 Catch:{ all -> 0x0020 }
        r10 = 50;
        r1 = r1.m5628a(r9, r10);	 Catch:{ all -> 0x0020 }
        r9 = com.google.android.gms.ads.internal.client.C0046n.m5409a();	 Catch:{ all -> 0x0020 }
        r10 = r12.f3569l;	 Catch:{ all -> 0x0020 }
        r11 = 50;
        r9 = r9.m5628a(r10, r11);	 Catch:{ all -> 0x0020 }
        r2.<init>(r1, r9);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3559b;	 Catch:{ all -> 0x0020 }
        r9 = r1.hashCode();	 Catch:{ all -> 0x0020 }
        switch(r9) {
            case -1364013995: goto L_0x01f6;
            case -1012429441: goto L_0x01e0;
            case -655373719: goto L_0x0201;
            case 1163912186: goto L_0x0217;
            case 1288627767: goto L_0x020c;
            case 1755462605: goto L_0x01eb;
            default: goto L_0x0155;
        };	 Catch:{ all -> 0x0020 }
    L_0x0155:
        r1 = r4;
    L_0x0156:
        switch(r1) {
            case 0: goto L_0x0222;
            case 1: goto L_0x022e;
            case 2: goto L_0x023a;
            case 3: goto L_0x0241;
            case 4: goto L_0x024d;
            case 5: goto L_0x0259;
            default: goto L_0x0159;
        };	 Catch:{ all -> 0x0020 }
    L_0x0159:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
    L_0x0163:
        r1 = r12.f3572o;	 Catch:{ all -> 0x0020 }
        r3 = new com.google.android.gms.b.dw;	 Catch:{ all -> 0x0020 }
        r3.<init>(r12);	 Catch:{ all -> 0x0020 }
        r1.setOnClickListener(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3572o;	 Catch:{ all -> 0x0020 }
        r3 = "Close button";
        r1.setContentDescription(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3575r;	 Catch:{ all -> 0x0020 }
        r3 = r12.f3572o;	 Catch:{ all -> 0x0020 }
        r1.addView(r3, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3574q;	 Catch:{ RuntimeException -> 0x0265 }
        r2 = r7.getDecorView();	 Catch:{ RuntimeException -> 0x0265 }
        r3 = 0;
        r4 = com.google.android.gms.ads.internal.client.C0046n.m5409a();	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r12.f3569l;	 Catch:{ RuntimeException -> 0x0265 }
        r7 = 0;
        r7 = r8[r7];	 Catch:{ RuntimeException -> 0x0265 }
        r4 = r4.m5628a(r5, r7);	 Catch:{ RuntimeException -> 0x0265 }
        r5 = com.google.android.gms.ads.internal.client.C0046n.m5409a();	 Catch:{ RuntimeException -> 0x0265 }
        r7 = r12.f3569l;	 Catch:{ RuntimeException -> 0x0265 }
        r9 = 1;
        r9 = r8[r9];	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r5.m5628a(r7, r9);	 Catch:{ RuntimeException -> 0x0265 }
        r1.showAtLocation(r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0265 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.m6397a(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r2 = new com.google.android.gms.ads.internal.client.AdSizeParcel;	 Catch:{ all -> 0x0020 }
        r3 = r12.f3569l;	 Catch:{ all -> 0x0020 }
        r4 = new com.google.android.gms.ads.c;	 Catch:{ all -> 0x0020 }
        r5 = r12.f3566i;	 Catch:{ all -> 0x0020 }
        r7 = r12.f3563f;	 Catch:{ all -> 0x0020 }
        r4.<init>(r5, r7);	 Catch:{ all -> 0x0020 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x0020 }
        r1.m6634a(r2);	 Catch:{ all -> 0x0020 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.m6401b(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = "resized";
        r12.m6388d(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01ce:
        r1 = r12.f3574q;	 Catch:{ all -> 0x0020 }
        r1.dismiss();	 Catch:{ all -> 0x0020 }
        goto L_0x00dd;
    L_0x01d5:
        r1 = "Webview is detached, probably in the middle of a resize or expand.";
        r12.m6386b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01dd:
        r1 = r3;
        goto L_0x0116;
    L_0x01e0:
        r5 = "top-left";
        r1 = r1.equals(r5);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01e8:
        r1 = r3;
        goto L_0x0156;
    L_0x01eb:
        r3 = "top-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01f3:
        r1 = r5;
        goto L_0x0156;
    L_0x01f6:
        r3 = "center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01fe:
        r1 = 2;
        goto L_0x0156;
    L_0x0201:
        r3 = "bottom-left";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0209:
        r1 = 3;
        goto L_0x0156;
    L_0x020c:
        r3 = "bottom-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0214:
        r1 = 4;
        goto L_0x0156;
    L_0x0217:
        r3 = "bottom-right";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x021f:
        r1 = 5;
        goto L_0x0156;
    L_0x0222:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x022e:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x023a:
        r1 = 13;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0241:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x024d:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0259:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0265:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0020 }
        r2.<init>();	 Catch:{ all -> 0x0020 }
        r3 = "Cannot show popup window: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0020 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0020 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0020 }
        r1 = r1.toString();	 Catch:{ all -> 0x0020 }
        r12.m6386b(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3575r;	 Catch:{ all -> 0x0020 }
        r2 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m6639b();	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3576s;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x02a8;
    L_0x028f:
        r1 = r12.f3576s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f3571n;	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3576s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m6639b();	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f3568k;	 Catch:{ all -> 0x0020 }
        r2 = r12.f3570m;	 Catch:{ all -> 0x0020 }
        r1.m6634a(r2);	 Catch:{ all -> 0x0020 }
    L_0x02a8:
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.dv.a(java.util.Map):void");
    }

    public void m6399a(boolean z) {
        synchronized (this.f3567j) {
            if (this.f3574q != null) {
                this.f3574q.dismiss();
                this.f3575r.removeView(this.f3568k.m6639b());
                if (this.f3576s != null) {
                    this.f3576s.removeView(this.f3571n);
                    this.f3576s.addView(this.f3568k.m6639b());
                    this.f3568k.m6634a(this.f3570m);
                }
                if (z) {
                    m6388d("default");
                    if (this.f3573p != null) {
                        this.f3573p.m6437a();
                    }
                }
                this.f3574q = null;
                this.f3575r = null;
                this.f3576s = null;
                this.f3572o = null;
            }
        }
    }

    boolean m6400a() {
        return this.f3566i > -1 && this.f3563f > -1;
    }

    void m6401b(int i, int i2) {
        m6383a(i, i2 - C0056g.m5439c().m6554d(this.f3569l)[0], this.f3566i, this.f3563f);
    }

    public boolean m6402b() {
        boolean z;
        synchronized (this.f3567j) {
            z = this.f3574q != null;
        }
        return z;
    }

    public void m6403c(int i, int i2) {
        this.f3561d = i;
        this.f3562e = i2;
    }

    boolean m6404c() {
        int[] b = C0056g.m5439c().m6549b(this.f3569l);
        int[] d = C0056g.m5439c().m6554d(this.f3569l);
        int i = b[0];
        int i2 = b[1];
        if (this.f3566i < 50 || this.f3566i > i) {
            C0099b.m5643d("Width is too small or too large.");
            return false;
        } else if (this.f3563f < 50 || this.f3563f > i2) {
            C0099b.m5643d("Height is too small or too large.");
            return false;
        } else if (this.f3563f == i2 && this.f3566i == i) {
            C0099b.m5643d("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.f3560c) {
                int i3;
                String str = this.f3559b;
                boolean z = true;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            z = false;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        i3 = this.f3564g + this.f3561d;
                        i2 = this.f3562e + this.f3565h;
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        i3 = ((this.f3561d + this.f3564g) + (this.f3566i / 2)) - 25;
                        i2 = this.f3562e + this.f3565h;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        i3 = ((this.f3561d + this.f3564g) + (this.f3566i / 2)) - 25;
                        i2 = ((this.f3562e + this.f3565h) + (this.f3563f / 2)) - 25;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        i3 = this.f3564g + this.f3561d;
                        i2 = ((this.f3562e + this.f3565h) + this.f3563f) - 50;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        i3 = ((this.f3561d + this.f3564g) + (this.f3566i / 2)) - 25;
                        i2 = ((this.f3562e + this.f3565h) + this.f3563f) - 50;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        i3 = ((this.f3561d + this.f3564g) + this.f3566i) - 50;
                        i2 = ((this.f3562e + this.f3565h) + this.f3563f) - 50;
                        break;
                    default:
                        i3 = ((this.f3561d + this.f3564g) + this.f3566i) - 50;
                        i2 = this.f3562e + this.f3565h;
                        break;
                }
                if (i3 < 0 || i3 + 50 > i || r2 < d[0] || r2 + 50 > d[1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
