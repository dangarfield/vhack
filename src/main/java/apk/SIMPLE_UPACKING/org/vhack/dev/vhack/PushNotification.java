package org.vhack.dev.vhack;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.bo;
import android.util.Log;
import com.google.android.gms.gcm.C0336a;

public class PushNotification extends C0336a {
    public void m9028a(String str, Bundle bundle) {
        bundle.getString("message");
        Log.e("PUSH", bundle.getString("message"));
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, SplashActivity.class), 0);
        getResources();
        ((NotificationManager) getSystemService("notification")).notify(0, new bo(this).m1010c(bundle.getString("tickerText")).m1001a(2130837687).m1004a(bundle.getString("title")).m1008b(bundle.getString("message")).m1002a(activity).m1005a(true).m1000a());
    }
}
