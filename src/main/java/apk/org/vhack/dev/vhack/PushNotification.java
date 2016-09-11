package org.vhack.dev.vhack;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.bo;
import android.util.Log;
import com.google.android.gms.gcm.a;

public class PushNotification extends a {
    public void a(String str, Bundle bundle) {
        bundle.getString("message");
        Log.e("PUSH", bundle.getString("message"));
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, SplashActivity.class), 0);
        getResources();
        ((NotificationManager) getSystemService("notification")).notify(0, new bo(this).c(bundle.getString("tickerText")).a(2130837687).a(bundle.getString("title")).b(bundle.getString("message")).a(activity).a(true).a());
    }
}
