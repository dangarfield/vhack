package com.google.android.gms.p051b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.C0056g;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.az */
public class az {
    boolean f3469a;
    private final List f3470b;
    private final Map f3471c;
    private final Object f3472d;
    private az f3473e;

    public az(boolean z, String str, String str2) {
        this.f3470b = new LinkedList();
        this.f3471c = new LinkedHashMap();
        this.f3472d = new Object();
        this.f3469a = z;
        this.f3471c.put("action", str);
        this.f3471c.put("ad_format", str2);
    }

    public av m6126a() {
        return m6127a(C0056g.m5443g().m6914b());
    }

    public av m6127a(long j) {
        return !this.f3469a ? null : new av(j, null, null);
    }

    public void m6128a(az azVar) {
        synchronized (this.f3472d) {
            this.f3473e = azVar;
        }
    }

    public void m6129a(String str, String str2) {
        if (this.f3469a && !TextUtils.isEmpty(str2)) {
            ao a = C0056g.m5442f().m6497a();
            if (a != null) {
                synchronized (this.f3472d) {
                    a.m6109a(str).m6116a(this.f3471c, str, str2);
                }
            }
        }
    }

    public boolean m6130a(av avVar, long j, String... strArr) {
        synchronized (this.f3472d) {
            for (String avVar2 : strArr) {
                this.f3470b.add(new av(j, avVar2, avVar));
            }
        }
        return true;
    }

    public boolean m6131a(av avVar, String... strArr) {
        return (!this.f3469a || avVar == null) ? false : m6130a(avVar, C0056g.m5443g().m6914b(), strArr);
    }
}
