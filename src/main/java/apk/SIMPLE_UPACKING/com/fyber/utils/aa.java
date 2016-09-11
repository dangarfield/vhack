package com.fyber.utils;

import java.util.Map;

/* compiled from: SDKParamsProvider */
public final class aa implements ParametersProvider {
    private static final String[] f2776a;
    private Map f2777b;

    static {
        f2776a = new String[]{"MPI", "VPL", "JUD"};
    }

    public aa() {
        this.f2777b = new ab(this);
    }

    public final Map m5230a() {
        return this.f2777b;
    }
}
