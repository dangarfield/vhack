package com.google.android.gms.p051b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.client.C0046n;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.ee */
public class ee extends ef implements ce {
    DisplayMetrics f3597a;
    int f3598b;
    int f3599c;
    int f3600d;
    int f3601e;
    int f3602f;
    int f3603g;
    private final hb f3604h;
    private final Context f3605i;
    private final WindowManager f3606j;
    private final ad f3607k;
    private float f3608l;
    private int f3609m;

    public ee(hb hbVar, Context context, ad adVar) {
        super(hbVar);
        this.f3598b = -1;
        this.f3599c = -1;
        this.f3600d = -1;
        this.f3601e = -1;
        this.f3602f = -1;
        this.f3603g = -1;
        this.f3604h = hbVar;
        this.f3605i = context;
        this.f3607k = adVar;
        this.f3606j = (WindowManager) context.getSystemService("window");
    }

    private void m6426g() {
        this.f3597a = new DisplayMetrics();
        Display defaultDisplay = this.f3606j.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f3597a);
        this.f3608l = this.f3597a.density;
        this.f3609m = defaultDisplay.getRotation();
    }

    private void m6427h() {
        int[] iArr = new int[2];
        this.f3604h.getLocationOnScreen(iArr);
        m6430a(C0046n.m5409a().m5632b(this.f3605i, iArr[0]), C0046n.m5409a().m5632b(this.f3605i, iArr[1]));
    }

    private eb m6428i() {
        return new ed().m6422b(this.f3607k.m6078a()).m6421a(this.f3607k.m6080b()).m6423c(this.f3607k.m6083f()).m6424d(this.f3607k.m6081c()).m6425e(this.f3607k.m6082d()).m6420a();
    }

    void m6429a() {
        this.f3598b = C0046n.m5409a().m5633b(this.f3597a, this.f3597a.widthPixels);
        this.f3599c = C0046n.m5409a().m5633b(this.f3597a, this.f3597a.heightPixels);
        Activity e = this.f3604h.m6646e();
        if (e == null || e.getWindow() == null) {
            this.f3600d = this.f3598b;
            this.f3601e = this.f3599c;
            return;
        }
        int[] a = C0056g.m5439c().m6543a(e);
        this.f3600d = C0046n.m5409a().m5633b(this.f3597a, a[0]);
        this.f3601e = C0046n.m5409a().m5633b(this.f3597a, a[1]);
    }

    public void m6430a(int i, int i2) {
        m6385b(i, i2 - (this.f3605i instanceof Activity ? C0056g.m5439c().m6554d((Activity) this.f3605i)[0] : 0), this.f3602f, this.f3603g);
        this.f3604h.m6652k().m6677a(i, i2);
    }

    public void m6431a(hb hbVar, Map map) {
        m6433c();
    }

    void m6432b() {
        if (this.f3604h.m6651j().f2913e) {
            this.f3602f = this.f3598b;
            this.f3603g = this.f3599c;
            return;
        }
        this.f3604h.measure(0, 0);
        this.f3602f = C0046n.m5409a().m5632b(this.f3605i, this.f3604h.getMeasuredWidth());
        this.f3603g = C0046n.m5409a().m5632b(this.f3605i, this.f3604h.getMeasuredHeight());
    }

    public void m6433c() {
        m6426g();
        m6429a();
        m6432b();
        m6435e();
        m6436f();
        m6427h();
        m6434d();
    }

    void m6434d() {
        if (C0099b.m5638a(2)) {
            C0099b.m5641c("Dispatching Ready Event.");
        }
        m6387c(this.f3604h.m6655n().f3092b);
    }

    void m6435e() {
        m6384a(this.f3598b, this.f3599c, this.f3600d, this.f3601e, this.f3608l, this.f3609m);
    }

    void m6436f() {
        this.f3604h.m6261a("onDeviceFeaturesReceived", m6428i().m6414a());
    }
}
