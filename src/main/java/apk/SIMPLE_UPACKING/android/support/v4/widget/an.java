package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* compiled from: PopupWindowCompatApi21 */
class an {
    private static Field f1014a;

    static {
        try {
            f1014a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f1014a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void m2511a(PopupWindow popupWindow, boolean z) {
        if (f1014a != null) {
            try {
                f1014a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
