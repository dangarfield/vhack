package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: PopupWindowCompat */
public final class ag {
    static final am f1013a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1013a = new ai();
        } else if (i >= 21) {
            f1013a = new ah();
        } else if (i >= 19) {
            f1013a = new al();
        } else if (i >= 9) {
            f1013a = new ak();
        } else {
            f1013a = new aj();
        }
    }

    public static void m2498a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1013a.m2501a(popupWindow, view, i, i2, i3);
    }

    public static void m2499a(PopupWindow popupWindow, boolean z) {
        f1013a.m2502a(popupWindow, z);
    }

    public static void m2497a(PopupWindow popupWindow, int i) {
        f1013a.m2500a(popupWindow, i);
    }
}
