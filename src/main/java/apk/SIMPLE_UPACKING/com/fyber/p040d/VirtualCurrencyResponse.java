package com.fyber.p040d;

import com.fyber.p034b.VirtualCurrencyNetworkOperation;

/* renamed from: com.fyber.d.c */
public class VirtualCurrencyResponse implements VirtualCurrencyNetworkOperation {
    private double f2729a;
    private String f2730b;
    private String f2731c;
    private String f2732d;
    private boolean f2733e;

    public VirtualCurrencyResponse(double d, String str, String str2, String str3, boolean z) {
        this.f2729a = d;
        this.f2730b = str;
        this.f2731c = str2;
        this.f2732d = str3;
        this.f2733e = z;
    }

    public double m5159a() {
        return this.f2729a;
    }

    public String m5160b() {
        return this.f2730b;
    }

    public String m5161c() {
        return this.f2731c;
    }

    public String m5162d() {
        return this.f2732d;
    }

    public boolean m5163e() {
        return this.f2733e;
    }
}
