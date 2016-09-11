package android.support.v7.view;

import android.content.res.TypedArray;
import android.support.v4.p002h.ActionProvider;
import android.support.v4.p002h.ar;
import android.support.v7.p018b.R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

/* renamed from: android.support.v7.view.k */
class SupportMenuInflater {
    final /* synthetic */ SupportMenuInflater f1383a;
    private Menu f1384b;
    private int f1385c;
    private int f1386d;
    private int f1387e;
    private int f1388f;
    private boolean f1389g;
    private boolean f1390h;
    private boolean f1391i;
    private int f1392j;
    private int f1393k;
    private CharSequence f1394l;
    private CharSequence f1395m;
    private int f1396n;
    private char f1397o;
    private char f1398p;
    private int f1399q;
    private boolean f1400r;
    private boolean f1401s;
    private boolean f1402t;
    private int f1403u;
    private int f1404v;
    private String f1405w;
    private String f1406x;
    private String f1407y;
    private ActionProvider f1408z;

    public SupportMenuInflater(SupportMenuInflater supportMenuInflater, Menu menu) {
        this.f1383a = supportMenuInflater;
        this.f1384b = menu;
        m3150a();
    }

    public void m3150a() {
        this.f1385c = 0;
        this.f1386d = 0;
        this.f1387e = 0;
        this.f1388f = 0;
        this.f1389g = true;
        this.f1390h = true;
    }

    public void m3151a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f1383a.f1378e.obtainStyledAttributes(attributeSet, R.MenuGroup);
        this.f1385c = obtainStyledAttributes.getResourceId(R.MenuGroup_android_id, 0);
        this.f1386d = obtainStyledAttributes.getInt(R.MenuGroup_android_menuCategory, 0);
        this.f1387e = obtainStyledAttributes.getInt(R.MenuGroup_android_orderInCategory, 0);
        this.f1388f = obtainStyledAttributes.getInt(R.MenuGroup_android_checkableBehavior, 0);
        this.f1389g = obtainStyledAttributes.getBoolean(R.MenuGroup_android_visible, true);
        this.f1390h = obtainStyledAttributes.getBoolean(R.MenuGroup_android_enabled, true);
        obtainStyledAttributes.recycle();
    }

    public void m3153b(AttributeSet attributeSet) {
        boolean z = true;
        TypedArray obtainStyledAttributes = this.f1383a.f1378e.obtainStyledAttributes(attributeSet, R.MenuItem);
        this.f1392j = obtainStyledAttributes.getResourceId(R.MenuItem_android_id, 0);
        this.f1393k = (obtainStyledAttributes.getInt(R.MenuItem_android_menuCategory, this.f1386d) & -65536) | (obtainStyledAttributes.getInt(R.MenuItem_android_orderInCategory, this.f1387e) & 65535);
        this.f1394l = obtainStyledAttributes.getText(R.MenuItem_android_title);
        this.f1395m = obtainStyledAttributes.getText(R.MenuItem_android_titleCondensed);
        this.f1396n = obtainStyledAttributes.getResourceId(R.MenuItem_android_icon, 0);
        this.f1397o = m3146a(obtainStyledAttributes.getString(R.MenuItem_android_alphabeticShortcut));
        this.f1398p = m3146a(obtainStyledAttributes.getString(R.MenuItem_android_numericShortcut));
        if (obtainStyledAttributes.hasValue(R.MenuItem_android_checkable)) {
            this.f1399q = obtainStyledAttributes.getBoolean(R.MenuItem_android_checkable, false) ? 1 : 0;
        } else {
            this.f1399q = this.f1388f;
        }
        this.f1400r = obtainStyledAttributes.getBoolean(R.MenuItem_android_checked, false);
        this.f1401s = obtainStyledAttributes.getBoolean(R.MenuItem_android_visible, this.f1389g);
        this.f1402t = obtainStyledAttributes.getBoolean(R.MenuItem_android_enabled, this.f1390h);
        this.f1403u = obtainStyledAttributes.getInt(R.MenuItem_showAsAction, -1);
        this.f1407y = obtainStyledAttributes.getString(R.MenuItem_android_onClick);
        this.f1404v = obtainStyledAttributes.getResourceId(R.MenuItem_actionLayout, 0);
        this.f1405w = obtainStyledAttributes.getString(R.MenuItem_actionViewClass);
        this.f1406x = obtainStyledAttributes.getString(R.MenuItem_actionProviderClass);
        if (this.f1406x == null) {
            z = false;
        }
        if (z && this.f1404v == 0 && this.f1405w == null) {
            this.f1408z = (ActionProvider) m3148a(this.f1406x, SupportMenuInflater.f1375b, this.f1383a.f1377d);
        } else {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f1408z = null;
        }
        obtainStyledAttributes.recycle();
        this.f1391i = false;
    }

    private char m3146a(String str) {
        if (str == null) {
            return '\u0000';
        }
        return str.charAt(0);
    }

    private void m3149a(MenuItem menuItem) {
        boolean z = true;
        menuItem.setChecked(this.f1400r).setVisible(this.f1401s).setEnabled(this.f1402t).setCheckable(this.f1399q >= 1).setTitleCondensed(this.f1395m).setIcon(this.f1396n).setAlphabeticShortcut(this.f1397o).setNumericShortcut(this.f1398p);
        if (this.f1403u >= 0) {
            ar.m1793a(menuItem, this.f1403u);
        }
        if (this.f1407y != null) {
            if (this.f1383a.f1378e.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new SupportMenuInflater(this.f1383a.m3143c(), this.f1407y));
        }
        if (menuItem instanceof MenuItemImpl) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        }
        if (this.f1399q >= 2) {
            if (menuItem instanceof MenuItemImpl) {
                ((MenuItemImpl) menuItem).m3332a(true);
            } else if (menuItem instanceof MenuItemWrapperICS) {
                ((MenuItemWrapperICS) menuItem).m3353a(true);
            }
        }
        if (this.f1405w != null) {
            ar.m1791a(menuItem, (View) m3148a(this.f1405w, SupportMenuInflater.f1374a, this.f1383a.f1376c));
        } else {
            z = false;
        }
        if (this.f1404v > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                ar.m1794b(menuItem, this.f1404v);
            }
        }
        if (this.f1408z != null) {
            ar.m1790a(menuItem, this.f1408z);
        }
    }

    public void m3152b() {
        this.f1391i = true;
        m3149a(this.f1384b.add(this.f1385c, this.f1392j, this.f1393k, this.f1394l));
    }

    public SubMenu m3154c() {
        this.f1391i = true;
        SubMenu addSubMenu = this.f1384b.addSubMenu(this.f1385c, this.f1392j, this.f1393k, this.f1394l);
        m3149a(addSubMenu.getItem());
        return addSubMenu;
    }

    public boolean m3155d() {
        return this.f1391i;
    }

    private Object m3148a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor constructor = this.f1383a.f1378e.getClassLoader().loadClass(str).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Throwable e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }
}
