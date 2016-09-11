package android.support.v7.view;

import android.content.Context;
import android.support.v4.p011d.p012a.SupportMenu;
import android.support.v4.p011d.p012a.SupportMenuItem;
import android.support.v4.p014g.SimpleArrayMap;
import android.support.v7.view.menu.ab;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.h */
public class SupportActionModeWrapper implements ActionMode {
    final Callback f1370a;
    final Context f1371b;
    final ArrayList f1372c;
    final SimpleArrayMap f1373d;

    public SupportActionModeWrapper(Context context, Callback callback) {
        this.f1371b = context;
        this.f1370a = callback;
        this.f1372c = new ArrayList();
        this.f1373d = new SimpleArrayMap();
    }

    public boolean m3133a(ActionMode actionMode, Menu menu) {
        return this.f1370a.onCreateActionMode(m3135b(actionMode), m3131a(menu));
    }

    public boolean m3136b(ActionMode actionMode, Menu menu) {
        return this.f1370a.onPrepareActionMode(m3135b(actionMode), m3131a(menu));
    }

    public boolean m3134a(ActionMode actionMode, MenuItem menuItem) {
        return this.f1370a.onActionItemClicked(m3135b(actionMode), ab.m3197a(this.f1371b, (SupportMenuItem) menuItem));
    }

    public void m3132a(ActionMode actionMode) {
        this.f1370a.onDestroyActionMode(m3135b(actionMode));
    }

    private Menu m3131a(Menu menu) {
        Menu menu2 = (Menu) this.f1373d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        menu2 = ab.m3196a(this.f1371b, (SupportMenu) menu);
        this.f1373d.put(menu, menu2);
        return menu2;
    }

    public ActionMode m3135b(ActionMode actionMode) {
        int size = this.f1372c.size();
        for (int i = 0; i < size; i++) {
            SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) this.f1372c.get(i);
            if (supportActionModeWrapper != null && supportActionModeWrapper.f1369b == actionMode) {
                return supportActionModeWrapper;
            }
        }
        ActionMode supportActionModeWrapper2 = new SupportActionModeWrapper(this.f1371b, actionMode);
        this.f1372c.add(supportActionModeWrapper2);
        return supportActionModeWrapper2;
    }
}
