package org.vhack.dev.vhack;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0274e;
import com.google.android.gms.gcm.C0339d;

/* compiled from: GCMClientManager */
public class br {
    private C0339d f5310a;
    private String f5311b;
    private String f5312c;
    private Activity f5313d;

    public br(Activity activity, String str) {
        this.f5313d = activity;
        this.f5312c = str;
        this.f5310a = C0339d.m8086a((Context) activity);
    }

    private static int m9103a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    public void m9118a(bt btVar) {
        if (m9109a()) {
            this.f5311b = m9112b(m9110b());
            if (this.f5311b.isEmpty()) {
                m9113b(btVar);
                return;
            }
            Log.i("GCMClientManager", this.f5311b);
            btVar.m9122a(this.f5311b, false);
            return;
        }
        Log.i("GCMClientManager", "No valid Google Play Services APK found.");
    }

    private void m9113b(bt btVar) {
        new bs(this, btVar).execute(new Void[]{null, null, null});
    }

    private String m9112b(Context context) {
        SharedPreferences c = m9115c(context);
        String string = c.getString("registration_id", "");
        if (string.isEmpty()) {
            Log.i("GCMClientManager", "Registration not found.");
            return "";
        } else if (c.getInt("appVersion", Integer.MIN_VALUE) == m9103a(context)) {
            return string;
        } else {
            Log.i("GCMClientManager", "App version changed.");
            return "";
        }
    }

    private void m9107a(Context context, String str) {
        SharedPreferences c = m9115c(context);
        int a = m9103a(context);
        Log.i("GCMClientManager", "Saving regId on app version " + a);
        Editor edit = c.edit();
        edit.putString("registration_id", str);
        edit.putInt("appVersion", a);
        edit.commit();
    }

    private SharedPreferences m9115c(Context context) {
        return m9110b().getSharedPreferences(context.getPackageName(), 0);
    }

    private boolean m9109a() {
        int a = C0274e.m7670a(m9110b());
        if (a == 0) {
            return true;
        }
        if (C0274e.m7674a(a)) {
            C0274e.m7671a(a, m9114c(), 9000).show();
        } else {
            Log.i("GCMClientManager", "This device is not supported.");
        }
        return false;
    }

    private Context m9110b() {
        return this.f5313d;
    }

    private Activity m9114c() {
        return this.f5313d;
    }
}
