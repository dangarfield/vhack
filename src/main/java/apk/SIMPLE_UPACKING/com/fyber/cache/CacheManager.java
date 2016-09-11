package com.fyber.cache;

import android.content.Context;
import android.content.Intent;
import com.fyber.cache.p039a.CacheStatistics;
import com.fyber.cache.p039a.CacheStore;
import com.fyber.utils.FyberLogger;

/* renamed from: com.fyber.cache.f */
final class CacheManager implements Runnable {
    final /* synthetic */ Context f2709a;
    final /* synthetic */ CacheManager f2710b;

    CacheManager(CacheManager cacheManager, Context context) {
        this.f2710b = cacheManager;
        this.f2709a = context;
    }

    public final void run() {
        if (this.f2710b.f2692b.equals(CacheStore.f2681a)) {
            this.f2710b.f2692b = new CacheStore(this.f2709a);
            this.f2710b.f2694d = new CacheStatistics(this.f2709a);
        }
        if (this.f2710b.f2692b.m5117c()) {
            this.f2709a.startService(new Intent(this.f2709a, CacheVideoDownloadService.class));
            return;
        }
        FyberLogger.m5226c("FybCacheManager", "Cache is not enabled.");
    }
}
