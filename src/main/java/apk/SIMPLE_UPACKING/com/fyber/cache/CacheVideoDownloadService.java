package com.fyber.cache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.fyber.cache.p039a.CacheConfiguration;
import com.fyber.cache.p039a.CacheConfigurationBuilder;
import com.fyber.cache.p039a.CacheEntry;
import com.fyber.cache.p039a.CacheStore;
import com.fyber.cache.p039a.ConfigurationResponseParser;
import com.fyber.cache.p039a.VideoEntry;
import com.fyber.utils.FyberLogger;
import java.util.List;
import java.util.Locale;

/* renamed from: com.fyber.cache.b */
final class CacheVideoDownloadService extends Handler {
    final /* synthetic */ CacheVideoDownloadService f2698a;
    private SparseArray f2699b;
    private int f2700c;

    public CacheVideoDownloadService(CacheVideoDownloadService cacheVideoDownloadService, Looper looper) {
        this.f2698a = cacheVideoDownloadService;
        super(looper);
        this.f2699b = new SparseArray();
        this.f2700c = 0;
    }

    public final void handleMessage(Message message) {
        int i;
        switch (message.what) {
            case 200:
                if (this.f2698a.f2658f != CacheVideoDownloadService.f2705a) {
                    return;
                }
                if (m5141b()) {
                    FyberLogger.m5226c("CacheVideoDownloadService", "No more videos to download \\m/");
                    this.f2698a.f2654b.sendEmptyMessage(100);
                } else if (!this.f2698a.f2659g) {
                    m5140a();
                }
            case 1100:
                int i2;
                Object obj = message.obj;
                this.f2698a.f2658f = CacheVideoDownloadService.f2705a;
                this.f2700c = 0;
                this.f2699b.clear();
                if (obj != null) {
                    FyberLogger.m5226c("CacheVideoDownloadService", "Cache config received, parsing...");
                    ConfigurationResponseParser a = ConfigurationResponseParser.m5119a(obj.toString());
                    CacheConfigurationBuilder a2 = a.m5120a();
                    if (a2 != null) {
                        FyberLogger.m5226c("CacheVideoDownloadService", "Creating cache configuration object");
                        CacheConfiguration a3 = a2.m5085a();
                        CacheManager.m5127a().m5132a(a3);
                        List<VideoEntry> b = a.m5121b();
                        if (!b.isEmpty()) {
                            int c = CacheManager.m5127a().m5134b().m5084c();
                            i = 0;
                            for (VideoEntry put : b) {
                                this.f2699b.put(i, put);
                                i2 = i + 1;
                                if (i2 == c) {
                                    FyberLogger.m5226c("CacheVideoDownloadService", String.format(Locale.ENGLISH, "There are %d videos to download and the maximum cache slots size is %d", new Object[]{Integer.valueOf(b.size()), Integer.valueOf(c)}));
                                    FyberLogger.m5226c("CacheVideoDownloadService", "Trimming the list of new videos to download to " + c);
                                    m5142c();
                                    CacheManager.m5127a().m5135c().m5114a(a3.m5084c());
                                    sendEmptyMessage(200);
                                } else {
                                    i = i2;
                                }
                            }
                            m5142c();
                            CacheManager.m5127a().m5135c().m5114a(a3.m5084c());
                            sendEmptyMessage(200);
                        }
                    }
                }
                CacheConfiguration b2 = CacheManager.m5127a().m5134b();
                if (b2 != null) {
                    i2 = b2.m5083b();
                    FyberLogger.m5226c("CacheVideoDownloadService", "Cache configuration exists, refresh interval is " + i2);
                } else {
                    i2 = 3600;
                }
                m5072b(this.f2698a, i2);
            case 1160:
                String obj2 = message.obj.toString();
                i = message.arg1;
                int i3 = message.arg2;
                CacheStore c2 = CacheManager.m5127a().m5135c();
                CacheEntry a4 = c2.m5112a(obj2);
                if (a4 != null) {
                    FyberLogger.m5226c("CacheVideoDownloadService", "Updating entry " + a4.m5093b() + " with state " + i3);
                    a4.m5091a(i3);
                    c2.m5115b();
                    if (i3 == 2) {
                        m5139a(i);
                        FyberLogger.m5226c("CacheVideoDownloadService", "Reason - File fully downloaded");
                    } else if (i3 == 4) {
                        m5139a(i);
                        FyberLogger.m5226c("CacheVideoDownloadService", "Reason - File not downloadable (file not found or no space left)");
                    } else if (a4.m5095d() > 10) {
                        m5139a(i);
                        FyberLogger.m5226c("CacheVideoDownloadService", "Reason - Maximum retry count reached");
                    }
                } else {
                    FyberLogger.m5226c("CacheVideoDownloadService", "There was no cache entry for the url: " + obj2);
                    m5139a(i);
                }
                if (!message.getData().getBoolean("canceled", false)) {
                    sendEmptyMessage(200);
                }
            case 1300:
                this.f2698a.f2654b.sendEmptyMessage(300);
            case 1310:
                sendEmptyMessage(200);
            default:
        }
    }

