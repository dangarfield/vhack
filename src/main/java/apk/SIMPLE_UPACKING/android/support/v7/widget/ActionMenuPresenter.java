package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.ActionProvider;
import android.support.v7.p018b.R;
import android.support.v7.p021f.ActionBarTransition;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.ad;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

/* renamed from: android.support.v7.widget.k */
class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider {
    private ActionMenuPresenter f2340A;
    final ActionMenuPresenter f2341g;
    int f2342h;
    private ActionMenuPresenter f2343i;
    private Drawable f2344j;
    private boolean f2345k;
    private boolean f2346l;
    private boolean f2347m;
    private int f2348n;
    private int f2349o;
    private int f2350p;
    private boolean f2351q;
    private boolean f2352r;
    private boolean f2353s;
    private boolean f2354t;
    private int f2355u;
    private final SparseBooleanArray f2356v;
    private View f2357w;
    private ActionMenuPresenter f2358x;
    private ActionMenuPresenter f2359y;
    private ActionMenuPresenter f2360z;

    public ActionMenuPresenter(Context context) {
        super(context, R.abc_action_menu_layout, R.abc_action_menu_item_layout);
        this.f2356v = new SparseBooleanArray();
        this.f2341g = new ActionMenuPresenter();
    }

    public void m4767a(Context context, MenuBuilder menuBuilder) {
        super.m3293a(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy a = ActionBarPolicy.m3102a(context);
        if (!this.f2347m) {
            this.f2346l = a.m3104b();
        }
        if (!this.f2353s) {
            this.f2348n = a.m3105c();
        }
        if (!this.f2351q) {
            this.f2350p = a.m3103a();
        }
        int i = this.f2348n;
        if (this.f2346l) {
            if (this.f2343i == null) {
                this.f2343i = new ActionMenuPresenter(this, this.a);
                if (this.f2345k) {
                    this.f2343i.setImageDrawable(this.f2344j);
                    this.f2344j = null;
                    this.f2345k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f2343i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f2343i.getMeasuredWidth();
        } else {
            this.f2343i = null;
        }
        this.f2349o = i;
        this.f2355u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f2357w = null;
    }

    public void m4768a(Configuration configuration) {
        if (!this.f2351q) {
            this.f2350p = this.b.getResources().getInteger(R.abc_max_action_buttons);
        }
        if (this.c != null) {
            this.c.m3235b(true);
        }
    }

    public void m4780c(boolean z) {
        this.f2346l = z;
        this.f2347m = true;
    }

    public void m4781d(boolean z) {
        this.f2354t = z;
    }

    public void m4769a(Drawable drawable) {
        if (this.f2343i != null) {
            this.f2343i.setImageDrawable(drawable);
            return;
        }
        this.f2345k = true;
        this.f2344j = drawable;
    }

    public Drawable m4779c() {
        if (this.f2343i != null) {
            return this.f2343i.getDrawable();
        }
        if (this.f2345k) {
            return this.f2344j;
        }
        return null;
    }

    public MenuView m4765a(ViewGroup viewGroup) {
        MenuView a = super.m3290a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public View m4766a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.m3350n()) {
            actionView = super.m3291a(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m3448a(layoutParams));
        }
        return actionView;
    }

    public void m4771a(MenuItemImpl menuItemImpl, aa aaVar) {
        aaVar.m95a(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aaVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f2340A == null) {
            this.f2340A = new ActionMenuPresenter();
        }
        actionMenuItemView.setPopupCallback(this.f2340A);
    }

    public boolean m4774a(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.m3346j();
    }

    public void m4777b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            ActionBarTransition.m3101a(viewGroup);
        }
        super.m3303b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.m3249k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                ActionProvider a = ((MenuItemImpl) k.get(i)).m3328a();
                if (a != null) {
                    a.m2396a((ActionProvider) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.m3250l() : null;
        if (this.f2346l && l != null) {
            i = l.size();
            if (i == 1) {
                int i4;
                if (((MenuItemImpl) l.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f2343i == null) {
                this.f2343i = new ActionMenuPresenter(this, this.a);
            }
            viewGroup = (ViewGroup) this.f2343i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2343i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f2343i, actionMenuView.m3457c());
            }
        } else if (this.f2343i != null && this.f2343i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f2343i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f2346l);
    }

    public boolean m4776a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f2343i) {
            return false;
        }
        return super.m3301a(viewGroup, i);
    }

