package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils */
class cd {
    private static final cf f403a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f403a = new ch();
        } else {
            f403a = new cg();
        }
    }

    static void m661a(ViewGroup viewGroup, View view, Rect rect) {
        f403a.m663a(viewGroup, view, rect);
    }

    static void m662b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m661a(viewGroup, view, rect);
    }
}
