package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatJellybean */
class cm {
    private static final Object f627a;
    private static Field f628b;
    private static boolean f629c;
    private static final Object f630d;

    static {
        f627a = new Object();
        f630d = new Object();
    }

    public static void m1038a(bi biVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(biVar.m980a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void m1037a(bi biVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(biVar.m980a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void m1039a(bi biVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(biVar.m980a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray m1036a(List list) {
        SparseArray sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle m1035a(Notification notification) {
        synchronized (f627a) {
            if (f629c) {
                return null;
            }
            try {
                if (f628b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f628b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f629c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f628b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f628b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f629c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f629c = true;
                return null;
            }
        }
    }

    public static Bundle m1034a(Builder builder, cg cgVar) {
        builder.addAction(cgVar.m987a(), cgVar.m988b(), cgVar.m989c());
        Bundle bundle = new Bundle(cgVar.m990d());
        if (cgVar.m991f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", da.m1060a(cgVar.m991f()));
        }
        return bundle;
    }
}
