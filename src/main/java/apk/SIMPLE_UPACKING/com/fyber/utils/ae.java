package com.fyber.utils;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.SparseArray;
import com.fyber.p025a.Credentials;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

/* compiled from: UrlBuilder */
public final class ae {
    private static SparseArray f2779a;
    private String f2780b;
    private Credentials f2781c;
    private String f2782d;
    private String f2783e;
    private Map f2784f;
    private boolean f2785g;
    private boolean f2786h;
    private boolean f2787i;
    private boolean f2788j;
    private boolean f2789k;
    private boolean f2790l;
    private boolean f2791m;

    private ae(String str, Credentials credentials) {
        this.f2785g = false;
        this.f2786h = false;
        this.f2787i = true;
        this.f2788j = false;
        this.f2789k = false;
        this.f2790l = false;
        this.f2791m = false;
        this.f2780b = str;
        this.f2781c = credentials;
    }

    public final ae m5241a(Map map) {
        if (map != null) {
            m5237e().putAll(map);
        }
        return this;
    }

    public final ae m5240a(String str, String str2) {
        if (StringUtils.m5260b(str)) {
            m5237e().put(str, str2);
        }
        return this;
    }

    public final ae m5238a() {
        this.f2785g = true;
        return this;
    }

    public final ae m5242a(boolean z) {
        this.f2787i = z;
        return this;
    }

    public final ae m5243b() {
        this.f2789k = true;
        this.f2788j = true;
        return this;
    }

    public final ae m5245c() {
        this.f2790l = true;
        return this;
    }

    public final ae m5239a(String str) {
        this.f2783e = str;
        return this;
    }

    public final String m5246d() {
        String str;
        Map hashMap = new HashMap();
        m5236a(hashMap, 6);
        if (MapUtils.m5321b(this.f2784f)) {
            hashMap.putAll(this.f2784f);
        }
        hashMap.put("appid", this.f2781c.m4847a());
        if (this.f2787i) {
            hashMap.put("uid", this.f2781c.m4848b());
        }
        m5236a(hashMap, 0);
        m5236a(hashMap, 2);
        m5236a(hashMap, 1);
        if (this.f2783e != null) {
            hashMap.put("placement_id", this.f2783e);
        }
        if (this.f2785g) {
            m5236a(hashMap, 3);
        }
        if (this.f2786h) {
            m5236a(hashMap, 4);
        }
        if (this.f2788j) {
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        }
        m5236a(hashMap, 5);
        if (StringUtils.m5260b(this.f2782d)) {
            hashMap.put("request_id", this.f2782d);
        } else if (this.f2790l) {
            hashMap.put("request_id", UUID.randomUUID().toString());
        }
        Builder buildUpon = Uri.parse(this.f2780b).buildUpon();
        for (Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            if (entry.getValue() != null) {
                str = (String) entry.getValue();
            } else {
                str = "";
            }
            buildUpon.appendQueryParameter(str2, str);
        }
        if (this.f2789k) {
            str = this.f2781c.m4849c();
            if (StringUtils.m5260b(str)) {
                buildUpon.appendQueryParameter("signature", ac.m5233a(hashMap, str));
            } else {
                FyberLogger.m5223b("UrlBuilder", "It was impossible to add the signature, the SecretKey has not been provided");
            }
        }
        if (this.f2791m) {
            buildUpon.scheme("http");
        }
        return buildUpon.build().toString();
    }

    private static void m5236a(Map map, int i) {
        ParametersProvider parametersProvider = (ParametersProvider) f2779a.get(i);
        if (parametersProvider != null) {
            map.putAll(parametersProvider.m5228a());
        }
    }

    private Map m5237e() {
        if (this.f2784f == null) {
            this.f2784f = new HashMap();
        }
        return this.f2784f;
    }

    public static ae m5235a(String str, Credentials credentials) {
        return new ae(str, credentials);
    }

    public final ae m5244b(String str) {
        this.f2782d = str;
        return this;
    }

    static {
        SparseArray sparseArray = new SparseArray(7);
        sparseArray.put(6, new GlobalParamsProvider());
        sparseArray.put(3, new HostInfo());
        sparseArray.put(4, new HostInfo());
        sparseArray.put(5, new HostInfo());
        sparseArray.put(2, new HostInfo());
        sparseArray.put(1, new HostInfo());
        sparseArray.put(0, new aa());
        f2779a = sparseArray;
    }
}
