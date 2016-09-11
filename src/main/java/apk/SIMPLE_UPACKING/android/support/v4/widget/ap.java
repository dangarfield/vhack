package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* compiled from: PopupWindowCompatGingerbread */
class ap {
    private static Method f1015a;
    private static boolean f1016b;

    static void m2514a(PopupWindow popupWindow, int i) {
        if (!f1016b) {
            try {
                f1015a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f1015a.setAccessible(true);
            } catch (Exception e) {
            }
            f1016b = true;
        }
        if (f1015a != null) {
            try {
                f1015a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
