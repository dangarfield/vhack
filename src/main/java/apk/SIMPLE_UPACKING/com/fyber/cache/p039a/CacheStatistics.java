package com.fyber.cache.p039a;

import android.content.Context;
import android.content.SharedPreferences;
import com.fyber.cache.CacheManager;
import org.json.JSONArray;

/* renamed from: com.fyber.cache.a.g */
public final class CacheStatistics {
    public static final CacheStatistics f2678a;
    private final SharedPreferences f2679b;
    private volatile int f2680c;

    static {
        f2678a = new CacheStatistics();
    }

    protected CacheStatistics() {
        this.f2679b = null;
    }

    public CacheStatistics(Context context) {
        this.f2679b = context.getSharedPreferences("FyberCacheStatistics", 0);
        this.f2680c = this.f2679b.getInt("download.count", 0);
    }

    public final int m5102a() {
        return this.f2680c;
    }

    public final void m5103b() {
        this.f2680c++;
        m5101e();
    }

    public final void m5104c() {
        this.f2680c = 0;
        m5101e();
    }

    public static String m5100d() {
        JSONArray jSONArray = new JSONArray();
        CacheStore c = CacheManager.m5127a().m5135c();
        if (c != null) {
            for (CacheEntry cacheEntry : c.m5113a().values()) {
                if (cacheEntry.m5094c() == 2 && cacheEntry.m5090a().exists()) {
                    for (VideoEntry a : cacheEntry.m5097f()) {
                        jSONArray.put(a.m5122a());
                    }
                }
            }
        }
        return jSONArray.toString();
    }

    private void m5101e() {
        if (this.f2679b != null) {
            this.f2679b.edit().putInt("download.count", this.f2680c).apply();
        }
    }
}
