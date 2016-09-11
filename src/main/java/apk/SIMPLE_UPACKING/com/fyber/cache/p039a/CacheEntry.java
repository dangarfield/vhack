package com.fyber.cache.p039a;

import android.text.TextUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.fyber.cache.a.e */
public final class CacheEntry implements Serializable {
    private final File f2671a;
    private final String f2672b;
    private int f2673c;
    private Set f2674d;
    private long f2675e;
    private int f2676f;

    public CacheEntry(File file, String str, int i) {
        this.f2674d = new HashSet();
        this.f2676f = 0;
        this.f2671a = file;
        this.f2672b = str;
        this.f2673c = i;
        m5089h();
    }

    public CacheEntry(JSONObject jSONObject) {
        int i = 0;
        this.f2674d = new HashSet();
        this.f2676f = 0;
        this.f2671a = new File(jSONObject.getString("local_file"));
        this.f2672b = jSONObject.getString("remote_url");
        this.f2673c = jSONObject.getInt("download_state");
        this.f2676f = jSONObject.getInt("retries");
        this.f2675e = jSONObject.getLong("created_at");
        this.f2674d = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("video_entries");
        int length = jSONArray.length();
        while (i < length) {
            this.f2674d.add(new VideoEntry(jSONArray.getJSONObject(i)));
            i++;
        }
    }

    public final File m5090a() {
        return this.f2671a;
    }

    public final String m5093b() {
        return this.f2672b;
    }

    public final int m5094c() {
        return this.f2673c;
    }

    public final void m5091a(int i) {
        this.f2673c = i;
        if (i == 1) {
            this.f2676f++;
        }
    }

    public final int m5095d() {
        return this.f2676f;
    }

    public final void m5096e() {
        this.f2676f = 0;
    }

    public final Set m5097f() {
        return this.f2674d;
    }

    public final boolean m5092a(VideoEntry videoEntry) {
        boolean add = this.f2674d.add(videoEntry);
        m5089h();
        return add;
    }

    private void m5089h() {
        this.f2675e = Calendar.getInstance().getTimeInMillis();
    }

    public final long m5098g() {
        return this.f2675e;
    }

    public final String toString() {
        String join = TextUtils.join(",", this.f2674d);
        return String.format(Locale.ENGLISH, "{\"local_file\":\"%s\", \"remote_url\":\"%s\",\"download_state\":%d,\"created_at\":%d,\"retries\":%d,\"video_entries\":[%s]}", new Object[]{this.f2671a.getAbsolutePath(), this.f2672b, Integer.valueOf(this.f2673c), Long.valueOf(this.f2675e), Integer.valueOf(this.f2676f), join});
    }

    public final int hashCode() {
        return this.f2672b.hashCode();
    }

    public final boolean equals(Object obj) {
        return obj == this || obj.hashCode() == hashCode();
    }
}
