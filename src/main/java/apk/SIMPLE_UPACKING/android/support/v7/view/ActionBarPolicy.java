package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p002h.ct;
import android.support.v7.p018b.R;
import android.view.ViewConfiguration;

/* renamed from: android.support.v7.view.a */
public class ActionBarPolicy {
    private Context f1357a;

    public static ActionBarPolicy m3102a(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.f1357a = context;
    }

    public int m3103a() {
        return this.f1357a.getResources().getInteger(R.abc_max_action_buttons);
    }

    public boolean m3104b() {
        if (VERSION.SDK_INT < 19 && ct.m2232b(ViewConfiguration.get(this.f1357a))) {
            return false;
        }
        return true;
    }

    public int m3105c() {
        return this.f1357a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m3106d() {
        if (this.f1357a.getApplicationInfo().targetSdkVersion >= 16) {
            return this.f1357a.getResources().getBoolean(R.abc_action_bar_embed_tabs);
        }
        return this.f1357a.getResources().getBoolean(R.abc_action_bar_embed_tabs_pre_jb);
    }

    public int m3107e() {
        TypedArray obtainStyledAttributes = this.f1357a.obtainStyledAttributes(null, R.ActionBar, R.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.ActionBar_height, 0);
        Resources resources = this.f1357a.getResources();
        if (!m3106d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m3108f() {
        return this.f1357a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m3109g() {
        return this.f1357a.getResources().getDimensionPixelSize(R.abc_action_bar_stacked_tab_max_width);
    }
}
