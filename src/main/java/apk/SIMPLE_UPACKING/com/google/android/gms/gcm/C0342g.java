package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.bo;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.google.android.gms.gcm.g */
class C0342g {
    static C0342g f4561a;
    private final Context f4562b;
    private final Class f4563c;

    private C0342g(Context context, Class cls) {
        this.f4562b = context.getApplicationContext();
        this.f4563c = cls;
    }

    private int m8102a() {
        return (int) SystemClock.uptimeMillis();
    }

    private PendingIntent m8103a(Bundle bundle, PendingIntent pendingIntent) {
        Intent intent = new Intent("com.google.android.gms.gcm.NOTIFICATION_OPEN");
        m8107a(intent, bundle);
        intent.putExtra("com.google.android.gms.gcm.PENDING_INTENT", pendingIntent);
        return PendingIntent.getService(this.f4562b, m8102a(), intent, 1073741824);
    }

    static synchronized C0342g m8104a(Context context, Class cls) {
        C0342g c0342g;
        synchronized (C0342g.class) {
            if (f4561a == null) {
                f4561a = new C0342g(context, cls);
            }
            c0342g = f4561a;
        }
        return c0342g;
    }

    static String m8105a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private String m8106a(String str) {
        return str.substring("gcm.n.".length());
    }

    private void m8107a(Intent intent, Bundle bundle) {
        intent.setClass(this.f4562b, this.f4563c);
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private void m8108a(String str, Notification notification) {
        if (Log.isLoggable("GcmNotification", 3)) {
            Log.d("GcmNotification", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.f4562b.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            str = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(str, 0, notification);
    }

    static boolean m8109a(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    static boolean m8110a(Bundle bundle) {
        return "1".equals(C0342g.m8105a(bundle, "gcm.n.e")) || C0342g.m8105a(bundle, "gcm.n.icon") != null;
    }

    private int m8111b(String str) {
        int identifier;
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.f4562b.getResources();
            identifier = resources.getIdentifier(str, "drawable", this.f4562b.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            identifier = resources.getIdentifier(str, "mipmap", this.f4562b.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            Log.w("GcmNotification", "Icon resource " + str + " not found. Notification will use app icon.");
        }
        identifier = this.f4562b.getApplicationInfo().icon;
        return identifier == 0 ? 17301651 : identifier;
    }

    private String m8112b(Bundle bundle, String str) {
        Object a = C0342g.m8105a(bundle, str);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = C0342g.m8105a(bundle, str + "_loc_key");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        Resources resources = this.f4562b.getResources();
        int identifier = resources.getIdentifier(a2, "string", this.f4562b.getPackageName());
        if (identifier == 0) {
            Log.w("GcmNotification", m8106a(str + "_loc_key") + " resource not found: " + a2 + " Default value will be used.");
            return null;
        }
        String a3 = C0342g.m8105a(bundle, str + "_loc_args");
        if (TextUtils.isEmpty(a3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(a3);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return resources.getString(identifier, strArr);
        } catch (JSONException e) {
            Log.w("GcmNotification", "Malformed " + m8106a(str + "_loc_args") + ": " + a3 + "  Default value will be used.");
            return null;
        } catch (Throwable e2) {
            Log.w("GcmNotification", "Missing format argument for " + a2 + ": " + a3 + " Default value will be used.", e2);
            return null;
        }
    }

    static void m8113b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("gcm.n.")) {
                bundle2.putString(str.substring("gcm.n.".length()), bundle.getString(str));
                it.remove();
            } else if (str.startsWith("gcm.notification.")) {
                bundle2.putString(str.substring("gcm.notification.".length()), bundle.getString(str));
                it.remove();
            }
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("notification", bundle2);
        }
    }

    private Uri m8114c(String str) {
        return TextUtils.isEmpty(str) ? null : ("default".equals(str) || this.f4562b.getResources().getIdentifier(str, "raw", this.f4562b.getPackageName()) == 0) ? RingtoneManager.getDefaultUri(2) : Uri.parse("android.resource://" + this.f4562b.getPackageName() + "/raw/" + str);
    }

    private Notification m8115d(Bundle bundle) {
        CharSequence b = m8112b(bundle, "gcm.n.title");
        CharSequence b2 = m8112b(bundle, "gcm.n.body");
        int b3 = m8111b(C0342g.m8105a(bundle, "gcm.n.icon"));
        Object a = C0342g.m8105a(bundle, "gcm.n.color");
        Uri c = m8114c(C0342g.m8105a(bundle, "gcm.n.sound2"));
        PendingIntent e = m8116e(bundle);
        PendingIntent pendingIntent = null;
        if (C0336a.m8076b(bundle)) {
            e = m8103a(bundle, e);
            pendingIntent = m8117f(bundle);
        }
        bo a2 = new bo(this.f4562b).m1005a(true).m1001a(b3);
        if (TextUtils.isEmpty(b)) {
            a2.m1004a(this.f4562b.getApplicationInfo().loadLabel(this.f4562b.getPackageManager()));
        } else {
            a2.m1004a(b);
        }
        if (!TextUtils.isEmpty(b2)) {
            a2.m1008b(b2);
        }
        if (!TextUtils.isEmpty(a)) {
            a2.m1006b(Color.parseColor(a));
        }
        if (c != null) {
            a2.m1003a(c);
        }
        if (e != null) {
            a2.m1002a(e);
        }
        if (pendingIntent != null) {
            a2.m1007b(pendingIntent);
        }
        return a2.m1000a();
    }

    private PendingIntent m8116e(Bundle bundle) {
        Intent intent;
        Object a = C0342g.m8105a(bundle, "gcm.n.click_action");
        Intent launchIntentForPackage;
        if (TextUtils.isEmpty(a)) {
            launchIntentForPackage = this.f4562b.getPackageManager().getLaunchIntentForPackage(this.f4562b.getPackageName());
            if (launchIntentForPackage == null) {
                Log.w("GcmNotification", "No activity found to launch app");
                return null;
            }
            intent = launchIntentForPackage;
        } else {
            launchIntentForPackage = new Intent(a);
            launchIntentForPackage.setPackage(this.f4562b.getPackageName());
            launchIntentForPackage.setFlags(268435456);
            intent = launchIntentForPackage;
        }
        Bundle bundle2 = new Bundle(bundle);
        C0336a.m8072a(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.f4562b, m8102a(), intent, 1073741824);
    }

    private PendingIntent m8117f(Bundle bundle) {
        Intent intent = new Intent("com.google.android.gms.gcm.NOTIFICATION_DISMISS");
        m8107a(intent, bundle);
        return PendingIntent.getService(this.f4562b, m8102a(), intent, 1073741824);
    }

    boolean m8118c(Bundle bundle) {
        try {
            m8108a(C0342g.m8105a(bundle, "gcm.n.tag"), m8115d(bundle));
            return true;
        } catch (C0343h e) {
            Log.e("GcmNotification", "Failed to show notification: " + e.getMessage());
            return false;
        }
    }
}
