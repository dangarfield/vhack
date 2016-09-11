package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;
import org.json.JSONObject;

@fi
/* renamed from: com.google.android.gms.b.eb */
public class eb {
    private final boolean f3587a;
    private final boolean f3588b;
    private final boolean f3589c;
    private final boolean f3590d;
    private final boolean f3591e;

    private eb(ed edVar) {
        this.f3587a = edVar.f3592a;
        this.f3588b = edVar.f3593b;
        this.f3589c = edVar.f3594c;
        this.f3590d = edVar.f3595d;
        this.f3591e = edVar.f3596e;
    }

    public JSONObject m6414a() {
        try {
            return new JSONObject().put("sms", this.f3587a).put("tel", this.f3588b).put("calendar", this.f3589c).put("storePicture", this.f3590d).put("inlineVideo", this.f3591e);
        } catch (Throwable e) {
            C0099b.m5640b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
