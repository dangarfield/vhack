package com.google.android.gms.auth.api.signin.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.auth.api.signin.internal.w */
public class C0183w {
    private static final WeakHashMap f3348a;
    private static final Lock f3349b;
    private final Lock f3350c;
    private final Map f3351d;

    static {
        f3348a = new WeakHashMap();
        f3349b = new ReentrantLock();
    }

    private C0183w(Map map) {
        this.f3350c = new ReentrantLock();
        this.f3351d = map;
    }

    public static C0183w m6050a(String str) {
        bf.m7875a(str);
        f3349b.lock();
        try {
            C0183w c0183w = (C0183w) f3348a.get(str);
            if (c0183w == null) {
                c0183w = new C0183w(new C0185y(20));
                f3348a.put(str, c0183w);
            }
            f3349b.unlock();
            return c0183w;
        } catch (Throwable th) {
            f3349b.unlock();
        }
    }

    public boolean m6051a(Set set, C0184x c0184x) {
        bf.m7873a((Object) set);
        bf.m7873a((Object) c0184x);
        if (set.size() == 0 || c0184x.m6052a()) {
            return false;
        }
        Iterable arrayList = new ArrayList(set);
        Collections.sort(arrayList);
        this.f3350c.lock();
        try {
            this.f3351d.put(TextUtils.join(" ", arrayList), c0184x);
            return true;
        } finally {
            this.f3350c.unlock();
        }
    }
}
