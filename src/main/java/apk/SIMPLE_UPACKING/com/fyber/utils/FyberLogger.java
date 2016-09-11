package com.fyber.utils;

/* renamed from: com.fyber.utils.j */
final class FyberLogger implements Runnable {
    final /* synthetic */ FyberLogger f2821a;
    final /* synthetic */ String f2822b;
    final /* synthetic */ String f2823c;
    final /* synthetic */ Exception f2824d;
    final /* synthetic */ FyberLogger f2825e;

    FyberLogger(FyberLogger fyberLogger, FyberLogger fyberLogger2, String str, String str2, Exception exception) {
        this.f2825e = fyberLogger;
        this.f2821a = fyberLogger2;
        this.f2822b = str;
        this.f2823c = str2;
        this.f2824d = exception;
    }

    public final void run() {
        for (LoggerListener a : this.f2825e.f2775c) {
            a.m5251a(this.f2821a, this.f2822b, this.f2823c, this.f2824d);
        }
    }
}
