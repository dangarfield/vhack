package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;
import org.json.JSONObject;

@fi
/* renamed from: com.google.android.gms.b.ef */
public class ef {
    private final hb f3547a;
    private final String f3548b;

    public ef(hb hbVar) {
        this(hbVar, "");
    }

    public ef(hb hbVar, String str) {
        this.f3547a = hbVar;
        this.f3548b = str;
    }

    public void m6383a(int i, int i2, int i3, int i4) {
        try {
            this.f3547a.m6261a("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            C0099b.m5640b("Error occured while dispatching size change.", e);
        }
    }

    public void m6384a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f3547a.m6261a("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (Throwable e) {
            C0099b.m5640b("Error occured while obtaining screen information.", e);
        }
    }

    public void m6385b(int i, int i2, int i3, int i4) {
        try {
            this.f3547a.m6261a("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            C0099b.m5640b("Error occured while dispatching default position.", e);
        }
    }

    public void m6386b(String str) {
        try {
            this.f3547a.m6261a("onError", new JSONObject().put("message", str).put("action", this.f3548b));
        } catch (Throwable e) {
            C0099b.m5640b("Error occurred while dispatching error event.", e);
        }
    }

    public void m6387c(String str) {
        try {
            this.f3547a.m6261a("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (Throwable e) {
            C0099b.m5640b("Error occured while dispatching ready Event.", e);
        }
    }

    public void m6388d(String str) {
        try {
            this.f3547a.m6261a("onStateChanged", new JSONObject().put("state", str));
        } catch (Throwable e) {
            C0099b.m5640b("Error occured while dispatching state change.", e);
        }
    }
}
