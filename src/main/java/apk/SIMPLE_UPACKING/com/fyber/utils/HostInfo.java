package com.fyber.utils;

import java.util.Collections;
import java.util.Map;

/* renamed from: com.fyber.utils.q */
final class HostInfo implements ParametersProvider {
    HostInfo() {
    }

    public final Map m5306a() {
        if (HostInfo.f2826a == null) {
            return Collections.emptyMap();
        }
        return Collections.singletonMap("orientation", HostInfo.f2826a.m5298b());
    }
}
