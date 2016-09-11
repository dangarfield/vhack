package android.support.v4.app;

import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;

/* compiled from: NotificationCompatApi20 */
class cb {
    public static void m1022a(Builder builder, cg cgVar) {
        Action.Builder builder2 = new Action.Builder(cgVar.m987a(), cgVar.m988b(), cgVar.m989c());
        if (cgVar.m991f() != null) {
            for (RemoteInput addRemoteInput : cw.m1056a(cgVar.m991f())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (cgVar.m990d() != null) {
            builder2.addExtras(cgVar.m990d());
        }
        builder.addAction(builder2.build());
    }
}
