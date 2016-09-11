package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.p002h.ActionProvider;
import android.support.v4.p002h.ar;
import android.support.v4.p007b.ContextCompat;
import android.support.v4.p011d.p012a.SupportMenu;
import android.support.v7.p018b.R;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v7.view.menu.i */
public class MenuBuilder implements SupportMenu {
    private static final int[] f1467d;
    CharSequence f1468a;
    Drawable f1469b;
    View f1470c;
    private final Context f1471e;
    private final Resources f1472f;
    private boolean f1473g;
    private boolean f1474h;
    private MenuBuilder f1475i;
    private ArrayList f1476j;
    private ArrayList f1477k;
    private boolean f1478l;
    private ArrayList f1479m;
    private ArrayList f1480n;
    private boolean f1481o;
    private int f1482p;
    private ContextMenuInfo f1483q;
    private boolean f1484r;
    private boolean f1485s;
    private boolean f1486t;
    private boolean f1487u;
    private ArrayList f1488v;
    private CopyOnWriteArrayList f1489w;
    private MenuItemImpl f1490x;
    private boolean f1491y;

    static {
        f1467d = new int[]{1, 4, 5, 3, 2, 0};
    }

    public MenuBuilder(Context context) {
        this.f1482p = 0;
        this.f1484r = false;
        this.f1485s = false;
        this.f1486t = false;
        this.f1487u = false;
        this.f1488v = new ArrayList();
        this.f1489w = new CopyOnWriteArrayList();
        this.f1471e = context;
        this.f1472f = context.getResources();
        this.f1476j = new ArrayList();
        this.f1477k = new ArrayList();
        this.f1478l = true;
        this.f1479m = new ArrayList();
        this.f1480n = new ArrayList();
        this.f1481o = true;
        m3211e(true);
    }

    public MenuBuilder m3213a(int i) {
        this.f1482p = i;
        return this;
    }

    public void m3223a(MenuPresenter menuPresenter) {
        m3224a(menuPresenter, this.f1471e);
    }

    public void m3224a(MenuPresenter menuPresenter, Context context) {
        this.f1489w.add(new WeakReference(menuPresenter));
        menuPresenter.m3282a(context, this);
        this.f1481o = true;
    }

