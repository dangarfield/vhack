package com.fyber.p040d.p041a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.fyber.Fyber;
import com.fyber.p025a.Credentials;
import com.fyber.p040d.VirtualCurrencyResponse;
import com.fyber.utils.StringUtils;

/* renamed from: com.fyber.d.a.c */
public class VirtualCurrencyPrefManager {
    private static VirtualCurrencyPrefManager f2718c;
    private final Credentials f2719a;
    private final SharedPreferences f2720b;

    public static VirtualCurrencyPrefManager m5153a(Context context) {
        if (f2718c == null) {
            synchronized (VirtualCurrencyPrefManager.class) {
                if (f2718c == null) {
                    f2718c = new VirtualCurrencyPrefManager(context);
                }
            }
        }
        return f2718c;
    }

    private VirtualCurrencyPrefManager(Context context) {
        this.f2720b = context.getSharedPreferences("FyberPreferences", 0);
        this.f2719a = Fyber.getConfigs().m4845e();
    }

    private String m5154c(String str) {
        if (StringUtils.m5259a(str)) {
            str = "";
        }
        return "STATE_LATEST_CURRENCY_TRANSACTION_ID_" + this.f2719a.m4847a() + "_" + this.f2719a.m4848b() + "_STATE_LATEST_TRANSACTION_CURRENCY_ID_" + str;
    }

    public final String m5155a() {
        return this.f2720b.getString("DEFAULT_CURRENCY_ID_KEY_" + this.f2719a.m4847a(), "");
    }

    public final void m5157a(String str) {
        this.f2720b.edit().putString("DEFAULT_CURRENCY_ID_KEY_" + this.f2719a.m4847a(), str).commit();
    }

    public final String m5158b(String str) {
        if (StringUtils.m5259a(str)) {
            str = m5155a();
        }
        if (StringUtils.m5259a(str)) {
            return "NO_TRANSACTION";
        }
        return this.f2720b.getString(m5154c(str), "NO_TRANSACTION");
    }

    public final void m5156a(VirtualCurrencyResponse virtualCurrencyResponse) {
        String b = virtualCurrencyResponse.m5160b();
        if (StringUtils.m5260b(b) && !b.equals("NO_TRANSACTION")) {
            Editor edit = this.f2720b.edit();
            edit.putString(m5154c(virtualCurrencyResponse.m5161c()), b);
            edit.commit();
        }
        if (virtualCurrencyResponse.m5163e()) {
            m5157a(virtualCurrencyResponse.m5161c());
        }
    }
}
