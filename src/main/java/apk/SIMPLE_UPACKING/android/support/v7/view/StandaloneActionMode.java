package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.view.f */
public class StandaloneActionMode extends ActionMode implements MenuBuilder {
    private Context f1361a;
    private ActionBarContextView f1362b;
    private ActionMode f1363c;
    private WeakReference f1364d;
    private boolean f1365e;
    private boolean f1366f;
    private MenuBuilder f1367g;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode actionMode, boolean z) {
        this.f1361a = context;
        this.f1362b = actionBarContextView;
        this.f1363c = actionMode;
        this.f1367g = new MenuBuilder(actionBarContextView.getContext()).m3213a(1);
        this.f1367g.m3221a((MenuBuilder) this);
        this.f1366f = z;
    }

    public void m3124b(CharSequence charSequence) {
        this.f1362b.setTitle(charSequence);
    }

    public void m3119a(CharSequence charSequence) {
        this.f1362b.setSubtitle(charSequence);
    }

    public void m3116a(int i) {
        m3124b(this.f1361a.getString(i));
    }

    public void m3123b(int i) {
        m3119a(this.f1361a.getString(i));
    }

    public void m3120a(boolean z) {
        super.m2999a(z);
        this.f1362b.setTitleOptional(z);
    }

    public boolean m3129h() {
        return this.f1362b.m3406d();
    }

    public void m3118a(View view) {
        this.f1362b.setCustomView(view);
        this.f1364d = view != null ? new WeakReference(view) : null;
    }

    public void m3126d() {
        this.f1363c.m2878b(this, this.f1367g);
    }

    public void m3125c() {
        if (!this.f1365e) {
            this.f1365e = true;
            this.f1362b.sendAccessibilityEvent(32);
            this.f1363c.m2875a(this);
        }
    }

    public Menu m3122b() {
        return this.f1367g;
    }

    public CharSequence m3127f() {
        return this.f1362b.getTitle();
    }

    public CharSequence m3128g() {
        return this.f1362b.getSubtitle();
    }

    public View m3130i() {
        return this.f1364d != null ? (View) this.f1364d.get() : null;
    }

    public MenuInflater m3115a() {
        return new MenuInflater(this.f1362b.getContext());
    }

    public boolean m3121a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f1363c.m2877a((ActionMode) this, menuItem);
    }

    public void m3117a(MenuBuilder menuBuilder) {
        m3126d();
        this.f1362b.m3403a();
    }
}
