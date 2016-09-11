package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.iid.a */
public class C0344a {
    static Map f4566a;
    static String f4567f;
    private static C0353j f4568g;
    private static C0351h f4569h;
    Context f4570b;
    KeyPair f4571c;
    String f4572d;
    long f4573e;

    static {
        f4566a = new HashMap();
    }

    protected C0344a(Context context, String str, Bundle bundle) {
        this.f4572d = "";
        this.f4570b = context.getApplicationContext();
        this.f4572d = str;
    }

    static int m8121a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("InstanceID", "Never happens: can't find own package " + e);
            return i;
        }
    }

    public static synchronized C0344a m8122a(Context context, Bundle bundle) {
        C0344a c0344a;
        synchronized (C0344a.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (f4568g == null) {
                f4568g = new C0353j(applicationContext);
                f4569h = new C0351h(applicationContext);
            }
            f4567f = Integer.toString(C0344a.m8121a(applicationContext));
            c0344a = (C0344a) f4566a.get(str);
            if (c0344a == null) {
                c0344a = new C0344a(applicationContext, str, bundle);
                f4566a.put(str, c0344a);
            }
        }
        return c0344a;
    }

    static String m8123a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String m8124a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static C0344a m8125b(Context context) {
        return C0344a.m8122a(context, null);
    }

    public String m8126a(String str, String str2, Bundle bundle) {
        Object obj = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        Object obj2 = 1;
        String a = m8132e() ? null : f4568g.m8167a(this.f4572d, str, str2);
        if (a == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getString("ttl") != null) {
                obj2 = null;
            }
            if (!"jwt".equals(bundle.getString("type"))) {
                obj = obj2;
            }
            a = m8128b(str, str2, bundle);
            Log.w("InstanceID", "token: " + a);
            if (!(a == null || r1 == null)) {
                f4568g.m8170a(this.f4572d, str, str2, a, f4567f);
            }
        }
        return a;
    }

    KeyPair m8127a() {
        if (this.f4571c == null) {
            this.f4571c = f4568g.m8174c(this.f4572d);
        }
        if (this.f4571c == null) {
            this.f4573e = System.currentTimeMillis();
            this.f4571c = f4568g.m8168a(this.f4572d, this.f4573e);
        }
        return this.f4571c;
    }

    public String m8128b(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.f4572d) ? str : this.f4572d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return f4569h.m8160b(f4569h.m8154a(bundle, m8127a()));
    }

    void m8129b() {
        this.f4573e = 0;
        f4568g.m8175d(this.f4572d);
        this.f4571c = null;
    }

    public C0353j m8130c() {
        return f4568g;
    }

    C0351h m8131d() {
        return f4569h;
    }

    boolean m8132e() {
        String a = f4568g.m8165a("appVersion");
        if (a == null || !a.equals(f4567f)) {
            return true;
        }
        a = f4568g.m8165a("lastToken");
        if (a == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(a)).longValue() > 604800;
    }
}
