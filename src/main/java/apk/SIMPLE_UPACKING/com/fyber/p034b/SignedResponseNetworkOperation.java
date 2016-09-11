package com.fyber.p034b;

import com.fyber.utils.FyberLogger;
import com.fyber.utils.HttpConnection;
import com.fyber.utils.StringUtils;
import com.fyber.utils.ac;
import com.fyber.utils.ae;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* renamed from: com.fyber.b.i */
public abstract class SignedResponseNetworkOperation extends NetworkOperation implements Callable {
    protected String f2622b;

    protected abstract Object m5022a(int i, String str, String str2);

    protected abstract Object m5024a(Object obj);

    protected abstract Object m5025a(String str);

    public SignedResponseNetworkOperation(ae aeVar, String str) {
        super(aeVar);
        if (StringUtils.m5259a(str)) {
            throw new IllegalArgumentException("Security token must be set");
        }
        this.f2622b = str;
    }

    public Object call() {
        return m5015c();
    }

    protected final Object m5023a(HttpConnection httpConnection) {
        Object a;
        int b = httpConnection.m5271b();
        String str = (String) httpConnection.m5273c();
        List a2 = httpConnection.m5270a("X-Sponsorpay-Response-Signature");
        String str2 = (a2 == null || a2.size() <= 0) ? "" : (String) a2.get(0);
        FyberLogger.m5223b(m5014b(), String.format(Locale.ENGLISH, "Server Response, status code: %d, response body: %s, signature: %s", new Object[]{Integer.valueOf(b), str, str2}));
        if (SignedResponseNetworkOperation.m5021a(b) || !m5026a(str, str2)) {
            a = m5022a(b, str, str2);
        } else {
            a = m5025a(str);
        }
        return m5024a(a);
    }

    protected final boolean m5026a(String str, String str2) {
        return ac.m5232a(str, this.f2622b).equals(str2);
    }

    protected static boolean m5021a(int i) {
        return i < 200 || i > 299;
    }
}
