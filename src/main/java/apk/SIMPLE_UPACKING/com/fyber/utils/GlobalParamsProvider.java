package com.fyber.utils;

import com.fyber.Fyber;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.fyber.utils.l */
public final class GlobalParamsProvider implements ParametersProvider {
    public final Map m5278a() {
        Map c = Fyber.getConfigs().m4843c();
        if (MapUtils.m5320a(c)) {
            return Collections.emptyMap();
        }
        return c;
    }
}
