package android.support.v4.p007b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* renamed from: android.support.v4.b.d */
class ContextCompatApi21 {
    public static Drawable m1292a(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File m1293a(Context context) {
        return context.getNoBackupFilesDir();
    }
}
