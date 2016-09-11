package android.support.v7.p017a;

import android.content.Context;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: WindowDecorActionBar */
/* renamed from: android.support.v7.a.bh */
public class bh extends ActionMode implements MenuBuilder {
    final /* synthetic */ bd f1239a;
    private final Context f1240b;
    private final MenuBuilder f1241c;
    private ActionMode f1242d;
    private WeakReference f1243e;

    public bh(bd bdVar, Context context, ActionMode actionMode) {
        this.f1239a = bdVar;
        this.f1240b = context;
        this.f1242d = actionMode;
        this.f1241c = new MenuBuilder(context).m3213a(1);
        this.f1241c.m3221a((MenuBuilder) this);
    }

    public MenuInflater m3011a() {
        return new SupportMenuInflater(this.f1240b);
    }

    public Menu m3018b() {
        return this.f1241c;
    }

    public void m3021c() {
        if (this.f1239a.f1212a == this) {
            if (bd.m2950b(this.f1239a.f1206D, this.f1239a.f1207E, false)) {
                this.f1242d.m2875a(this);
            } else {
                this.f1239a.f1213b = this;
                this.f1239a.f1214c = this.f1242d;
            }
            this.f1242d = null;
            this.f1239a.m2985j(false);
            this.f1239a.f1226s.m3404b();
            this.f1239a.f1225r.m4116a().sendAccessibilityEvent(32);
            this.f1239a.f1223p.setHideOnContentScrollEnabled(this.f1239a.f1215d);
            this.f1239a.f1212a = null;
        }
    }

    public void m3022d() {
        if (this.f1239a.f1212a == this) {
            this.f1241c.m3245g();
            try {
                this.f1242d.m2878b(this, this.f1241c);
            } finally {
                this.f1241c.m3246h();
            }
        }
    }

    public boolean m3023e() {
        this.f1241c.m3245g();
        try {
            boolean a = this.f1242d.m2876a((ActionMode) this, this.f1241c);
            return a;
        } finally {
            this.f1241c.m3246h();
        }
    }

    public void m3014a(View view) {
        this.f1239a.f1226s.setCustomView(view);
        this.f1243e = new WeakReference(view);
    }

    public void m3015a(CharSequence charSequence) {
        this.f1239a.f1226s.setSubtitle(charSequence);
    }

    public void m3020b(CharSequence charSequence) {
        this.f1239a.f1226s.setTitle(charSequence);
    }

    public void m3012a(int i) {
        m3020b(this.f1239a.f1219l.getResources().getString(i));
    }

    public void m3019b(int i) {
        m3015a(this.f1239a.f1219l.getResources().getString(i));
    }

    public CharSequence m3024f() {
        return this.f1239a.f1226s.getTitle();
    }

    public CharSequence m3025g() {
        return this.f1239a.f1226s.getSubtitle();
    }

    public void m3016a(boolean z) {
        super.m2999a(z);
        this.f1239a.f1226s.setTitleOptional(z);
    }

    public boolean m3026h() {
        return this.f1239a.f1226s.m3406d();
    }

    public View m3027i() {
        return this.f1243e != null ? (View) this.f1243e.get() : null;
    }

    public boolean m3017a(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f1242d != null) {
            return this.f1242d.m2877a((ActionMode) this, menuItem);
        }
        return false;
    }

    public void m3013a(MenuBuilder menuBuilder) {
        if (this.f1242d != null) {
            m3022d();
            this.f1239a.f1226s.m3403a();
        }
    }
}
