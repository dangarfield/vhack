package android.support.v4.p009c.p010a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.c.a.n */
class DrawableCompatJellybeanMr1 {
    private static Method f823a;
    private static boolean f824b;
    private static Method f825c;
    private static boolean f826d;

    public static void m1406a(Drawable drawable, int i) {
        if (!f824b) {
            try {
                f823a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f823a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f824b = true;
        }
        if (f823a != null) {
            try {
                f823a.invoke(drawable, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f823a = null;
            }
        }
    }

    public static int m1405a(Drawable drawable) {
        if (!f826d) {
            try {
                f825c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f825c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f826d = true;
        }
        if (f825c != null) {
            try {
                return ((Integer) f825c.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f825c = null;
            }
        }
        return -1;
    }
}
