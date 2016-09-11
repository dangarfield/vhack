package com.google.android.gms.p047a;

import android.os.IBinder;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.a.d */
public final class C0005d extends C0003b {
    private final Object f2860a;

    private C0005d(Object obj) {
        this.f2860a = obj;
    }

    public static C0002a m5323a(Object obj) {
        return new C0005d(obj);
    }

    public static Object m5324a(C0002a c0002a) {
        if (c0002a instanceof C0005d) {
            return ((C0005d) c0002a).f2860a;
        }
        IBinder asBinder = c0002a.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
