package com.fyber.cache.p039a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.utils.FyberLogger;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.fyber.cache.a.h */
public final class CacheStore {
    public static final CacheStore f2681a;
    private final File f2682b;
    private final boolean f2683c;
    private final SharedPreferences f2684d;
    private Map f2685e;

    static {
        f2681a = new CacheStore();
    }

    protected CacheStore() {
        this.f2683c = false;
        this.f2682b = null;
        this.f2684d = null;
        this.f2685e = new HashMap();
    }

    public CacheStore(Context context) {
        File file = new File(context.getCacheDir(), "FyberVideoCache");
        if (!file.exists()) {
            FyberLogger.m5223b("CacheStore", "The cache directory does not exist, creating...");
            file.mkdirs();
        }
        this.f2682b = file;
        this.f2684d = context.getSharedPreferences("FyberCacheStorage", 0);
        this.f2683c = m5106d();
    }

    private boolean m5106d() {
        try {
            this.f2685e = new HashMap();
            if (this.f2684d.getAll().isEmpty()) {
                m5109g();
            } else {
                try {
                    JSONArray jSONArray = new JSONObject(this.f2684d.getString("FyberCacheStorage", "{\"cache\":[]}")).getJSONArray("cache");
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        CacheEntry cacheEntry = new CacheEntry(jSONArray.getJSONObject(i));
                        this.f2685e.put(Uri.parse(cacheEntry.m5093b()).getEncodedSchemeSpecificPart(), cacheEntry);
                    }
                } catch (JSONException e) {
                    m5109g();
                }
            }
            m5107e();
            if (this.f2682b.exists() && this.f2682b.isDirectory()) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            this.f2685e = new HashMap();
            return false;
        }
    }

    private void m5107e() {
        int i = 0;
        for (CacheEntry cacheEntry : this.f2685e.values()) {
            int i2;
            if (cacheEntry.m5090a().exists()) {
                i2 = i;
            } else {
                FyberLogger.m5223b("CacheStore", "Local file for cache entry " + cacheEntry.m5093b() + " was removed.");
                cacheEntry.m5091a(0);
                i2 = 1;
            }
            i = i2;
        }
        if (i != 0) {
            FyberLogger.m5223b("CacheStore", "Saving Cache file.");
            m5108f();
        }
    }

    public final CacheEntry m5112a(String str) {
        return (CacheEntry) this.f2685e.get(Uri.parse(str).getEncodedSchemeSpecificPart());
    }

    public final Map m5113a() {
        return this.f2685e;
    }

    public final CacheEntry m5111a(VideoEntry videoEntry) {
        CacheEntry cacheEntry;
        String b = videoEntry.m5123b();
        String encodedSchemeSpecificPart = Uri.parse(b).getEncodedSchemeSpecificPart();
        if (!this.f2683c) {
            cacheEntry = new CacheEntry(m5110h(), b, 4);
        } else if (this.f2685e.containsKey(encodedSchemeSpecificPart)) {
            cacheEntry = (CacheEntry) this.f2685e.get(encodedSchemeSpecificPart);
        } else {
            cacheEntry = new CacheEntry(m5110h(), b, 0);
            this.f2685e.put(encodedSchemeSpecificPart, cacheEntry);
        }
        cacheEntry.m5092a(videoEntry);
        m5108f();
        return cacheEntry;
    }

    public final void m5115b() {
        m5108f();
    }

    public static String m5105a(Collection collection) {
        return String.format(Locale.ENGLISH, "{\"cache\":[%s]}", new Object[]{TextUtils.join(",", collection)});
    }

    private void m5109g() {
        FyberLogger.m5223b("CacheStore", "Cache storage file recovering issue, purging the local files...");
        File[] listFiles = this.f2682b.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    private File m5110h() {
        File file = new File(this.f2682b, UUID.randomUUID().toString());
        if (file.exists()) {
            FyberLogger.m5226c("CacheStore", "Video already exists in cache: " + file.getAbsolutePath());
            file = m5110h();
        }
        FyberLogger.m5226c("CacheStore", "Save in file: " + file.getAbsolutePath());
        return file;
    }

    public final void m5114a(int i) {
        if (i >= 0 && i < this.f2685e.size()) {
            FyberLogger.m5226c("CacheStore", "Trimming cache to " + i + " slots");
            m5116b(this.f2685e.size() - i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m5116b(int r4) {
        /*
        r3 = this;
        if (r4 <= 0) goto L_0x0085;
    L_0x0002:
        r0 = r3.f2685e;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0085;
    L_0x000a:
        r0 = "CacheStore";
        r1 = new java.lang.StringBuilder;
        r2 = "Freeing up ";
        r1.<init>(r2);
        r1 = r1.append(r4);
        r2 = " cache slots";
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.fyber.utils.FyberLogger.m5226c(r0, r1);
        r1 = new java.util.TreeSet;
        r0 = new com.fyber.cache.a.i;
        r2 = 0;
        r0.<init>();
        r1.<init>(r0);
        r0 = r3.f2685e;
        r0 = r0.values();
        r1.addAll(r0);
    L_0x0038:
        r0 = r1.pollFirst();
        r0 = (com.fyber.cache.p039a.CacheEntry) r0;
        if (r0 == 0) goto L_0x0065;
    L_0x0040:
        if (r4 <= 0) goto L_0x0065;
    L_0x0042:
        r0 = r0.m5093b();
        r2 = r3.f2685e;
        r0 = android.net.Uri.parse(r0);
        r0 = r0.getEncodedSchemeSpecificPart();
        r0 = r2.remove(r0);
        r0 = (com.fyber.cache.p039a.CacheEntry) r0;
        if (r0 == 0) goto L_0x0062;
    L_0x0058:
        r0 = r0.m5090a();
        r0.delete();
        r3.m5108f();
    L_0x0062:
        r4 = r4 + -1;
        goto L_0x0038;
    L_0x0065:
        r0 = "CacheStore";
        r1 = new java.lang.StringBuilder;
        r2 = "Current cache size: ";
        r1.<init>(r2);
        r2 = r3.f2685e;
        r2 = r2.size();
        r1 = r1.append(r2);
        r2 = " slots";
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.fyber.utils.FyberLogger.m5226c(r0, r1);
    L_0x0085:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.cache.a.h.b(int):void");
    }

    public final boolean m5117c() {
        return this.f2683c;
    }

    private void m5108f() {
        if (this.f2683c) {
            this.f2684d.edit().putString("FyberCacheStorage", CacheStore.m5105a(this.f2685e.values())).apply();
        }
    }
}
