package android.support.v4.p002h;

import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemCompatHoneycomb */
/* renamed from: android.support.v4.h.ax */
class ax {
    public static void m1821a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m1819a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static MenuItem m1822b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    public static View m1820a(MenuItem menuItem) {
        return menuItem.getActionView();
    }
}
