package com.fyber.cache.p039a;

import com.fyber.utils.FyberLogger;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.fyber.cache.a.j */
public final class ConfigurationResponseParser {
    private CacheConfigurationBuilder f2686a;
    private JSONObject f2687b;
    private ArrayList f2688c;

    public static ConfigurationResponseParser m5119a(String str) {
        return new ConfigurationResponseParser(str);
    }

    private ConfigurationResponseParser(String str) {
        this.f2686a = null;
        this.f2687b = null;
        this.f2688c = new ArrayList();
        FyberLogger.m5226c("ConfigurationResponseParser", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f2687b = jSONObject.getJSONObject("config");
            this.f2686a = ConfigurationResponseParser.m5118a(this.f2687b);
            JSONArray jSONArray = jSONObject.getJSONArray("videos");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                this.f2688c.add(new VideoEntry(jSONObject2.getInt("ad_id"), jSONObject2.getString("url")));
            }
        } catch (JSONException e) {
            FyberLogger.m5223b("ConfigurationResponseParser", e.getLocalizedMessage());
        }
    }

    private static CacheConfigurationBuilder m5118a(JSONObject jSONObject) {
        String string = jSONObject.getString("id");
        Integer num = null;
        if (jSONObject.has("refresh_interval")) {
            try {
                num = Integer.valueOf(jSONObject.getInt("refresh_interval"));
            } catch (JSONException e) {
            }
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("network_policy");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("wifi");
        jSONObject2 = jSONObject2.getJSONObject("cellular");
        CacheNetworkPolicy cacheNetworkPolicy = new CacheNetworkPolicy(jSONObject3.getInt("max_download_count"));
        return new CacheConfigurationBuilder().m5086a(CacheConfiguration.WIFI, cacheNetworkPolicy).m5086a(CacheConfiguration.CELLULAR, new CacheNetworkPolicy(jSONObject2.getInt("max_download_count"))).m5087a(num).m5088a(string);
    }

    public final CacheConfigurationBuilder m5120a() {
        return this.f2686a;
    }

    public final ArrayList m5121b() {
        return this.f2688c;
    }
}
