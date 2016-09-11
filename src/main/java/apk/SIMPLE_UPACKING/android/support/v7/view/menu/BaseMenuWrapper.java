package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p011d.p012a.SupportMenuItem;
import android.support.v4.p011d.p012a.SupportSubMenu;
import android.support.v4.p014g.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.v7.view.menu.e */
abstract class BaseMenuWrapper extends BaseWrapper {
    final Context f1464a;
    private Map f1465c;
    private Map f1466d;

    BaseMenuWrapper(Context context, Object obj) {
        super(obj);
        this.f1464a = context;
    }

    final MenuItem m3199a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f1465c == null) {
            this.f1465c = new ArrayMap();
        }
        MenuItem menuItem2 = (MenuItem) this.f1465c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = ab.m3197a(this.f1464a, supportMenuItem);
        this.f1465c.put(supportMenuItem, menuItem2);
        return menuItem2;
    }

    final SubMenu m3200a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f1466d == null) {
            this.f1466d = new ArrayMap();
        }
        SubMenu subMenu2 = (SubMenu) this.f1466d.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = ab.m3198a(this.f1464a, supportSubMenu);
        this.f1466d.put(supportSubMenu, subMenu2);
        return subMenu2;
    }

    final void m3201a() {
        if (this.f1465c != null) {
            this.f1465c.clear();
        }
        if (this.f1466d != null) {
            this.f1466d.clear();
        }
    }

    final void m3202a(int i) {
        if (this.f1465c != null) {
            Iterator it = this.f1465c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m3203b(int i) {
        if (this.f1465c != null) {
            Iterator it = this.f1465c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
