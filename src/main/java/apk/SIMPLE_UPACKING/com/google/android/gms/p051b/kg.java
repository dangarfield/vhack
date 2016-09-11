package com.google.android.gms.p051b;

import android.support.v4.p014g.ArrayMap;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.b.kg */
public final class kg {
    public static Map m6915a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        Map arrayMap = new ArrayMap(6);
        arrayMap.put(obj, obj2);
        arrayMap.put(obj3, obj4);
        arrayMap.put(obj5, obj6);
        arrayMap.put(obj7, obj8);
        arrayMap.put(obj9, obj10);
        arrayMap.put(obj11, obj12);
        return Collections.unmodifiableMap(arrayMap);
    }

    public static Set m6916a() {
        return Collections.emptySet();
    }

    public static Set m6917a(Object obj) {
        return Collections.singleton(obj);
    }

    public static Set m6918a(Object obj, Object obj2) {
        Set kdVar = new kd(2);
        kdVar.add(obj);
        kdVar.add(obj2);
        return Collections.unmodifiableSet(kdVar);
    }

    public static Set m6919a(Object obj, Object obj2, Object obj3) {
        Set kdVar = new kd(3);
        kdVar.add(obj);
        kdVar.add(obj2);
        kdVar.add(obj3);
        return Collections.unmodifiableSet(kdVar);
    }

    public static Set m6920a(Object obj, Object obj2, Object obj3, Object obj4) {
        Set kdVar = new kd(4);
        kdVar.add(obj);
        kdVar.add(obj2);
        kdVar.add(obj3);
        kdVar.add(obj4);
        return Collections.unmodifiableSet(kdVar);
    }

    public static Set m6921a(Object... objArr) {
        switch (objArr.length) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return kg.m6916a();
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return kg.m6917a(objArr[0]);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return kg.m6918a(objArr[0], objArr[1]);
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return kg.m6919a(objArr[0], objArr[1], objArr[2]);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                return kg.m6920a(objArr[0], objArr[1], objArr[2], objArr[3]);
            default:
                return Collections.unmodifiableSet(objArr.length <= 32 ? new kd(Arrays.asList(objArr)) : new HashSet(Arrays.asList(objArr)));
        }
    }
}
