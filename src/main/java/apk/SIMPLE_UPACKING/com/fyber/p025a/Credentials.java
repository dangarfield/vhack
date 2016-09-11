package com.fyber.p025a;

import com.fyber.utils.StringUtils;

/* renamed from: com.fyber.a.b */
public final class Credentials {
    private String f2419a;
    private String f2420b;
    private String f2421c;

    public Credentials(String str) {
        this.f2419a = StringUtils.m5261c(str);
    }

    public final Credentials m4854a(String str) {
        this.f2419a = StringUtils.m5261c(str);
        return this;
    }

    public final Credentials m4855b(String str) {
        this.f2420b = str;
        return this;
    }

    public final Credentials m4856c(String str) {
        this.f2421c = StringUtils.m5261c(str);
        return this;
    }

    public final Credentials m4853a() {
        return new Credentials();
    }
}
