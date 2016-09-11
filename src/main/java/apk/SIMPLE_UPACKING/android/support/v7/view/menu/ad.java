package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p007b.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuBuilder */
public class ad extends MenuBuilder implements SubMenu {
    private MenuBuilder f1492d;
    private MenuItemImpl f1493e;

    public ad(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f1492d = menuBuilder;
        this.f1493e = menuItemImpl;
    }

    public void setQwertyMode(boolean z) {
        this.f1492d.setQwertyMode(z);
    }

    public boolean m3260b() {
        return this.f1492d.m3236b();
    }

    public boolean m3261c() {
        return this.f1492d.m3239c();
    }

    public Menu m3265s() {
        return this.f1492d;
    }

    public MenuItem getItem() {
        return this.f1493e;
    }

    public void m3258a(MenuBuilder menuBuilder) {
        this.f1492d.m3221a(menuBuilder);
    }

    public MenuBuilder m3264p() {
        return this.f1492d;
    }

    boolean m3259a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.m3228a(menuBuilder, menuItem) || this.f1492d.m3228a(menuBuilder, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1493e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1493e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m3214a(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m3214a(ContextCompat.m741a(m3243e(), i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m3216a(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m3216a(m3243e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m3215a(view);
        return this;
    }

    public boolean m3262c(MenuItemImpl menuItemImpl) {
        return this.f1492d.m3240c(menuItemImpl);
    }

    public boolean m3263d(MenuItemImpl menuItemImpl) {
        return this.f1492d.m3242d(menuItemImpl);
    }

    public String m3257a() {
        int itemId = this.f1493e != null ? this.f1493e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.m3219a() + ":" + itemId;
    }
}
