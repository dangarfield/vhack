package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.view.MenuItem;

/* renamed from: android.support.v7.widget.x */
class ActionMenuView implements MenuBuilder {
    final /* synthetic */ ActionMenuView f2379a;

    private ActionMenuView(ActionMenuView actionMenuView) {
        this.f2379a = actionMenuView;
    }

    public boolean m4799a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f2379a.f1654l != null && this.f2379a.f1654l.m4663a(menuItem);
    }

    public void m4798a(MenuBuilder menuBuilder) {
        if (this.f2379a.f1649g != null) {
            this.f2379a.f1649g.m2777a(menuBuilder);
        }
    }
}
