package android.support.v7.p017a;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.p018b.R;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: AppCompatDelegateImplV7 */
/* renamed from: android.support.v7.a.aq */
final class aq {
    int f1145a;
    int f1146b;
    int f1147c;
    int f1148d;
    int f1149e;
    int f1150f;
    ViewGroup f1151g;
    View f1152h;
    View f1153i;
    MenuBuilder f1154j;
    ListMenuPresenter f1155k;
    Context f1156l;
    boolean f1157m;
    boolean f1158n;
    boolean f1159o;
    public boolean f1160p;
    boolean f1161q;
    boolean f1162r;
    Bundle f1163s;

    aq(int i) {
        this.f1145a = i;
        this.f1161q = false;
    }

    public boolean m2890a() {
        if (this.f1152h == null) {
            return false;
        }
        if (this.f1153i != null || this.f1155k.m3308a().getCount() > 0) {
            return true;
        }
        return false;
    }

    void m2888a(Context context) {
        TypedValue typedValue = new TypedValue();
        Theme newTheme = context.getResources().newTheme();
        newTheme.setTo(context.getTheme());
        newTheme.resolveAttribute(R.actionBarPopupTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            newTheme.applyStyle(typedValue.resourceId, true);
        }
        newTheme.resolveAttribute(R.panelMenuListTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            newTheme.applyStyle(typedValue.resourceId, true);
        } else {
            newTheme.applyStyle(R.Theme_AppCompat_CompactMenu, true);
        }
        Context contextThemeWrapper = new ContextThemeWrapper(context, 0);
        contextThemeWrapper.getTheme().setTo(newTheme);
        this.f1156l = contextThemeWrapper;
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.AppCompatTheme);
        this.f1146b = obtainStyledAttributes.getResourceId(R.AppCompatTheme_panelBackground, 0);
        this.f1150f = obtainStyledAttributes.getResourceId(R.AppCompatTheme_android_windowAnimationStyle, 0);
        obtainStyledAttributes.recycle();
    }

    void m2889a(MenuBuilder menuBuilder) {
        if (menuBuilder != this.f1154j) {
            if (this.f1154j != null) {
                this.f1154j.m3234b(this.f1155k);
            }
            this.f1154j = menuBuilder;
            if (menuBuilder != null && this.f1155k != null) {
                menuBuilder.m3223a(this.f1155k);
            }
        }
    }

    MenuView m2887a(MenuPresenter menuPresenter) {
        if (this.f1154j == null) {
            return null;
        }
        if (this.f1155k == null) {
            this.f1155k = new ListMenuPresenter(this.f1156l, R.abc_list_menu_item_layout);
            this.f1155k.m3311a(menuPresenter);
            this.f1154j.m3223a(this.f1155k);
        }
        return this.f1155k.m3307a(this.f1151g);
    }
}
