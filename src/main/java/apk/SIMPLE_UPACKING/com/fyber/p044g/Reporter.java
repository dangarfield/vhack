package com.fyber.p044g;

import android.content.Context;
import android.util.Log;
import com.fyber.p025a.Credentials;
import com.fyber.p034b.ReporterOperation;
import com.fyber.p044g.p045a.ReporterResult;
import com.fyber.utils.FyberBaseUrlProvider;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.HostInfo;
import com.fyber.utils.StringUtils;
import com.fyber.utils.ae;
import java.util.Map;

/* renamed from: com.fyber.g.a */
public abstract class Reporter {
    protected final String f2745a;
    protected Map f2746b;

    protected abstract ae m5175a(ae aeVar);

    protected abstract String m5176a();

    protected abstract Credentials m5178b();

    protected abstract String m5179c();

    protected abstract ReporterResult m5180d();

    public boolean m5177a(Context context) {
        if (HostInfo.m5287e()) {
            HostInfo.m5280a(context);
            new Thread(new ReporterOperation(m5175a(ae.m5235a(FyberBaseUrlProvider.m5274a(m5176a()), m5178b()).m5241a(this.f2746b).m5238a()), m5180d())).start();
            return true;
        }
        String str = "Only devices running Android API level 10 and above are supported";
        if (FyberLogger.m5222a()) {
            FyberLogger.m5226c(m5179c(), str);
        } else {
            Log.i(m5179c(), str);
        }
        return false;
    }

    protected Reporter(String str) {
        if (StringUtils.m5259a(str)) {
            throw new IllegalArgumentException("appId cannot be null nor empty");
        }
        this.f2745a = str;
    }
}
