package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.C0339d;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* renamed from: com.google.android.gms.iid.h */
public class C0351h {
    static String f4583a;
    static int f4584b;
    static int f4585c;
    static int f4586d;
    Context f4587e;
    Map f4588f;
    Messenger f4589g;
    Messenger f4590h;
    MessengerCompat f4591i;
    PendingIntent f4592j;
    long f4593k;
    long f4594l;
    int f4595m;
    int f4596n;
    long f4597o;

    static {
        f4583a = null;
        f4584b = 0;
        f4585c = 0;
        f4586d = 0;
    }

    public C0351h(Context context) {
        this.f4588f = new HashMap();
        this.f4587e = context;
    }

    public static String m8146a(Context context) {
        ApplicationInfo applicationInfo;
        if (f4583a != null) {
            return f4583a;
        }
        f4584b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo2.uid);
                    f4585c = applicationInfo2.uid;
                    f4583a = resolveInfo.serviceInfo.packageName;
                    return f4583a;
                } catch (NameNotFoundException e) {
                }
            } else {
                Log.w("InstanceID/Rpc", "Possible malicious package " + resolveInfo.serviceInfo.packageName + " declares " + "com.google.android.c2dm.intent.REGISTER" + " without permission");
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try {
            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
            f4583a = applicationInfo.packageName;
            f4585c = applicationInfo.uid;
            return f4583a;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                f4583a = applicationInfo.packageName;
                f4585c = applicationInfo.uid;
                return f4583a;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    static String m8147a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = C0344a.m8124a(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private void m8148a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f4588f.keySet()) {
                Object obj2 = this.f4588f.get(str);
                this.f4588f.put(str, obj);
                m8149a(obj2, obj);
            }
        }
    }

    private void m8149a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                Log.w("InstanceID/Rpc", "Failed to send response " + e);
            }
        }
    }

    private void m8150a(String str) {
        if ("com.google.android.gsf".equals(f4583a)) {
            this.f4595m++;
            if (this.f4595m >= 3) {
                if (this.f4595m == 3) {
                    this.f4596n = new Random().nextInt(1000) + 1000;
                }
                this.f4596n *= 2;
                this.f4597o = SystemClock.elapsedRealtime() + ((long) this.f4596n);
                Log.w("InstanceID/Rpc", "Backoff due to " + str + " for " + this.f4596n);
            }
        }
    }

    private void m8151a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f4588f.get(str);
            this.f4588f.put(str, obj);
            m8149a(obj2, obj);
        }
    }

    private Intent m8152b(Bundle bundle, KeyPair keyPair) {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String b = C0351h.m8153b();
        synchronized (getClass()) {
            this.f4588f.put(b, conditionVariable);
        }
        m8158a(bundle, keyPair, b);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.f4588f.remove(b);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                Log.w("InstanceID/Rpc", "No response " + remove);
                throw new IOException("TIMEOUT");
            }
        }
        return intent;
    }

    public static synchronized String m8153b() {
        String num;
        synchronized (C0351h.class) {
            int i = f4586d;
            f4586d = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    Intent m8154a(Bundle bundle, KeyPair keyPair) {
        Intent b = m8152b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : m8152b(bundle, keyPair);
    }

    void m8155a() {
        if (this.f4589g == null) {
            C0351h.m8146a(this.f4587e);
            this.f4589g = new Messenger(new C0352i(this, Looper.getMainLooper()));
        }
    }

    synchronized void m8156a(Intent intent) {
        if (this.f4592j == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f4592j = PendingIntent.getBroadcast(this.f4587e, 0, intent2, 0);
        }
        intent.putExtra("app", this.f4592j);
    }

    protected void m8157a(Intent intent, String str) {
        this.f4593k = SystemClock.elapsedRealtime();
        intent.putExtra("kid", "|ID|" + str + "|");
        intent.putExtra("X-kid", "|ID|" + str + "|");
        boolean equals = "com.google.android.gsf".equals(f4583a);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            equals = "1".equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Sending " + intent.getExtras());
        }
        if (this.f4590h != null) {
            intent.putExtra("google.messenger", this.f4589g);
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                this.f4590h.send(obtain);
                return;
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        if (equals) {
            Intent intent2 = new Intent("com.google.android.gms.iid.InstanceID");
            intent2.setPackage(this.f4587e.getPackageName());
            intent2.putExtra("GSF", intent);
            this.f4587e.startService(intent2);
            return;
        }
        intent.putExtra("google.messenger", this.f4589g);
        intent.putExtra("messenger2", "1");
        if (this.f4591i != null) {
            Message obtain2 = Message.obtain();
            obtain2.obj = intent;
            try {
                this.f4591i.m8120a(obtain2);
                return;
            } catch (RemoteException e2) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.f4587e.startService(intent);
    }

    void m8158a(Bundle bundle, KeyPair keyPair, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f4597o == 0 || elapsedRealtime > this.f4597o) {
            m8155a();
            if (f4583a == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.f4593k = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(f4583a);
            bundle.putString("gmsv", Integer.toString(C0339d.m8094c(this.f4587e)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(C0344a.m8121a(this.f4587e)));
            bundle.putString("cliv", "1");
            bundle.putString("appid", C0344a.m8123a(keyPair));
            bundle.putString("pub2", C0344a.m8124a(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", C0351h.m8147a(keyPair, this.f4587e.getPackageName(), r1));
            intent.putExtras(bundle);
            m8156a(intent);
            m8157a(intent, str);
            return;
        }
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.f4597o - elapsedRealtime) + " interval: " + this.f4596n);
        throw new IOException("RETRY_LATER");
    }

    public void m8159a(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.f4591i = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f4590h = (Messenger) parcelableExtra;
                    }
                }
                m8162d((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    String m8160b(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0);
        if (stringExtra != null) {
            if (stringExtra == null) {
                return stringExtra;
            }
            stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                throw new IOException(stringExtra);
            }
            Log.w("InstanceID/Rpc", "Unexpected response from GCM " + intent.getExtras(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } else if (stringExtra == null) {
            return stringExtra;
        } else {
            stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                Log.w("InstanceID/Rpc", "Unexpected response from GCM " + intent.getExtras(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
            throw new IOException(stringExtra);
        }
    }

    void m8161c(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            Log.w("InstanceID/Rpc", "Unexpected response, no error or registration id " + intent.getExtras());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Received InstanceID error " + stringExtra);
        }
        String str = null;
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra);
            }
            if (split.length > 2) {
                str = split[2];
                stringExtra = split[3];
                if (stringExtra.startsWith(":")) {
                    stringExtra = stringExtra.substring(1);
                }
            } else {
                stringExtra = "UNKNOWN";
            }
            intent.putExtra("error", stringExtra);
        }
        if (str == null) {
            m8148a((Object) stringExtra);
        } else {
            m8151a(str, (Object) stringExtra);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.f4594l = SystemClock.elapsedRealtime();
            this.f4596n = ((int) longExtra) * 1000;
            this.f4597o = SystemClock.elapsedRealtime() + ((long) this.f4596n);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.f4596n);
        } else if ("SERVICE_NOT_AVAILABLE".equals(stringExtra) || "AUTHENTICATION_FAILED".equals(stringExtra)) {
            m8150a(stringExtra);
        }
    }

    void m8162d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
                action = intent.getStringExtra("registration_id");
                String stringExtra = action == null ? intent.getStringExtra("unregistered") : action;
                if (stringExtra == null) {
                    m8161c(intent);
                    return;
                }
                this.f4593k = SystemClock.elapsedRealtime();
                this.f4597o = 0;
                this.f4595m = 0;
                this.f4596n = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "AppIDResponse: " + stringExtra + " " + intent.getExtras());
                }
                action = null;
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra);
                    }
                    stringExtra = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            C0345b.m8133a(this.f4587e);
                        } else if ("RST".equals(split[3])) {
                            C0345b.m8134a(this.f4587e, C0344a.m8125b(this.f4587e).m8130c());
                            intent.removeExtra("registration_id");
                            m8151a(stringExtra, (Object) intent);
                            return;
                        }
                    }
                    action = split[split.length - 1];
                    if (action.startsWith(":")) {
                        action = action.substring(1);
                    }
                    intent.putExtra("registration_id", action);
                    action = stringExtra;
                }
                if (action == null) {
                    m8148a((Object) intent);
                } else {
                    m8151a(action, (Object) intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response " + intent.getAction());
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
