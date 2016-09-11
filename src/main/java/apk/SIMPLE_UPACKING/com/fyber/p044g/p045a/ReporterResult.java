package com.fyber.p044g.p045a;

import android.util.Log;
import com.fyber.utils.FyberLogger;

/* renamed from: com.fyber.g.a.c */
public abstract class ReporterResult {
    public abstract void m5187a();

    protected abstract String m5189b();

    public final void m5188a(int i) {
        String str = "Report was unsuccessful. Response code: " + i;
        if (FyberLogger.m5222a()) {
            FyberLogger.m5226c(m5189b(), str);
        } else {
            Log.i(m5189b(), str);
        }
    }
}
