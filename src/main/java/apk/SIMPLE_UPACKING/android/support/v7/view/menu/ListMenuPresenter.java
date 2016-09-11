package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.p018b.R;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

/* renamed from: android.support.v7.view.menu.g */
public class ListMenuPresenter implements MenuPresenter, OnItemClickListener {
    Context f1515a;
    LayoutInflater f1516b;
    MenuBuilder f1517c;
    ExpandedMenuView f1518d;
    int f1519e;
    int f1520f;
    ListMenuPresenter f1521g;
    private int f1522h;
    private MenuPresenter f1523i;

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f1515a = context;
        this.f1516b = LayoutInflater.from(this.f1515a);
    }

    public ListMenuPresenter(int i, int i2) {
        this.f1520f = i;
        this.f1519e = i2;
    }

    public void m3309a(Context context, MenuBuilder menuBuilder) {
        if (this.f1519e != 0) {
            this.f1515a = new ContextThemeWrapper(context, this.f1519e);
            this.f1516b = LayoutInflater.from(this.f1515a);
        } else if (this.f1515a != null) {
            this.f1515a = context;
            if (this.f1516b == null) {
                this.f1516b = LayoutInflater.from(this.f1515a);
            }
        }
        this.f1517c = menuBuilder;
        if (this.f1521g != null) {
            this.f1521g.notifyDataSetChanged();
        }
    }

    public MenuView m3307a(ViewGroup viewGroup) {
        if (this.f1518d == null) {
            this.f1518d = (ExpandedMenuView) this.f1516b.inflate(R.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1521g == null) {
                this.f1521g = new ListMenuPresenter(this);
            }
            this.f1518d.setAdapter(this.f1521g);
            this.f1518d.setOnItemClickListener(this);
        }
        return this.f1518d;
    }

    public ListAdapter m3308a() {
        if (this.f1521g == null) {
            this.f1521g = new ListMenuPresenter(this);
        }
        return this.f1521g;
    }

    public void m3314b(boolean z) {
        if (this.f1521g != null) {
            this.f1521g.notifyDataSetChanged();
        }
    }

    public void m3311a(MenuPresenter menuPresenter) {
        this.f1523i = menuPresenter;
    }

    public boolean m3312a(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(adVar).m3320a(null);
        if (this.f1523i != null) {
            this.f1523i.m2872a(adVar);
        }
        return true;
    }

    public void m3310a(MenuBuilder menuBuilder, boolean z) {
        if (this.f1523i != null) {
            this.f1523i.m2871a(menuBuilder, z);
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1517c.m3230a(this.f1521g.m3317a(i), (MenuPresenter) this, 0);
    }

    public boolean m3315b() {
        return false;
    }

    public boolean m3313a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean m3316b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }
}
