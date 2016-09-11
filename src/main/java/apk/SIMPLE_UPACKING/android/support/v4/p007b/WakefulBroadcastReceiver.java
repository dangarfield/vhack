package android.support.v4.p007b;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

/* renamed from: android.support.v4.b.z */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final SparseArray f809a;
    private static int f810b;

    static {
        f809a = new SparseArray();
        f810b = 1;
    }

    public static ComponentName m1303a(Context context, Intent intent) {
        synchronized (f809a) {
            int i = f810b;
            f810b++;
            if (f810b <= 0) {
                f810b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            f809a.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean m1304a(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (f809a) {
            WakeLock wakeLock = (WakeLock) f809a.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                f809a.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + intExtra);
            return true;
        }
    }
}
