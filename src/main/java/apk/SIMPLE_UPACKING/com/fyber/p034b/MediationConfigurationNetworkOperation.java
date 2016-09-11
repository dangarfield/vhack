package com.fyber.p034b;

import android.app.Activity;
import android.content.SharedPreferences;
import com.fyber.Fyber;
import com.fyber.p025a.Credentials;
import com.fyber.utils.FyberBaseUrlProvider;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.StringUtils;
import com.fyber.utils.ae;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.fyber.b.e */
public final class MediationConfigurationNetworkOperation extends SignedResponseNetworkOperation {
    private SharedPreferences f2623c;

    protected final /* synthetic */ Object m5032a(Object obj) {
        return m5028b((String) obj);
    }

    public static Future m5027a(Credentials credentials, Activity activity) {
        ae b = ae.m5235a(FyberBaseUrlProvider.m5274a("config"), credentials).m5243b();
        if (Fyber.getConfigs().m4844d()) {
            return Fyber.getConfigs().m4840a(new MediationConfigurationNetworkOperation(b, credentials.m4849c(), activity));
        }
        return null;
    }

    private MediationConfigurationNetworkOperation(ae aeVar, String str, Activity activity) {
        super(aeVar, str);
        this.f2623c = activity.getSharedPreferences("MediationConfigurationNetworkOperation", 0);
    }

    private Map m5028b(String str) {
        if (StringUtils.m5259a(str)) {
            FyberLogger.m5223b("MediationConfigurationNetworkOperation", "No configs from the server, fallback to cached version.");
            str = this.f2623c.getString("MediationConfigurationNetworkOperation", "");
            if (StringUtils.m5259a(str)) {
                FyberLogger.m5223b("MediationConfigurationNetworkOperation", "There were no cached version to use.");
            } else {
                FyberLogger.m5223b("MediationConfigurationNetworkOperation", "Using cached json file.");
            }
        }
        return MediationConfigurationNetworkOperation.m5029c(str);
    }

    protected final boolean m5034a() {
        return true;
    }

    protected final String m5035b() {
        return "MediationConfigurationNetworkOperation";
    }

    private static Map m5029c(String str) {
        FyberLogger.m5223b("MediationConfigurationNetworkOperation", "Reading config file");
        Map hashMap = new HashMap();
        if (StringUtils.m5260b(str)) {
            try {
                FyberLogger.m5223b("MediationConfigurationNetworkOperation", "Parsing configurations");
                JSONArray jSONArray = new JSONObject(str).getJSONArray("adapters");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String toLowerCase = jSONObject.getString("name").toLowerCase(Locale.ENGLISH);
                    if (jSONObject.has("settings")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("settings");
                        Map hashMap2 = new HashMap(jSONObject2.length());
                        Iterator keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String str2 = (String) keys.next();
                            hashMap2.put(str2, jSONObject2.get(str2));
                        }
                        hashMap.put(toLowerCase, hashMap2);
                    } else {
                        hashMap.put(toLowerCase, Collections.emptyMap());
                    }
                }
                FyberLogger.m5223b("MediationConfigurationNetworkOperation", "configuration loaded successfully");
            } catch (Exception e) {
                FyberLogger.m5221a("MediationConfigurationNetworkOperation", "A JSON error occurred while parsing the configuration file, there will be no mediation configurations.", e);
            }
        } else {
            FyberLogger.m5223b("MediationConfigurationNetworkOperation", "Configuration was not found, there will be no mediation configurations.");
        }
        return hashMap;
    }

    protected final /* synthetic */ Object m5033a(String str) {
        FyberLogger.m5223b("MediationConfigurationNetworkOperation", "The signature is valid, proceeding...");
        String str2 = "";
        if (!StringUtils.m5260b(str)) {
            return str2;
        }
        if (this.f2623c.edit().putString("MediationConfigurationNetworkOperation", str).commit()) {
            FyberLogger.m5223b("MediationConfigurationNetworkOperation", "Server Side Configuration has been saved successfully.");
            return str;
        }
        FyberLogger.m5223b("MediationConfigurationNetworkOperation", "Failed to save Server Side Configuration.");
        return str;
    }

    protected final /* synthetic */ Object m5030a(int i, String str, String str2) {
        if (!m5026a(str, str2)) {
            FyberLogger.m5223b("MediationConfigurationNetworkOperation", "Invalid signature, those configs will not be used.");
        }
        return "";
    }

    protected final /* synthetic */ Object m5031a(IOException iOException) {
        FyberLogger.m5223b("MediationConfigurationNetworkOperation", "Connection error - " + iOException.getMessage());
        return m5028b("");
    }
}
