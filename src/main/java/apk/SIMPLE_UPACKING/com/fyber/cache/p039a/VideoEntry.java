package com.fyber.cache.p039a;

import java.io.Serializable;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.fyber.cache.a.k */
public final class VideoEntry implements Serializable {
    private final int f2689a;
    private final String f2690b;

    public VideoEntry(int i, String str) {
        this.f2689a = i;
        this.f2690b = str;
    }

    public VideoEntry(JSONObject jSONObject) {
        this.f2689a = jSONObject.getInt("ad_id");
        this.f2690b = jSONObject.getString("url");
    }

    public final int m5122a() {
        return this.f2689a;
    }

    public final String m5123b() {
        return this.f2690b;
    }

    public final int hashCode() {
        return this.f2689a;
    }

    public final boolean equals(Object obj) {
        return obj == this || obj.hashCode() == hashCode();
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "{\"ad_id\":%d, \"url\":\"%s\"}", new Object[]{Integer.valueOf(this.f2689a), this.f2690b});
    }
}