    public void m3234b(MenuPresenter menuPresenter) {
        Iterator it = this.f1489w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f1489w.remove(weakReference);
            }
        }
    }

    private void m3210d(boolean z) {
        if (!this.f1489w.isEmpty()) {
            m3245g();
            Iterator it = this.f1489w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f1489w.remove(weakReference);
                } else {
                    menuPresenter.m3286b(z);
                }
            }
            m3246h();
        }
    }

    private boolean m3208a(ad adVar, MenuPresenter menuPresenter) {
        boolean z = false;
        if (this.f1489w.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z = menuPresenter.m3284a(adVar);
        }
        Iterator it = this.f1489w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
            if (menuPresenter2 == null) {
                this.f1489w.remove(weakReference);
                z = z2;
            } else if (z2) {
                z = z2;
            } else {
                z = menuPresenter2.m3284a(adVar);
            }
            z2 = z;
        }
        return z2;
    }

    public void m3220a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = ar.m1792a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (ar.m1796c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((ad) item.getSubMenu()).m3220a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(m3219a(), sparseArray);
        }
    }

    public void m3232b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(m3219a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = ar.m1792a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((ad) item.getSubMenu()).m3232b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    ar.m1795b(item);
                }
            }
        }
    }

    protected String m3219a() {
        return "android:menu:actionviewstates";
    }

    public void m3221a(MenuBuilder menuBuilder) {
        this.f1475i = menuBuilder;
    }

    protected MenuItem m3218a(int i, int i2, int i3, CharSequence charSequence) {
        int d = MenuBuilder.m3209d(i3);
        MenuItem a = m3205a(i, i2, i3, d, charSequence, this.f1482p);
        if (this.f1483q != null) {
            a.m3331a(this.f1483q);
        }
        this.f1476j.add(MenuBuilder.m3204a(this.f1476j, d), a);
        m3235b(true);
        return a;
    }

    private MenuItemImpl m3205a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return m3218a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m3218a(0, 0, 0, this.f1472f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m3218a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m3218a(i, i2, i3, this.f1472f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1472f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) m3218a(i, i2, i3, charSequence);
        ad adVar = new ad(this.f1471e, this, menuItemImpl);
        menuItemImpl.m3330a(adVar);
        return adVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1472f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1471e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m3207a(m3231b(i), true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeGroup(int r6) {
        /*
        r5 = this;
        r1 = 0;
        r3 = r5.m3237c(r6);
        if (r3 < 0) goto L_0x002b;
    L_0x0007:
        r0 = r5.f1476j;
        r0 = r0.size();
        r4 = r0 - r3;
        r0 = r1;
    L_0x0010:
        r2 = r0 + 1;
        if (r0 >= r4) goto L_0x0027;
    L_0x0014:
        r0 = r5.f1476j;
        r0 = r0.get(r3);
        r0 = (android.support.v7.view.menu.MenuItemImpl) r0;
        r0 = r0.getGroupId();
        if (r0 != r6) goto L_0x0027;
    L_0x0022:
        r5.m3207a(r3, r1);
        r0 = r2;
        goto L_0x0010;
    L_0x0027:
        r0 = 1;
        r5.m3235b(r0);
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.i.removeGroup(int):void");
    }

    private void m3207a(int i, boolean z) {
        if (i >= 0 && i < this.f1476j.size()) {
            this.f1476j.remove(i);
            if (z) {
                m3235b(true);
            }
        }
    }

    public void clear() {
        if (this.f1490x != null) {
            m3242d(this.f1490x);
        }
        this.f1476j.clear();
        m3235b(true);
    }

    void m3225a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1476j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (MenuItemImpl) this.f1476j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m3343g() && menuItem2.isCheckable()) {
                menuItem2.m3334b(menuItem2 == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1476j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1476j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.m3332a(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f1476j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1476j.get(i2);
            if (menuItemImpl.getGroupId() == i && menuItemImpl.m3337c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            m3235b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1476j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1476j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1491y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((MenuItemImpl) this.f1476j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1476j.get(i2);
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu()) {
                MenuItem findItem = menuItemImpl.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int m3231b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((MenuItemImpl) this.f1476j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int m3237c(int i) {
        return m3212a(i, 0);
    }

    public int m3212a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((MenuItemImpl) this.f1476j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f1476j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f1476j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m3217a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f1473g = z;
        m3235b(false);
    }

    private static int m3209d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f1467d.length) {
            return (f1467d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean m3236b() {
        return this.f1473g;
    }

    private void m3211e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f1472f.getConfiguration().keyboard != 1 && this.f1472f.getBoolean(R.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f1474h = z2;
    }

    public boolean m3239c() {
        return this.f1474h;
    }

    Resources m3241d() {
        return this.f1472f;
    }

    public Context m3243e() {
        return this.f1471e;
    }

    boolean m3228a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f1475i != null && this.f1475i.m2778a(menuBuilder, menuItem);
    }

    public void m3244f() {
        if (this.f1475i != null) {
            this.f1475i.m2777a(this);
        }
    }

    private static int m3204a(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((MenuItemImpl) arrayList.get(size)).m3336c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m3217a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m3229a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m3227a(true);
        }
        return z;
    }

    void m3226a(List list, int i, KeyEvent keyEvent) {
        boolean b = m3236b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1476j.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1476j.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).m3226a(list, i, keyEvent);
                }
                char alphabeticShortcut = b ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && menuItemImpl.isEnabled())) {
                    list.add(menuItemImpl);
                }
            }
        }
    }

    MenuItemImpl m3217a(int i, KeyEvent keyEvent) {
        List list = this.f1488v;
        list.clear();
        m3226a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (MenuItemImpl) list.get(0);
        }
        boolean b = m3236b();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) list.get(i2);
            char alphabeticShortcut = b ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return menuItemImpl;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return menuItemImpl;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m3229a(findItem(i), i2);
    }

    public boolean m3229a(MenuItem menuItem, int i) {
        return m3230a(menuItem, null, i);
    }

    public boolean m3230a(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean z;
        boolean b = menuItemImpl.m3335b();
        ActionProvider a = menuItemImpl.m3328a();
        if (a == null || !a.m2403e()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (menuItemImpl.m3350n()) {
            expandActionView = menuItemImpl.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m3227a(true);
            return expandActionView;
        } else if (menuItemImpl.hasSubMenu() || z) {
            m3227a(false);
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.m3330a(new ad(m3243e(), this, menuItemImpl));
            }
            ad adVar = (ad) menuItemImpl.getSubMenu();
            if (z) {
                a.m2398a((SubMenu) adVar);
            }
            expandActionView = m3208a(adVar, menuPresenter) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m3227a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m3227a(true);
            }
            return b;
        }
    }

    public final void m3227a(boolean z) {
        if (!this.f1487u) {
            this.f1487u = true;
            Iterator it = this.f1489w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f1489w.remove(weakReference);
                } else {
                    menuPresenter.m3283a(this, z);
                }
            }
            this.f1487u = false;
        }
    }

    public void close() {
        m3227a(true);
    }

    public void m3235b(boolean z) {
        if (this.f1484r) {
            this.f1485s = true;
            return;
        }
        if (z) {
            this.f1478l = true;
            this.f1481o = true;
        }
        m3210d(z);
    }

    public void m3245g() {
        if (!this.f1484r) {
            this.f1484r = true;
            this.f1485s = false;
        }
    }

    public void m3246h() {
        this.f1484r = false;
        if (this.f1485s) {
            this.f1485s = false;
            m3235b(true);
        }
    }

    void m3222a(MenuItemImpl menuItemImpl) {
        this.f1478l = true;
        m3235b(true);
    }

    void m3233b(MenuItemImpl menuItemImpl) {
        this.f1481o = true;
        m3235b(true);
    }

    public ArrayList m3247i() {
        if (!this.f1478l) {
            return this.f1477k;
        }
        this.f1477k.clear();
        int size = this.f1476j.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1476j.get(i);
            if (menuItemImpl.isVisible()) {
                this.f1477k.add(menuItemImpl);
            }
        }
        this.f1478l = false;
        this.f1481o = true;
        return this.f1477k;
    }

    public void m3248j() {
        ArrayList i = m3247i();
        if (this.f1481o) {
            Iterator it = this.f1489w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f1489w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = menuPresenter.m3287b() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f1479m.clear();
                this.f1480n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) i.get(i4);
                    if (menuItemImpl.m3346j()) {
                        this.f1479m.add(menuItemImpl);
                    } else {
                        this.f1480n.add(menuItemImpl);
                    }
                }
            } else {
                this.f1479m.clear();
                this.f1480n.clear();
                this.f1480n.addAll(m3247i());
            }
            this.f1481o = false;
        }
    }

    public ArrayList m3249k() {
        m3248j();
        return this.f1479m;
    }

    public ArrayList m3250l() {
        m3248j();
        return this.f1480n;
    }

    public void clearHeader() {
        this.f1469b = null;
        this.f1468a = null;
        this.f1470c = null;
        m3235b(false);
    }

    private void m3206a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m3241d();
        if (view != null) {
            this.f1470c = view;
            this.f1468a = null;
            this.f1469b = null;
        } else {
            if (i > 0) {
                this.f1468a = d.getText(i);
            } else if (charSequence != null) {
                this.f1468a = charSequence;
            }
            if (i2 > 0) {
                this.f1469b = ContextCompat.m741a(m3243e(), i2);
            } else if (drawable != null) {
                this.f1469b = drawable;
            }
            this.f1470c = null;
        }
        m3235b(false);
    }

    protected MenuBuilder m3216a(CharSequence charSequence) {
        m3206a(0, charSequence, 0, null, null);
        return this;
    }

    protected MenuBuilder m3214a(Drawable drawable) {
        m3206a(0, null, 0, drawable, null);
        return this;
    }

    protected MenuBuilder m3215a(View view) {
        m3206a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m3251m() {
        return this.f1468a;
    }

    public Drawable m3252n() {
        return this.f1469b;
    }

    public View m3253o() {
        return this.f1470c;
    }

    public MenuBuilder m3254p() {
        return this;
    }

    boolean m3255q() {
        return this.f1486t;
    }

    public boolean m3240c(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f1489w.isEmpty()) {
            m3245g();
            Iterator it = this.f1489w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f1489w.remove(weakReference);
                    z = z2;
                } else {
                    z = menuPresenter.m3285a(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3246h();
            if (z) {
                this.f1490x = menuItemImpl;
            }
        }
        return z;
    }

    public boolean m3242d(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f1489w.isEmpty() && this.f1490x == menuItemImpl) {
            m3245g();
            Iterator it = this.f1489w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f1489w.remove(weakReference);
                    z = z2;
                } else {
                    z = menuPresenter.m3288b(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3246h();
            if (z) {
                this.f1490x = null;
            }
        }
        return z;
    }

    public MenuItemImpl m3256r() {
        return this.f1490x;
    }

    public void m3238c(boolean z) {
        this.f1491y = z;
    }
}
