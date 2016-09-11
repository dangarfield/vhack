package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p002h.ActionProvider;
import android.support.v4.p002h.aw;
import android.support.v4.p011d.p012a.SupportMenuItem;
import android.support.v7.p018b.R;
import android.support.v7.widget.ar;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: android.support.v7.view.menu.m */
public final class MenuItemImpl implements SupportMenuItem {
    private static String f1530w;
    private static String f1531x;
    private static String f1532y;
    private static String f1533z;
    private final int f1534a;
    private final int f1535b;
    private final int f1536c;
    private final int f1537d;
    private CharSequence f1538e;
    private CharSequence f1539f;
    private Intent f1540g;
    private char f1541h;
    private char f1542i;
    private Drawable f1543j;
    private int f1544k;
    private MenuBuilder f1545l;
    private ad f1546m;
    private Runnable f1547n;
    private OnMenuItemClickListener f1548o;
    private int f1549p;
    private int f1550q;
    private View f1551r;
    private ActionProvider f1552s;
    private aw f1553t;
    private boolean f1554u;
    private ContextMenuInfo f1555v;

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3324a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3327a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3333b(i);
    }

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1544k = 0;
        this.f1549p = 16;
        this.f1550q = 0;
        this.f1554u = false;
        this.f1545l = menuBuilder;
        this.f1534a = i2;
        this.f1535b = i;
        this.f1536c = i3;
        this.f1537d = i4;
        this.f1538e = charSequence;
        this.f1550q = i5;
    }

    public boolean m3335b() {
        if ((this.f1548o != null && this.f1548o.onMenuItemClick(this)) || this.f1545l.m3228a(this.f1545l.m3254p(), (MenuItem) this)) {
            return true;
        }
        if (this.f1547n != null) {
            this.f1547n.run();
            return true;
        }
        if (this.f1540g != null) {
            try {
                this.f1545l.m3243e().startActivity(this.f1540g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f1552s == null || !this.f1552s.m2402d()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f1549p & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1549p |= 16;
        } else {
            this.f1549p &= -17;
        }
        this.f1545l.m3235b(false);
        return this;
    }

    public int getGroupId() {
        return this.f1535b;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f1534a;
    }

    public int getOrder() {
        return this.f1536c;
    }

    public int m3336c() {
        return this.f1537d;
    }

    public Intent getIntent() {
        return this.f1540g;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1540g = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f1542i;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1542i != c) {
            this.f1542i = Character.toLowerCase(c);
            this.f1545l.m3235b(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.f1541h;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1541h != c) {
            this.f1541h = c;
            this.f1545l.m3235b(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1541h = c;
        this.f1542i = Character.toLowerCase(c2);
        this.f1545l.m3235b(false);
        return this;
    }

    char m3338d() {
        return this.f1545l.m3236b() ? this.f1542i : this.f1541h;
    }

    String m3340e() {
        char d = m3338d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f1530w);
        switch (d) {
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                stringBuilder.append(f1532y);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                stringBuilder.append(f1531x);
                break;
            case R.AppCompatTheme_actionModeCutDrawable /*32*/:
                stringBuilder.append(f1533z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    boolean m3342f() {
        return this.f1545l.m3239c() && m3338d() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.f1546m;
    }

    public boolean hasSubMenu() {
        return this.f1546m != null;
    }

    public void m3330a(ad adVar) {
        this.f1546m = adVar;
        adVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1538e;
    }

    CharSequence m3329a(aa aaVar) {
        return (aaVar == null || !aaVar.m96a()) ? getTitle() : getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1538e = charSequence;
        this.f1545l.m3235b(false);
        if (this.f1546m != null) {
            this.f1546m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f1545l.m3243e().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1539f != null ? this.f1539f : this.f1538e;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1539f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1538e;
        }
        this.f1545l.m3235b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f1543j != null) {
            return this.f1543j;
        }
        if (this.f1544k == 0) {
            return null;
        }
        Drawable a = ar.m3972a().m3993a(this.f1545l.m3243e(), this.f1544k);
        this.f1544k = 0;
        this.f1543j = a;
        return a;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1544k = 0;
        this.f1543j = drawable;
        this.f1545l.m3235b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1543j = null;
        this.f1544k = i;
        this.f1545l.m3235b(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.f1549p & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1549p;
        this.f1549p = (z ? 1 : 0) | (this.f1549p & -2);
        if (i != this.f1549p) {
            this.f1545l.m3235b(false);
        }
        return this;
    }

    public void m3332a(boolean z) {
        this.f1549p = (z ? 4 : 0) | (this.f1549p & -5);
    }

    public boolean m3343g() {
        return (this.f1549p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f1549p & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1549p & 4) != 0) {
            this.f1545l.m3225a((MenuItem) this);
        } else {
            m3334b(z);
        }
        return this;
    }

    void m3334b(boolean z) {
        int i;
        int i2 = this.f1549p;
        int i3 = this.f1549p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f1549p = i | i3;
        if (i2 != this.f1549p) {
            this.f1545l.m3235b(false);
        }
    }

    public boolean isVisible() {
        if (this.f1552s == null || !this.f1552s.m2400b()) {
            if ((this.f1549p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f1549p & 8) == 0 && this.f1552s.m2401c()) {
            return true;
        } else {
            return false;
        }
    }

    boolean m3337c(boolean z) {
        int i = this.f1549p;
        this.f1549p = (z ? 0 : 8) | (this.f1549p & -9);
        if (i != this.f1549p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (m3337c(z)) {
            this.f1545l.m3222a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1548o = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.f1538e != null ? this.f1538e.toString() : null;
    }

    void m3331a(ContextMenuInfo contextMenuInfo) {
        this.f1555v = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f1555v;
    }

    public void m3344h() {
        this.f1545l.m3233b(this);
    }

    public boolean m3345i() {
        return this.f1545l.m3255q();
    }

    public boolean m3346j() {
        return (this.f1549p & 32) == 32;
    }

    public boolean m3347k() {
        return (this.f1550q & 1) == 1;
    }

    public boolean m3348l() {
        return (this.f1550q & 2) == 2;
    }

    public void m3339d(boolean z) {
        if (z) {
            this.f1549p |= 32;
        } else {
            this.f1549p &= -33;
        }
    }

    public boolean m3349m() {
        return (this.f1550q & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
            case ModuleDescriptor.MODULE_VERSION /*1*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f1550q = i;
                this.f1545l.m3233b(this);
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public SupportMenuItem m3327a(View view) {
        this.f1551r = view;
        this.f1552s = null;
        if (view != null && view.getId() == -1 && this.f1534a > 0) {
            view.setId(this.f1534a);
        }
        this.f1545l.m3233b(this);
        return this;
    }

    public SupportMenuItem m3324a(int i) {
        Context e = this.f1545l.m3243e();
        m3327a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public View getActionView() {
        if (this.f1551r != null) {
            return this.f1551r;
        }
        if (this.f1552s == null) {
            return null;
        }
        this.f1551r = this.f1552s.m2395a((MenuItem) this);
        return this.f1551r;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public ActionProvider m3328a() {
        return this.f1552s;
    }

    public SupportMenuItem m3326a(ActionProvider actionProvider) {
        if (this.f1552s != null) {
            this.f1552s.m2404f();
        }
        this.f1551r = null;
        this.f1552s = actionProvider;
        this.f1545l.m3235b(true);
        if (this.f1552s != null) {
            this.f1552s.m2397a(new MenuItemImpl(this));
        }
        return this;
    }

    public SupportMenuItem m3333b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!m3350n()) {
            return false;
        }
        if (this.f1553t == null || this.f1553t.m1817a(this)) {
            return this.f1545l.m3240c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f1550q & 8) == 0) {
            return false;
        }
        if (this.f1551r == null) {
            return true;
        }
        if (this.f1553t == null || this.f1553t.m1818b(this)) {
            return this.f1545l.m3242d(this);
        }
        return false;
    }

    public SupportMenuItem m3325a(aw awVar) {
        this.f1553t = awVar;
        return this;
    }

    public boolean m3350n() {
        if ((this.f1550q & 8) == 0) {
            return false;
        }
        if (this.f1551r == null && this.f1552s != null) {
            this.f1551r = this.f1552s.m2395a((MenuItem) this);
        }
        if (this.f1551r != null) {
            return true;
        }
        return false;
    }

    public void m3341e(boolean z) {
        this.f1554u = z;
        this.f1545l.m3235b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f1554u;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
