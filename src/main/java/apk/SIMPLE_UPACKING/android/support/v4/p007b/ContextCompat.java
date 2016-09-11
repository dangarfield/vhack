package android.support.v4.p007b;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import java.io.File;

/* renamed from: android.support.v4.b.c */
public class ContextCompat {
    public static boolean m743a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            ContextCompatJellybean.m1295a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            ContextCompatHoneycomb.m1294a(context, intentArr);
            return true;
        }
    }

    public static final Drawable m741a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return ContextCompatApi21.m1292a(context, i);
        }
        return context.getResources().getDrawable(i);
    }

    public final File m744a(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return ContextCompatApi21.m1293a(context);
        }
        return ContextCompat.m742a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File m742a(File file) {
        synchronized (ContextCompat.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }
}
