package android.support.v7.view.menu;

import android.support.v4.p002h.aw;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

/* renamed from: android.support.v7.view.menu.r */
class MenuItemWrapperICS extends BaseWrapper implements aw {
    final /* synthetic */ MenuItemWrapperICS f1561a;

    MenuItemWrapperICS(MenuItemWrapperICS menuItemWrapperICS, OnActionExpandListener onActionExpandListener) {
        this.f1561a = menuItemWrapperICS;
        super(onActionExpandListener);
    }

    public boolean m3361a(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f1561a.m3199a(menuItem));
    }

    public boolean m3362b(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f1561a.m3199a(menuItem));
    }
}
