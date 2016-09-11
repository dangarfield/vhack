package android.support.v7.widget;

import android.view.MenuItem;

/* compiled from: Toolbar */
class gc implements ActionMenuView {
    final /* synthetic */ Toolbar f2302a;

    gc(Toolbar toolbar) {
        this.f2302a = toolbar;
    }

    public boolean m4664a(MenuItem menuItem) {
        if (this.f2302a.f1801E != null) {
            return this.f2302a.f1801E.m4673a(menuItem);
        }
        return false;
    }
}
