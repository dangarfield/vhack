package org.vhack.dev.vhack.a;

import org.json.JSONObject;

/* compiled from: Purchase */
public class o {
    String a;
    String b;
    String c;
    String d;
    long e;
    int f;
    String g;
    String h;
    String i;
    String j;

    public o(String str, String str2, String str3) {
        this.a = str;
        this.i = str2;
        JSONObject jSONObject = new JSONObject(this.i);
        this.b = jSONObject.optString("orderId");
        this.c = jSONObject.optString("packageName");
        this.d = jSONObject.optString("productId");
        this.e = jSONObject.optLong("purchaseTime");
        this.f = jSONObject.optInt("purchaseState");
        this.g = jSONObject.optString("developerPayload");
        this.h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.j = str3;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.h;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.a + "):" + this.i;
    }
}
