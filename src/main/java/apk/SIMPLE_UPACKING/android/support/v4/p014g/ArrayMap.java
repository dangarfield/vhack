package android.support.v4.p014g;

import java.util.Map;

/* renamed from: android.support.v4.g.b */
class ArrayMap extends MapCollections {
    final /* synthetic */ ArrayMap f849a;

    ArrayMap(ArrayMap arrayMap) {
        this.f849a = arrayMap;
    }

    protected int m1486a() {
        return this.f849a.h;
    }

    protected Object m1488a(int i, int i2) {
        return this.f849a.g[(i << 1) + i2];
    }

    protected int m1487a(Object obj) {
        return this.f849a.m1457a(obj);
    }

    protected int m1492b(Object obj) {
        return this.f849a.m1462b(obj);
    }

    protected Map m1493b() {
        return this.f849a;
    }

    protected void m1491a(Object obj, Object obj2) {
        this.f849a.put(obj, obj2);
    }

    protected Object m1489a(int i, Object obj) {
        return this.f849a.m1459a(i, obj);
    }

    protected void m1490a(int i) {
        this.f849a.m1465d(i);
    }

    protected void m1494c() {
        this.f849a.clear();
    }
}
