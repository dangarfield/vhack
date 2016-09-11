package com.google.android.gms.p051b;

import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: com.google.android.gms.b.jd */
class jd implements InvocationHandler {
    final /* synthetic */ Class f3843a;
    final /* synthetic */ jc f3844b;

    jd(jc jcVar, Class cls) {
        this.f3844b = jcVar;
        this.f3843a = cls;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        Class cls = Class.forName("com.facebook.SessionState");
        Class[] parameterTypes = method.getParameterTypes();
        if (method.getName().equals("call") && parameterTypes.length == 3 && parameterTypes[0] == this.f3843a && parameterTypes[1] == cls && parameterTypes[2] == Exception.class) {
            if (((Boolean) this.f3843a.getDeclaredMethod("isOpened", new Class[0]).invoke(objArr[0], new Object[0])).booleanValue()) {
                this.f3844b.m6849c().m5920a(this.f3844b.m6843a(IdpTokenType.f3293a, (String) this.f3843a.getDeclaredMethod("getAccessToken", new Class[0]).invoke(objArr[0], new Object[0]), this.f3844b.m6850d()));
            }
            return null;
        }
        throw new ExceptionInInitializerError("Method not supported!");
    }
}
