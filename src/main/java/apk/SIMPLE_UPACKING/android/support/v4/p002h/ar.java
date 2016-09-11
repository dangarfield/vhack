package android.support.v4.p002h;

import android.os.Build.VERSION;
import android.support.v4.p011d.p012a.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemCompat */
/* renamed from: android.support.v4.h.ar */
public final class ar {
    static final av f912a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f912a = new au();
        } else if (i >= 11) {
            f912a = new at();
        } else {
            f912a = new as();
        }
    }

    public static void m1793a(MenuItem menuItem, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setShowAsAction(i);
        } else {
            f912a.m1799a(menuItem, i);
        }
    }

    public static MenuItem m1791a(MenuItem menuItem, View view) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setActionView(view);
        }
        return f912a.m1797a(menuItem, view);
    }

    public static MenuItem m1794b(MenuItem menuItem, int i) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setActionView(i);
        }
        return f912a.m1800b(menuItem, i);
    }

    public static View m1792a(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getActionView();
        }
        return f912a.m1798a(menuItem);
    }

    public static MenuItem m1790a(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).m1428a(actionProvider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static boolean m1795b(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).expandActionView();
        }
        return f912a.m1801b(menuItem);
    }

    public static boolean m1796c(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).isActionViewExpanded();
        }
        return f912a.m1802c(menuItem);
    }
}
