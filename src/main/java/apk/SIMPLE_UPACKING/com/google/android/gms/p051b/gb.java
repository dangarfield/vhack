package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;

@TargetApi(9)
/* renamed from: com.google.android.gms.b.gb */
public class gb extends fz {
    public gb() {
        super();
    }

    public int m6574a() {
        return 6;
    }

    public boolean m6575a(Request request) {
        request.setShowRunningNotification(true);
        return true;
    }

    public int m6576b() {
        return 7;
    }
}
