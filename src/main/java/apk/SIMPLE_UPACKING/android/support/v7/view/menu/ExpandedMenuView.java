package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.widget.gb;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements MenuBuilder, MenuView, OnItemClickListener {
    private static final int[] f1432a;
    private MenuBuilder f1433b;
    private int f1434c;

    static {
        f1432a = new int[]{16842964, 16843049};
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        gb a = gb.m4646a(context, attributeSet, f1432a, i, 0);
        if (a.m4661f(0)) {
            setBackgroundDrawable(a.m4649a(0));
        }
        if (a.m4661f(1)) {
            setDivider(a.m4649a(1));
        }
        a.m4650a();
    }

    public void m3182a(MenuBuilder menuBuilder) {
        this.f1433b = menuBuilder;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean m3183a(MenuItemImpl menuItemImpl) {
        return this.f1433b.m3229a((MenuItem) menuItemImpl, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m3183a((MenuItemImpl) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f1434c;
    }
}
