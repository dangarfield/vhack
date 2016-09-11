package com.google.android.gms.p051b;

import android.support.v4.p014g.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.google.android.gms.b.kd */
public class kd extends AbstractSet {
    private final ArrayMap f3864a;

    public kd() {
        this.f3864a = new ArrayMap();
    }

    public kd(int i) {
        this.f3864a = new ArrayMap(i);
    }

    public kd(Collection collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean m6910a(kd kdVar) {
        int size = size();
        this.f3864a.m1461a(kdVar.f3864a);
        return size() > size;
    }

    public boolean add(Object obj) {
        if (this.f3864a.containsKey(obj)) {
            return false;
        }
        this.f3864a.put(obj, obj);
        return true;
    }

    public boolean addAll(Collection collection) {
        return collection instanceof kd ? m6910a((kd) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f3864a.clear();
    }

    public boolean contains(Object obj) {
        return this.f3864a.containsKey(obj);
    }

    public Iterator iterator() {
        return this.f3864a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f3864a.containsKey(obj)) {
            return false;
        }
        this.f3864a.remove(obj);
        return true;
    }

    public int size() {
        return this.f3864a.size();
    }
}
