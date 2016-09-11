package android.support.v4.p002h;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;

/* compiled from: LayoutInflaterCompatBase */
/* renamed from: android.support.v4.h.ag */
class ag {
    static void m1776a(LayoutInflater layoutInflater, al alVar) {
        layoutInflater.setFactory(alVar != null ? new ah(alVar) : null);
    }

    static al m1775a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof ah) {
            return ((ah) factory).f908a;
        }
        return null;
    }
}
