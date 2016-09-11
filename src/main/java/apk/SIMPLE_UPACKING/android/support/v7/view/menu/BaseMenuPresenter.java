package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p002h.bu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.d */
public abstract class BaseMenuPresenter implements MenuPresenter {
    protected Context f1505a;
    protected Context f1506b;
    protected MenuBuilder f1507c;
    protected LayoutInflater f1508d;
    protected LayoutInflater f1509e;
    protected MenuView f1510f;
    private MenuPresenter f1511g;
    private int f1512h;
    private int f1513i;
    private int f1514j;

    public abstract void m3295a(MenuItemImpl menuItemImpl, aa aaVar);

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.f1505a = context;
        this.f1508d = LayoutInflater.from(context);
        this.f1512h = i;
        this.f1513i = i2;
    }

    public void m3293a(Context context, MenuBuilder menuBuilder) {
        this.f1506b = context;
        this.f1509e = LayoutInflater.from(this.f1506b);
        this.f1507c = menuBuilder;
    }

    public MenuView m3290a(ViewGroup viewGroup) {
        if (this.f1510f == null) {
            this.f1510f = (MenuView) this.f1508d.inflate(this.f1512h, viewGroup, false);
            this.f1510f.m216a(this.f1507c);
            m3303b(true);
        }
        return this.f1510f;
    }

    public void m3303b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1510f;
        if (viewGroup != null) {
            int i;
            if (this.f1507c != null) {
                this.f1507c.m3248j();
                ArrayList i2 = this.f1507c.m3247i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    MenuItemImpl menuItemImpl = (MenuItemImpl) i2.get(i3);
                    if (m3298a(i, menuItemImpl)) {
                        View childAt = viewGroup.getChildAt(i);
                        MenuItemImpl itemData = childAt instanceof aa ? ((aa) childAt).getItemData() : null;
                        View a = m3291a(menuItemImpl, childAt, viewGroup);
                        if (menuItemImpl != itemData) {
                            a.setPressed(false);
                            bu.m1964u(a);
                        }
                        if (a != childAt) {
                            m3297a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!m3301a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void m3297a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1510f).addView(view, i);
    }

    protected boolean m3301a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void m3296a(MenuPresenter menuPresenter) {
        this.f1511g = menuPresenter;
    }

    public MenuPresenter m3289a() {
        return this.f1511g;
    }

    public aa m3302b(ViewGroup viewGroup) {
        return (aa) this.f1508d.inflate(this.f1513i, viewGroup, false);
    }

    public View m3291a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        aa aaVar;
        if (view instanceof aa) {
            aaVar = (aa) view;
        } else {
            aaVar = m3302b(viewGroup);
        }
        m3295a(menuItemImpl, aaVar);
        return (View) aaVar;
    }

    public boolean m3298a(int i, MenuItemImpl menuItemImpl) {
        return true;
    }

    public void m3294a(MenuBuilder menuBuilder, boolean z) {
        if (this.f1511g != null) {
            this.f1511g.m2871a(menuBuilder, z);
        }
    }

    public boolean m3299a(ad adVar) {
        if (this.f1511g != null) {
            return this.f1511g.m2872a(adVar);
        }
        return false;
    }

    public boolean m3304b() {
        return false;
    }

    public boolean m3300a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean m3305b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void m3292a(int i) {
        this.f1514j = i;
    }
}
