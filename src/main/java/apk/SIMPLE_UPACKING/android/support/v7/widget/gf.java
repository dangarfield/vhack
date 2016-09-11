package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.ad;
import android.view.ViewGroup.LayoutParams;

/* compiled from: Toolbar */
class gf implements MenuPresenter {
    MenuBuilder f2305a;
    MenuItemImpl f2306b;
    final /* synthetic */ Toolbar f2307c;

    private gf(Toolbar toolbar) {
        this.f2307c = toolbar;
    }

    public void m4665a(Context context, MenuBuilder menuBuilder) {
        if (!(this.f2305a == null || this.f2306b == null)) {
            this.f2305a.m3242d(this.f2306b);
        }
        this.f2305a = menuBuilder;
    }

    public void m4669b(boolean z) {
        Object obj = null;
        if (this.f2306b != null) {
            if (this.f2305a != null) {
                int size = this.f2305a.size();
                for (int i = 0; i < size; i++) {
                    if (this.f2305a.getItem(i) == this.f2306b) {
                        obj = 1;
                        break;
                    }
                }
            }
            if (obj == null) {
                m4671b(this.f2305a, this.f2306b);
            }
        }
    }

    public boolean m4667a(ad adVar) {
        return false;
    }

    public void m4666a(MenuBuilder menuBuilder, boolean z) {
    }

    public boolean m4670b() {
        return false;
    }

    public boolean m4668a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        this.f2307c.m3879p();
        if (this.f2307c.f1819i.getParent() != this.f2307c) {
            this.f2307c.addView(this.f2307c.f1819i);
        }
        this.f2307c.f1811a = menuItemImpl.getActionView();
        this.f2306b = menuItemImpl;
        if (this.f2307c.f1811a.getParent() != this.f2307c) {
            LayoutParams i = this.f2307c.m3897i();
            i.a = 8388611 | (this.f2307c.f1824n & 112);
            i.f2308b = 2;
            this.f2307c.f1811a.setLayoutParams(i);
            this.f2307c.addView(this.f2307c.f1811a);
        }
        this.f2307c.m3898j();
        this.f2307c.requestLayout();
        menuItemImpl.m3341e(true);
        if (this.f2307c.f1811a instanceof CollapsibleActionView) {
            ((CollapsibleActionView) this.f2307c.f1811a).m3110a();
        }
        return true;
    }

    public boolean m4671b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        if (this.f2307c.f1811a instanceof CollapsibleActionView) {
            ((CollapsibleActionView) this.f2307c.f1811a).m3111b();
        }
        this.f2307c.removeView(this.f2307c.f1811a);
        this.f2307c.removeView(this.f2307c.f1819i);
        this.f2307c.f1811a = null;
        this.f2307c.m3899k();
        this.f2306b = null;
        this.f2307c.requestLayout();
        menuItemImpl.m3341e(false);
        return true;
    }
}
