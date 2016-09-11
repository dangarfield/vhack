package android.support.v4.p014g;

import java.util.LinkedHashMap;

/* renamed from: android.support.v4.g.g */
public class LruCache {
    private final LinkedHashMap f860a;
    private int f861b;
    private int f862c;
    private int f863d;
    private int f864e;
    private int f865f;
    private int f866g;
    private int f867h;

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f862c = i;
        this.f860a = new LinkedHashMap(0, 0.75f, true);
    }

    public final Object m1515a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Object obj2 = this.f860a.get(obj);
            if (obj2 != null) {
                this.f866g++;
                return obj2;
            }
            this.f867h++;
            Object b = m1520b(obj);
            if (b == null) {
                return null;
            }
            synchronized (this) {
                this.f864e++;
                obj2 = this.f860a.put(obj, b);
                if (obj2 != null) {
                    this.f860a.put(obj, obj2);
                } else {
                    this.f861b += m1514c(obj, b);
                }
            }
            if (obj2 != null) {
                m1518a(false, obj, b, obj2);
                return obj2;
            }
            m1517a(this.f862c);
            return b;
        }
    }

    public final Object m1516a(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        Object put;
        synchronized (this) {
            this.f863d++;
            this.f861b += m1514c(obj, obj2);
            put = this.f860a.put(obj, obj2);
            if (put != null) {
                this.f861b -= m1514c(obj, put);
            }
        }
        if (put != null) {
            m1518a(false, obj, put, obj2);
        }
        m1517a(this.f862c);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1517a(int r5) {
        /*
        r4 = this;
    L_0x0000:
        monitor-enter(r4);
        r0 = r4.f861b;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r4.f860a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r4.f861b;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r4.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r4.f861b;	 Catch:{ all -> 0x0032 }
        if (r0 <= r5) goto L_0x0041;
    L_0x0039:
        r0 = r4.f860a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r0 = r4.f860a;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r2 = r4.f860a;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r2 = r4.f861b;	 Catch:{ all -> 0x0032 }
        r3 = r4.m1514c(r1, r0);	 Catch:{ all -> 0x0032 }
        r2 = r2 - r3;
        r4.f861b = r2;	 Catch:{ all -> 0x0032 }
        r2 = r4.f865f;	 Catch:{ all -> 0x0032 }
        r2 = r2 + 1;
        r4.f865f = r2;	 Catch:{ all -> 0x0032 }
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        r2 = 1;
        r3 = 0;
        r4.m1518a(r2, r1, r0, r3);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.g.a(int):void");
    }

    protected void m1518a(boolean z, Object obj, Object obj2, Object obj3) {
    }

    protected Object m1520b(Object obj) {
        return null;
    }

    private int m1514c(Object obj, Object obj2) {
        int b = m1519b(obj, obj2);
        if (b >= 0) {
            return b;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    protected int m1519b(Object obj, Object obj2) {
        return 1;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f866g + this.f867h;
            if (i2 != 0) {
                i = (this.f866g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f862c), Integer.valueOf(this.f866g), Integer.valueOf(this.f867h), Integer.valueOf(i)});
        }
        return format;
    }
}