    public boolean m4775a(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        ad adVar2 = adVar;
        while (adVar2.m3265s() != this.c) {
            adVar2 = (ad) adVar2.m3265s();
        }
        View a = m4756a(adVar2.getItem());
        if (a == null) {
            if (this.f2343i == null) {
                return false;
            }
            a = this.f2343i;
        }
        this.f2342h = adVar.getItem().getItemId();
        this.f2359y = new ActionMenuPresenter(this, this.b, adVar);
        this.f2359y.m3377a(a);
        this.f2359y.m3372a();
        super.m3299a(adVar);
        return true;
    }

    private View m4756a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof aa) && ((aa) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean m4782d() {
        if (!this.f2346l || m4786h() || this.c == null || this.f == null || this.f2360z != null || this.c.m3250l().isEmpty()) {
            return false;
        }
        this.f2360z = new ActionMenuPresenter(this, new ActionMenuPresenter(this, this.b, this.c, this.f2343i, true));
        ((View) this.f).post(this.f2360z);
        super.m3299a(null);
        return true;
    }

    public boolean m4783e() {
        if (this.f2360z == null || this.f == null) {
            MenuPopupHelper menuPopupHelper = this.f2358x;
            if (menuPopupHelper == null) {
                return false;
            }
            menuPopupHelper.m3386e();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f2360z);
        this.f2360z = null;
        return true;
    }

    public boolean m4784f() {
        return m4783e() | m4785g();
    }

    public boolean m4785g() {
        if (this.f2359y == null) {
            return false;
        }
        this.f2359y.m3386e();
        return true;
    }

    public boolean m4786h() {
        return this.f2358x != null && this.f2358x.m3387f();
    }

    public boolean m4787i() {
        return this.f2360z != null || m4786h();
    }

    public boolean m4778b() {
        int i;
        ArrayList i2 = this.c.m3247i();
        int size = i2.size();
        int i3 = this.f2350p;
        int i4 = this.f2349o;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) i2.get(i7);
            if (menuItemImpl.m3348l()) {
                i5++;
            } else if (menuItemImpl.m3347k()) {
                i6++;
            } else {
                obj = 1;
            }
            if (this.f2354t && menuItemImpl.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i3;
            }
            i7++;
            i3 = i;
        }
        if (this.f2346l && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.f2356v;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f2352r) {
            i = i4 / this.f2355u;
            i6 = ((i4 % this.f2355u) / i) + this.f2355u;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            menuItemImpl = (MenuItemImpl) i2.get(i8);
            int i10;
            if (menuItemImpl.m3348l()) {
                View a = m4766a(menuItemImpl, this.f2357w, viewGroup);
                if (this.f2357w == null) {
                    this.f2357w = a;
                }
                if (this.f2352r) {
                    i9 -= ActionMenuView.m3443a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = menuItemImpl.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                menuItemImpl.m3339d(true);
                i = i10;
                i3 = i7;
            } else if (menuItemImpl.m3347k()) {
                boolean z;
                int groupId = menuItemImpl.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.f2352r || i9 > 0);
                if (z3) {
                    View a2 = m4766a(menuItemImpl, this.f2357w, viewGroup);
                    if (this.f2357w == null) {
                        this.f2357w = a2;
                    }
                    boolean z4;
                    if (this.f2352r) {
                        int a3 = ActionMenuView.m3443a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.f2352r) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        MenuItemImpl menuItemImpl2 = (MenuItemImpl) i2.get(i7);
                        if (menuItemImpl2.getGroupId() == groupId) {
                            if (menuItemImpl2.m3346j()) {
                                i5++;
                            }
                            menuItemImpl2.m3339d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                menuItemImpl.m3339d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                menuItemImpl.m3339d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public void m4770a(MenuBuilder menuBuilder, boolean z) {
        m4784f();
        super.m3294a(menuBuilder, z);
    }

    public void m4773a(boolean z) {
        if (z) {
            super.m3299a(null);
        } else {
            this.c.m3227a(false);
        }
    }

    public void m4772a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.m3449a(this.c);
    }
}
