package com.fyber.cache.p039a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.fyber.cache.a.d */
public final class CacheConfigurationBuilder implements Serializable {
    private String f2668a;
    private Integer f2669b;
    private HashMap f2670c;

    public CacheConfigurationBuilder() {
        this.f2670c = new HashMap();
    }

    public final CacheConfigurationBuilder m5088a(String str) {
        this.f2668a = str;
        return this;
    }

    public final CacheConfigurationBuilder m5087a(Integer num) {
        this.f2669b = num;
        return this;
    }

    public final CacheConfigurationBuilder m5086a(CacheConfiguration cacheConfiguration, CacheNetworkPolicy cacheNetworkPolicy) {
        this.f2670c.put(cacheConfiguration, cacheNetworkPolicy);
        return this;
    }

    public final CacheConfiguration m5085a() {
        CacheConfiguration cacheConfiguration = new CacheConfiguration(this.f2668a, this.f2669b);
        for (Entry entry : this.f2670c.entrySet()) {
            cacheConfiguration.m5082a((CacheConfiguration) entry.getKey(), (CacheNetworkPolicy) entry.getValue());
        }
        return cacheConfiguration;
    }
}
