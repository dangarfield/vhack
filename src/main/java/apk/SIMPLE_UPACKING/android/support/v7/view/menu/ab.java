package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p011d.p012a.SupportMenu;
import android.support.v4.p011d.p012a.SupportMenuItem;
import android.support.v4.p011d.p012a.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: MenuWrapperFactory */
public final class ab {
    public static Menu m3196a(Context context, SupportMenu supportMenu) {
        if (VERSION.SDK_INT >= 14) {
            return new ac(context, supportMenu);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m3197a(Context context, SupportMenuItem supportMenuItem) {
        if (VERSION.SDK_INT >= 16) {
            return new MenuItemWrapperJB(context, supportMenuItem);
        }
        if (VERSION.SDK_INT >= 14) {
            return new MenuItemWrapperICS(context, supportMenuItem);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m3198a(Context context, SupportSubMenu supportSubMenu) {
        if (VERSION.SDK_INT >= 14) {
            return new ae(context, supportSubMenu);
        }
        throw new UnsupportedOperationException();
    }
}
