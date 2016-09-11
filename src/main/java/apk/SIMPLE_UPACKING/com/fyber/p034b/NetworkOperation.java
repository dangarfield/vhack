package com.fyber.p034b;

import com.fyber.utils.FyberLogger;
import com.fyber.utils.HttpConnection;
import com.fyber.utils.ae;
import java.io.IOException;

/* renamed from: com.fyber.b.f */
public abstract class NetworkOperation implements Runnable {
    protected ae f2620a;

    protected abstract Object m5011a(HttpConnection httpConnection);

    protected abstract Object m5012a(IOException iOException);

    protected abstract boolean m5013a();

    protected abstract String m5014b();

    protected NetworkOperation(ae aeVar) {
        this.f2620a = aeVar;
    }

    public void run() {
        m5015c();
    }

    protected final Object m5015c() {
        if (!m5013a()) {
            return null;
        }
        try {
            String d = this.f2620a.m5246d();
            FyberLogger.m5223b(m5014b(), "sending request to " + d);
            return m5011a((HttpConnection) HttpConnection.m5308b(d).m5267a());
        } catch (IOException e) {
            FyberLogger.m5221a(m5014b(), "An error occurred", e);
            return m5012a(e);
        }
    }
}
