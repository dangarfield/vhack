package com.fyber.utils;

import android.text.TextUtils;
import com.fyber.Fyber;
import java.util.HashMap;

/* compiled from: SDKParamsProvider */
final class ab extends HashMap {
    final /* synthetic */ aa f2778a;

    ab(aa aaVar) {
        this.f2778a = aaVar;
        put("sdk_version", Fyber.RELEASE_VERSION_STRING);
        put("platform", "android");
        put("client", "sdk");
        put("sdk_features", TextUtils.join(",", aa.f2776a));
    }
}
