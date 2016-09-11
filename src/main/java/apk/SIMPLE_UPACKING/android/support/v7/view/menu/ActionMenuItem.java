package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.aw;
import android.support.v4.p007b.ContextCompat;
import android.support.v4.p011d.p012a.SupportMenuItem;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.a */
public class ActionMenuItem implements SupportMenuItem {
    private final int f1449a;
    private final int f1450b;
    private final int f1451c;
    private final int f1452d;
    private CharSequence f1453e;
    private CharSequence f1454f;
    private Intent f1455g;
    private char f1456h;
    private char f1457i;
    private Drawable f1458j;
    private int f1459k;
    private Context f1460l;
    private OnMenuItemClickListener f1461m;
    private int f1462n;

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3190a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3193a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3195b(i);
    }

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1459k = 0;
        this.f1462n = 16;
        this.f1460l = context;
        this.f1449a = i2;
        this.f1450b = i;
        this.f1451c = i3;
        this.f1452d = i4;
        this.f1453e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f1457i;
    }

    public int getGroupId() {
        return this.f1450b;
    }

    public Drawable getIcon() {
        return this.f1458j;
    }

    public Intent getIntent() {
        return this.f1455g;
    }

    public int getItemId() {
        return this.f1449a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f1456h;
    }

    public int getOrder() {
        return this.f1452d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1453e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1454f != null ? this.f1454f : this.f1453e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f1462n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1462n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1462n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1462n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1457i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1462n = (z ? 1 : 0) | (this.f1462n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1462n = (z ? 2 : 0) | (this.f1462n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f1462n = (z ? 16 : 0) | (this.f1462n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1458j = drawable;
        this.f1459k = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1459k = i;
        this.f1458j = ContextCompat.m741a(this.f1460l, i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1455g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1456h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1461m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1456h = c;
        this.f1457i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1453e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f1453e = this.f1460l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1454f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f1462n = (z ? 0 : 8) | (this.f1462n & 8);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public SupportMenuItem m3193a(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem m3190a(int i) {
        throw new UnsupportedOperationException();
    }

    public android.support.v4.p002h.ActionProvider m3194a() {
        return null;
    }

    public SupportMenuItem m3192a(android.support.v4.p002h.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem m3195b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem m3191a(aw awVar) {
        return this;
    }
}
