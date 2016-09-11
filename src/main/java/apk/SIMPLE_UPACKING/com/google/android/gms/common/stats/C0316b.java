package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.C0284f;
import com.google.android.gms.p051b.ke;
import com.google.android.gms.p051b.ko;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.b */
public class C0316b {
    private static final Object f4491a;
    private static C0316b f4492b;
    private static Integer f4493h;
    private final List f4494c;
    private final List f4495d;
    private final List f4496e;
    private final List f4497f;
    private C0321g f4498g;
    private C0321g f4499i;

    static {
        f4491a = new Object();
    }

    private C0316b() {
        if (C0316b.m8040c() == C0320f.f4511b) {
            this.f4494c = Collections.EMPTY_LIST;
            this.f4495d = Collections.EMPTY_LIST;
            this.f4496e = Collections.EMPTY_LIST;
            this.f4497f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) C0318d.f4503b.m6870c();
        this.f4494c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C0318d.f4504c.m6870c();
        this.f4495d = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C0318d.f4505d.m6870c();
        this.f4496e = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C0318d.f4506e.m6870c();
        this.f4497f = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.f4498g = new C0321g(1024, ((Long) C0318d.f4507f.m6870c()).longValue());
        this.f4499i = new C0321g(1024, ((Long) C0318d.f4507f.m6870c()).longValue());
    }

    public static C0316b m8032a() {
        synchronized (f4491a) {
            if (f4492b == null) {
                f4492b = new C0316b();
            }
        }
        return f4492b;
    }

    private String m8033a(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private void m8034a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Parcelable connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((C0316b.m8040c() & C0320f.f4515f) == 0 || i == 13)) {
            str6 = ko.m6942a(3, 5);
        }
        long j = 0;
        if ((C0316b.m8040c() & C0320f.f4517h) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(C0320f.f4510a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void m8035a(Context context, String str, String str2, Intent intent, int i) {
        String str3 = null;
        if (m8039b() && this.f4498g != null) {
            String str4;
            String str5;
            if (i != 4 && i != 1) {
                ServiceInfo b = C0316b.m8038b(context, intent);
                if (b == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = b.processName;
                str5 = b.name;
                str3 = ko.m6943a(context);
                if (m8037a(str3, str2, str4, str5)) {
                    this.f4498g.m8047a(str);
                } else {
                    return;
                }
            } else if (this.f4498g.m8048b(str)) {
                str5 = null;
                str4 = null;
            } else {
                return;
            }
            m8034a(context, str, i, str3, str2, str4, str5);
        }
    }

    private boolean m8036a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return (component == null || (C0284f.f4420a && "com.google.android.gms".equals(component.getPackageName()))) ? false : ke.m6912a(context, component.getPackageName());
    }

    private boolean m8037a(String str, String str2, String str3, String str4) {
        return (this.f4494c.contains(str) || this.f4495d.contains(str2) || this.f4496e.contains(str3) || this.f4497f.contains(str4) || (str3.equals(str) && (C0316b.m8040c() & C0320f.f4516g) != 0)) ? false : true;
    }

    private static ServiceInfo m8038b(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), ko.m6942a(3, 20)}));
            return null;
        }
        if (queryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), ko.m6942a(3, 20)}));
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                Log.w("ConnectionTracker", ((ResolveInfo) it.next()).serviceInfo.name);
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    private boolean m8039b() {
        return C0284f.f4420a && C0316b.m8040c() != C0320f.f4511b;
    }

    private static int m8040c() {
        if (f4493h == null) {
            try {
                f4493h = Integer.valueOf(ke.m6911a() ? ((Integer) C0318d.f4502a.m6870c()).intValue() : C0320f.f4511b);
            } catch (SecurityException e) {
                f4493h = Integer.valueOf(C0320f.f4511b);
            }
        }
        return f4493h.intValue();
    }

    @SuppressLint({"UntrackedBindService"})
    public void m8041a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        m8035a(context, m8033a(serviceConnection), null, null, 1);
    }

    public void m8042a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        m8035a(context, m8033a(serviceConnection), str, intent, 3);
    }

    public boolean m8043a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m8044a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean m8044a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (m8036a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            m8035a(context, m8033a(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void m8045b(Context context, ServiceConnection serviceConnection) {
        m8035a(context, m8033a(serviceConnection), null, null, 4);
    }
}
