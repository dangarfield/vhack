package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p018b.R;
import android.support.v7.widget.cy;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: android.support.v7.view.menu.v */
public class MenuPopupHelper implements MenuPresenter, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f1565a;
    boolean f1566b;
    private final Context f1567c;
    private final LayoutInflater f1568d;
    private final MenuBuilder f1569e;
    private final MenuPopupHelper f1570f;
    private final boolean f1571g;
    private final int f1572h;
    private final int f1573i;
    private final int f1574j;
    private View f1575k;
    private cy f1576l;
    private ViewTreeObserver f1577m;
    private MenuPresenter f1578n;
    private ViewGroup f1579o;
    private boolean f1580p;
    private int f1581q;
    private int f1582r;

    static {
        f1565a = R.abc_popup_menu_item_layout;
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false, R.popupMenuStyle);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f1582r = 0;
        this.f1567c = context;
        this.f1568d = LayoutInflater.from(context);
        this.f1569e = menuBuilder;
        this.f1570f = new MenuPopupHelper(this, this.f1569e);
        this.f1571g = z;
        this.f1573i = i;
        this.f1574j = i2;
        Resources resources = context.getResources();
        this.f1572h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.abc_config_prefDialogWidth));
        this.f1575k = view;
        menuBuilder.m3224a((MenuPresenter) this, context);
    }

    public void m3377a(View view) {
        this.f1575k = view;
    }

    public void m3378a(boolean z) {
        this.f1566b = z;
    }

    public void m3373a(int i) {
        this.f1582r = i;
    }

    public void m3372a() {
        if (!m3385d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public cy m3384c() {
        return this.f1576l;
    }

    public boolean m3385d() {
        boolean z = false;
        this.f1576l = new cy(this.f1567c, null, this.f1573i, this.f1574j);
        this.f1576l.m4038a((OnDismissListener) this);
        this.f1576l.m4036a((OnItemClickListener) this);
        this.f1576l.m4037a(this.f1570f);
        this.f1576l.m4039a(true);
        View view = this.f1575k;
        if (view == null) {
            return false;
        }
        if (this.f1577m == null) {
            z = true;
        }
        this.f1577m = view.getViewTreeObserver();
        if (z) {
            this.f1577m.addOnGlobalLayoutListener(this);
        }
        this.f1576l.m4035a(view);
        this.f1576l.m4044d(this.f1582r);
        if (!this.f1580p) {
            this.f1581q = m3371g();
            this.f1580p = true;
        }
        this.f1576l.m4048f(this.f1581q);
        this.f1576l.m4050g(2);
        this.f1576l.m4041c();
        this.f1576l.m4057m().setOnKeyListener(this);
        return true;
    }

    public void m3386e() {
        if (m3387f()) {
            this.f1576l.m4053i();
        }
    }

    public void onDismiss() {
        this.f1576l = null;
        this.f1569e.close();
        if (this.f1577m != null) {
            if (!this.f1577m.isAlive()) {
                this.f1577m = this.f1575k.getViewTreeObserver();
            }
            this.f1577m.removeGlobalOnLayoutListener(this);
            this.f1577m = null;
        }
    }

    public boolean m3387f() {
        return this.f1576l != null && this.f1576l.m4055k();
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        MenuPopupHelper menuPopupHelper = this.f1570f;
        menuPopupHelper.f1584b.m3229a(menuPopupHelper.m3389a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m3386e();
        return true;
    }

    private int m3371g() {
        ListAdapter listAdapter = this.f1570f;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.f1579o == null) {
                this.f1579o = new FrameLayout(this.f1567c);
            }
            view = listAdapter.getView(i, view2, this.f1579o);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.f1572h) {
                return this.f1572h;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public void onGlobalLayout() {
        if (m3387f()) {
            View view = this.f1575k;
            if (view == null || !view.isShown()) {
                m3386e();
            } else if (m3387f()) {
                this.f1576l.m4041c();
            }
        }
    }

    public void m3374a(Context context, MenuBuilder menuBuilder) {
    }

    public void m3381b(boolean z) {
        this.f1580p = false;
        if (this.f1570f != null) {
            this.f1570f.notifyDataSetChanged();
        }
    }

    public void m3376a(MenuPresenter menuPresenter) {
        this.f1578n = menuPresenter;
    }

    public boolean m3379a(ad adVar) {
        if (adVar.hasVisibleItems()) {
            boolean z;
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f1567c, adVar, this.f1575k);
            menuPopupHelper.m3376a(this.f1578n);
            int size = adVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = adVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            menuPopupHelper.m3378a(z);
            if (menuPopupHelper.m3385d()) {
                if (this.f1578n == null) {
                    return true;
                }
                this.f1578n.m2872a(adVar);
                return true;
            }
        }
        return false;
    }

    public void m3375a(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f1569e) {
            m3386e();
            if (this.f1578n != null) {
                this.f1578n.m2871a(menuBuilder, z);
            }
        }
    }

    public boolean m3382b() {
        return false;
    }

    public boolean m3380a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean m3383b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }
}
