package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotificationCompatJellybean */
public class cn implements bh, bi {
    private Builder f631a;
    private final Bundle f632b;
    private List f633c;

    public cn(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
        boolean z5;
        this.f633c = new ArrayList();
        Builder lights = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        lights = lights.setOngoing(z5);
        if ((notification.flags & 8) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        lights = lights.setOnlyAlertOnce(z5);
        if ((notification.flags & 16) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        lights = lights.setAutoCancel(z5).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f631a = lights.setFullScreenIntent(pendingIntent2, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
        this.f632b = new Bundle();
        if (bundle != null) {
            this.f632b.putAll(bundle);
        }
        if (z3) {
            this.f632b.putBoolean("android.support.localOnly", true);
        }
        if (str != null) {
            this.f632b.putString("android.support.groupKey", str);
            if (z4) {
                this.f632b.putBoolean("android.support.isGroupSummary", true);
            } else {
                this.f632b.putBoolean("android.support.useSideChannel", true);
            }
        }
        if (str2 != null) {
            this.f632b.putString("android.support.sortKey", str2);
        }
    }

    public void m1041a(cg cgVar) {
        this.f633c.add(cm.m1034a(this.f631a, cgVar));
    }

    public Builder m1040a() {
        return this.f631a;
    }

    public Notification m1042b() {
        Notification build = this.f631a.build();
        Bundle a = cm.m1035a(build);
        Bundle bundle = new Bundle(this.f632b);
        for (String str : this.f632b.keySet()) {
            if (a.containsKey(str)) {
                bundle.remove(str);
            }
        }
        a.putAll(bundle);
        SparseArray a2 = cm.m1036a(this.f633c);
        if (a2 != null) {
            cm.m1035a(build).putSparseParcelableArray("android.support.actionExtras", a2);
        }
        return build;
    }
}
