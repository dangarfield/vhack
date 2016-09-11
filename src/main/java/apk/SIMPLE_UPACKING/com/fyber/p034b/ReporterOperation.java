package com.fyber.p034b;

import com.fyber.p044g.p045a.ReporterResult;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.HttpConnection;
import com.fyber.utils.ae;

/* renamed from: com.fyber.b.h */
public final class ReporterOperation implements Runnable {
    private ae f2625a;
    private ReporterResult f2626b;

    public ReporterOperation(ae aeVar, ReporterResult reporterResult) {
        this.f2625a = aeVar;
        this.f2626b = reporterResult;
    }

    public final void run() {
        try {
            String d = this.f2625a.m5246d();
            FyberLogger.m5223b("ReporterOperation", "event will be sent to " + d);
            int b = ((HttpConnection) HttpConnection.m5308b(d).m5267a()).m5271b();
            FyberLogger.m5223b("ReporterOperation", "Server returned status code: " + b);
            if (b == 200) {
                this.f2626b.m5187a();
            } else {
                this.f2626b.m5188a(b);
            }
        } catch (Exception e) {
            FyberLogger.m5221a("ReporterOperation", "An error occurred", e);
        }
    }
}