    private void m5139a(int i) {
        FyberLogger.m5226c("CacheVideoDownloadService", "Removing videos to cache, entry num " + i);
        this.f2699b.put(i, null);
        this.f2700c++;
    }

    private boolean m5140a() {
        CacheConfiguration h = m5079h(this.f2698a);
        if (h != null) {
            FyberLogger.m5226c("CacheVideoDownloadService", "Queuing video for network " + h.name());
            CacheManager a = CacheManager.m5127a();
            CacheConfiguration b = a.m5134b();
            int c = b.m5084c();
            CacheStore c2 = a.m5135c();
            int a2 = b.m5080a(h).m5099a();
            int i = 0;
            while (i < this.f2699b.size() && i < a2) {
                VideoEntry videoEntry = (VideoEntry) this.f2699b.get(i);
                if (videoEntry != null) {
                    FyberLogger.m5226c("CacheVideoDownloadService", "Queuing video entry for ad_id " + videoEntry.m5122a() + " and URL " + videoEntry.m5123b());
                    boolean z = c2.m5112a(videoEntry.m5123b()) == null;
                    CacheEntry a3 = c2.m5111a(videoEntry);
                    int c3 = a3.m5094c();
                    if (c3 == 0 || c3 == 1) {
                        if (z) {
                            c2.m5116b(c2.m5113a().size() - c);
                        }
                        a3.m5091a(3);
                        Message obtainMessage = this.f2698a.f2655c.obtainMessage(200, a3);
                        obtainMessage.arg1 = i;
                        obtainMessage.sendToTarget();
                        return true;
                    } else if (c3 == 4) {
                        FyberLogger.m5226c("CacheVideoDownloadService", "The file is marked as NOT_DOWNLOADABLE. Removing it from the current download list.");
                        m5139a(i);
                    } else {
                        FyberLogger.m5226c("CacheVideoDownloadService", "This cache entry will not be queued for download. Current state: " + c3);
                    }
                }
                i++;
            }
        }
        FyberLogger.m5226c("CacheVideoDownloadService", "No videos to be queued for download at the moment");
        if (m5141b()) {
            this.f2698a.f2654b.sendEmptyMessage(100);
        }
        return false;
    }

    private boolean m5141b() {
        return this.f2700c == this.f2699b.size();
    }

    private void m5142c() {
        FyberLogger.m5226c("CacheVideoDownloadService", "Checking videos already available locally...");
        CacheStore c = CacheManager.m5127a().m5135c();
        for (int i = 0; i < this.f2699b.size(); i++) {
            VideoEntry videoEntry = (VideoEntry) this.f2699b.get(i);
            if (videoEntry != null) {
                FyberLogger.m5226c("CacheVideoDownloadService", "Video entry for ad_id " + videoEntry.m5122a() + " and url " + videoEntry.m5123b());
                CacheEntry a = c.m5112a(videoEntry.m5123b());
                if (a != null) {
                    FyberLogger.m5226c("CacheVideoDownloadService", "A cache entry already exists for url - " + a.m5093b());
                    if (a.m5092a(videoEntry)) {
                        FyberLogger.m5226c("CacheVideoDownloadService", "Video entry successfully added to cache entry");
                    } else {
                        FyberLogger.m5226c("CacheVideoDownloadService", "The video entry was already part of this cache entry");
                    }
                    a.m5096e();
                    c.m5115b();
                    if (a.m5094c() == 2) {
                        FyberLogger.m5226c("CacheVideoDownloadService", "Cache entry is already fully downloaded");
                        FyberLogger.m5226c("CacheVideoDownloadService", "Removing URL " + a.m5093b() + " from the new downloads list");
                        this.f2699b.put(i, null);
                        this.f2700c++;
                    }
                }
            }
        }
    }
}
