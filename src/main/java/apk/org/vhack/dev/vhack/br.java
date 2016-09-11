package org.vhack.dev.vhack;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.e;
import com.google.android.gms.gcm.d;

/* compiled from: GCMClientManager */
public class br {
    private d a;
    private String b;
    private String c;
    private Activity d;

    public br(Activity activity, String str) {
        this.d = activity;
        this.c = str;
        this.a = d.a((Context) activity);
    }

    private static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    public void a(bt btVar) {
        if (a()) {
            this.b = b(b());
            if (this.b.isEmpty()) {
                b(btVar);
                return;
            }
            Log.i("GCMClientManager", this.b);
            btVar.a(this.b, false);
            return;
        }
        Log.i("GCMClientManager", "No valid Google Play Services APK found.");
    }

    private void b(bt btVar) {
        new bs(this, btVar).execute(new Void[]{null, null, null});
    }

    private String b(Context context) {
        SharedPreferences c = c(context);
        String string = c.getString("registration_id", "");
        if (string.isEmpty()) {
            Log.i("GCMClientManager", "Registration not found.");
            return "";
        } else if (c.getInt("appVersion", Integer.MIN_VALUE) == a(context)) {
            return string;
        } else {
            Log.i("GCMClientManager", "App version changed.");
            return "";
        }
    }

    private void a(Context context, String str) {
        SharedPreferences c = c(context);
        int a = a(context);
        Log.i("GCMClientManager", "Saving regId on app version " + a);
        Editor edit = c.edit();
        edit.putString("registration_id", str);
        edit.putInt("appVersion", a);
        edit.commit();
    }

    private SharedPreferences c(Context context) {
        return b().getSharedPreferences(context.getPackageName(), 0);
    }

    private boolean a() {
        int a = e.a(b());
        if (a == 0) {
            return true;
        }
        if (e.a(a)) {
            e.getUpdate(a, c(), 9000).show();
        } else {
            Log.i("GCMClientManager", "This device is not supported.");
        }
        return false;
    }

    private Context b() {
        return this.d;
    }

    private Activity c() {
        return this.d;
    }
}
