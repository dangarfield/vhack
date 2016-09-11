package com.google.android.gms.p051b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.C0155h;
import com.google.android.gms.common.internal.bf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.b.jc */
public class jc extends jb {
    public static final List f3838c;
    private Class f3839d;
    private Class f3840e;
    private Object f3841f;
    private Object f3842g;

    static {
        f3838c = Collections.singletonList("email");
    }

    public jc(Activity activity, List list) {
        super(activity, f3838c, list);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m6853a(android.content.Context r5) {
        /*
        com.google.android.gms.common.internal.bf.m7873a(r5);
        r0 = "com.facebook.FacebookSdk";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x006b }
        r1 = "sdkInitialize";
        r2 = 2;
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r3 = 0;
        r4 = android.content.Context.class;
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r3 = 1;
        r4 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r1 = 0;
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r3 = 0;
        r4 = r5.getApplicationContext();	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r3 = 1;
        r4 = 64206; // 0xface float:8.9972E-41 double:3.1722E-319;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r0.invoke(r1, r2);	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r0 = "com.facebook.login.LoginManager";
        r0 = java.lang.Class.forName(r0);	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r1 = "getInstance";
        r2 = 0;
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r1 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r2 = 0;
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r1 = r1.invoke(r2, r3);	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r2 = "logOut";
        r3 = 0;
        r3 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r0 = r0.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
        r0.invoke(r1, r2);	 Catch:{ NoSuchMethodException -> 0x00ab, IllegalAccessException -> 0x005b, InvocationTargetException -> 0x00ad }
    L_0x005a:
        return;
    L_0x005b:
        r0 = move-exception;
    L_0x005c:
        r1 = "AuthSignInClient";
        r2 = "Facebook logout error.";
        android.util.Log.e(r1, r2, r0);	 Catch:{ ClassNotFoundException -> 0x006b }
        r0 = new java.lang.IllegalStateException;	 Catch:{ ClassNotFoundException -> 0x006b }
        r1 = "No supported Facebook SDK version found to use Facebook logout.";
        r0.<init>(r1);	 Catch:{ ClassNotFoundException -> 0x006b }
        throw r0;	 Catch:{ ClassNotFoundException -> 0x006b }
    L_0x006b:
        r0 = move-exception;
        r0 = "com.facebook.Session";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a7, IllegalAccessException -> 0x00a5, InvocationTargetException -> 0x00a9 }
        r1 = "getActiveSession";
        r2 = 0;
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a7, IllegalAccessException -> 0x00a5, InvocationTargetException -> 0x00a9 }
        r1 = r0.getDeclaredMethod(r1, r2);	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a7, IllegalAccessException -> 0x00a5, InvocationTargetException -> 0x00a9 }
        r2 = 0;
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a7, IllegalAccessException -> 0x00a5, InvocationTargetException -> 0x00a9 }
        r1 = r1.invoke(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a7, IllegalAccessException -> 0x00a5, InvocationTargetException -> 0x00a9 }
        if (r1 == 0) goto L_0x005a;
    L_0x0085:
        r2 = "closeAndClearTokenInformation";
        r3 = 0;
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a7, IllegalAccessException -> 0x00a5, InvocationTargetException -> 0x00a9 }
        r0 = r0.getDeclaredMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a7, IllegalAccessException -> 0x00a5, InvocationTargetException -> 0x00a9 }
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a7, IllegalAccessException -> 0x00a5, InvocationTargetException -> 0x00a9 }
        r0.invoke(r1, r2);	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a7, IllegalAccessException -> 0x00a5, InvocationTargetException -> 0x00a9 }
        goto L_0x005a;
    L_0x0095:
        r0 = move-exception;
    L_0x0096:
        r1 = "AuthSignInClient";
        r2 = "Facebook logout error.";
        android.util.Log.e(r1, r2, r0);
        r0 = new java.lang.IllegalStateException;
        r1 = "No supported Facebook SDK version found to use Facebook logout.";
        r0.<init>(r1);
        throw r0;
    L_0x00a5:
        r0 = move-exception;
        goto L_0x0096;
    L_0x00a7:
        r0 = move-exception;
        goto L_0x0096;
    L_0x00a9:
        r0 = move-exception;
        goto L_0x0096;
    L_0x00ab:
        r0 = move-exception;
        goto L_0x005c;
    L_0x00ad:
        r0 = move-exception;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.jc.a(android.content.Context):void");
    }

    private void m6855e() {
        if (this.f3842g != null) {
            Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", new Class[]{Activity.class, Collection.class}).invoke(this.f3842g, new Object[]{this.a, new ArrayList(m6845b())});
            return;
        }
        Class cls = Class.forName("com.facebook.Session$OpenRequest");
        Object newInstance = cls.getConstructor(new Class[]{Activity.class}).newInstance(new Object[]{this.a});
        cls.getDeclaredMethod("setPermissions", new Class[]{List.class}).invoke(newInstance, new Object[]{new ArrayList(m6845b())});
        cls.getDeclaredMethod("setRequestCode", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{Integer.valueOf(64206)});
        Class cls2 = Class.forName("com.facebook.Session");
        cls.getDeclaredMethod("setCallback", new Class[]{Class.forName("com.facebook.Session$StatusCallback")}).invoke(newInstance, new Object[]{m6856f()});
        Object newInstance2 = cls2.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.a});
        cls2.getDeclaredMethod("setActiveSession", new Class[]{cls2}).invoke(null, new Object[]{newInstance2});
        cls2.getDeclaredMethod("openForRead", new Class[]{cls}).invoke(newInstance2, new Object[]{newInstance});
    }

    private Object m6856f() {
        Class cls = Class.forName("com.facebook.Session");
        return Proxy.newProxyInstance(Class.forName("com.facebook.Session$StatusCallback").getClassLoader(), new Class[]{r1}, new jd(this, cls));
    }

    public C0155h m6857a() {
        return C0155h.FACEBOOK;
    }

    public void m6858a(ja jaVar) {
        Throwable e;
        m6848b(null, null, (ja) bf.m7873a((Object) jaVar));
        try {
            m6855e();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public void m6859a(String str, ja jaVar) {
        Throwable e;
        m6848b((String) bf.m7873a((Object) str), null, (ja) bf.m7873a((Object) jaVar));
        try {
            m6855e();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public void m6860a(String str, String str2, ja jaVar) {
        Throwable e;
        m6848b((String) bf.m7873a((Object) str), (String) bf.m7873a((Object) str2), (ja) bf.m7873a((Object) jaVar));
        try {
            m6855e();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public boolean m6861a(int i, int i2, Intent intent, ja jaVar) {
        Throwable e;
        m6846b(jaVar);
        if (i != 64206 && this.f3839d == null) {
            return false;
        }
        if (this.f3839d == null || this.f3840e == null || this.f3841f == null) {
            try {
                Class cls = Class.forName("com.facebook.Session");
                Object invoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                Method declaredMethod = cls.getDeclaredMethod("onActivityResult", new Class[]{Activity.class, Integer.TYPE, Integer.TYPE, Intent.class});
                if (invoke == null) {
                    return false;
                }
                return ((Boolean) declaredMethod.invoke(invoke, new Object[]{this.a, Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
            } catch (ClassNotFoundException e2) {
                e = e2;
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e3) {
                e = e3;
                throw new RuntimeException(e);
            } catch (IllegalAccessException e4) {
                e = e4;
                throw new RuntimeException(e);
            } catch (InvocationTargetException e5) {
                e = e5;
                throw new RuntimeException(e);
            }
        }
        try {
            if (!((Boolean) this.f3839d.getDeclaredMethod("isFacebookRequestCode", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)})).booleanValue()) {
                return false;
            }
            return ((Boolean) this.f3840e.getDeclaredMethod("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}).invoke(this.f3841f, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e7) {
            e = e7;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e8) {
            e = e8;
            throw new RuntimeException(e);
        }
    }
}
