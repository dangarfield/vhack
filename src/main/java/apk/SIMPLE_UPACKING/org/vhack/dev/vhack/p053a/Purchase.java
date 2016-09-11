package org.vhack.dev.vhack.p053a;

import org.json.JSONObject;

/* renamed from: org.vhack.dev.vhack.a.o */
public class Purchase {
    String f5244a;
    String f5245b;
    String f5246c;
    String f5247d;
    long f5248e;
    int f5249f;
    String f5250g;
    String f5251h;
    String f5252i;
    String f5253j;

    public Purchase(String str, String str2, String str3) {
        this.f5244a = str;
        this.f5252i = str2;
        JSONObject jSONObject = new JSONObject(this.f5252i);
        this.f5245b = jSONObject.optString("orderId");
        this.f5246c = jSONObject.optString("packageName");
        this.f5247d = jSONObject.optString("productId");
        this.f5248e = jSONObject.optLong("purchaseTime");
        this.f5249f = jSONObject.optInt("purchaseState");
        this.f5250g = jSONObject.optString("developerPayload");
        this.f5251h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.f5253j = str3;
    }

    public String m9063a() {
        return this.f5247d;
    }

    public String m9064b() {
        return this.f5251h;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.f5244a + "):" + this.f5252i;
    }
}
