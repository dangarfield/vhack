package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.fi;
import org.json.JSONException;
import org.json.JSONObject;

@fi
/* renamed from: com.google.android.gms.ads.internal.purchase.g */
public class C0086g {
    public int m5588a(Intent intent) {
        if (intent == null) {
            return 5;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            C0099b.m5643d("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            C0099b.m5643d("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public int m5589a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            C0099b.m5643d("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            C0099b.m5643d("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public String m5590a(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                C0099b.m5643d("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public String m5591b(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public String m5592c(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }
}
