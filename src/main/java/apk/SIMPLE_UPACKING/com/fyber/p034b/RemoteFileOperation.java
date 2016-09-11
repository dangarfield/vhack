package com.fyber.p034b;

import com.fyber.Fyber;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.HttpConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* renamed from: com.fyber.b.g */
public final class RemoteFileOperation implements Callable {
    private String f2624a;

    public final /* synthetic */ Object call() {
        return m5036a();
    }

    public static Future m5037a(String str) {
        if (Fyber.getConfigs().m4844d()) {
            return Fyber.getConfigs().m4840a(new RemoteFileOperation(str));
        }
        return null;
    }

    private RemoteFileOperation(String str) {
        this.f2624a = str;
    }

    private String m5036a() {
        try {
            return (String) ((HttpConnection) HttpConnection.m5308b(this.f2624a).m5267a()).m5273c();
        } catch (Exception e) {
            FyberLogger.m5221a("RemoteFileOperation", e.getMessage(), e);
            return null;
        }
    }
}
