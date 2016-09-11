package android.support.v4.p002h;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompatHC */
/* renamed from: android.support.v4.h.ai */
class ai {
    private static Field f909a;
    private static boolean f910b;

    static void m1777a(LayoutInflater layoutInflater, al alVar) {
        Factory2 ajVar;
        if (alVar != null) {
            ajVar = new aj(alVar);
        } else {
            ajVar = null;
        }
        layoutInflater.setFactory2(ajVar);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            ai.m1778a(layoutInflater, (Factory2) factory);
        } else {
            ai.m1778a(layoutInflater, ajVar);
        }
    }

    static void m1778a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f910b) {
            try {
                f909a = LayoutInflater.class.getDeclaredField("mFactory2");
                f909a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f910b = true;
        }
        if (f909a != null) {
            try {
                f909a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
