package android.support.v4.p014g;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.g.j */
final class MapCollections implements Set {
    final /* synthetic */ MapCollections f873a;

    MapCollections(MapCollections mapCollections) {
        this.f873a = mapCollections;
    }

    public /* synthetic */ boolean add(Object obj) {
        return m1521a((Entry) obj);
    }

    public boolean m1521a(Entry entry) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        int a = this.f873a.m1472a();
        for (Entry entry : collection) {
            this.f873a.m1477a(entry.getKey(), entry.getValue());
        }
        return a != this.f873a.m1472a();
    }

    public void clear() {
        this.f873a.m1482c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.f873a.m1473a(entry.getKey());
        if (a >= 0) {
            return ContainerHelpers.m1498a(this.f873a.m1474a(a, 1), entry.getValue());
        }
        return false;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f873a.m1472a() == 0;
    }

    public Iterator iterator() {
        return new MapCollections(this.f873a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f873a.m1472a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(Object[] objArr) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        return MapCollections.m1469a((Set) this, obj);
    }

    public int hashCode() {
        int a = this.f873a.m1472a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.f873a.m1474a(a, 0);
            Object a3 = this.f873a.m1474a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }
}
