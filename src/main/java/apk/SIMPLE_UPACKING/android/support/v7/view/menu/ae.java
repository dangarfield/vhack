package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p011d.p012a.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuWrapperICS */
class ae extends ac implements SubMenu {
    ae(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    public SupportSubMenu m3266b() {
        return (SupportSubMenu) this.b;
    }

    public SubMenu setHeaderTitle(int i) {
        m3266b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m3266b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        m3266b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m3266b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m3266b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        m3266b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        m3266b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m3266b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return m3199a(m3266b().getItem());
    }
}
